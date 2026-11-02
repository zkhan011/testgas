package com.dpw.ports.promis.hht.service;

import com.dpw.ports.promis.common.util.PromisUtil;
import com.dpw.ports.promis.hht.dao.HhtIntegrationsDAO;
import com.dpw.ports.promis.hht.type.AcceptTokenReqType;
import com.dpw.ports.promis.hht.type.AcceptTokenResType;
import com.dpw.ports.promis.hht.type.AddMTRefusalReqType;
import com.dpw.ports.promis.hht.type.AddMTRefusalResType;
import com.dpw.ports.promis.hht.type.AdjustTimeSlotReqType;
import com.dpw.ports.promis.hht.type.AdjustTimeSlotRespType;
import com.dpw.ports.promis.hht.type.AnchorageType;
import com.dpw.ports.promis.hht.type.BoatType;
import com.dpw.ports.promis.hht.type.BouyType;
import com.dpw.ports.promis.hht.type.CTMSUpdVesselResType;
import com.dpw.ports.promis.hht.type.CTMSVoyageResType;
import com.dpw.ports.promis.hht.type.CTMSVoyagesType;
import com.dpw.ports.promis.hht.type.ComTruckNoReqType;
import com.dpw.ports.promis.hht.type.ComTruckNoRespType;
import com.dpw.ports.promis.hht.type.ConfirmGateoutMoveReqType;
import com.dpw.ports.promis.hht.type.ConfirmGateoutMoveResType;
import com.dpw.ports.promis.hht.type.ContainerReqType;
import com.dpw.ports.promis.hht.type.ContainerResType;
import com.dpw.ports.promis.hht.type.ContainerType;
import com.dpw.ports.promis.hht.type.ContrLocationReqType;
import com.dpw.ports.promis.hht.type.ContrLocationResType;
import com.dpw.ports.promis.hht.type.ContrLocationType;
import com.dpw.ports.promis.hht.type.ContrReqType;
import com.dpw.ports.promis.hht.type.ContrResType;
import com.dpw.ports.promis.hht.type.DamageReqType;
import com.dpw.ports.promis.hht.type.DamageResType;
import com.dpw.ports.promis.hht.type.CodeResType;
import com.dpw.ports.promis.hht.type.DummyContainerType;
import com.dpw.ports.promis.hht.type.EirReqType;
import com.dpw.ports.promis.hht.type.EirResType;
import com.dpw.ports.promis.hht.type.EirType;
import com.dpw.ports.promis.hht.type.ExceptionType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutSearchList;
import com.dpw.ports.promis.hht.type.FZGPGateInOutSearchReqType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutSearchResType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutUpdateReqType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutUpdateResType;
import com.dpw.ports.promis.hht.type.LocationType;
import com.dpw.ports.promis.hht.type.LoginInfoReqType;
import com.dpw.ports.promis.hht.type.MajorDamageFlagResType;
import com.dpw.ports.promis.hht.type.MarineDetailType;
import com.dpw.ports.promis.hht.type.MarineHeaderType;
import com.dpw.ports.promis.hht.type.MarinePushReqType;
import com.dpw.ports.promis.hht.type.MarinePushRespType;
import com.dpw.ports.promis.hht.type.MoveType;
import com.dpw.ports.promis.hht.type.PilotType;
import com.dpw.ports.promis.hht.type.PrintEirReqType;
import com.dpw.ports.promis.hht.type.PrintEirResType;
import com.dpw.ports.promis.hht.type.PrintEirType;
import com.dpw.ports.promis.hht.type.RefDataRespType;
import com.dpw.ports.promis.hht.type.SealReqType;
import com.dpw.ports.promis.hht.type.SealResType;
import com.dpw.ports.promis.hht.type.ServiceExceptionType;
import com.dpw.ports.promis.hht.type.SignReqType;
import com.dpw.ports.promis.hht.type.SignRespType;
import com.dpw.ports.promis.hht.type.StandardReqType;
import com.dpw.ports.promis.hht.type.TOSMsgReqType;
import com.dpw.ports.promis.hht.type.TOSMsgResType;
import com.dpw.ports.promis.hht.type.TokenResType;
import com.dpw.ports.promis.hht.type.TokensType;
import com.dpw.ports.promis.hht.type.TruckReqType;
import com.dpw.ports.promis.hht.type.TruckResType;
import com.dpw.ports.promis.hht.type.TruckType;
import com.dpw.ports.promis.hht.type.TruckEIRType;
import com.dpw.ports.promis.hht.type.TxnType;
import com.dpw.ports.promis.hht.type.UpdVesselReqType;
import com.dpw.ports.promis.hht.type.UpdateSealReqType;
import com.dpw.ports.promis.hht.type.UpdateSealResType;
import com.dpw.ports.promis.hht.type.VGMWtResType;
import com.dpw.ports.promis.hht.type.VerifyUserReqType;
import com.dpw.ports.promis.hht.type.VerifyUserRespType;
import com.dpw.ports.promis.hht.type.VoyagesResType;
import com.dpw.ports.promis.hht.type.VoyagesType;

import java.sql.Time;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dpw.ports.promis.hht.type.NoticeDetailsReqType;
import com.dpw.ports.promis.hht.type.NoticeDetailsResType;
import com.dpw.ports.promis.hht.type.NoticeTypeList;
import com.dpw.ports.promis.hht.type.UpdateNoticeDetailsReqType;
import com.dpw.ports.promis.hht.type.UpdateNoticeDetailsResType;
import com.dpw.ports.promis.hht.type.BerthResType;
import com.dpw.ports.promis.hht.type.BerthType;
import com.dpw.ports.promis.hht.type.ContainerDamageReqType;
import com.dpw.ports.promis.hht.type.ContainerDamageRespType;
import com.dpw.ports.promis.hht.type.TokenSlotType;
import com.dpw.ports.promis.hht.type.TokenTimeSlotReqType;
import com.dpw.ports.promis.hht.type.TokenTimeSlotResType;
import com.dpw.ports.promis.hht.type.TruckEIRReqType;
import com.dpw.ports.promis.hht.type.TruckEIRResType;
import com.dpw.ports.promis.hht.type.TruckInfoReqType;
import com.dpw.ports.promis.hht.type.TruckInfoResType;
import com.dpw.ports.promis.hht.type.UpdateVGMReqType;
import com.dpw.ports.promis.hht.type.UpdateVGMResType;
import com.dpw.ports.promis.hht.type.VGMWtReqType;
import com.dpw.ports.promis.hht.type.VGMWtType;
import com.dpw.ports.promis.hht.type.UpdateCustmReqType;
import com.dpw.ports.promis.hht.type.UpdateCustmResType;
import com.dpw.ports.promis.hht.type.UpdateDamagesReqType;
import com.dpw.ports.promis.hht.type.UpdateDamagesResType;
import com.dpw.ports.promis.hht.type.UpdateStdDmgDtlsReqType;
import com.dpw.ports.promis.hht.type.UpdateStdDmgDtlsRespType;

public class HhtServiceImpl implements HhtService {

    private final HhtIntegrationsDAO hhtDAO;
    private final String inspectionMessage, inspectionFlag;
    public HhtServiceImpl(HhtIntegrationsDAO dao,String message,String flag){hhtDAO=dao;inspectionMessage=message;inspectionFlag=flag;}

    private HhtIntegrationsDAO ctmsHHTDAO;

    private static final Log logger = LogFactory.getLog(HhtServiceImpl.class);

    /* Spring accessor methods*/

public HhtIntegrationsDAO getHhtDAO() {
        return hhtDAO;
    }


    /**
     * @see {@link com.dpw.ports.promis.hht.service.HhtService#getVoyages(StandardReqType)}
     * @param userInfo
     * @return
     */
    public VoyagesResType getVoyages(StandardReqType userInfo) {
        logger.info("Begin HhtServiceImpl.getVoyages at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        VoyagesResType voyageResType = new VoyagesResType();
        try {
            /*
             * Authenticate user details
             */
            logger.info("Authenticating user details...") ;
            String loginInfo =
                checkIfUserLoggedIn(userInfo.getUserCredentials());

            if (StringUtils.isNotEmpty(loginInfo)) {
                logger.info("Authentication failed, forwarding response") ;
                serviceException = new ServiceExceptionType();
                serviceException.setBusinessException(new ExceptionType[] { getExceptionType(loginInfo,
                                                                                             3) });
                voyageResType.setException(serviceException);
                return voyageResType;
            }
            logger.info("Authentication successful, retrieving required information...");

            List<VoyagesType> voyagesList = getHhtDAO().getVoyages(userInfo);
            if (voyagesList.size() == 0) {
                serviceException = new ServiceExceptionType();
                serviceException.setBusinessException(new ExceptionType[] { getExceptionType("No Voyages Found",
                                                                                             2) });
            } else {
                voyageResType.setVoyages(getVoyagesArray(voyagesList));
            }
        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                          2) });
            voyageResType.setException(serviceException);
        }

        logger.info("End HhtServiceImpl.getVoyages at :" + getCurrentTime());
        return voyageResType;

    }

    private ExceptionType getExceptionType(String cause, long code) {
        ExceptionType exceptionType = new ExceptionType();
        exceptionType.setMessage(cause);
        exceptionType.setId(Long.toString(code));
        return exceptionType;
    }

    private VoyagesType[] getVoyagesArray(List<VoyagesType> voyagesList) {
        VoyagesType[] voyagesArray = new VoyagesType[voyagesList.size()];
        int count = 0;
        for (VoyagesType voyage: voyagesList)
            voyagesArray[count++] = voyage;
        return voyagesArray;
    }

    public RefDataRespType getRefData(StandardReqType refDataInput) {
        logger.info("Begin HhtServiceImpl.getRefData() at :" +
                    getCurrentTime());
        ServiceExceptionType serviceException = null;
        RefDataRespType refDataResp = new RefDataRespType();
        try {
           /* String loginInfo =
                checkIfUserLoggedIn(refDataInput.getUserCredentials());
            if (StringUtils.isNotEmpty(loginInfo)) {
                serviceException = new ServiceExceptionType();
                serviceException.setBusinessException(new ExceptionType[] { getExceptionType(loginInfo,
                                                                                             3) });
                refDataResp.setException(serviceException);
                return refDataResp;
            }*/
            Map refMap = getHhtDAO().getRefData(refDataInput);
           // refDataResp.setBoat(getBoatArray((List<BoatType>)refMap.get("pcurboats")));
          //  refDataResp.setBerth(getBerthArray((List<BerthType>)refMap.get("pcurberths")));
           // refDataResp.setLocation(getLocationsArray((List<LocationType>)refMap.get("pcurlocs")));
            //refDataResp.setBouy(getBouyArray((List<BouyType>)refMap.get("pcurbouys")));
             PilotType[] pilotdet = getPilotArray((List<PilotType>)refMap.get("pcurpilots"));
            refDataResp.setPilot(pilotdet);
            //refDataResp.setPilot(getPilotArray((List<PilotType>)refMap.get("pcurpilots")));
            //TruckType[] truckdet = getTruckArray((List<TruckType>)tokensList.get("tokenres"));
            //refDataResp.setMove(getMoveArray((List<MoveType>)refMap.get("pcurmovetypes")));
           // refDataResp.setAnchorage(getAnchorageReasonsArray((List<AnchorageType>)refMap.get("pcuranchtypes")));
        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                          2) });
            refDataResp.setException(serviceException);
        }
        logger.info("End HhtServiceImpl.getRefData() at :" +
                    getCurrentTime());
        return refDataResp;
    }

    private BoatType[] getBoatArray(List<BoatType> boatList) {
        BoatType[] boatType = new BoatType[boatList.size()];
        boatList.toArray(boatType);
        return boatType;
    }

  /*  private BerthType[] getLocationsArray(List<BerthType> berthList) {
        BerthType[] berthArray = new BerthType[berthList.size()];
        berthList.toArray(berthArray);
        return berthArray;
    }*/

   private LocationType[] getLocationsArray(List<LocationType> locationsList) {
           LocationType[] locationsArray = new LocationType[locationsList.size()];
           locationsList.toArray(locationsArray);
           return locationsArray;
   }
    private BouyType[] getBouyArray(List<BouyType> buouList) {
        BouyType[] bouyArray = new BouyType[buouList.size()];
        buouList.toArray(bouyArray);
        return bouyArray;
    }

    private PilotType[] getPilotArray(List<PilotType> pilotList) {
        PilotType[] pilotArray = new PilotType[pilotList.size()];
                             int count = 0;
                             for (PilotType pilot: pilotList)
                                 pilotArray[count++] = pilot;
                             return pilotArray;
        /*PilotType[] pilotArray = new PilotType[pilotList.size()];
        pilotList.toArray(pilotArray);
        return pilotArray;*/
    }

    private MoveType[] getMoveArray(List<MoveType> moveList) {
        MoveType[] moveArray = new MoveType[moveList.size()];
        moveList.toArray(moveArray);
        return moveArray;
    }

    private AnchorageType[] getAnchorageReasonsArray(List<AnchorageType> anchReasonList) {
        AnchorageType[] anchReasonsArray = new AnchorageType[anchReasonList.size()];
        anchReasonList.toArray(anchReasonsArray);
        return anchReasonsArray;
    }

    public MarinePushRespType pushMarineDetails(MarinePushReqType pushMarineDetailsInput) {
        logger.info("Begin HhtServiceImpl.pushMarineDetails() at :" +
                    getCurrentTime());
        ServiceExceptionType serviceException = null;
        MarinePushRespType marinePushResp = new MarinePushRespType();
        TxnType[] txnType =
            new TxnType[pushMarineDetailsInput.getPilotPlanning().length];
        try {
            String loginInfo =
                checkIfUserLoggedIn(pushMarineDetailsInput.getUserCredentials());
            if (StringUtils.isNotEmpty(loginInfo)) {
                serviceException = new ServiceExceptionType();
                serviceException.setBusinessException(new ExceptionType[] { getExceptionType(loginInfo,
                                                                                             3) });
                marinePushResp.setException(serviceException);
                return marinePushResp;
            }
            for (int i = 0;
                 i < pushMarineDetailsInput.getPilotPlanning().length; i++) {
                txnType[i] = new TxnType();
                txnType[i] =
                        push(pushMarineDetailsInput.getPilotPlanning()[i].getMarineHeader(),
                             pushMarineDetailsInput.getPilotPlanning()[i].getMarineDetail());
            }
            marinePushResp.setTxnType(txnType);
        } catch (Exception exception) {
            logger.error(exception);
            exception.printStackTrace();
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                          2) });
            marinePushResp.setException(serviceException);
        }
        logger.info("End HhtServiceImpl.pushMarineDetails() at :" +
                    getCurrentTime());
        return marinePushResp;
    }

    private TxnType push(MarineHeaderType marineHeaderType,
                         MarineDetailType[] marineDetailTypes) {
        Map respMap;
        String excep;
        TxnType txnType = new TxnType();
        ServiceExceptionType serviceException = null;
        Integer txnid = null;
        try {
            txnType.setMdt_txn_id(marineHeaderType.getMdt_txn_id());
            respMap =
                    getHhtDAO().pushMarineDetails(marineHeaderType, marineDetailTypes);
            excep = (String)respMap.get("excep");
            txnid = (Integer)respMap.get("txnid");
            txnType.setTxn_id(txnid);
            if (!StringUtils.isEmpty(excep)) {
                serviceException = new ServiceExceptionType();
                serviceException.setBusinessException(new ExceptionType[] { getExceptionType(excep,
                                                                                             2) });
                txnType.setException(serviceException);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(ex.getMessage(),
                                                                                          4) });
            txnType.setException(serviceException);
        }
        return txnType;
    }

    private String checkIfUserLoggedIn(LoginInfoReqType loginInfoReqType) {
        Map credentialMap = getHhtDAO().checkUser(loginInfoReqType);
        if (!StringUtils.isEmpty((String)credentialMap.get("retval"))) {
            return (String)credentialMap.get("errmsg");
        } else {
            return StringUtils.EMPTY;
        }
    }

    public SignRespType uploadSignature(SignReqType uploadSignatureInput) {
        logger.info("Begin HhtServiceImpl.uploadSignature at :" +
                    getCurrentTime());
        ServiceExceptionType serviceException = null;
        SignRespType signresp = new SignRespType();
        String excep = null;
        try {
            String loginInfo =
                checkIfUserLoggedIn(uploadSignatureInput.getUserCredentials());
            if (StringUtils.isNotEmpty(loginInfo)) {
                serviceException = new ServiceExceptionType();
                serviceException.setBusinessException(new ExceptionType[] { getExceptionType(loginInfo,
                                                                                             3) });
                signresp.setException(serviceException);
                return signresp;
            }
            excep = getHhtDAO().uploadSignature(uploadSignatureInput);
            signresp.setTxn_id(uploadSignatureInput.getTxn_id());
            signresp.setErr_msg(excep);

            logger.info("HhtServiceImpl.uploadSignature - Txn_id :" + uploadSignatureInput.getTxn_id() + " - Err_msg - " + excep);

            if (!StringUtils.isEmpty(excep)) {
                serviceException = new ServiceExceptionType();
                serviceException.setBusinessException(new ExceptionType[] { getExceptionType(excep,
                                                                                             2) });
                signresp.setException(serviceException);
            }

        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                          2) });
            signresp.setException(serviceException);
        }
        logger.info("End HhtServiceImpl.uploadSignature at :" +
                    getCurrentTime());
        return signresp;
    }

    private String getCurrentTime() {
        String currentTime = new Time(System.currentTimeMillis()).toString();
        return currentTime;
    }


  public CTMSVoyageResType getVoyagesFromCTMS(StandardReqType userInfo){
     //       return (CtmsHHTRotnResp)getHhtDAO().getVoyagesFromCTMS(userInfo);
      logger.info("Begin HhtServiceImpl.getVoyagesFromCTMS at :" + getCurrentTime());
      ServiceExceptionType serviceException = null;
     CTMSVoyageResType ctmsVoyagesResType = new CTMSVoyageResType();
      try {

          Map ctmsVoyages = getHhtDAO().getVoyagesFromCTMS(userInfo);
          logger.info("getVoyagesFromCTMS result is :" +     ctmsVoyages.get("errmessage"));
          if(ctmsVoyages.get("errmessage").toString().equalsIgnoreCase("SUCCESS")){
              logger.info("The  ctms voyage value is return");

             CTMSVoyagesType[] voyageTypeIs = getCTMSVoyagesArray((List<CTMSVoyagesType>)ctmsVoyages.get("pcontainerres"));
              logger.info("Total size is "+voyageTypeIs.length);

              if(voyageTypeIs.length == 0){
                  ctmsVoyagesResType.setStatus("No voyage found");
              }else{
                 ctmsVoyagesResType.setStatus(ctmsVoyages.get("errmessage").toString());
                 ctmsVoyagesResType.setVoyages(voyageTypeIs);
              }
          }else{
               logger.info("getVoyagesFromCTMS error message is :" + ctmsVoyages.get("errmessage"));
               /*The following error messages will return from package if any error
                * ie:
                PO_STATUS := 'User id cannot be null';
                PO_STATUS := 'Password cannot be null';
                PO_STATUS := 'Device id  cannot be null';
                PO_STATUS := 'IN PROGRESS';
                   */
                 ctmsVoyagesResType.setStatus(ctmsVoyages.get("errmessage").toString());
           }

      } catch (Exception exception) {
          logger.error(exception);
          serviceException = new ServiceExceptionType();
          serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                        2) });
          ctmsVoyagesResType.setException(serviceException);
      }

      logger.info("End HhtServiceImpl.getVoyagesFromCTMS at :" + getCurrentTime());
      return ctmsVoyagesResType;
   }


public CTMSUpdVesselResType CTMSVoyageUpdate(UpdVesselReqType CTMSVoyageUpdateInput) {
    CTMSUpdVesselResType ctmsUpdVesselResType = new CTMSUpdVesselResType();
    logger.info("Begin HhtServiceImpl.CTMSVoyageUpdate at :" + getCurrentTime());
    ServiceExceptionType serviceException = null;
    CTMSUpdVesselResType ctmsHHTResType = new CTMSUpdVesselResType();
    try
    {
                CTMSUpdVesselResType output = getHhtDAO().CTMSVoyageUpdate(CTMSVoyageUpdateInput);
                logger.info("getErr_msg :" + output.getErr_msg());
                ctmsUpdVesselResType.setErr_msg(output.getErr_msg());
                   //if(ctmsUpdVesselResType.getErr_msg().equalsIgnoreCase("0")) {
                       //Sucess
                     //   ctmsUpdVesselResType.setErr_msg("This is suscess message");
                   //}
    }
    catch (Exception exception) {
    logger.error(exception);
    serviceException = new ServiceExceptionType();
    serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                             2) });
    ctmsHHTResType.setException(serviceException);
}
logger.info("End HhtServiceImpl.getVoyagesFromCTMS at :" + getCurrentTime());
return ctmsUpdVesselResType;
}

private CTMSVoyagesType[] getCTMSVoyagesArray(List<CTMSVoyagesType> ctmsVoyagesList) {
         CTMSVoyagesType[] voyagesArray = new CTMSVoyagesType[ctmsVoyagesList.size()];
         int count = 0;
         for (CTMSVoyagesType voyage: ctmsVoyagesList)
             voyagesArray[count++] = voyage;
         return voyagesArray;
     }

    public void setCtmsHHTDAO(HhtIntegrationsDAO ctmsHHTDAO) {
        this.ctmsHHTDAO = ctmsHHTDAO;
    }

    public HhtIntegrationsDAO getCtmsHHTDAO() {
        return ctmsHHTDAO;
    }



        /**
         * @see {@link com.dpw.ports.promis.hht.service.HhtService#getVoyages(StandardReqType)}
         * @param userInfo
         * @return
         */
public TokenResType getTokens(StandardReqType userInfo) {
            logger.info("Begin HhtServiceImpl.getTokens at :" + getCurrentTime());
            ServiceExceptionType serviceException = null;
            TokenResType tokensResType = new TokenResType();
            try {
                Map tokensList = getHhtDAO().getTokens(userInfo);
                logger.info("getTokens result is :" +     tokensList.get("status"));
                if(tokensList.get("status").toString().equalsIgnoreCase("SUCCESS")){
                        logger.info("The ctms token values returned" );
                TokensType[] token = getTokensArray((List<TokensType>)tokensList.get("tokenres"));
                tokensResType.setTokens(token);
                tokensResType.setStatus(tokensList.get("status").toString());
                }
                else {
                    tokensResType.setStatus(tokensList.get("status").toString());


                }
            }
            catch(Exception exception) {
                logger.error(exception);
                serviceException = new ServiceExceptionType();
                serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                              2) });
                tokensResType.setException(serviceException);
        }
        return tokensResType;
}

private TokensType[] getTokensArray(List<TokensType> tokenList) {
                         TokensType[] tokenArray = new TokensType[tokenList.size()];
                         int count = 0;
                         for (TokensType token: tokenList)
                             tokenArray[count++] = token;
                         return tokenArray;
 }

  public TruckResType getTokenForTruck (TruckReqType truckReqType)
    {
        logger.info("Begin HhtServiceImpl.getTokenForTruck at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        TruckResType truckResType = new TruckResType();
        try {
            Map tokensList = getHhtDAO().getTokenForTruck(truckReqType);
            logger.info("getTokenForTruck result is :" +     tokensList.get("status"));
            if(tokensList.get("status").toString().equalsIgnoreCase("SUCCESS")){
                    logger.info("The ctms token values returned" );
            TruckType[] truckdet = getTruckArray((List<TruckType>)tokensList.get("tokenres"));
            truckResType.setTruckdet(truckdet);
            truckResType.setStatus(tokensList.get("status").toString());
            }
            else {
                truckResType.setStatus(tokensList.get("status").toString());
            }
        }
        catch(Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                          2) });
            truckResType.setException(serviceException);
        }
        return truckResType;
    }
    //230517 starts
     public TruckEIRResType getDWCTruckEIR (TruckEIRReqType truckReqType)
       {
           logger.info("Begin HhtServiceImpl.getDWCTruckEIR at :" + getCurrentTime());
           ServiceExceptionType serviceException = null;
           TruckEIRResType truckResType = new TruckEIRResType();
           try {
               Map tokensList = getHhtDAO().getDWCTruckEIR(truckReqType);
               logger.info("getDWCTruckEIR result is :" +     tokensList.get("status"));
               if(tokensList.get("status").toString().equalsIgnoreCase("SUCCESS")){
                       logger.info("The ctms token values returned" );
               TruckEIRType[] truckdet = getTruckEIRArray((List<TruckEIRType>)tokensList.get("tokendwcres"));
               truckResType.setTruckdet(truckdet);
               truckResType.setStatus(tokensList.get("status").toString());
               }
               else {
                   truckResType.setStatus(tokensList.get("status").toString());
               }
           }
           catch(Exception exception) {
               logger.error(exception);
               serviceException = new ServiceExceptionType();
               serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                             2) });
               truckResType.setException(serviceException);
           }
           return truckResType;
       }
     //230517 ends
   /**
     * Get container weight details
     * @param vgmWtReqType
     * @return
     */
    public VGMWtResType getVGMContainerWeightDetails(VGMWtReqType vgmWtReqType) {
        logger.info("Begin HhtServiceImpl.getVGMContainerWeightDetails at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        VGMWtResType vgmWtResType = new VGMWtResType();
        try {
            if ((!PromisUtil.isEmpty(vgmWtReqType.getRegplate()) &&
                 !PromisUtil.isEmpty(vgmWtReqType.getVehicleno())) ||
                (!PromisUtil.isEmpty(vgmWtReqType.getContainerno()))) {
                Map vgmWtDtls = getHhtDAO().getVGMContainerWeightDetails(vgmWtReqType);
                logger.info("getVGMContainerWeightDetails error is :" + vgmWtDtls.get("po_err_msg"));
                if (!PromisUtil.isEmpty((String)vgmWtDtls.get("po_err_msg"))) {
                    vgmWtResType.setErrorMsg((String)vgmWtDtls.get("po_err_msg"));
                } else {
                    VGMWtType[] vgmWtdet = getVGMWtArray((List<VGMWtType>)vgmWtDtls.get("po_result_cpm"));
                    vgmWtResType.setVgmWtdet(vgmWtdet);
                }
            } else {
                vgmWtResType.setErrorMsg("Either truck number or container is mandatory.");
            }
        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                          2) });
            vgmWtResType.setException(serviceException);
        }
        return vgmWtResType;
    }

    /**
     * Update Container final weight
     * @param updateVGMReqType
     * @return
     */
    public UpdateVGMResType updateVGMContainerWeightDetails(UpdateVGMReqType updateVGMReqType) {
        UpdateVGMResType updateVGMResType = new UpdateVGMResType();
        logger.info("Begin HhtServiceImpl.UpdateVGMResType at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        try {
            UpdateVGMResType output = getHhtDAO().updateVGMContainerWeightDetails(updateVGMReqType);
            updateVGMResType.setStatus(output.getStatus());
            logger.info("HhtServiceImpl.updateVGMContainerWeightDetails - Status :" + output.getStatus());
          }
        catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                                     2) });
            updateVGMResType.setException(serviceException);
        }
        logger.info("End HhtServiceImpl.updateVGMContainerWeightDetails at :" + getCurrentTime());
        return updateVGMResType;

    }

    /**
     *
     * @param updateCustmReqType
     * @return
     */
    public UpdateCustmResType updateCustmGateEntry(UpdateCustmReqType updateCustmReqType) {
        UpdateCustmResType updateCustmResType = new UpdateCustmResType();
        logger.info("Begin HhtServiceImpl.UpdateCustmResType at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        try {
            UpdateCustmResType output = getHhtDAO().updateCustmGateEntry(updateCustmReqType);
            updateCustmResType.setStatus(output.getStatus());
            logger.info("HhtServiceImpl.updateCustmGateEntry - Status :" + output.getStatus());
          }
        catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                                     2) });
            updateCustmResType.setException(serviceException);
        }
        logger.info("End HhtServiceImpl.updateCustmGateEntry at :" + getCurrentTime());
        return updateCustmResType;

    }

    private VGMWtType[] getVGMWtArray(List<VGMWtType> wtList) {
        VGMWtType[] wtArray = new VGMWtType[wtList.size()];
        int count = 0;
        for (VGMWtType wt: wtList)
          wtArray[count++] = wt;
        return wtArray;
     }


private TruckType[] getTruckArray(List<TruckType> truckList) {
        TruckType[] truckArray = new TruckType[truckList.size()];
                             int count = 0;
                             for (TruckType truck: truckList)
                                 truckArray[count++] = truck;
                             return truckArray;
     }
    private TruckEIRType[] getTruckEIRArray(List<TruckEIRType> truckList) {
            TruckEIRType[] truckArray = new TruckEIRType[truckList.size()];
                                 int count = 0;
                                 for (TruckEIRType truck: truckList)
                                     truckArray[count++] = truck;
                                 return truckArray;
         }
    public ContainerResType getDynamicMTContainer(ContainerReqType containerReqType) {
        logger.info("Begin HhtServiceImpl.getTokenDetails at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        ContainerResType containerResType = new ContainerResType();
        try {
            Map params = getHhtDAO().getTokenDetails(containerReqType);
            String tokenNo = (String) params.get("tokenNo");
            String errMsg = (String) params.get("errMsg");
            logger.info("getTokenDetails - errMsg is (" + tokenNo +"): " + errMsg);

            containerResType.setTokenNo(tokenNo);
            containerResType.setErrMsg(errMsg);

            if (errMsg == null || "".equalsIgnoreCase(errMsg.trim())) {

                List<ContainerType> contrList = (List) params.get("contrList");
                int contrListSize = (contrList!= null)?contrList.size():0;
                logger.info("getTokenDetails - contrList size is:" +contrListSize);

                ContainerType[] contrArray = getContainerArray(contrList);
                containerResType.setContrList(contrArray);

            } else {
                containerResType.setContrList(null);
            }
        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                          2) });
        }
        return containerResType;
    }

    public ContrResType getDEDContrPlanMoves(ContrReqType contrReqType) {
        logger.info("Begin HhtServiceImpl.getDEDContrPlanMoves at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        ContrResType contrResType = new ContrResType();
        try {
            Map params = getHhtDAO().getDEDContrPlanMoves(contrReqType);
            String tokenNo = (String) params.get("tokenNo");
            String errMsg = (String) params.get("errMsg");
            logger.info("getDEDContrPlanMoves - errMsg is (" + tokenNo +"): " + errMsg);

            contrResType.setTokenNo(tokenNo);
            contrResType.setErrMsg(errMsg);

            if (errMsg == null || "".equalsIgnoreCase(errMsg.trim())) {

                List<DummyContainerType> contrList = (List<DummyContainerType>) params.get("dummyContrList");
                int contrListSize = (contrList!= null)?contrList.size():0;
                logger.info("getDEDContrPlanMoves - contrList size is:" +contrListSize);
                contrResType.setDummyContrList(contrList.toArray(new DummyContainerType[contrList.size()]));


            } else {
                contrResType.setDummyContrList(null);
            }
        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                          2) });
        }
        return contrResType;
    }

    public TOSMsgResType sendTOSMsg(TOSMsgReqType tosMsgReqType) {
        logger.info("Begin HhtServiceImpl.sendTOSMsg at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        TOSMsgResType tosMsgResType = null;
        try {
            tosMsgResType = getHhtDAO().sendTOSMsg(tosMsgReqType);
            logger.info("sendTOSMsg - errMsg is: " + tosMsgResType.getErrMsg());
            logger.info("sendTOSMsg - msg is: " + tosMsgResType.getMsg());
        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                          2) });
        }
        return tosMsgResType;
    }


    private ContainerType[] getContainerArray(List<ContainerType> contrList) {
        ContainerType[] containerArray = new ContainerType[contrList.size()];
        int count = 0;
        for (ContainerType ctr: contrList)
            containerArray[count++] = ctr;
        return containerArray;
    }

    public UpdateSealResType updateContainer(UpdateSealReqType updateSealReqType) {
        UpdateSealResType updateSealResType = new UpdateSealResType();
        logger.info("Begin HhtServiceImpl.UpdateSealResType at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        try
        {
                    UpdateSealResType output = getHhtDAO().updateContainer(updateSealReqType);
                    updateSealResType.setStatus(output.getStatus());

                    logger.info("HhtServiceImpl.updateContainer - Status :" + output.getStatus());
          }
        catch (Exception exception) {
        logger.error(exception);
        serviceException = new ServiceExceptionType();
        serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                                 2) });
        updateSealResType.setException(serviceException);
        }
        logger.info("End HhtServiceImpl.updateSealResType at :" + getCurrentTime());
        return updateSealResType;

    }

    //Added by ics.raj for MT Refusal(CRR)
    public AddMTRefusalResType addMTRefusal(AddMTRefusalReqType addMTRefusalReqType) {
        AddMTRefusalResType addMTRefusalResType = new AddMTRefusalResType();
        logger.info("Begin HhtServiceImpl.AddMTRefusalResType at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        try
        {
                    AddMTRefusalResType output = getHhtDAO().addMTRefusal(addMTRefusalReqType);
                    addMTRefusalResType.setStatus(output.getStatus());

                    logger.info("HhtServiceImpl.addMTRefusal - Status :" + output.getStatus());
          }
        catch (Exception exception) {
        logger.error(exception);
        serviceException = new ServiceExceptionType();
        serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                                 2) });
        addMTRefusalResType.setException(serviceException);
        }
        logger.info("End HhtServiceImpl.addMTRefusalResType at :" + getCurrentTime());
        return addMTRefusalResType;

    }

    public AcceptTokenResType acceptToken(AcceptTokenReqType acceptTokenReqType) {
        AcceptTokenResType acceptTokenResType = new AcceptTokenResType();
        logger.info("Begin HhtServiceImpl.AcceptTokenResType at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        try
        {
                    AcceptTokenResType output = getHhtDAO().acceptToken(acceptTokenReqType);
                    acceptTokenResType.setStatus(output.getStatus());
          }
        catch (Exception exception) {
        logger.error(exception);
        serviceException = new ServiceExceptionType();
        serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                                 2) });
        acceptTokenResType.setException(serviceException);
        }
        logger.info("End HhtServiceImpl.updateSealResType at :" + getCurrentTime());
        return acceptTokenResType;
    }


    public EirResType getEir (EirReqType eirReqType)
      {
          logger.info("Begin HhtServiceImpl.getEir at :" + getCurrentTime());
          ServiceExceptionType serviceException = null;
          EirResType eirResType = new EirResType();
          try {
              Map eirList = getHhtDAO().getEir(eirReqType);
              logger.info("getEir result is :" +     eirList.get("status"));
              if(eirList.get("status").toString().equalsIgnoreCase("SUCCESS")){
                      logger.info(" values returned" );
              EirType[] eirDet = getEirArray((List<EirType>)eirList.get("eirres"));
              eirResType.setEir(eirDet);
              eirResType.setStatus(eirList.get("status").toString());
              }
              else {
                  eirResType.setStatus(eirList.get("status").toString());
              }
          }
          catch(Exception exception) {
              logger.error(exception);
              serviceException = new ServiceExceptionType();
              serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                            2) });
              eirResType.setException(serviceException);
          }
          return eirResType;
      }
    private EirType[] getEirArray(List<EirType> eirList) {
          EirType[] eirArray = new EirType[eirList.size()];
                               int count = 0;
                               for (EirType truck: eirList)
                                   eirArray[count++] = truck;
                               return eirArray;
       }

     public ConfirmGateoutMoveResType confirmGateoutMove(ConfirmGateoutMoveReqType confirmGateoutMoveReqType) {
        ConfirmGateoutMoveResType confirmGateoutMoveResType = new ConfirmGateoutMoveResType();
        logger.info("Begin HhtServiceImpl.ConfirmGateoutMoveReqType at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        try
        {
                    ConfirmGateoutMoveResType output = getHhtDAO().confirmGateoutMove(confirmGateoutMoveReqType);
                    confirmGateoutMoveResType.setStatus(output.getStatus());
                    if(!"SUCCESS".equalsIgnoreCase(output.getStatus())) {
                      serviceException = new ServiceExceptionType();
                      serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(output.getStatus(),  2) });
                      confirmGateoutMoveResType.setException(serviceException);
                    }
          }
        catch (Exception exception) {
        logger.error(exception);
        serviceException = new ServiceExceptionType();
        serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                                 2) });
        confirmGateoutMoveResType.setException(serviceException);
        }
        logger.info("End HhtServiceImpl.updateSealResType at :" + getCurrentTime());
        return confirmGateoutMoveResType;
    }

    public FZGPGateInOutSearchResType getFZGPGateInOutSearchList(FZGPGateInOutSearchReqType eFZGPGateInOutSearchInput) {
           FZGPGateInOutSearchResType eFZGPGateInOutSearchResType = new FZGPGateInOutSearchResType();
           logger.info("Begin HhtServiceImpl.eFZGPGateInOutSearchReqType at :" + getCurrentTime());
           ServiceExceptionType serviceException = null;
           FZGPGateInOutSearchList[] gplist = null;
           try
           {
                 logger.info("Before calling DAO list  HhtServiceImpl.eFZGPGateInOutSearchReqType at :" + getCurrentTime());
                 Map output = getHhtDAO().FZGPGateInOutSearch(eFZGPGateInOutSearchInput);
            /**
             * Added by Raghu, CMC Team for Gate HHT CR
             */
            List<FZGPGateInOutSearchList> outputList = (List<FZGPGateInOutSearchList>)output.get("gatepasslist");
            if (outputList != null && !outputList.isEmpty()) {
                gplist = getGPList(outputList);
            }

            String errMsg = (String)(output.get("errmessage"));
            String error = (String)(output.get("error"));
            if (errMsg != null && error != null) {
                eFZGPGateInOutSearchResType.setStatus(errMsg);
                logger.info("HhtServiceImpl.FZGPGateInOutSearch - errmessage:" +  errMsg);
            } else {
                 eFZGPGateInOutSearchResType.setInspmessage(inspectionMessage);
                 eFZGPGateInOutSearchResType.setInspmessflag(inspectionFlag);
                eFZGPGateInOutSearchResType.setGplist(gplist);
                eFZGPGateInOutSearchResType.setStatus("Success");
            }
            /**------------------------------END------------------------------------*/
           }catch (Exception exception) {
           logger.error(exception);
           serviceException = new ServiceExceptionType();
           serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                                    2) });
           eFZGPGateInOutSearchResType.setException(serviceException);
           }
           logger.info("End HhtServiceImpl.eFZGPGateInOutSearchReqType at :" + getCurrentTime());
           return eFZGPGateInOutSearchResType;
       }
    public FZGPGateInOutUpdateResType procFZGPGateInOutUpdate(FZGPGateInOutUpdateReqType eFZGPGateInOutUpdateInput) {
           FZGPGateInOutUpdateResType eFZGPGateInOutUpdateResType = new FZGPGateInOutUpdateResType();
           logger.info("Begin HhtServiceImpl.FZGPGateInOutUpdateReqType at :" + getCurrentTime());
           ServiceExceptionType serviceException = null;
           try
           {
                       eFZGPGateInOutUpdateResType = getHhtDAO().FZGPGateInOutUpdate(eFZGPGateInOutUpdateInput);

             }
           catch (Exception exception) {
           logger.error(exception);
           serviceException = new ServiceExceptionType();
           serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                                    2) });
            /**
                * Added by Raghu, CMC Team for Gate HHT CR
                */
            eFZGPGateInOutUpdateResType.setPerno(exception.getMessage());
            /**------------------------------END------------------------------------*/
           }
           logger.info("End HhtServiceImpl.FZGPGateInOutUpdateReqType at :" + getCurrentTime());
           return eFZGPGateInOutUpdateResType;
       }

       private FZGPGateInOutSearchList[] getGPList(List<FZGPGateInOutSearchList> gpList) {
               FZGPGateInOutSearchList[] gpListArray = new FZGPGateInOutSearchList[gpList.size()];
                                    int count = 0;
                                    for (FZGPGateInOutSearchList gp: gpList) {
                                        gpListArray[count++] = gp;
                                    }
                                    return gpListArray;
            }

    public SealResType prevSealDetails(SealReqType req) {
        SealResType sealResType = new SealResType();
        logger.info("Begin HhtServiceImpl.prevSealDetails at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        try {
            sealResType = getHhtDAO().prevSealDetails(req);
        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(), 2) });
        }
        logger.info("End HhtServiceImpl.prevSealDetails at :" + getCurrentTime());
        return sealResType;
    }

    //[CTO-MAJOR DAMAGE ENHANCEMENT CR]
    public CodeResType getMajorDamages(boolean includeNonMajor) {
        CodeResType codeResType = new CodeResType();
        logger.info("Begin HhtServiceImpl.getMajorDamages at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        try {
            codeResType = getHhtDAO().getMajorDamages(includeNonMajor);
            codeResType.setStatus("success");
        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(), 2) });
            codeResType.setStatus("error");
        }
        logger.info("End HhtServiceImpl.getMajorDamages at :" + getCurrentTime());
        return codeResType;
        }
    //[/CTO-MAJOR DAMAGE ENHANCEMENT CR]

    public DamageResType prevDamageDetails(DamageReqType req) {
        DamageResType damageResType = new DamageResType();
        logger.info("Begin HhtServiceImpl.prevDamageDetails at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        try {
            damageResType = getHhtDAO().prevDamageDetails(req);
        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(), 2) });
        }
        logger.info("End HhtServiceImpl.prevDamageDetails at :" + getCurrentTime());
        return damageResType;
    }

    //[Damage: Standing instruction]
    public ContainerDamageRespType getContainerDamages(ContainerDamageReqType containers) {
            ContainerDamageRespType containerDamageRespType = new ContainerDamageRespType();
            logger.info("Begin HhtServiceImpl.getContainerDamages at :" + getCurrentTime());
            ServiceExceptionType serviceException = null;
            try {
                    containerDamageRespType = getHhtDAO().getContainerDamages(containers);
            } catch (Exception exception) {
                    logger.error(exception);
                    serviceException = new ServiceExceptionType();
                    serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(), 2) });
            }
            logger.info("End HhtServiceImpl.getContainerDamages at :" + getCurrentTime());
            return containerDamageRespType;
        }

        public UpdateStdDmgDtlsRespType updateStdDmgDetails(UpdateStdDmgDtlsReqType stdDmgDtl) {
            UpdateStdDmgDtlsRespType updateStdDmgDtlsRespType = new UpdateStdDmgDtlsRespType();
            logger.info("Begin HhtServiceImpl.updateStdDmgDetails at :" + getCurrentTime());
            ServiceExceptionType serviceException = null;
            try {
                updateStdDmgDtlsRespType = getHhtDAO().updateStdDmgDetails(stdDmgDtl);
            } catch (Exception exception) {
                logger.error(exception);
                serviceException = new ServiceExceptionType();
                serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(), 2) });
            }
            logger.info("End HhtServiceImpl.updateStdDmgDetails at :" + getCurrentTime());
            return updateStdDmgDtlsRespType;
        }
    //[/Damage: Standing instruction]

    public ComTruckNoRespType getTokenContrDtlsForTruck(ComTruckNoReqType truckNoReqType) {
        ComTruckNoRespType truckNoRespType = new ComTruckNoRespType();
        logger.info("Begin HhtServiceImpl.getTokenContrDtlsForTruck at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        try {
            truckNoRespType = getHhtDAO().getTokenContrDtlsForTruck(truckNoReqType);

        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(), 2) });
        }
        logger.info("End HhtServiceImpl.getTokenContrDtlsForTruck at :" + getCurrentTime());
        return truckNoRespType;
    }

    public VerifyUserRespType verifyUser(VerifyUserReqType verifyUserInput) {
        VerifyUserRespType verifyUserRespType = new VerifyUserRespType();
        logger.info("Begin HhtServiceImpl.verifyUser at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        try {
            verifyUserRespType = getHhtDAO().verifyUser(verifyUserInput);
        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(), 2) });
        }
        logger.info("End HhtServiceImpl.verifyUser at :" + getCurrentTime());
        return verifyUserRespType;
    }

    /** DPW-PROMIS Release 1 - Added by CMCTEAM (Annapurna) to get location and Print EIR through MDT **/
    public ContrLocationResType getContrLocation(ContrLocationReqType contrLocReqType) {
        logger.info("Begin HhtServiceImpl.getContrLocation at :" +
                    getCurrentTime());
        ServiceExceptionType serviceException = null;
        ContrLocationResType contrLocResType = new ContrLocationResType();
        try {
            Map contrLocList = getHhtDAO().getContrLocation(contrLocReqType);

            logger.info("getContrLocation result is :" +
                            contrLocList.get( contrLocList.get("status")));
                if ("SUCCESS".equalsIgnoreCase((String)contrLocList.get("status"))) {
                    logger.info("The container details are eturned");

                    ContrLocationType[] contrLocationdet =
                        getContrLocArray((List<ContrLocationType>)contrLocList.get("contrlocres"));
                    contrLocResType.setContrLocationdet(contrLocationdet);
                    contrLocResType.setStatus((String)contrLocList.get("status"));
                } else {
                    contrLocResType.setStatus((String)contrLocList.get("status"));
                }
            }
         catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                          2) });
            contrLocResType.setException(serviceException);
        }
        return contrLocResType;
    }

    private ContrLocationType[] getContrLocArray(List<ContrLocationType> contrLocList) {
        ContrLocationType[] contrLocArray =
            new ContrLocationType[contrLocList.size()];
        int count = 0;
        for (ContrLocationType contrLoc: contrLocList)
            contrLocArray[count++] = contrLoc;
        return contrLocArray;
    }

    public PrintEirResType printEir(PrintEirReqType printEirReqType) {
        logger.info("Begin HhtServiceImpl.printEir at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        PrintEirResType printEirResType = new PrintEirResType();
        try {
            Map printEirList = getHhtDAO().printEir(printEirReqType);

            logger.info("printEir result is :" +
                        printEirList.get((String)printEirList.get("status")));
                if ("SUCCESS".equalsIgnoreCase((String)printEirList.get("status"))) {
                    logger.info("EIR details are returned");
                    PrintEirType[] printEirDet =
                        getPrintEirArray((List<PrintEirType>)printEirList.get("printeirres"));
                    printEirResType.setPrintEirDet(printEirDet);
                    printEirResType.setStatus((String)printEirList.get("status"));
                } else {
                    printEirResType.setStatus((String)printEirList.get("status"));
                }

        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                          2) });
            printEirResType.setException(serviceException);
        }
        return printEirResType;
    }

    private PrintEirType[] getPrintEirArray(List<PrintEirType> printEirList) {
        PrintEirType[] printArray = new PrintEirType[printEirList.size()];
        int count = 0;
        for (PrintEirType eir: printEirList)
            printArray[count++] = eir;
        return printArray;
    }

    /** End by  CMCTeam(Annapurna)*/
    public NoticeDetailsResType getNoticeDetailsForVessel(NoticeDetailsReqType noticeDetailsReq) {
         logger.info("Begin HhtServiceImpl.getNoticeDetailsForVessel at :" +  getCurrentTime());
         ServiceExceptionType serviceException = null;
         NoticeDetailsResType noticeResponse = new NoticeDetailsResType();
         try {
             Map paramList = getHhtDAO().getNoticeDetails(noticeDetailsReq);

             logger.info("NoticeDetailsResType result is :" + paramList.get((String)paramList.get("status")));
             noticeResponse.setStatus((String)paramList.get("status"));
             if ("SUCCESS".equalsIgnoreCase((String)paramList.get("status"))) {
                 logger.info("Notice Details are returned");
                 NoticeDetailsResType noticeRes = getVesselDetails((List<NoticeDetailsResType>)paramList.get("vesselRS"));
                 noticeResponse.setRotationNumber(noticeRes.getRotationNumber());
                 noticeResponse.setVesselName(noticeRes.getVesselName());
                 noticeResponse.setBerthNumber(noticeRes.getBerthNumber());
                 noticeResponse.setVoyageNumber(noticeRes.getVoyageNumber());
                 noticeResponse.setPinNumber(noticeRes.getPinNumber());

                 NoticeTypeList[] noticeArray = getNoticeTypeArray((List<NoticeTypeList>)paramList.get("noticeDetailsRS"));
                 noticeResponse.setNoticeList(noticeArray);
             }
         } catch (Exception exception) {
             logger.error(exception);
             serviceException = new ServiceExceptionType();
             serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(), 2) });
             noticeResponse.setException(serviceException);
         }
         return noticeResponse;
     }

     private NoticeTypeList[] getNoticeTypeArray(List<NoticeTypeList> noticeTypeList) {
         NoticeTypeList[] noticeArray = new NoticeTypeList[noticeTypeList.size()];
         int count = 0;
         for (NoticeTypeList notice: noticeTypeList)
             noticeArray[count++] = notice;
         return noticeArray;
     }

     private NoticeDetailsResType getVesselDetails(List<NoticeDetailsResType> noticeList) {
         NoticeDetailsResType[] noticeArray = new NoticeDetailsResType[noticeList.size()];
         int count = 0;
         for (NoticeDetailsResType notice: noticeList)
             noticeArray[count++] = notice;
         return noticeArray[0];
     }

     public UpdateNoticeDetailsResType updateNoticeDetailsForVessel(UpdateNoticeDetailsReqType updateNoticeDetailsReq) {
         logger.info("Begin HhtServiceImpl.updateNoticeDetailsForVessel at :" +  getCurrentTime());
         ServiceExceptionType serviceException = null;
         UpdateNoticeDetailsResType response = new UpdateNoticeDetailsResType();
         try {
             Map paramsList = getHhtDAO().updateNoticeDetails(updateNoticeDetailsReq);
             logger.info("UpdateNoticeDetailsResType result is :" + paramsList.get((String)paramsList.get("status")));
              response.setStatus((String)paramsList.get("status"));
         } catch (Exception exception) {
             logger.error(exception);
             serviceException = new ServiceExceptionType();
             serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),2) });
             response.setException(serviceException);
         }
         return response;
     }

     public BerthResType getBerthDetails(StandardReqType userInfo){
         logger.info("Begin HhtServiceImpl.getBerthDetails at :" + getCurrentTime());
         ServiceExceptionType serviceException = null;
         BerthResType berthResType = new BerthResType();
         try {
             List<BerthType> berthList = getHhtDAO().getBerthList();
             if (berthList.size() == 0) {
                 serviceException = new ServiceExceptionType();
                 serviceException.setBusinessException(new ExceptionType[] { getExceptionType("No Voyages Found", 2) });
             } else {
                 berthResType.setBerth(getBerthArray(berthList));
             }
         } catch (Exception exception) {
             logger.error(exception);
             serviceException = new ServiceExceptionType();
             serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),2) });
             berthResType.setException(serviceException);
         }
         logger.info("End HhtServiceImpl.getBerthDetails at :" + getCurrentTime());
         return berthResType;
     }

     private BerthType[] getBerthArray(List<BerthType> berthList) {
         BerthType[] berthArray = new BerthType[berthList.size()];
         int count = 0;
         for (BerthType berth: berthList)
             berthArray[count++] = berth;
         return berthArray;
     }

    public TokenTimeSlotResType getTokenTimeSlot(TokenTimeSlotReqType tokenTimeSlot){
        logger.info("Begin HhtServiceImpl.getTokenTimeSlot at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        TokenTimeSlotResType slotResType = new TokenTimeSlotResType();
        try {
            List<TokenSlotType> slotType = getHhtDAO().getTokenSlotList(tokenTimeSlot);
            if (slotType.size() == 0) {
                serviceException = new ServiceExceptionType();
                serviceException.setBusinessException(new ExceptionType[] { getExceptionType("No Slot Found", 2) });
            } else {
                slotResType.setTokenSlotList(getTokenTimeSlotArray(slotType));
            }
        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),2) });
            slotResType.setException(serviceException);
        }
        logger.info("End HhtServiceImpl.getTokenTimeSlot at :" + getCurrentTime());
        return slotResType;
    }

    private TokenSlotType[] getTokenTimeSlotArray(List<TokenSlotType> slotList) {
        TokenSlotType[] slotArray = new TokenSlotType[slotList.size()];
        int count = 0;
        for (TokenSlotType slot: slotList)
            slotArray[count++] = slot;
        return slotArray;
    }

    public TruckInfoResType getTruckInfoByContainer(TruckInfoReqType truckInfoReqType){
        logger.info("Begin HhtServiceImpl.getTruckInfoByContainer at :" + getCurrentTime());
        ServiceExceptionType serviceException = null;
        TruckInfoResType truckInfoResType = null;
        try {
            truckInfoResType = getHhtDAO().getTruckInfoByContainer(truckInfoReqType);
            if (truckInfoResType == null) {
                truckInfoResType = new TruckInfoResType();
                serviceException = new ServiceExceptionType();
                serviceException.setBusinessException(new ExceptionType[] { getExceptionType("No trunk info Found", 2) });
                truckInfoResType.setException(serviceException);
            }
        } catch (Exception exception) {
            logger.error(exception);
            truckInfoResType = new TruckInfoResType();
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),2) });
            truckInfoResType.setException(serviceException);
        }
        logger.info("End HhtServiceImpl.getTruckInfoByContainer at :" + getCurrentTime());
        return truckInfoResType;
    }

    //Adjust tokenslot starts
     public AdjustTimeSlotRespType getAdjustTimeSlot(AdjustTimeSlotReqType req) {
            AdjustTimeSlotRespType adjustTimeSlotRespType = new AdjustTimeSlotRespType();
            logger.info("Begin HhtServiceImpl.getAdjustTimeSlot at :" + getCurrentTime());
            ServiceExceptionType serviceException = null;
            try {
                    adjustTimeSlotRespType = getHhtDAO().getAdjustTimeSlot(req);
            } catch (Exception exception) {
                    logger.error(exception);
                    serviceException = new ServiceExceptionType();
                    serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(), 2) });
            }
            logger.info("End HhtServiceImpl.adjustTimeSlotRespType at :" + getCurrentTime());
            return adjustTimeSlotRespType;
    }
//[CTO-MAJOR DAMAGE ENHANCEMENT CR]
    public MajorDamageFlagResType getMajorDamageFlag() {
        logger.info("Begin HhtServiceImpl.getMajorDamageFlag at :" +  getCurrentTime());
        ServiceExceptionType serviceException = null;
        MajorDamageFlagResType majorDmg=new MajorDamageFlagResType();
        try {
            String  majorDmgFlag = getHhtDAO().getMajorDamageFlag();
            logger.info("getMajorDamageFlag  is :" + majorDmgFlag);
            majorDmg.setFlag(majorDmgFlag);
        } catch (Exception exception) {
            logger.error(exception);
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),2) });
            majorDmg.setFlag("E");
        }
        return majorDmg;
    }
  //[/CTO-MAJOR DAMAGE ENHANCEMENT CR]

   public UpdateDamagesResType updateContainerWithDamages(UpdateDamagesReqType updateDamagesReqType) {
           UpdateDamagesResType updateDamagesResType = new UpdateDamagesResType();
           logger.info("Begin HhtServiceImpl.updateContainerWithDamages at :" + getCurrentTime());
           ServiceExceptionType serviceException = null;
           try {
               UpdateDamagesResType output = getHhtDAO().updateContainerWithDamages(updateDamagesReqType);
               updateDamagesResType.setStatus(output.getStatus());

               logger.info("HhtServiceImpl.updateContainerWithDamages - Status :" + output.getStatus());
           }
           catch (Exception exception) {
           logger.error(exception);
           serviceException = new ServiceExceptionType();
           serviceException.setTechnicalException(new ExceptionType[] { getExceptionType(exception.getMessage(),
                                                                                                    2) });
           updateDamagesResType.setException(serviceException);
           }
           logger.info("End HhtServiceImpl.updateContainerWithDamages at :" + getCurrentTime());
           return updateDamagesResType;

       }

}
