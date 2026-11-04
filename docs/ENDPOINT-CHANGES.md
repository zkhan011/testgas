# Endpoint naming changes

All 50 business endpoints now follow the legacy method naming convention: `POST /api/v1/<operationName>`, consuming JSON. There are no aliases for the previous URLs. Clients must update their method, path and any parameters moved to JSON. Responses, service calls, database procedures and authentication requirements remain unchanged.

- HHT request DTOs are unchanged.
- GAS `getTokenDetails` and `getContainerDetails`: query parameters become JSON properties.
- `adviceVoyage` and `cancelVoyage`: JSON now contains both `twsId` and `userName`.
- `billVoyage`: JSON body contains `twsId`.
- `startScheduler` and `stopScheduler`: JSON body contains `name`; the admin key is still required.
- `getMajorDamageFlag` and `getConfiguredJobsForMarineAQ`: use POST with JSON `{}`.
- Infrastructure/documentation resources, including `GET /actuator/health` and `GET /openapi.json`, are unchanged.

| Previous method and path | New method and path |
|---|---|
| `POST /api/v1/marine/voyages/search` | `POST /api/v1/getVoyages` |
| `POST /api/v1/reference-data/search` | `POST /api/v1/getRefData` |
| `POST /api/v1/marine/transactions` | `POST /api/v1/pushMarineDetails` |
| `POST /api/v1/marine/signatures` | `POST /api/v1/uploadSignature` |
| `POST /api/v1/ctms/voyages/search` | `POST /api/v1/getVoyagesFromCTMS` |
| `POST /api/v1/ctms/voyage-updates` | `POST /api/v1/CTMSVoyageUpdate` |
| `POST /api/v1/tokens/search` | `POST /api/v1/getTokens` |
| `POST /api/v1/trucks/token-search` | `POST /api/v1/getTokenForTruck` |
| `POST /api/v1/trucks/eirs/search` | `POST /api/v1/getDWCTruckEIR` |
| `POST /api/v1/gates/customs-entries` | `POST /api/v1/updateCustmGateEntry` |
| `POST /api/v1/containers/empty-allocations` | `POST /api/v1/getDynamicMTContainer` |
| `POST /api/v1/containers/planned-moves/search` | `POST /api/v1/getDEDContrPlanMoves` |
| `POST /api/v1/tos/messages` | `POST /api/v1/sendTOSMsg` |
| `POST /api/v1/containers/seal-updates` | `POST /api/v1/updateContainer` |
| `POST /api/v1/tokens/acceptances` | `POST /api/v1/acceptToken` |
| `POST /api/v1/eirs/search` | `POST /api/v1/getEir` |
| `POST /api/v1/gates/exit-confirmations` | `POST /api/v1/confirmGateoutMove` |
| `POST /api/v1/gate-passes/search` | `POST /api/v1/getFZGPGateInOutSearchList` |
| `POST /api/v1/gate-passes/movements` | `POST /api/v1/procFZGPGateInOutUpdate` |
| `POST /api/v1/containers/seal-history/search` | `POST /api/v1/prevSealDetails` |
| `POST /api/v1/containers/damage-history/search` | `POST /api/v1/prevDamageDetails` |
| `POST /api/v1/damage-codes/search` | `POST /api/v1/getMajorDamages` |
| `POST /api/v1/users/verifications` | `POST /api/v1/verifyUser` |
| `POST /api/v1/commercial-trucks/token-search` | `POST /api/v1/getTokenForCommercialTruck` |
| `POST /api/v1/containers/location-search` | `POST /api/v1/getContrLocation` |
| `POST /api/v1/eirs/print-jobs` | `POST /api/v1/printEir` |
| `POST /api/v1/containers/empty-refusals` | `POST /api/v1/addMTRefusal` |
| `POST /api/v1/vessels/notices/search` | `POST /api/v1/getNoticeDetailsForVessel` |
| `POST /api/v1/vessels/notice-updates` | `POST /api/v1/updateNoticeDetailsForVessel` |
| `POST /api/v1/berths/search` | `POST /api/v1/getBerthDetails` |
| `POST /api/v1/containers/weights/search` | `POST /api/v1/getVGMContainerWeightDetails` |
| `POST /api/v1/containers/weight-updates` | `POST /api/v1/updateVGMContainerWeightDetails` |
| `POST /api/v1/tokens/time-slots/search` | `POST /api/v1/getTokenTimeSlot` |
| `POST /api/v1/containers/truck-search` | `POST /api/v1/getTruckInfoByContainer` |
| `POST /api/v1/tokens/time-slot-adjustments` | `POST /api/v1/getAdjustTimeSlot` |
| `POST /api/v1/containers/standing-damages/search` | `POST /api/v1/getContainerDamages` |
| `POST /api/v1/containers/standing-damage-updates` | `POST /api/v1/updateStdDmgDetails` |
| `GET /api/v1/configuration/major-damage-flag` | `POST /api/v1/getMajorDamageFlag` |
| `POST /api/v1/containers/damage-updates` | `POST /api/v1/updateContainerWithDamages` |
| `POST /api/v1/voyages/rotations` | `POST /api/v1/generateRotationNo` |
| `POST /api/v1/voyages/{twsId}/advices` | `POST /api/v1/adviceVoyage` |
| `POST /api/v1/voyages/{twsId}/cancellations` | `POST /api/v1/cancelVoyage` |
| `POST /api/v1/voyages/{twsId}/billings` | `POST /api/v1/billVoyage` |
| `GET /api/v1/admin/schedulers` | `POST /api/v1/getConfiguredJobsForMarineAQ` |
| `POST /api/v1/admin/schedulers/{name}/starts` | `POST /api/v1/startScheduler` |
| `POST /api/v1/admin/schedulers/{name}/stops` | `POST /api/v1/stopScheduler` |
| `GET /api/v1/tokens` | `POST /api/v1/getTokenDetails` |
| `GET /api/v1/containers` | `POST /api/v1/getContainerDetails` |
| `POST /api/v1/eir-location-requests` | `POST /api/v1/getEirLocationDetails` |
| `POST /api/v1/gate-exceptions` | `POST /api/v1/postExceptionData` |

## Request examples

```http
POST /api/v1/getContainerDetails
Content-Type: application/json
Authorization: Basic <credentials>

{"terminalId":"T1"}
```

```json
{"terminalId":"T1","rfIdNo":null,"truckNo":"00123","regPlace":"DXB"}
```

Use the preceding body with `POST /api/v1/getTokenDetails`.

```http
POST /api/v1/adviceVoyage
Content-Type: application/json
X-API-Key: <client-or-admin-key>

{"twsId":42,"userName":"YOUR_USER"}
```

`cancelVoyage` uses the same body. `billVoyage` accepts `{"twsId":42}`.

```http
POST /api/v1/startScheduler
Content-Type: application/json
X-API-Key: <admin-key>

{"name":"PROCESS_VOYAGE_SCH"}
```

`stopScheduler` uses the same body. Use actual UAT identifiers; command operations may write to Oracle.
