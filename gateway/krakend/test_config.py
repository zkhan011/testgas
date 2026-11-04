import json
import unittest
from generate import ROOT, DEFAULT_OUTPUT, build


class ContractTest(unittest.TestCase):
    def test_routes_and_auth_match_contract(self):
        config = json.loads(DEFAULT_OUTPUT.read_text())
        spec = json.loads((ROOT / 'src/main/resources/static/openapi.json').read_text())
        expected = {(p, m.upper()) for p, item in spec['paths'].items() for m in item if m == 'post'}
        actual = [(e['endpoint'], e['method']) for e in config['endpoints']]
        self.assertEqual(len(expected), 50)
        self.assertEqual(len(actual), len(set(actual)))
        self.assertEqual(set(actual), expected | {('/openapi.json', 'GET'), ('/actuator/health', 'GET')})
        for e in config['endpoints']:
            self.assertEqual(e['output_encoding'], 'no-op')
            self.assertEqual(len(e['backend']), 1)
            self.assertEqual(e['backend'][0]['url_pattern'], e['endpoint'])
            self.assertEqual(e['backend'][0]['method'], e['method'])
            self.assertNotIn('*', e['input_headers'])
            if e['endpoint'] in spec['paths']:
                op = spec['paths'][e['endpoint']]['post']
                schemes = op.get('security', spec['security'])
                basic = any(spec['components']['securitySchemes'][s]['type'] == 'http' for r in schemes for s in r)
                self.assertIn('Authorization' if basic else 'X-API-Key', e['input_headers'])
                self.assertNotIn('X-API-Key' if basic else 'Authorization', e['input_headers'])

    def test_invalid_backend_is_rejected(self):
        for origin in ['ftp://server', 'http://user:secret@server', 'http://server/api', 'http://server?q=1']:
            with self.assertRaises(ValueError):
                build(origin)


class DeploymentToggleTest(unittest.TestCase):
    def test_disabled_only_stops_gateway(self):
        from manage import plan
        config, commands = plan({'enabled': False})
        self.assertIsNone(config)
        self.assertEqual(len(commands), 1)
        self.assertEqual(commands[0][-2:], ['stop', 'krakend'])

    def test_enabled_checks_before_start(self):
        from manage import plan
        config, commands = plan({'enabled': True, 'backend_url': 'http://app:8080'})
        self.assertEqual(len(config['endpoints']), 52)
        self.assertIn('check', commands[0])
        self.assertEqual(commands[1][-4:], ['up', '-d', '--force-recreate', 'krakend'])

    def test_string_false_rejected(self):
        from manage import plan
        with self.assertRaises(ValueError):
            plan({'enabled': 'false'})


if __name__ == '__main__':
    unittest.main()
