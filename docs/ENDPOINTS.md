# REST endpoints — legacy operation naming

All 50 business operations use **POST** with `Content-Type: application/json` under `/api/v1`. Names and capitalization match the legacy operation names. Send `{}` for operations without arguments. Authentication and response structures are unchanged.

HHT/voyage operations use `X-API-Key`; scheduler operations require the admin key. The four GAS operations use HTTP Basic. `/actuator/health` and `/openapi.json` remain GET resources.

| Operation | HTTP | Path | Request |
|---|---|---|---|
| getVoyages | POST | `/api/v1/getVoyages` | StandardReqType |
| getRefData | POST | `/api/v1/getRefData` | StandardReqType |
| pushMarineDetails | POST | `/api/v1/pushMarineDetails` | MarinePushReqType |
| uploadSignature | POST | `/api/v1/uploadSignature` | SignReqType |
| getVoyagesFromCTMS | POST | `/api/v1/getVoyagesFromCTMS` | StandardReqType |
| CTMSVoyageUpdate | POST | `/api/v1/CTMSVoyageUpdate` | UpdVesselReqType |
| getTokens | POST | `/api/v1/getTokens` | StandardReqType |
| getTokenForTruck | POST | `/api/v1/getTokenForTruck` | TruckReqType |
| getDWCTruckEIR | POST | `/api/v1/getDWCTruckEIR` | TruckEIRReqType |
| updateCustmGateEntry | POST | `/api/v1/updateCustmGateEntry` | UpdateCustmReqType |
| getDynamicMTContainer | POST | `/api/v1/getDynamicMTContainer` | ContainerReqType |
| getDEDContrPlanMoves | POST | `/api/v1/getDEDContrPlanMoves` | ContrReqType |
| sendTOSMsg | POST | `/api/v1/sendTOSMsg` | TOSMsgReqType |
| updateContainer | POST | `/api/v1/updateContainer` | UpdateSealReqType |
| acceptToken | POST | `/api/v1/acceptToken` | AcceptTokenReqType |
| getEir | POST | `/api/v1/getEir` | EirReqType |
| confirmGateoutMove | POST | `/api/v1/confirmGateoutMove` | ConfirmGateoutMoveReqType |
| getFZGPGateInOutSearchList | POST | `/api/v1/getFZGPGateInOutSearchList` | FZGPGateInOutSearchReqType |
| procFZGPGateInOutUpdate | POST | `/api/v1/procFZGPGateInOutUpdate` | FZGPGateInOutUpdateReqType |
| prevSealDetails | POST | `/api/v1/prevSealDetails` | SealReqType |
| prevDamageDetails | POST | `/api/v1/prevDamageDetails` | DamageReqType |
| getMajorDamages | POST | `/api/v1/getMajorDamages` | CodeReqType |
| verifyUser | POST | `/api/v1/verifyUser` | VerifyUserReqType |
| getTokenForCommercialTruck | POST | `/api/v1/getTokenForCommercialTruck` | ComTruckNoReqType |
| getContrLocation | POST | `/api/v1/getContrLocation` | ContrLocationReqType |
| printEir | POST | `/api/v1/printEir` | PrintEirReqType |
| addMTRefusal | POST | `/api/v1/addMTRefusal` | AddMTRefusalReqType |
| getNoticeDetailsForVessel | POST | `/api/v1/getNoticeDetailsForVessel` | NoticeDetailsReqType |
| updateNoticeDetailsForVessel | POST | `/api/v1/updateNoticeDetailsForVessel` | UpdateNoticeDetailsReqType |
| getBerthDetails | POST | `/api/v1/getBerthDetails` | StandardReqType |
| getVGMContainerWeightDetails | POST | `/api/v1/getVGMContainerWeightDetails` | VGMWtReqType |
| updateVGMContainerWeightDetails | POST | `/api/v1/updateVGMContainerWeightDetails` | UpdateVGMReqType |
| getTokenTimeSlot | POST | `/api/v1/getTokenTimeSlot` | TokenTimeSlotReqType |
| getTruckInfoByContainer | POST | `/api/v1/getTruckInfoByContainer` | TruckInfoReqType |
| getAdjustTimeSlot | POST | `/api/v1/getAdjustTimeSlot` | AdjustTimeSlotReqType |
| getContainerDamages | POST | `/api/v1/getContainerDamages` | ContainerDamageReqType |
| updateStdDmgDetails | POST | `/api/v1/updateStdDmgDetails` | UpdateStdDmgDtlsReqType |
| getMajorDamageFlag | POST | `/api/v1/getMajorDamageFlag` | {} |
| updateContainerWithDamages | POST | `/api/v1/updateContainerWithDamages` | UpdateDamagesReqType |
| generateRotationNo | POST | `/api/v1/generateRotationNo` | Voyage |
| adviceVoyage | POST | `/api/v1/adviceVoyage` | Actor |
| cancelVoyage | POST | `/api/v1/cancelVoyage` | Actor |
| billVoyage | POST | `/api/v1/billVoyage` | VoyageId |
| getConfiguredJobsForMarineAQ | POST | `/api/v1/getConfiguredJobsForMarineAQ` | {} |
| startScheduler | POST | `/api/v1/startScheduler` | SchedulerRequest |
| stopScheduler | POST | `/api/v1/stopScheduler` | SchedulerRequest |
| getTokenDetails | POST | `/api/v1/getTokenDetails` | TokenSearch |
| getContainerDetails | POST | `/api/v1/getContainerDetails` | ContainerSearch |
| getEirLocationDetails | POST | `/api/v1/getEirLocationDetails` | {} |
| postExceptionData | POST | `/api/v1/postExceptionData` | {} |

See [ENDPOINT-CHANGES.md](ENDPOINT-CHANGES.md) for breaking changes and request examples.
