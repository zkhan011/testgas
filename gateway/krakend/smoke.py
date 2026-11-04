#!/usr/bin/env python3
"""Exercise the real gateway against a mock backend; requires Docker on Linux."""
import json
import subprocess
import tempfile
import threading
import time
import urllib.error
import urllib.request
from http.server import BaseHTTPRequestHandler, ThreadingHTTPServer
from pathlib import Path
from generate import build


class Backend(BaseHTTPRequestHandler):
    def log_message(self, *args):
        pass

    def do_POST(self):
        body = self.rfile.read(int(self.headers.get('Content-Length', '0')))
        payload = json.loads(body)
        code = payload.get('testStatus', 200)
        response = json.dumps({'path': self.path, 'body': body.decode(),
                               'authorization': self.headers.get('Authorization'),
                               'apiKey': self.headers.get('X-API-Key'),
                               'unexpected': self.headers.get('X-Untrusted')}).encode()
        self.send_response(code)
        self.send_header('Content-Type', 'application/problem+json' if code >= 400 else 'application/json')
        self.send_header('X-Backend-Test', 'preserved')
        self.send_header('Content-Length', str(len(response)))
        self.end_headers()
        self.wfile.write(response)


def request(path, payload):
    req = urllib.request.Request('http://127.0.0.1:18081' + path, data=payload,
        headers={'Content-Type': 'application/json', 'Authorization': 'Basic dGVzdDp0ZXN0',
                 'X-API-Key': 'test-key-only-not-real', 'X-Untrusted': 'must-not-forward'})
    try:
        return urllib.request.urlopen(req, timeout=3)
    except urllib.error.HTTPError as error:
        return error


def main():
    config = build('http://127.0.0.1:18080')
    config['port'] = 18081
    server = ThreadingHTTPServer(('127.0.0.1', 18080), Backend)
    threading.Thread(target=server.serve_forever, daemon=True).start()
    container = None
    with tempfile.TemporaryDirectory() as folder:
        path = Path(folder) / 'krakend.json'
        path.write_text(json.dumps(config))
        # Docker must read both the temporary directory and configuration file.
        Path(folder).chmod(0o755)
        try:
            container = subprocess.check_output(['docker', 'run', '-d', '--rm', '--network', 'host',
                '-v', f'{path}:/etc/krakend/krakend.json:ro', 'krakend:3.0.3',
                'run', '-c', '/etc/krakend/krakend.json'], text=True).strip()
            for attempt in range(60):
                try:
                    with request('/api/v1/getVoyages', b'{}') as res:
                        assert res.status == 200
                    break
                except (urllib.error.URLError, ConnectionError):
                    time.sleep(0.5)
            else:
                raise AssertionError('Gateway did not start')
            count = 0
            for route in config['endpoints']:
                if route['method'] != 'POST':
                    continue
                # Preserve JSON whitespace and all application error codes.
                for status in (200, 400, 401, 403, 415, 422, 500):
                    body = ('{ "testStatus": %d, "value": "unchanged" }' % status).encode()
                    with request(route['endpoint'], body) as response:
                        assert response.status == status, (route['endpoint'], status, response.status)
                        assert response.headers['X-Backend-Test'] == 'preserved'
                        result = json.load(response)
                        assert result['body'] == body.decode()
                        assert result['path'] == route['endpoint']
                        assert result['unexpected'] is None
                        basic = 'Authorization' in route['input_headers']
                        assert result['authorization'] == ('Basic dGVzdDp0ZXN0' if basic else None)
                        assert result['apiKey'] == (None if basic else 'test-key-only-not-real')
                    count += 1
            with request('/api/v1/notAnEndpoint', b'{}') as response:
                assert response.status == 404
            print(f'Passed {count} real-gateway forwarding checks across 50 endpoints; unknown route rejected')
        finally:
            if container:
                subprocess.run(['docker', 'logs', container], check=False)
                subprocess.run(['docker', 'stop', container], check=False, stdout=subprocess.DEVNULL)
            server.shutdown()


if __name__ == '__main__':
    main()
