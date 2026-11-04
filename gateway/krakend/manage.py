#!/usr/bin/env python3
"""Apply the enabled/disabled gateway setting without stopping Spring Boot."""
import argparse
import json
import subprocess
from pathlib import Path
from generate import build

HERE = Path(__file__).resolve().parent


def plan(settings):
    enabled = settings.get('enabled')
    if not isinstance(enabled, bool):
        raise ValueError('enabled must be a JSON boolean: true or false')
    compose = ['docker', 'compose', '-f', str(HERE / 'compose.yaml')]
    if not enabled:
        return None, [compose + ['stop', 'krakend']]
    config = build(settings['backend_url'], settings.get('timeout', '60s'))
    return config, [compose + ['run', '--rm', 'krakend', 'check', '-t',
                              '--lint-no-network', '-c', '/etc/krakend/krakend.json'],
                    compose + ['up', '-d', '--force-recreate', 'krakend']]


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--config', type=Path, default=HERE / 'deployment.json')
    parser.add_argument('--dry-run', action='store_true', help='Show commands without changing files or containers')
    args = parser.parse_args()
    settings = json.loads(args.config.read_text())
    config, commands = plan(settings)
    if args.dry_run:
        print(json.dumps({'enabled': settings['enabled'], 'commands': commands}, indent=2))
        return
    if config is not None:
        (HERE / 'krakend.json').write_text(json.dumps(config, indent=2) + '\n')
    for command in commands:
        subprocess.run(command, check=True)
    print('KrakenD enabled: use gateway port 8081.' if settings['enabled'] else
          'KrakenD disabled: use the direct Spring Boot URL (normally port 8080).')


if __name__ == '__main__':
    main()
