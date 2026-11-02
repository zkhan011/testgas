package com.dpw.ports.promis.hht.dao;

import com.dpw.ports.promis.hht.type.AcceptTokenReqType;
import com.dpw.ports.promis.hht.type.AcceptTokenResType;
import com.dpw.ports.promis.hht.type.AddMTRefusalReqType;
import com.dpw.ports.promis.hht.type.AddMTRefusalResType;
import com.dpw.ports.promis.hht.type.AdjustTimeSlotReqType;
import com.dpw.ports.promis.hht.type.AdjustTimeSlotRespType;
import com.dpw.ports.promis.hht.type.CTMSUpdVesselResType;
import com.dpw.ports.promis.hht.type.ComTruckNoReqType;
import com.dpw.ports.promis.hht.type.ComTruckNoRespType;
import com.dpw.ports.promis.hht.type.ConfirmGateoutMoveReqType;
import com.dpw.ports.promis.hht.type.ConfirmGateoutMoveResType;
import com.dpw.ports.promis.hht.type.ContainerReqType;
import com.dpw.ports.promis.hht.type.ContrLocationReqType;
import com.dpw.ports.promis.hht.type.ContrReqType;
import com.dpw.ports.promis.hht.type.DamageReqType;
import com.dpw.ports.promis.hht.type.DamageResType;
import com.dpw.ports.promis.hht.type.CodeResType;
import com.dpw.ports.promis.hht.type.EirReqType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutSearchReqType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutUpdateReqType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutUpdateResType;
import com.dpw.ports.promis.hht.type.LoginInfoReqType;
import com.dpw.ports.promis.hht.type.MarineDetailType;
import com.dpw.ports.promis.hht.type.MarineHeaderType;
import com.dpw.ports.promis.hht.type.PrintEirReqType;
import com.dpw.ports.promis.hht.type.SealReqType;
import com.dpw.ports.promis.hht.type.SealResType;
import com.dpw.ports.promis.hht.type.SignReqType;
import com.dpw.ports.promis.hht.type.StandardReqType;
import com.dpw.ports.promis.hht.type.TOSMsgReqType;
import com.dpw.ports.promis.hht.type.TOSMsgResType;
import com.dpw.ports.promis.hht.type.TruckEIRReqType;
import com.dpw.ports.promis.hht.type.UpdateCustmReqType;
import com.dpw.ports.promis.hht.type.UpdateCustmResType;
import com.dpw.ports.promis.hht.type.VGMWtReqType;
import com.dpw.ports.promis.hht.type.VGMWtType;
import com.dpw.ports.promis.hht.type.VerifyUserReqType;
import com.dpw.ports.promis.hht.type.VerifyUserRespType;

import com.dpw.ports.promis.hht.type.TruckReqType;
import com.dpw.ports.promis.hht.type.UpdVesselReqType;
import com.dpw.ports.promis.hht.type.UpdateSealReqType;
import com.dpw.ports.promis.hht.type.UpdateSealResType;
import com.dpw.ports.promis.hht.type.VoyagesType;

import java.util.List;
import java.util.Map;
import com.dpw.ports.promis.hht.type.NoticeDetailsReqType;
import com.dpw.ports.promis.hht.type.UpdateNoticeDetailsReqType;
import com.dpw.ports.promis.hht.type.BerthType;
import com.dpw.ports.promis.hht.type.ContainerDamageReqType;
import com.dpw.ports.promis.hht.type.ContainerDamageRespType;
import com.dpw.ports.promis.hht.type.TokenSlotType;
import com.dpw.ports.promis.hht.type.TokenTimeSlotReqType;
import com.dpw.ports.promis.hht.type.TruckInfoReqType;
import com.dpw.ports.promis.hht.type.TruckInfoResType;
import com.dpw.ports.promis.hht.type.UpdateDamagesReqType;
import com.dpw.ports.promis.hht.type.UpdateDamagesResType;
import com.dpw.ports.promis.hht.type.UpdateStdDmgDtlsReqType;
import com.dpw.ports.promis.hht.type.UpdateStdDmgDtlsRespType;
import com.dpw.ports.promis.hht.type.UpdateVGMReqType;
import com.dpw.ports.promis.hht.type.UpdateVGMResType;


public interface HhtIntegrationsDAO {

    public List<VoyagesType> getVoyages(StandardReqType standardReqType);

    public Map getRefData(StandardReqType refDataInput);

    public Map pushMarineDetails(MarineHeaderType marineHeaderType, MarineDetailType[] marineDetailTypes);

    public Map checkUser(LoginInfoReqType loginInfoType );

    public String uploadSignature(SignReqType signtype) ;

    public Map getVoyagesFromCTMS(StandardReqType getVoyagesForCTMS);

    public CTMSUpdVesselResType CTMSVoyageUpdate(UpdVesselReqType CTMSVoyageUpdateInput);

    public Map getTokens(StandardReqType standardReqType);

    public Map getTokenForTruck (TruckReqType truckReqType);
    //230517 starts
    public Map getDWCTruckEIR (TruckEIRReqType truckEIRReqType);
    //230517 ends
    // customGate Changes 021116
     public UpdateCustmResType updateCustmGateEntry (UpdateCustmReqType updateCustmReqType);
    // 160616 VGM changes
     public Map getVGMContainerWeightDetails (VGMWtReqType vgmWtType);
     public UpdateVGMResType updateVGMContainerWeightDetails (UpdateVGMReqType updateVGMReqType);
    // end of vgm
    public UpdateSealResType updateContainer(UpdateSealReqType updateSealReqType);

    //Added by ics.raj for MT Refusal(CRR)
    public AddMTRefusalResType addMTRefusal(AddMTRefusalReqType updateSealReqType);

    public AcceptTokenResType acceptToken(AcceptTokenReqType acceptTokenReqType);

    public Map getEir (EirReqType EirReqType);

    public ConfirmGateoutMoveResType confirmGateoutMove(ConfirmGateoutMoveReqType confirmGateoutMoveReqType);

    public Map FZGPGateInOutSearch(FZGPGateInOutSearchReqType FZGPGateInOutSearchInput);

    public FZGPGateInOutUpdateResType FZGPGateInOutUpdate(FZGPGateInOutUpdateReqType FZGPGateInOutUpdateInput);

    public Map getTokenDetails(ContainerReqType req);

    public Map getDEDContrPlanMoves(ContrReqType req);

    public TOSMsgResType sendTOSMsg(TOSMsgReqType tosMsgReqType);

    public SealResType prevSealDetails(SealReqType req);

    public DamageResType prevDamageDetails(DamageReqType req);
    public CodeResType getMajorDamages(boolean includeNonMajor); //[CTO-MAJOR DAMAGE ENHANCEMENT CR]
    //[Damage: Standing instruction]
    public ContainerDamageRespType getContainerDamages(ContainerDamageReqType containers);
    public UpdateStdDmgDtlsRespType updateStdDmgDetails(UpdateStdDmgDtlsReqType stdDmgDtl);
    //[/Damage: Standing instruction]

    public ComTruckNoRespType getTokenContrDtlsForTruck(ComTruckNoReqType truckNoReqType);

    public VerifyUserRespType verifyUser(VerifyUserReqType verifyUserInput);

    /** Added by CMCTEAM (Annapurna) to get location and Print EIR through MDT */

    /**
     * This method retrieves Location for Container through MDT device.
     *
     * @param LocationReqType
     * @return LocationResType
     */
    public Map getContrLocation(ContrLocationReqType contrLocReqType);

    /**
     * This method prints EIR for Container through MDT device.
     *
     * @param EirReqType
     * @return EirResType
     **/
    public Map printEir(PrintEirReqType printEirReqType);

    /**
     *
     * @param NoticeDetailsReqType
     * @return NoticeDetailsResType
     */
    public Map getNoticeDetails(NoticeDetailsReqType noticeDetailsReq);

    /**
     *
     * @param UpdateNoticeDetailsReqType
     * @return UpdateNoticeDetailsResType
     */
    public Map updateNoticeDetails(UpdateNoticeDetailsReqType updateNoticeDetailsReq);

     /**
      *
      * @param StandardReqType
      * @return BerthResType
      */
     public  List<BerthType> getBerthList();

        /**
         *
         * @param StandardReqType
         * @return BerthResType
         */
        public  List<TokenSlotType> getTokenSlotList(TokenTimeSlotReqType tokenTimeSlot);

      public TruckInfoResType getTruckInfoByContainer(TruckInfoReqType truckInfoReqType);

      //Adjust tokenslot starts
       public AdjustTimeSlotRespType getAdjustTimeSlot(AdjustTimeSlotReqType req);
      /**
       * @author Vinculum.Arun
       * @return String
       */
      public String getMajorDamageFlag();

        public UpdateDamagesResType updateContainerWithDamages(UpdateDamagesReqType updateDamagesReqType);

    }
