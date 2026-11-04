#!/usr/bin/env python3
"""Generate explicit KrakenD routes from the application's OpenAPI contract."""
import argparse
import json
from pathlib import Path
from urllib.parse import urlsplit

ROOT = Path(__file__).resolve().parents[2]
DEFAULT_OUTPUT = Path(__file__).with_name('krakend.json')


def build(backend, timeout='60s'):
    url = urlsplit(backend)
    if url.scheme not in ('http', 'https') or not url.hostname or url.username or url.password or url.path not in ('', '/') or url.query or url.fragment:
        raise ValueError('Backend must be an http(s) origin without credentials, path, query or fragment')
    spec = json.loads((ROOT / 'src/main/resources/static/openapi.json').read_text())
    routes = []
    for path, item in sorted(spec['paths'].items()):
        for method, operation in item.items():
            if method not in ('get', 'post', 'put', 'patch', 'delete', 'head', 'options'):
                continue
            security = operation.get('security', spec.get('security', []))
            headers = {'Content-Type', 'Accept'}
            for requirement in security:
                for name in requirement:
                    scheme = spec['components']['securitySchemes'][name]
                    if scheme['type'] == 'http':
                        headers.add('Authorization')
                    elif scheme['type'] == 'apiKey' and scheme['in'] == 'header':
                        headers.add(scheme['name'])
                    else:
                        raise ValueError(f'Unsupported security scheme: {name}')
            routes.append(route(path, method.upper(), backend, sorted(headers)))
    # Infrastructure routes are explicit; do not expose actuator wildcards.
    routes += [route('/openapi.json', 'GET', backend, ['Accept', 'Authorization']),
               route('/actuator/health', 'GET', backend, ['Accept'])]
    return {'$schema': 'https://www.krakend.io/schema/v3.0/krakend.json',
            'version': 4, 'name': 'DPW Integration API Gateway', 'port': 8080,
            'timeout': timeout, 'cache_ttl': '0s', 'endpoints': routes}


def route(path, method, backend, headers):
    return {'endpoint': path, 'method': method, 'output_encoding': 'no-op',
            'input_headers': headers, 'backend': [{'host': [backend.rstrip('/')],
            'url_pattern': path, 'method': method, 'encoding': 'no-op'}]}


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--backend', default='http://host.docker.internal:8080')
    parser.add_argument('--timeout', default='60s')
    parser.add_argument('--output', type=Path, default=DEFAULT_OUTPUT)
    parser.add_argument('--check', action='store_true', help='Fail if checked-in configuration has drifted')
    args = parser.parse_args()
    rendered = json.dumps(build(args.backend, args.timeout), indent=2) + '\n'
    if args.check:
        if args.output.read_text() != rendered:
            raise SystemExit('Gateway config is stale: run python3 gateway/krakend/generate.py')
        print('Gateway configuration matches OpenAPI')
    else:
        args.output.write_text(rendered)
        print(f'Wrote {args.output}')


if __name__ == '__main__':
    main()
