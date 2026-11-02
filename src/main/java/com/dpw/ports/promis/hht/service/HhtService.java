package com.dpw.ports.promis.hht.service;

import com.dpw.ports.promis.hht.type.AcceptTokenReqType;
import com.dpw.ports.promis.hht.type.AcceptTokenResType;
import com.dpw.ports.promis.hht.type.AddMTRefusalResType;
import com.dpw.ports.promis.hht.type.AddMTRefusalReqType;
import com.dpw.ports.promis.hht.type.AdjustTimeSlotReqType;
import com.dpw.ports.promis.hht.type.AdjustTimeSlotRespType;
import com.dpw.ports.promis.hht.type.CTMSUpdVesselResType;
import com.dpw.ports.promis.hht.type.CTMSVoyageResType;
import com.dpw.ports.promis.hht.type.ComTruckNoReqType;
import com.dpw.ports.promis.hht.type.ComTruckNoRespType;
import com.dpw.ports.promis.hht.type.ConfirmGateoutMoveReqType;
import com.dpw.ports.promis.hht.type.ConfirmGateoutMoveResType;
import com.dpw.ports.promis.hht.type.ContainerReqType;
import com.dpw.ports.promis.hht.type.ContainerResType;
import com.dpw.ports.promis.hht.type.ContrLocationReqType;
import com.dpw.ports.promis.hht.type.ContrLocationResType;
import com.dpw.ports.promis.hht.type.ContrReqType;
import com.dpw.ports.promis.hht.type.ContrResType;
import com.dpw.ports.promis.hht.type.DamageReqType;
import com.dpw.ports.promis.hht.type.DamageResType;
import com.dpw.ports.promis.hht.type.CodeResType;
import com.dpw.ports.promis.hht.type.EirReqType;
import com.dpw.ports.promis.hht.type.EirResType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutSearchReqType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutSearchResType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutUpdateReqType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutUpdateResType;
import com.dpw.ports.promis.hht.type.MajorDamageFlagResType;
import com.dpw.ports.promis.hht.type.MarinePushReqType;
import com.dpw.ports.promis.hht.type.MarinePushRespType;
import com.dpw.ports.promis.hht.type.PrintEirReqType;
import com.dpw.ports.promis.hht.type.PrintEirResType;
import com.dpw.ports.promis.hht.type.RefDataRespType;
import com.dpw.ports.promis.hht.type.SealReqType;
import com.dpw.ports.promis.hht.type.SealResType;
import com.dpw.ports.promis.hht.type.SignReqType;
import com.dpw.ports.promis.hht.type.SignRespType;
import com.dpw.ports.promis.hht.type.StandardReqType;
import com.dpw.ports.promis.hht.type.TOSMsgReqType;
import com.dpw.ports.promis.hht.type.TOSMsgResType;
import com.dpw.ports.promis.hht.type.TokenResType;
import com.dpw.ports.promis.hht.type.TruckEIRResType;
import com.dpw.ports.promis.hht.type.TruckReqType;
import com.dpw.ports.promis.hht.type.TruckResType;
import com.dpw.ports.promis.hht.type.UpdVesselReqType;
import com.dpw.ports.promis.hht.type.UpdateSealReqType;
import com.dpw.ports.promis.hht.type.UpdateSealResType;
import com.dpw.ports.promis.hht.type.VGMWtReqType;
import com.dpw.ports.promis.hht.type.VGMWtResType;
import com.dpw.ports.promis.hht.type.VGMWtType;
import com.dpw.ports.promis.hht.type.VerifyUserReqType;
import com.dpw.ports.promis.hht.type.VerifyUserRespType;
import com.dpw.ports.promis.hht.type.VoyagesResType;

import com.dpw.ports.promis.hht.type.NoticeDetailsReqType;
import com.dpw.ports.promis.hht.type.NoticeDetailsResType;
import com.dpw.ports.promis.hht.type.UpdateNoticeDetailsReqType;
import com.dpw.ports.promis.hht.type.UpdateNoticeDetailsResType;
import com.dpw.ports.promis.hht.type.BerthResType;

import com.dpw.ports.promis.hht.type.ContainerDamageReqType;
import com.dpw.ports.promis.hht.type.ContainerDamageRespType;
import com.dpw.ports.promis.hht.type.TokenTimeSlotReqType;
import com.dpw.ports.promis.hht.type.TokenTimeSlotResType;
import com.dpw.ports.promis.hht.type.TruckEIRReqType;
import com.dpw.ports.promis.hht.type.TruckInfoReqType;
import com.dpw.ports.promis.hht.type.TruckInfoResType;
import com.dpw.ports.promis.hht.type.UpdateVGMReqType;
import com.dpw.ports.promis.hht.type.UpdateVGMResType;
import com.dpw.ports.promis.hht.type.UpdateCustmReqType;
import com.dpw.ports.promis.hht.type.UpdateCustmResType;

import com.dpw.ports.promis.hht.type.UpdateDamagesReqType;
import com.dpw.ports.promis.hht.type.UpdateDamagesResType;
import com.dpw.ports.promis.hht.type.UpdateStdDmgDtlsReqType;
import com.dpw.ports.promis.hht.type.UpdateStdDmgDtlsRespType;

import java.util.Map;

public interface HhtService {

    /**
     * This method retrieves all the planned voyages.
     *
     * @param userInfo
     * @return
     */
    public VoyagesResType getVoyages(StandardReqType userInfo);

    /**
     * This method retrieves ref_data required for HHT.
     *
     * @param getRefDataInput
     * @return
     */
    public RefDataRespType getRefData(StandardReqType getRefDataInput);

    /**
     *
     * @param pushMarineDetailsInput
     * @return
     */
    public MarinePushRespType pushMarineDetails(MarinePushReqType pushMarineDetailsInput);

    /**
     *
     * @param uploadSignatureInput
     * @return
     */
    public SignRespType uploadSignature(SignReqType uploadSignatureInput);

    public CTMSVoyageResType getVoyagesFromCTMS(StandardReqType getVoyagesForCTMS);

    public CTMSUpdVesselResType CTMSVoyageUpdate(UpdVesselReqType CTMSVoyageUpdateInput);

    /**
     * This method retrieves all the tokens.
     *
     * @param userInfo
     * @return
     */
    public TokenResType getTokens(StandardReqType userInfo);

    /**
     * This method retrieves single tokens based on the vehicle details.
     *
     * @param TruckReqType
     * @return
     */
    public TruckResType getTokenForTruck (TruckReqType truckReqType);

    //230517 starts
     public TruckEIRResType getDWCTruckEIR (TruckEIRReqType truckReqType);
     //230517 ends
        // customGate Changes 021116
     public UpdateCustmResType updateCustmGateEntry (UpdateCustmReqType updateCustmReqType);
    /**
     * This method retrives container weight details
     *
     * @param vgmWtType
     * @return
     */
     public VGMWtResType getVGMContainerWeightDetails (VGMWtReqType vgmWtType);

     /**
     * This method update container final weight
     * @param updateVGMReqType
     * @return
     */
     public UpdateVGMResType updateVGMContainerWeightDetails(UpdateVGMReqType updateVGMReqType);


    public ContainerResType getDynamicMTContainer (ContainerReqType containerReqType);

    public ContrResType getDEDContrPlanMoves(ContrReqType contrReqType);

    public TOSMsgResType sendTOSMsg(TOSMsgReqType tosMsgReqType);

    public UpdateSealResType updateContainer(UpdateSealReqType updateSealReqType);

    //Added by ics.raj for MT Refusal(CRR)
    public AddMTRefusalResType addMTRefusal(AddMTRefusalReqType addMTRefusalReqType);

    public AcceptTokenResType acceptToken(AcceptTokenReqType acceptTokenReqType);

    public EirResType getEir (EirReqType eirReqType);

    public ConfirmGateoutMoveResType confirmGateoutMove(ConfirmGateoutMoveReqType confirmGateoutMoveReqType);

    public FZGPGateInOutSearchResType getFZGPGateInOutSearchList(FZGPGateInOutSearchReqType eFZGPGateInOutSearchInput);

    public FZGPGateInOutUpdateResType procFZGPGateInOutUpdate(FZGPGateInOutUpdateReqType eFZGPGateInOutUpdateInput);

    public SealResType prevSealDetails(SealReqType req);

    public DamageResType prevDamageDetails(DamageReqType req);

    //[CTO-MAJOR DAMAGE ENHANCEMENT CR]
    public CodeResType getMajorDamages(boolean includeNonMajor);
    //[/CTO-MAJOR DAMAGE ENHANCEMENT CR]

    //[Damage: Standing instruction]
    public ContainerDamageRespType getContainerDamages(ContainerDamageReqType containers);
    public UpdateStdDmgDtlsRespType updateStdDmgDetails(UpdateStdDmgDtlsReqType stdDmgDtl);
    //[/Damage: Standing instruction]

    public ComTruckNoRespType getTokenContrDtlsForTruck(ComTruckNoReqType comTruckNoReqType);

    public VerifyUserRespType verifyUser(VerifyUserReqType verifyUserInput);

    /** Added by CMCTEAM (Annapurna) to get location and Print EIR through MDT */

    /**
     * This method retrieves Location for Container through MDT device.
     *
     * @param LocationReqType
     * @return LocationResType
     */
    public ContrLocationResType getContrLocation(ContrLocationReqType contrLocReqType);

    /**
     * This method prints EIR for Container through MDT device.
     *
     * @param EirReqType
     * @return EirResType
     */
    public

    PrintEirResType printEir(PrintEirReqType printEirReqType);

    /* End **/
    /**
     *
     * @param NoticeDetailsReqType
     * @return NoticeDetailsResType
     */
    public NoticeDetailsResType getNoticeDetailsForVessel(NoticeDetailsReqType noticeDetailsReq);

    /**
     *
     * @param UpdateNoticeDetailsReqType
     * @return UpdateNoticeDetailsResType
     */
     public UpdateNoticeDetailsResType updateNoticeDetailsForVessel(UpdateNoticeDetailsReqType updateNoticeDetailsReq);

     /**
      *
      * @param StandardReqType
      * @return BerthResType
      */
     public BerthResType getBerthDetails(StandardReqType userInfo);

     /**
      *
      * @param TokenTimeSlotReqType
      * @return TokenTimeSlotResType
      */
     public TokenTimeSlotResType getTokenTimeSlot(TokenTimeSlotReqType tokenTimeSlot);

     /**
     * Get trunk info by container
     * @param TruckInfoReqType
     * @return TruckInfoResType
     */
     public TruckInfoResType getTruckInfoByContainer(TruckInfoReqType truckInfoReqType);

     /**
     *
     * @param req
     * @return
     */
     public AdjustTimeSlotRespType getAdjustTimeSlot(AdjustTimeSlotReqType req);

     /**
      * Get Major Damage Flag
      * @return MajorDamageFlagResType
      */
     //[CTO-MAJOR DAMAGE ENHANCEMENT CR]
     public MajorDamageFlagResType getMajorDamageFlag();

    public UpdateDamagesResType updateContainerWithDamages(UpdateDamagesReqType updateDamagesReqType);
}
