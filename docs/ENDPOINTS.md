# REST endpoint mapping

Use `X-API-Key`. Scheduler routes require the admin key. POST searches carry complex criteria or legacy credentials in the body. Commands are POST because procedure side effects/idempotency are not guaranteed. Do not automatically retry writes.

| Legacy operation | HTTP | Path | Request | Response |
|---|---|---|---|---|
| getVoyages | POST | `/api/v1/marine/voyages/search` | StandardReqType | VoyagesResType |
| getRefData | POST | `/api/v1/reference-data/search` | StandardReqType | RefDataRespType |
| pushMarineDetails | POST | `/api/v1/marine/transactions` | MarinePushReqType | MarinePushRespType |
| uploadSignature | POST | `/api/v1/marine/signatures` | SignReqType | SignRespType |
| getVoyagesFromCTMS | POST | `/api/v1/ctms/voyages/search` | StandardReqType | CTMSVoyageResType |
| CTMSVoyageUpdate | POST | `/api/v1/ctms/voyage-updates` | UpdVesselReqType | CTMSUpdVesselResType |
| getTokens | POST | `/api/v1/tokens/search` | StandardReqType | TokenResType |
| getTokenForTruck | POST | `/api/v1/trucks/token-search` | TruckReqType | TruckResType |
| getDWCTruckEIR | POST | `/api/v1/trucks/eirs/search` | TruckEIRReqType | TruckEIRResType |
| updateCustmGateEntry | POST | `/api/v1/gates/customs-entries` | UpdateCustmReqType | UpdateCustmResType |
| getDynamicMTContainer | POST | `/api/v1/containers/empty-allocations` | ContainerReqType | ContainerResType |
| getDEDContrPlanMoves | POST | `/api/v1/containers/planned-moves/search` | ContrReqType | ContrResType |
| sendTOSMsg | POST | `/api/v1/tos/messages` | TOSMsgReqType | TOSMsgResType |
| updateContainer | POST | `/api/v1/containers/seal-updates` | UpdateSealReqType | UpdateSealResType |
| acceptToken | POST | `/api/v1/tokens/acceptances` | AcceptTokenReqType | AcceptTokenResType |
| getEir | POST | `/api/v1/eirs/search` | EirReqType | EirResType |
| confirmGateoutMove | POST | `/api/v1/gates/exit-confirmations` | ConfirmGateoutMoveReqType | ConfirmGateoutMoveResType |
| getFZGPGateInOutSearchList | POST | `/api/v1/gate-passes/search` | FZGPGateInOutSearchReqType | FZGPGateInOutSearchResType |
| procFZGPGateInOutUpdate | POST | `/api/v1/gate-passes/movements` | FZGPGateInOutUpdateReqType | FZGPGateInOutUpdateResType |
| prevSealDetails | POST | `/api/v1/containers/seal-history/search` | SealReqType | SealResType |
| prevDamageDetails | POST | `/api/v1/containers/damage-history/search` | DamageReqType | DamageResType |
| getMajorDamages | POST | `/api/v1/damage-codes/search` | CodeReqType | CodeResType |
| verifyUser | POST | `/api/v1/users/verifications` | VerifyUserReqType | VerifyUserRespType |
| getTokenForCommercialTruck | POST | `/api/v1/commercial-trucks/token-search` | ComTruckNoReqType | ComTruckNoRespType |
| getContrLocation | POST | `/api/v1/containers/location-search` | ContrLocationReqType | ContrLocationResType |
| printEir | POST | `/api/v1/eirs/print-jobs` | PrintEirReqType | PrintEirResType |
| addMTRefusal | POST | `/api/v1/containers/empty-refusals` | AddMTRefusalReqType | AddMTRefusalResType |
| getNoticeDetailsForVessel | POST | `/api/v1/vessels/notices/search` | NoticeDetailsReqType | NoticeDetailsResType |
| updateNoticeDetailsForVessel | POST | `/api/v1/vessels/notice-updates` | UpdateNoticeDetailsReqType | UpdateNoticeDetailsResType |
| getBerthDetails | POST | `/api/v1/berths/search` | StandardReqType | BerthResType |
| getVGMContainerWeightDetails | POST | `/api/v1/containers/weights/search` | VGMWtReqType | VGMWtResType |
| updateVGMContainerWeightDetails | POST | `/api/v1/containers/weight-updates` | UpdateVGMReqType | UpdateVGMResType |
| getTokenTimeSlot | POST | `/api/v1/tokens/time-slots/search` | TokenTimeSlotReqType | TokenTimeSlotResType |
| getTruckInfoByContainer | POST | `/api/v1/containers/truck-search` | TruckInfoReqType | TruckInfoResType |
| getAdjustTimeSlot | POST | `/api/v1/tokens/time-slot-adjustments` | AdjustTimeSlotReqType | AdjustTimeSlotRespType |
| getContainerDamages | POST | `/api/v1/containers/standing-damages/search` | ContainerDamageReqType | ContainerDamageRespType |
| updateStdDmgDetails | POST | `/api/v1/containers/standing-damage-updates` | UpdateStdDmgDtlsReqType | UpdateStdDmgDtlsRespType |
| getMajorDamageFlag | GET | `/api/v1/configuration/major-damage-flag` | None | MajorDamageFlagResType |
| updateContainerWithDamages | POST | `/api/v1/containers/damage-updates` | UpdateDamagesReqType | UpdateDamagesResType |
| generateRotationNo | POST | `/api/v1/voyages/rotations` | Voyage | Rotation |
| adviceVoyage | POST | `/api/v1/voyages/{twsId}/advices` | Actor | Outcome |
| cancelVoyage | POST | `/api/v1/voyages/{twsId}/cancellations` | Actor | Outcome |
| billVoyage | POST | `/api/v1/voyages/{twsId}/billings` | None | Outcome |
| getConfiguredJobsForMarineAQ | GET | `/api/v1/admin/schedulers` | None | SchedulerNames |
| startScheduler | POST | `/api/v1/admin/schedulers/{name}/starts` | None | Outcome |
| stopScheduler | POST | `/api/v1/admin/schedulers/{name}/stops` | None | Outcome |

## GAS routes in the same executable

These routes use HTTP Basic (`gasws.security`), not `X-API-Key`. See the root README for payloads.

| Method | Path | Operation |
|---|---|---|
| GET | `/api/v1/tokens` | getTokenDetails |
| GET | `/api/v1/containers` | getContainerDetails |
| POST | `/api/v1/eir-location-requests` | getEirLocationDetails |
| POST | `/api/v1/gate-exceptions` | postExceptionData |
