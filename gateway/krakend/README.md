# KrakenD integration

All 50 business endpoints keep their current `POST /api/v1/<legacyOperationName>` paths and JSON payloads. KrakenD Community 3.0.3 forwards each request to the combined Java 21 Spring Boot application. There are also two explicit infrastructure routes: `GET /openapi.json` (HTTP Basic) and `GET /actuator/health` (public). No other actuator routes are exposed. KrakenD's own `/__health` is a gateway liveness check, not an Oracle/application health check.

Clients -> HTTPS reverse proxy/load balancer -> KrakenD -> Spring Boot -> Oracle

## Authentication

| Endpoints | Client header | Enforcement |
| --- | --- | --- |
| GAS: getTokenDetails, getContainerDetails, getEirLocationDetails, postExceptionData | Authorization: Basic ... | Existing Spring Security |
| HHT/Marine and voyage endpoints | X-API-Key: client key | Existing ApiKeyInterceptor |
| getConfiguredJobsForMarineAQ, startScheduler, stopScheduler | X-API-Key: admin key | Existing ApiKeyInterceptor; client key remains forbidden |
| /openapi.json | Authorization: Basic ... | Existing Spring Security |
| /actuator/health | None | Existing application health configuration |

KrakenD does not inject or store credentials and does not replace backend authentication. Credentials are forwarded only to routes that use them. `Content-Type` and `Accept` are allowed; arbitrary client headers are not. Query strings are not forwarded because business inputs are JSON bodies. `no-op` preserves response bodies, status codes and response headers, including Basic authentication challenges. No caching, aggregation, retry configuration, JWT provider, CORS policy or rate limit is introduced. Select those policies separately for your deployment and client requirements.

## Enable or disable KrakenD

Edit `gateway/krakend/deployment.json`:

```json
{
  "enabled": true,
  "backend_url": "http://host.docker.internal:8080",
  "timeout": "60s"
}
```

Then apply the setting from repository root:

```bash
python3 gateway/krakend/manage.py --dry-run
python3 gateway/krakend/manage.py
```

- `enabled: true`: generate routes for `backend_url`, validate with KrakenD, then start/recreate the gateway on port 8081. A failed check prevents the start command.
- `enabled: false`: stop only the KrakenD container; Spring Boot continues running. Clients must use the direct Spring Boot URL, normally port 8080.

The checked-in deployment setting defaults to `false`. Changing the JSON alone does not change running containers: run `manage.py` to apply it. Use JSON booleans, not strings. Docker Compose must be available for either operation. You can keep environment-specific settings outside the repo with `--config /path/to/deployment.json`.

This is a deployment toggle, not a Spring Boot property or automatic traffic failover. Keeping one public URL while switching requires changing your load balancer/reverse-proxy upstream between KrakenD and Spring Boot. Review firewall access before disabling in production. The raw Compose commands below bypass this toggle and are intended for manual operation.

## Start against your existing Spring Boot server

Prerequisites: Python 3, Docker with Compose, and the application running with its existing authentication and Oracle configuration. Commands below run from repository root; use `python` instead of `python3` on Windows if required.

The checked-in config targets `http://host.docker.internal:8080`. Docker Desktop resolves this to the host; Compose adds the equivalent host-gateway mapping for Linux. The application must listen on an interface reachable from the container. Alternatively generate for the application's private DNS name or IP:

```bash
python3 gateway/krakend/generate.py --backend http://YOUR-SPRING-SERVER:8080

docker compose -f gateway/krakend/compose.yaml run --rm krakend check -t --lint-no-network -c /etc/krakend/krakend.json
docker compose -f gateway/krakend/compose.yaml up -d
docker compose -f gateway/krakend/compose.yaml logs -f
```

Gateway listens at `http://localhost:8081`; Spring Boot continues on port 8080. Compose binds the gateway to loopback for use behind a same-host HTTPS proxy. For a remote load balancer, change the bind address to the intended private interface and restrict its inbound firewall rules. Do not send Basic credentials or API keys over public HTTP. Use HTTPS to the application as well if the backend crosses an untrusted network, and configure the container's trust store for your internal CA.

Use the existing `docs/DPW-Integration.postman_collection.json`, changing its base URL to `http://localhost:8081` (or your production gateway HTTPS URL). All request examples in `docs/ENDPOINTS.md` remain valid with that base URL replacement.

```bash
# Application readiness through the gateway; may report DOWN if Oracle is unavailable.
curl -i http://localhost:8081/actuator/health

# Supply the same valid StandardReqType JSON used by the application.
curl -i http://localhost:8081/api/v1/getVoyages \
  -H "X-API-Key: $GATE_API_KEY" -H 'Content-Type: application/json' \
  --data-binary @standard-request.json

# GAS: curl prompts for password when only the username is supplied.
curl -i -u "$GASWS_USERNAME" http://localhost:8081/api/v1/getContainerDetails \
  -H 'Content-Type: application/json' --data '{"terminalId":"T1"}'

# Scheduler listing requires the admin key, even though it only reads jobs.
curl -i http://localhost:8081/api/v1/getConfiguredJobsForMarineAQ \
  -H "X-API-Key: $GATE_ADMIN_KEY" -H 'Content-Type: application/json' --data '{}'
```

## Production settings and rollout

1. Point the generator at the real application origin; deploy the generated JSON without committing environment-specific configuration or secrets. If a KrakenD gateway already exists, merge this file's `endpoints` into its configuration and keep that gateway's global settings. Route paths must be unique.
2. Configure HTTPS termination, DNS and firewall rules. Allow backend access from gateway nodes and explicitly approved internal operators only. Do not disable backend authentication.
3. Default gateway timeout is 60 seconds. Measure stored-procedure latency and align gateway, load balancer and application timeouts; regenerate with `--timeout 120s` if appropriate. A gateway timeout does not cancel an Oracle mutation: verify outcome before retrying writes.
4. Validate configuration and restart/reload your gateway deployment. In UAT verify valid/invalid Basic credentials, missing/invalid client keys, client-key denial on scheduler routes, admin-key access, representative reads and approved writes. Smoke tests use a mock and do not establish Oracle connectivity or business correctness.
5. Change client base URLs to your HTTPS gateway. For rollback point them back to the prior approved application route, or stop this gateway with `docker compose -f gateway/krakend/compose.yaml down`. The Spring Boot API is unchanged.

## Maintaining route coverage

`generate.py` reads `src/main/resources/static/openapi.json`, including each operation's security requirements. After changing application endpoints, update OpenAPI and regenerate the default config:

```bash
python3 gateway/krakend/generate.py
python3 gateway/krakend/generate.py --check
python3 -m unittest discover -s gateway/krakend -p 'test_*.py'
```

CI validates the configuration with the pinned KrakenD image and runs 350 forwarding checks (50 routes x seven response codes) against a mock backend. It checks unchanged request bodies, route paths, credential-header isolation, error status propagation and rejection of unknown routes. Locally run `python3 gateway/krakend/smoke.py` on Linux with Docker. It uses ports 18080 and 18081; the mock never connects to Oracle.

References: [no-op proxying](https://www.krakend.io/docs/endpoints/no-op/), [configuration validation](https://www.krakend.io/docs/configuration/check/), [official distribution](https://www.krakend.io/download/).
