package com.dpw.ports.promis.web;
import com.dpw.ports.promis.hht.service.HhtService;import com.dpw.ports.promis.hht.type.*;import org.springframework.web.bind.annotation.*;import jakarta.validation.Valid;
@RestController @RequestMapping(value="/api/v1",produces="application/json")
public class HhtController{
 private final HhtService service;public HhtController(HhtService service){this.service=service;}
 @PostMapping(value="/marine/voyages/search",consumes="application/json")
 public VoyagesResType getVoyages(@Valid @RequestBody StandardReqType request) {return service.getVoyages(request);}
 @PostMapping(value="/reference-data/search",consumes="application/json")
 public RefDataRespType getRefData(@Valid @RequestBody StandardReqType request) {return service.getRefData(request);}
 @PostMapping(value="/marine/transactions",consumes="application/json")
 public MarinePushRespType pushMarineDetails(@Valid @RequestBody MarinePushReqType request) {return service.pushMarineDetails(request);}
 @PostMapping(value="/marine/signatures",consumes="application/json")
 public SignRespType uploadSignature(@Valid @RequestBody SignReqType request) {return service.uploadSignature(request);}
 @PostMapping(value="/ctms/voyages/search",consumes="application/json")
 public CTMSVoyageResType getVoyagesFromCTMS(@Valid @RequestBody StandardReqType request) {return service.getVoyagesFromCTMS(request);}
 @PostMapping(value="/ctms/voyage-updates",consumes="application/json")
 public CTMSUpdVesselResType CTMSVoyageUpdate(@Valid @RequestBody UpdVesselReqType request) {return service.CTMSVoyageUpdate(request);}
 @PostMapping(value="/tokens/search",consumes="application/json")
 public TokenResType getTokens(@Valid @RequestBody StandardReqType request) {return service.getTokens(request);}
 @PostMapping(value="/trucks/token-search",consumes="application/json")
 public TruckResType getTokenForTruck(@Valid @RequestBody TruckReqType request) {return service.getTokenForTruck(request);}
 @PostMapping(value="/trucks/eirs/search",consumes="application/json")
 public TruckEIRResType getDWCTruckEIR(@Valid @RequestBody TruckEIRReqType request) {return service.getDWCTruckEIR(request);}
 @PostMapping(value="/gates/customs-entries",consumes="application/json")
 public UpdateCustmResType updateCustmGateEntry(@Valid @RequestBody UpdateCustmReqType request) {return service.updateCustmGateEntry(request);}
 @PostMapping(value="/containers/empty-allocations",consumes="application/json")
 public ContainerResType getDynamicMTContainer(@Valid @RequestBody ContainerReqType request) {return service.getDynamicMTContainer(request);}
 @PostMapping(value="/containers/planned-moves/search",consumes="application/json")
 public ContrResType getDEDContrPlanMoves(@Valid @RequestBody ContrReqType request) {return service.getDEDContrPlanMoves(request);}
 @PostMapping(value="/tos/messages",consumes="application/json")
 public TOSMsgResType sendTOSMsg(@Valid @RequestBody TOSMsgReqType request) {return service.sendTOSMsg(request);}
 @PostMapping(value="/containers/seal-updates",consumes="application/json")
 public UpdateSealResType updateContainer(@Valid @RequestBody UpdateSealReqType request) {return service.updateContainer(request);}
 @PostMapping(value="/tokens/acceptances",consumes="application/json")
 public AcceptTokenResType acceptToken(@Valid @RequestBody AcceptTokenReqType request) {return service.acceptToken(request);}
 @PostMapping(value="/eirs/search",consumes="application/json")
 public EirResType getEir(@Valid @RequestBody EirReqType request) {return service.getEir(request);}
 @PostMapping(value="/gates/exit-confirmations",consumes="application/json")
 public ConfirmGateoutMoveResType confirmGateoutMove(@Valid @RequestBody ConfirmGateoutMoveReqType request) {return service.confirmGateoutMove(request);}
 @PostMapping(value="/gate-passes/search",consumes="application/json")
 public FZGPGateInOutSearchResType getFZGPGateInOutSearchList(@Valid @RequestBody FZGPGateInOutSearchReqType request) {return service.getFZGPGateInOutSearchList(request);}
 @PostMapping(value="/gate-passes/movements",consumes="application/json")
 public FZGPGateInOutUpdateResType procFZGPGateInOutUpdate(@Valid @RequestBody FZGPGateInOutUpdateReqType request) {return service.procFZGPGateInOutUpdate(request);}
 @PostMapping(value="/containers/seal-history/search",consumes="application/json")
 public SealResType prevSealDetails(@Valid @RequestBody SealReqType request) {return service.prevSealDetails(request);}
 @PostMapping(value="/containers/damage-history/search",consumes="application/json")
 public DamageResType prevDamageDetails(@Valid @RequestBody DamageReqType request) {return service.prevDamageDetails(request);}
 @PostMapping(value="/damage-codes/search",consumes="application/json")
 public CodeResType getMajorDamages(@Valid @RequestBody CodeReqType request) {return service.getMajorDamages(Integer.valueOf(1).equals(request.getIncludeNonMajor()));}
 @PostMapping(value="/users/verifications",consumes="application/json")
 public VerifyUserRespType verifyUser(@Valid @RequestBody VerifyUserReqType request) {return service.verifyUser(request);}
 @PostMapping(value="/commercial-trucks/token-search",consumes="application/json")
 public ComTruckNoRespType getTokenForCommercialTruck(@Valid @RequestBody ComTruckNoReqType request) {return service.getTokenContrDtlsForTruck(request);}
 @PostMapping(value="/containers/location-search",consumes="application/json")
 public ContrLocationResType getContrLocation(@Valid @RequestBody ContrLocationReqType request) {return service.getContrLocation(request);}
 @PostMapping(value="/eirs/print-jobs",consumes="application/json")
 public PrintEirResType printEir(@Valid @RequestBody PrintEirReqType request) {return service.printEir(request);}
 @PostMapping(value="/containers/empty-refusals",consumes="application/json")
 public AddMTRefusalResType addMTRefusal(@Valid @RequestBody AddMTRefusalReqType request) {return service.addMTRefusal(request);}
 @PostMapping(value="/vessels/notices/search",consumes="application/json")
 public NoticeDetailsResType getNoticeDetailsForVessel(@Valid @RequestBody NoticeDetailsReqType request) {return service.getNoticeDetailsForVessel(request);}
 @PostMapping(value="/vessels/notice-updates",consumes="application/json")
 public UpdateNoticeDetailsResType updateNoticeDetailsForVessel(@Valid @RequestBody UpdateNoticeDetailsReqType request) {return service.updateNoticeDetailsForVessel(request);}
 @PostMapping(value="/berths/search",consumes="application/json")
 public BerthResType getBerthDetails(@Valid @RequestBody StandardReqType request) {return service.getBerthDetails(request);}
 @PostMapping(value="/containers/weights/search",consumes="application/json")
 public VGMWtResType getVGMContainerWeightDetails(@Valid @RequestBody VGMWtReqType request) {return service.getVGMContainerWeightDetails(request);}
 @PostMapping(value="/containers/weight-updates",consumes="application/json")
 public UpdateVGMResType updateVGMContainerWeightDetails(@Valid @RequestBody UpdateVGMReqType request) {return service.updateVGMContainerWeightDetails(request);}
 @PostMapping(value="/tokens/time-slots/search",consumes="application/json")
 public TokenTimeSlotResType getTokenTimeSlot(@Valid @RequestBody TokenTimeSlotReqType request) {return service.getTokenTimeSlot(request);}
 @PostMapping(value="/containers/truck-search",consumes="application/json")
 public TruckInfoResType getTruckInfoByContainer(@Valid @RequestBody TruckInfoReqType request) {return service.getTruckInfoByContainer(request);}
 @PostMapping(value="/tokens/time-slot-adjustments",consumes="application/json")
 public AdjustTimeSlotRespType getAdjustTimeSlot(@Valid @RequestBody AdjustTimeSlotReqType request) {return service.getAdjustTimeSlot(request);}
 @PostMapping(value="/containers/standing-damages/search",consumes="application/json")
 public ContainerDamageRespType getContainerDamages(@Valid @RequestBody ContainerDamageReqType request) {return service.getContainerDamages(request);}
 @PostMapping(value="/containers/standing-damage-updates",consumes="application/json")
 public UpdateStdDmgDtlsRespType updateStdDmgDetails(@Valid @RequestBody UpdateStdDmgDtlsReqType request) {return service.updateStdDmgDetails(request);}
 @GetMapping(value="/configuration/major-damage-flag")
 public MajorDamageFlagResType getMajorDamageFlag() {return service.getMajorDamageFlag();}
 @PostMapping(value="/containers/damage-updates",consumes="application/json")
 public UpdateDamagesResType updateContainerWithDamages(@Valid @RequestBody UpdateDamagesReqType request) {return service.updateContainerWithDamages(request);}
}
