package com.dpw.ports.promis.hht.dao;

import com.dpw.ports.promis.common.Utilities;
import com.dpw.ports.promis.hht.DBConstants;
import com.dpw.ports.promis.hht.domain.MarineBodySqlType;
import com.dpw.ports.promis.hht.domain.MarineHeaderSqlType;

import com.dpw.ports.promis.hht.type.AcceptTokenReqType;
import com.dpw.ports.promis.hht.type.AcceptTokenResType;
import com.dpw.ports.promis.hht.type.AddMTRefusalReqType;
import com.dpw.ports.promis.hht.type.AddMTRefusalResType;
import com.dpw.ports.promis.hht.type.AdjustTimeSlotReqType;
import com.dpw.ports.promis.hht.type.AdjustTimeSlotRespType;
import com.dpw.ports.promis.hht.type.CTMSUpdVesselResType;
import com.dpw.ports.promis.hht.type.CTMSVoyageResType;


import com.dpw.ports.promis.hht.type.ComTruckNoReqType;
import com.dpw.ports.promis.hht.type.ComTruckNoRespType;
import com.dpw.ports.promis.hht.type.ConfirmGateoutMoveReqType;
import com.dpw.ports.promis.hht.type.ConfirmGateoutMoveResType;
import com.dpw.ports.promis.hht.type.ContainerReqType;
import com.dpw.ports.promis.hht.type.ContainerType;
import com.dpw.ports.promis.hht.type.ContrLocationReqType;
import com.dpw.ports.promis.hht.type.ContrReqType;
import com.dpw.ports.promis.hht.type.DamageReqType;
import com.dpw.ports.promis.hht.type.DamageResType;
import com.dpw.ports.promis.hht.type.DamageType;
import com.dpw.ports.promis.hht.type.CodeResType;
import com.dpw.ports.promis.hht.type.CodeType;
import com.dpw.ports.promis.hht.type.DummyContainerType;
import com.dpw.ports.promis.hht.type.DummyTokenContrType;
import com.dpw.ports.promis.hht.type.EirReqType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutSearchList;
import com.dpw.ports.promis.hht.type.FZGPGateInOutSearchReqType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutSearchResType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutUpdateReqType;
import com.dpw.ports.promis.hht.type.FZGPGateInOutUpdateResType;
import com.dpw.ports.promis.hht.type.LoginInfoReqType;
import com.dpw.ports.promis.hht.type.MarineDetailType;
import com.dpw.ports.promis.hht.type.MarineHeaderType;
import com.dpw.ports.promis.hht.type.PrintEirReqType;
import com.dpw.ports.promis.hht.type.SealReqType;
import com.dpw.ports.promis.hht.type.SealResType;
import com.dpw.ports.promis.hht.type.SealType;
import com.dpw.ports.promis.hht.type.SignReqType;
import com.dpw.ports.promis.hht.type.StandardReqType;
import com.dpw.ports.promis.hht.type.VGMWtReqType;
import com.dpw.ports.promis.hht.type.VGMWtType;
import com.dpw.ports.promis.hht.type.VerifyUserReqType;
import com.dpw.ports.promis.hht.type.VerifyUserRespType;

import com.dpw.ports.promis.hht.type.TOSMsgReqType;
import com.dpw.ports.promis.hht.type.TOSMsgResType;
import com.dpw.ports.promis.hht.type.TruckReqType;
import com.dpw.ports.promis.hht.type.UpdVesselReqType;
import com.dpw.ports.promis.hht.type.UpdateSealReqType;
import com.dpw.ports.promis.hht.type.UpdateSealResType;
import com.dpw.ports.promis.hht.type.VoyagesType;
import com.dpw.services.exception.SystemException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import java.util.Set;

import javax.sql.DataSource;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import com.dpw.ports.promis.hht.type.NoticeDetailsReqType;
import com.dpw.ports.promis.hht.type.NoticeTypeList;
import com.dpw.ports.promis.hht.type.UpdateNoticeDetailsReqType;
import com.dpw.ports.promis.hht.type.BerthType;
import com.dpw.ports.promis.hht.type.ContainerDamageReqType;
import com.dpw.ports.promis.hht.type.ContainerDamageRespType;
import com.dpw.ports.promis.hht.type.ContainerDamageType;
import com.dpw.ports.promis.hht.type.TokenSlotType;
import com.dpw.ports.promis.hht.type.TokenTimeSlotReqType;
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


public class HhtIntegrationsDAOImpl implements HhtIntegrationsDAO {
    private static Log log = LogFactory.getLog(HhtIntegrationsDAOImpl.class);

    private String pushSql;
    private String uploadSignatureSql;
    private final DataSource marineDS;
    private final com.dpw.ports.promis.config.DatabaseRegistry databases;
    protected final Log logger=LogFactory.getLog(getClass());
    public HhtIntegrationsDAOImpl(com.dpw.ports.promis.config.DatabaseRegistry databases){
      this.databases=databases;marineDS=databases.dataSource("marine");ctmsJADatasource=databases.dataSource("ctms-ja");
      efzGatePassDS=databases.dataSource("efz-gate-pass");promisMainDS=databases.dataSource("promis-main");gcDS=databases.dataSource("general-cargo");rsisDS=databases.dataSource("rsis");
      pushSql="{call marine.pkg_pda_txns.prc_post_ppm_txns(?,?,?,?)}";uploadSignatureSql="{call marine.pkg_pda_txns.prc_post_ppm_signs(?,?,?)}";
    }

    private static String S_GTYPE_DOVAL_TBL="";

    private DataSource hhtDS;
    private DataSource efzGatePassDS;
    private DataSource ctmsJADatasource;
    private DataSource promisMainDS;
    private DataSource gcDS;
    private DataSource rsisDS;


    public void setPushSql(String pushSql) {
        DataSource selected=marineDS;
        this.pushSql = pushSql;
    }

    public String getPushSql() {
        DataSource selected=marineDS;
        return pushSql;
    }

    public List<VoyagesType> getVoyages(StandardReqType userInfo) {
        DataSource selected=marineDS;
        return getVoyagesList(userInfo);
    }

    public Map getRefData(StandardReqType refDataInput) {
        DataSource selected=marineDS;

        Map params = new HashMap();
        params.put("pcurpilots",new ArrayList());
        params.put("errmessage","");
        selected=getCtmsJADatasource();
        databases.sql(selected).queryForList("getRefData",params);

        logger.info("HhtServiceImpl.getRefData - errmessage :" + params.get("errmessage") );

        return params;

    }


    public Map getTokenDetails(ContainerReqType req) {
        DataSource selected=marineDS;
        log.info("Entering into HhtIntegrationsDAOImpl.getTokenDetails("+req.getTokenNo()+")...");

        Map params = new HashMap();
        Integer tokenNo = null;

        params.put("errMsg","");
        params.put("contrList",new ArrayList());

        try {
            tokenNo = Integer.parseInt(req.getTokenNo());
            params.put("tokenNo",tokenNo);
            params.put("userId",req.getUserId());
        } catch(NumberFormatException e) {
            params.put("tokenNo",req.getTokenNo());
            params.put("errMsg","Please enter number only.");
            return params;
        }

        long startTimeProc = System.currentTimeMillis();
        selected=getCtmsJADatasource();
        databases.sql(selected).queryForList("getTokenDetails",params);
        long endTimeProc = System.currentTimeMillis();
        double totalQueryTime = (endTimeProc - startTimeProc) / 1000.0;
        List<ContainerType> containerList = (List<ContainerType>)params.get("contrList");

        int listSize = ((containerList==null || containerList.size() ==0) ? 0 : containerList.size());
        logger.info("Procedure Execution Details : (" + "mt_contr_monitor.update_token_dtl" + ", " + listSize + " records, " +
                    totalQueryTime + " seconds, errMsg=" + (String)params.get("errMsg")+ ")");


        params.put("tokenNo",tokenNo.toString());
        return params;

    }
    public Map getDEDContrPlanMoves(ContrReqType req) {
        DataSource selected=marineDS;
        log.info("Entering into HhtIntegrationsDAOImpl.getDEDContrPlanMoves("+req.getTokenNo()+")...");

        Map params = new HashMap();
        Integer tokenNo = null;

        params.put("errMsg","");
        params.put("dummyContrList",new ArrayList<DummyContainerType>());

        try {
            tokenNo = Integer.parseInt(req.getTokenNo());
            params.put("tokenNo",tokenNo);
        } catch(NumberFormatException e) {
            params.put("tokenNo",req.getTokenNo());
            params.put("errMsg","Please enter number only.");
            return params;
        }

        long startTimeProc = System.currentTimeMillis();
        selected=getCtmsJADatasource();
        databases.sql(selected).queryForList("getDEDContrPlanMoves",params);
        long endTimeProc = System.currentTimeMillis();
        double totalQueryTime = (endTimeProc - startTimeProc) / 1000.0;
        List<DummyContainerType> containerList = (List<DummyContainerType>)params.get("dummyContrList");

        int listSize = ((containerList==null || containerList.size() ==0) ? 0 : containerList.size());
        logger.info("Procedure Execution Details : (" + "mt_contr_monitor.get_ded_plan_moves_dtls" + ", " + listSize + " records, " +
                    totalQueryTime + " seconds, errMsg=" + (String)params.get("errMsg")+ ")");


        params.put("tokenNo",tokenNo.toString());
        return params;

    }

    public TOSMsgResType sendTOSMsg(TOSMsgReqType tosMsgReqType){
        DataSource selected=marineDS;

        log.info("Entering into HhtIntegrationsDAOImpl.sendTOSMsg("+tosMsgReqType.getMsgID()+","+tosMsgReqType.getMsgAction()+","+tosMsgReqType.getLineCode()+
                                                                   ","+tosMsgReqType.getContrNo()+","+tosMsgReqType.getIsoType()+","+tosMsgReqType.getContrNo()+
                                                                   ","+tosMsgReqType.getNewIsoCode()+","+tosMsgReqType.getTruckCode()+","+tosMsgReqType.getScheduleId()+
                                                                   ","+tosMsgReqType.getSlotId()+","+tosMsgReqType.getHaulCode()+","+tosMsgReqType.getTerminalId()+")...");
        TOSMsgResType tosMsgResType= new TOSMsgResType();
        Map params = new HashMap();
        Integer tokenNo = null;

        tosMsgResType.setErrMsg("");
        tosMsgResType.setMsg("");
        params.put("errMsg","");
        params.put("msg","");

        params.put("msgID",tosMsgReqType.getMsgID());
        params.put("msgAction",tosMsgReqType.getMsgAction());
        params.put("lineCode",tosMsgReqType.getLineCode());
        params.put("contrNo",tosMsgReqType.getContrNo());
        params.put("isoType",tosMsgReqType.getIsoType());
        params.put("contrSize",tosMsgReqType.getContrSize());
        params.put("newIsoCode",tosMsgReqType.getNewIsoCode());
        params.put("truckCode",tosMsgReqType.getTruckCode());
        params.put("scheduleId",tosMsgReqType.getScheduleId());
        params.put("slotId",tosMsgReqType.getSlotId());
        params.put("haulCode",tosMsgReqType.getHaulCode());
        params.put("terminalId",tosMsgReqType.getTerminalId());


        long startTimeProc = System.currentTimeMillis();
        selected=getCtmsJADatasource();
        databases.sql(selected).queryForList("sendTOSMsg",params);
        long endTimeProc = System.currentTimeMillis();
        double totalQueryTime = (endTimeProc - startTimeProc) / 1000.0;
        tosMsgResType.setMsg((String)params.get("msg"));
        tosMsgResType.setErrMsg((String)params.get("errMsg"));

        logger.info("Procedure Execution Details : (" + "mt_contr_monitor.send_tos_msg_6021" + ",  " +
                    totalQueryTime + " seconds, errMsg=" + (String)params.get("errMsg")+ ")");



        return tosMsgResType;
    }

    private List<VoyagesType> getVoyagesList(StandardReqType standardReqType){
        DataSource selected=marineDS;
        Map params = new HashMap();
        params.put("userid",standardReqType.getUserCredentials().getUsername());
        params.put("password",standardReqType.getUserCredentials().getPassword());
        params.put("deviceid",standardReqType.getUserCredentials().getDeviceid());
        params.put("pcontainerres",new ArrayList());
        params.put("errmessage","");



        List<VoyagesType> lstVoyagesType = databases.sql(selected).queryForList("getvoyages",params);

        logger.info("HhtServiceImpl.getVoyagesList - errmessage :" + params.get("errmessage") );

        return lstVoyagesType;
    }

    private Map getReferenceData(StandardReqType refDataInput){
        DataSource selected=marineDS;
        Map params = new HashMap();

        params.put("pcurpilots",new ArrayList());

        params.put("errmessage","");
        selected=getCtmsJADatasource();
        databases.sql(selected).queryForList("getRefData",params);
        return params;
    }

    private Map pushData(MarineHeaderType header,MarineDetailType[] details){
 if(header==null || details==null)throw new IllegalArgumentException("Marine header and details required");
 return new org.springframework.transaction.support.TransactionTemplate(databases.transactions("marine")).execute(status ->
  new org.springframework.jdbc.core.JdbcTemplate(marineDS).execute((org.springframework.jdbc.core.ConnectionCallback<Map>) connection -> {
   var oracle=connection.unwrap(oracle.jdbc.OracleConnection.class);var head=new MarineHeaderSqlType();
   try{BeanUtils.copyProperties(head,header);}catch(Exception e){throw new IllegalArgumentException("Invalid header",e);}
   Object[] children=new Object[details.length];
   for(int i=0;i<details.length;i++){
    var body=new MarineBodySqlType();try{BeanUtils.copyProperties(body,details[i]);}catch(Exception e){throw new IllegalArgumentException("Invalid detail",e);}
    children[i]=oracle.createStruct("MARINE."+DBConstants.MARINE_DETAIL_REC_TYPE,body.attributes());
   }
   java.sql.Array array=oracle.createOracleArray("MARINE."+DBConstants.MARINE_DETAIL_TAB_TYPE,children);
   try(CallableStatement call=connection.prepareCall(pushSql)){
    call.setObject(1,oracle.createStruct("MARINE."+DBConstants.MARINE_HEAD_REC_TYPE,head.attributes()));call.setArray(2,array);call.registerOutParameter(3,Types.NUMERIC);call.registerOutParameter(4,Types.VARCHAR);call.execute();
    Map result=new HashMap();result.put("txnid",call.getInt(3));result.put("excep",call.getString(4));if(call.getString(4)!=null && !call.getString(4).isBlank())status.setRollbackOnly();return result;
   }finally{array.free();}
  }));
}



    public Map pushMarineDetails(MarineHeaderType marineHeaderType,
                                  MarineDetailType[] marineDetailTypes) {
        DataSource selected=marineDS;
        return pushData(marineHeaderType,marineDetailTypes);
    }

    private String getSchemaNameMarineTypes(String pkgname){
        DataSource selected=marineDS;
            try {
                if(S_GTYPE_DOVAL_TBL == null) {
                    HashMap map=new HashMap();
                    map.put("pkgname",pkgname);
                    databases.sql(selected).queryForList("getschemaname", map);
                    S_GTYPE_DOVAL_TBL=(String)map.get("schemaname");
                }
            }catch(DataAccessException ex){
              ex.printStackTrace();
            }
            return S_GTYPE_DOVAL_TBL;
        }

     private Map validateLoggedinUser(LoginInfoReqType loginfoType)    {
        DataSource selected=marineDS;
         Map params = new HashMap();
         params.put("txntype","");
         params.put("id","");
         params.put("userid",loginfoType.getUsername());
         params.put("password",loginfoType.getPassword());
         params.put("deviceid",loginfoType.getDeviceid());
         params.put("deviceidresp",new String());
         params.put("retval","");
         params.put("errmsg","");
         databases.sql(selected).queryForList("validateloggedinuser",params);

         logger.info("HhtServiceImpl.validateLoggedinUser - errmsg :" + params.get("errmsg") );

         return params;

     }

    public Map checkUser(LoginInfoReqType loginInfoType) {
        DataSource selected=marineDS;
        Map userMap = validateLoggedinUser(loginInfoType);
        return userMap;
    }

    public String uploadSignature(SignReqType request){
 return new org.springframework.transaction.support.TransactionTemplate(databases.transactions("marine")).execute(status ->
  new org.springframework.jdbc.core.JdbcTemplate(marineDS).execute((org.springframework.jdbc.core.ConnectionCallback<String>) connection -> {
   try(CallableStatement call=connection.prepareCall(uploadSignatureSql)){
    call.setInt(1,request.getTxn_id());call.setBytes(2,request.getSign());call.registerOutParameter(3,Types.VARCHAR);call.execute();String error=call.getString(3);if(error!=null && !error.isBlank())status.setRollbackOnly();return error;
   }
  }));
}

    public String getUploadSignatureSql() {
        DataSource selected=marineDS;
        return uploadSignatureSql;
    }

    public void setUploadSignatureSql(String uploadSignatureSql) {
        DataSource selected=marineDS;
        this.uploadSignatureSql = uploadSignatureSql;
    }


         public Map getVoyagesFromCTMS(StandardReqType getVoyagesForCTMS) {
        DataSource selected=marineDS;
             Map params = new HashMap();
             DataSource defaul = selected;
             CTMSVoyageResType voyageResult = new CTMSVoyageResType();
             params.put("userid",getVoyagesForCTMS.getUserCredentials().getUsername());
             params.put("password",getVoyagesForCTMS.getUserCredentials().getPassword());
             params.put("deviceid",getVoyagesForCTMS.getUserCredentials().getDeviceid());
             params.put("errmessage","");
             params.put("pcontainerres",new ArrayList());
             selected=getCtmsJADatasource();
             databases.sql(selected).queryForList("getctmsvoyages",params);

             logger.info("HhtServiceImpl.getVoyagesFromCTMS - errmessage :" + params.get("errmessage") );

             selected=defaul;
             return params;

         }

         public CTMSUpdVesselResType CTMSVoyageUpdate(UpdVesselReqType CTMSVoyageUpdateInput){
        DataSource selected=marineDS;
             DataSource defaul = selected;

             CTMSUpdVesselResType ctmsupdvessl = new CTMSUpdVesselResType();
             Map params = new HashMap();
             params.put("userid",CTMSVoyageUpdateInput.getUserid());
             params.put("rotationnumber",CTMSVoyageUpdateInput.getRotationnumber());
             params.put("startworkdt",CTMSVoyageUpdateInput.getStartworkdt());
             params.put("endworkdt",CTMSVoyageUpdateInput.getEndworkdt());
             params.put("berthdt",CTMSVoyageUpdateInput.getBerthdt());
             params.put("deviceid",CTMSVoyageUpdateInput.getDeviceid());
             params.put("errmessage","");
             selected=getCtmsJADatasource();

             String ctmsupdresult =  (String) databases.sql(selected).queryForObject("updvesslreq",params);
            ctmsupdresult= (String)params.get("errmessage");
             ctmsupdvessl.setErr_msg(ctmsupdresult);

             logger.info("HhtServiceImpl.CTMSVoyageUpdate - errmessage :" + ctmsupdresult );

             selected=defaul;
             return ctmsupdvessl;
         }


    public void setCtmsJADatasource(DataSource ctmsJADatasource) {
        DataSource selected=marineDS;
        this.ctmsJADatasource = ctmsJADatasource;
    }

    public DataSource getCtmsJADatasource() {
        DataSource selected=marineDS;
        return ctmsJADatasource;
    }

    public void setHhtDS(DataSource hhtDS) {
        DataSource selected=marineDS;
        this.hhtDS = hhtDS;
    }

    public DataSource getHhtDS() {
        DataSource selected=marineDS;
        return hhtDS;
    }

    public void setPromisMainDS(DataSource promisMainDS) {
        DataSource selected=marineDS;
        this.promisMainDS = promisMainDS;
    }

    public DataSource getPromisMainDS() {
        DataSource selected=marineDS;
        return promisMainDS;
    }

    public Map getTokens(StandardReqType standardReqType){
        DataSource selected=marineDS;
        DataSource defaul = selected;
        Map params = new HashMap();
        params.put("userid",standardReqType.getUserCredentials().getUsername());
        params.put("password",standardReqType.getUserCredentials().getPassword());
        params.put("deviceid",standardReqType.getUserCredentials().getDeviceid());
        params.put("status","");
        params.put("tokenres",new ArrayList());
       selected=getCtmsJADatasource();
        databases.sql(selected).queryForList("gettokens",params);

        logger.info("HhtServiceImpl.getTokens - Status :" + params.get("status") );

        selected=defaul;
        return params;
    }

  public Map getTokenForTruck (TruckReqType truckReqType)
    {
        DataSource selected=marineDS;

        DataSource defaul = selected;
        Map params = new HashMap();
        params.put("vehicleno",truckReqType.getVehicleno());
        params.put("regplate",truckReqType.getRegplate());
        params.put("platecode",truckReqType.getPlatecode());
        params.put("rfid",truckReqType.getRFID());
        params.put("status","");
        params.put("tokenres",new ArrayList());
        selected=getCtmsJADatasource();
        databases.sql(selected).queryForList("gettokenfortruck",params);

        logger.info("HhtServiceImpl.getTokenForTruck - Status :" + params.get("status") );

        selected=defaul;
        return params;
    }

     public Map getDWCTruckEIR (TruckEIRReqType truckReqType)
       {
        DataSource selected=marineDS;

           DataSource defaul = selected;
           Map params = new HashMap();
           params.put("vehicleno",truckReqType.getVehicleno());
           params.put("regplate",truckReqType.getRegplate());

           params.put("status","");
           params.put("tokendwcres",new ArrayList());
           selected=getCtmsJADatasource();
           databases.sql(selected).queryForList("getdwctruckeir",params);

           logger.info("HhtServiceImpl.getDWCTruckEIR - Status :" + params.get("status") );

           selected=defaul;
           return params;
       }

     public Map getVGMContainerWeightDetails(VGMWtReqType vgmWtType) {
        DataSource selected=marineDS;
        DataSource defaul = selected;
        Map params = null;
        try {
            params = new HashMap();
            params.put("pi_truck_no", vgmWtType.getVehicleno());
            params.put("pi_reg_place", vgmWtType.getRegplate());
            params.put("pi_contr_no", vgmWtType.getContainerno());
            params.put("pi_terminal_id", vgmWtType.getTerminalid());
            params.put("po_err_msg", "");
            params.put("po_result_cpm", new ArrayList());
            selected=getCtmsJADatasource();
            databases.sql(selected).queryForList("getVGMContainerWeightDetails", params);
            logger.info("HhtServiceImpl.getVGMContainerWeightDetails - errorMsg :" + params.get("po_err_msg"));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            selected=defaul;
        }
        return params;
    }

    public UpdateVGMResType updateVGMContainerWeightDetails (UpdateVGMReqType updateVGMReqType){
        DataSource selected=marineDS;
        DataSource defaul = selected;
        UpdateVGMResType updateVGMResType = null;
        try {
            updateVGMResType = new UpdateVGMResType();
            Map params = new HashMap();
            params.put("pi_contr_no",updateVGMReqType.getContainerno());
            params.put("pi_lift_wt",updateVGMReqType.getLiftedWt());
            params.put("pi_crane_id",updateVGMReqType.getCraneId());
            params.put("pi_user",updateVGMReqType.getUserName());
            params.put("po_error","");
            selected=getCtmsJADatasource();
            databases.sql(selected).queryForObject("updateVGMContainerWeightDetails",params);
            updateVGMResType.setStatus((String)params.get("po_error"));
            logger.info("HhtIntegrationsDAOImpl.updateVGMContainerWeightDetails - Status :" + updateVGMResType.getStatus());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            selected=defaul;
        }
        return updateVGMResType;
    }

    public UpdateCustmResType updateCustmGateEntry (UpdateCustmReqType updateCustmReqType){
        DataSource selected=marineDS;
        DataSource defaul = selected;

        UpdateCustmResType updateCustmResType = new UpdateCustmResType();

        if(updateCustmReqType.getSource().equalsIgnoreCase("F")){
            String gpNo = updateCustmReqType.getTokenNo();
            String lgpNo = getDSGatePassLGPNo(gpNo);
            if(!Utilities.isNullOrEmpty(lgpNo)){
                updateCustmResType.setStatus("This Gate Pass can not be taken OUT, instead It has to directly go to the freezone area. LGP No. - "+lgpNo);
                return updateCustmResType;
            }
        }

        Map params = new HashMap();
        params.put("p_vehicle_reg_place",updateCustmReqType.getVehicleRgPlc());
        params.put("p_vehicle_reg_no",updateCustmReqType.getVehicleRgNo());
        params.put("p_token_no",updateCustmReqType.getTokenNo());
        params.put("p_contr_no",updateCustmReqType.getContainerNo());
        params.put("p_source",updateCustmReqType.getSource());
        params.put("p_user_id",updateCustmReqType.getUserId());
        params.put("p_gate_code",updateCustmReqType.getGateCode());
        params.put("p_lane_code",updateCustmReqType.getLaneCode());
        params.put("p_lane_type",updateCustmReqType.getLaneType());
        params.put("v_error_msg","");

        logger.info("params.." + params);

        selected=getRsisDS();
        databases.sql(selected).queryForObject("updateCustmGateEntry",params);
        updateCustmResType.setStatus((String)params.get("v_error_msg"));

        logger.info("HhtIntegrationsDAOImpl.updateVGMContainerWeightDetails - Status :" + updateCustmResType.getStatus());

        selected=defaul;
        return updateCustmResType;
    }
    public UpdateSealResType updateContainer(UpdateSealReqType updateSealReqType)
    {
        DataSource selected=marineDS;
        DataSource defaul = selected;

        UpdateSealResType updateSealResType = new UpdateSealResType();
        Map params = new HashMap();
        params.put("tokenno",updateSealReqType.getTokenno());
        params.put("containerno",updateSealReqType.getContainerno());
        params.put("sealno",updateSealReqType.getSealno());
        params.put("movetype",updateSealReqType.getMovetype());
        params.put("regplate",updateSealReqType.getRegplate());
        params.put("vehicleno",updateSealReqType.getVehicleno());
        if (updateSealReqType.getDamagecode()==-1)
            params.put("damagecode",null);
        else
            params.put("damagecode",updateSealReqType.getDamagecode());
        params.put("damagedescr",updateSealReqType.getDamagedescr());
        params.put("mtinspflag",updateSealReqType.getMtinspflag() );
        params.put("customseal",updateSealReqType.getCustomseal());
        params.put("dpwseal",updateSealReqType.getDpwseal());
        params.put("agentseal",updateSealReqType.getAgentseal());
        params.put("usercode",updateSealReqType.getUsercode());
        params.put("atdate",updateSealReqType.getAtdate());
        params.put("devid",updateSealReqType.getDevid());
        params.put("tipmsg",updateSealReqType.getTipmsg());
        params.put("cancelstatus",updateSealReqType.getCancelstatus());
        params.put("gate",updateSealReqType.getGate());

        params.put("isSealInvalid",updateSealReqType.getIsSealInvalid());
        params.put("isImcoLabelInvalid",updateSealReqType.getIsImcoLabelInvalid());
        params.put("mtOutSeatIssued",updateSealReqType.getMtOutSeatIssued());

        params.put("chassisType",updateSealReqType.getChassisType());
        params.put("contrChassisPos",updateSealReqType.getContrChassisPos());



        params.put("oogStatus",updateSealReqType.getOogStatus());
        params.put("oogReason",updateSealReqType.getOogReason());

        params.put("status","");
        selected=getCtmsJADatasource();
        String ctmsupdresult =  (String) databases.sql(selected).queryForObject("updatecontainer",params);
        ctmsupdresult= (String)params.get("status");
        updateSealResType.setStatus(ctmsupdresult);

        logger.info("HhtIntegrationsDAOImpl.updateContainer - Status :" + ctmsupdresult);

        selected=defaul;
        return updateSealResType;
    }


    public AddMTRefusalResType addMTRefusal(AddMTRefusalReqType addMTRefusalReqType)
    {
        DataSource selected=marineDS;
        DataSource defaul = selected;

        AddMTRefusalResType addMTRefusalResType = new AddMTRefusalResType();
        Map params = new HashMap();
        params.put("tokenno",addMTRefusalReqType.getTokenno());
        params.put("containerno",addMTRefusalReqType.getContainerno());
        params.put("regplate",addMTRefusalReqType.getRegplate());
        params.put("vehicleno",addMTRefusalReqType.getVehicleno());
        if (addMTRefusalReqType.getDamagecode()==-1)
            params.put("damagecode",null);
        else
            params.put("damagecode",addMTRefusalReqType.getDamagecode());
        params.put("damagedescr",addMTRefusalReqType.getDamagedescr());
        params.put("usercode",addMTRefusalReqType.getUsercode());
        params.put("isMTRefusal",addMTRefusalReqType.getIsMTRefusal());
        params.put("status","");
        selected=getCtmsJADatasource();
        String ctmsupdresult =  (String) databases.sql(selected).queryForObject("addMTRefusal",params);
        ctmsupdresult= (String)params.get("status");
        addMTRefusalResType.setStatus(ctmsupdresult);

        logger.info("HhtIntegrationsDAOImpl.addMTRefusal - Status :" + ctmsupdresult);

        selected=defaul;
        return addMTRefusalResType;
    }



    public AcceptTokenResType acceptToken(AcceptTokenReqType acceptTokenReqType)
    {
        DataSource selected=marineDS;
        DataSource defaul = selected;
        AcceptTokenResType acceptTokenResType = new AcceptTokenResType();
        Map params = new HashMap();
        params.put("tokenno",acceptTokenReqType.getTokenno());
        params.put("vehicleno",acceptTokenReqType.getVehicleno());
        params.put("regplate",acceptTokenReqType.getRegplate());
        params.put("containerno",acceptTokenReqType.getContainerno());
        params.put("terminalid",acceptTokenReqType.getTerminalid());
        params.put("platecode",acceptTokenReqType.getPlatecode());
        params.put("acctdate",acceptTokenReqType.getAcctdate());
        params.put("usercode",acceptTokenReqType.getUsercode());
        params.put("gate",acceptTokenReqType.getGate());
        params.put("active",acceptTokenReqType.getActive());
        params.put("status","");
        selected=getCtmsJADatasource();
        String result =  (String) databases.sql(selected).queryForObject("accepttoken",params);
        result= (String)params.get("status");
        acceptTokenResType.setStatus(result);

        logger.info("HhtServiceImpl.acceptToken - Status :" + acceptTokenResType.getStatus() );

        selected=defaul;
        return acceptTokenResType;
    }

    public Map getEir (EirReqType eirReqType){
        DataSource selected=marineDS;
        DataSource defaul = selected;
        Map params = new HashMap();
        params.put("containerno",eirReqType.getContrno());
        params.put("regplace",eirReqType.getRegplace());
        params.put("vehicleno",eirReqType.getVehicleno());
        params.put("platecode",eirReqType.getPlatecode());
        params.put("param1",eirReqType.getParam1());
        params.put("param2",eirReqType.getParam2());
        params.put("param3",eirReqType.getParam3());
        params.put("status","");
        params.put("eirres",new ArrayList());
        selected=getCtmsJADatasource();
        databases.sql(selected).queryForList("geteir",params);

        logger.info("HhtServiceImpl.uploadSignature - Status :" + (String)params.get("status") );

        selected=defaul;
        return params;
    }


    public ConfirmGateoutMoveResType confirmGateoutMove(ConfirmGateoutMoveReqType confirmGateoutMoveReqType)
    {
        DataSource selected=marineDS;
        DataSource defaul = selected;
        ConfirmGateoutMoveResType confirmGateoutMoveResType = new ConfirmGateoutMoveResType();
        Map params = new HashMap();
        params.put("tokenno",confirmGateoutMoveReqType.getTokenno());
        params.put("eirno",confirmGateoutMoveReqType.getEirno());
        params.put("containerno",confirmGateoutMoveReqType.getContainerno());
        params.put("terminalid",confirmGateoutMoveReqType.getTerminalid());
        params.put("confirm",confirmGateoutMoveReqType.getConfirm());
        params.put("usercode",confirmGateoutMoveReqType.getUsercode());
        params.put("gate",confirmGateoutMoveReqType.getGate());
        params.put("status","");
        selected=getCtmsJADatasource();
        String result =  (String) databases.sql(selected).queryForObject("confirmgateoutmove",params);
        result= (String)params.get("status");

        logger.info("HhtServiceImpl.confirmGateoutMove - status :" + result );

        confirmGateoutMoveResType.setStatus(result);
        selected=defaul;
        return confirmGateoutMoveResType;
    }

    public Map FZGPGateInOutSearch(FZGPGateInOutSearchReqType eFZGPGateInOutSearchInput)
    {
        DataSource selected=marineDS;
        DataSource defaul = selected;
        List<FZGPGateInOutSearchList> fzList = new ArrayList<FZGPGateInOutSearchList>();
        List<FZGPGateInOutSearchList> fzResultList = new ArrayList<FZGPGateInOutSearchList>();;
        List<FZGPGateInOutSearchList> gcList = null;
        Map params = new HashMap();

        eFZGPGateInOutSearchInput = getTruckNoForGpNo(eFZGPGateInOutSearchInput);

        params.put("gpnumber", eFZGPGateInOutSearchInput.getGatepassno());
        params.put("vehicleno", eFZGPGateInOutSearchInput.getVehicleno());
        params.put("platecode", eFZGPGateInOutSearchInput.getPlatecode());
        params.put("regplace", eFZGPGateInOutSearchInput.getRegplace());
        params.put("gpType", eFZGPGateInOutSearchInput.getInOut());
        params.put("gatepasslist", new ArrayList());
        params.put("errmessage", "");

        try {
            selected=getEfzGatePassDS();
            databases.sql(selected).queryForList("fzgatepasslist",params);


            Object resultList = params.get("gatepasslist");
            if (resultList != null) {
                fzResultList = (List<FZGPGateInOutSearchList>)resultList;
                for (FZGPGateInOutSearchList result: fzResultList) {
                    if (null != result.getGpno()) {
                        result.setSrcApp("F");
                        fzList.add(result);
                    }
                }
            }
        } catch (Exception e) {
            logger.info("fzgatepasslist error ::  "+e.getMessage(), e);
        }

        HashMap resultMap = new HashMap<String, Object>();
        try {
            selected=getGcDS();
            resultMap = this.getGenCargoTrucks(eFZGPGateInOutSearchInput);
            Object result = resultMap.get("result");

            if (!Utilities.isNullOrEmpty(result)) {
                gcList = (List<FZGPGateInOutSearchList>)result;
                for (FZGPGateInOutSearchList fzObj: gcList) {
                    if (!isGpNoExists(fzObj.getGpno())){
                        fzObj.setSrcApp("G");
                        fzList.add(fzObj);
                    }
                }
            }
        } catch (Exception e) {
            logger.info("getGenCargoTrucks error ::  "+e.getMessage(), e);
        }


        if(!Utilities.isNullOrEmpty(fzList) && fzList.size() > 0){
            for (FZGPGateInOutSearchList fzpGpInOutSearch: fzList) {
                String boeDesc = fzpGpInOutSearch.getBoeDesc();
                if(!Utilities.isNullOrEmpty(boeDesc)){
                    fzpGpInOutSearch.setGoodsdesc(boeDesc);
                }
            }
        }

        params.put("gatepasslist", fzList);

        String error = (String)resultMap.get("error");
        params.put("error", error);

        selected=defaul;
        return params;
    }

    public FZGPGateInOutUpdateResType FZGPGateInOutUpdate(FZGPGateInOutUpdateReqType eFZGPGateInOutUpdateInput)
    {
        DataSource selected=marineDS;
                DataSource defaul = selected;
                FZGPGateInOutUpdateResType eFZGPGateInOutUpdateResType = new FZGPGateInOutUpdateResType();
                Map params = new HashMap();
        String srcpAppVal = eFZGPGateInOutUpdateInput.getSrcApp();
        if ("F".equalsIgnoreCase(srcpAppVal)) {
                params.put("gpnumber",eFZGPGateInOutUpdateInput.getPgpno());
                params.put("gprefnumber",eFZGPGateInOutUpdateInput.getPgprefno());
                params.put("gateno",eFZGPGateInOutUpdateInput.getGateno());
                params.put("gateuser",eFZGPGateInOutUpdateInput.getGateuser());
                params.put("sourcesys",eFZGPGateInOutUpdateInput.getSourcesys());
                params.put("remarks",eFZGPGateInOutUpdateInput.getPremark());
                params.put("noofrows","");
                params.put("errmessage","");
                selected=getEfzGatePassDS();
                String result =   (String) databases.sql(selected).queryForObject("fzgatepassupdate",params);
                eFZGPGateInOutUpdateResType.setPrownos( (String) params.get("noofrows"));
                eFZGPGateInOutUpdateResType.setPerno((String) params.get("errmessage"));

            logger.info("HhtIntegrationsDAOImpl.FZGPGateInOutUpdate - rownos :" + eFZGPGateInOutUpdateResType.getPrownos() +  " - erno :" + eFZGPGateInOutUpdateResType.getPerno());
        }

        else if ("G".equalsIgnoreCase(srcpAppVal)) {

            String lgpNo = getDSGatePassLGPNo(eFZGPGateInOutUpdateInput.getPgpno());
            if(!Utilities.isNullOrEmpty(lgpNo)){
                eFZGPGateInOutUpdateResType.setPerno("This GC Gate Pass can not be taken OUT, instead It has to directly go to the freezone area. LGP No. - "+lgpNo);
            } else {
              selected=getGcDS();
              this.insertGCTrkExtMove(eFZGPGateInOutUpdateInput);
              eFZGPGateInOutUpdateResType.setPrownos("SUCCESS");
            }

        }

        selected=defaul;
        return eFZGPGateInOutUpdateResType;
    }


    private void insertGCTrkExtMove(FZGPGateInOutUpdateReqType eFZGPGateInOutUpdateInput) {
        DataSource selected=marineDS;
        String refDocType = null;
        String docType = null;
        String truckRegNo = null;
        Map params = new HashMap();

        selected=getGcDS();
        Long id = (Long) databases.sql(selected).queryForObject("getGCTrkNextVal");
        String pgpRefNo = eFZGPGateInOutUpdateInput.getPgprefno();
        if (!Utilities.isNullOrEmpty(pgpRefNo)) {
            refDocType = "PGA";
            docType = "GP";
        } else {
            docType = "PGA";
        }

        if (eFZGPGateInOutUpdateInput.getPlatecode() != null) {
            truckRegNo = eFZGPGateInOutUpdateInput.getRegplace() + " " + eFZGPGateInOutUpdateInput.getPlatecode() +
                    " " + eFZGPGateInOutUpdateInput.getVehicleno();
        } else {
            truckRegNo = eFZGPGateInOutUpdateInput.getRegplace() + " " + eFZGPGateInOutUpdateInput.getVehicleno();
        }

        params.put("GATE_TYPE", "GC");
        params.put("REC_ID", id);
        params.put("GATE_LOCATION", eFZGPGateInOutUpdateInput.getGateno());
        params.put("TRUCK_NO", truckRegNo);
        params.put("DOC_NO", eFZGPGateInOutUpdateInput.getPgpno());
        params.put("DOC_TYPE", docType);
        params.put("REF_DOC_NO", pgpRefNo);
        params.put("REF_DOC_TYPE", refDocType);
        params.put("INOUTDATE", new Date());
        params.put("SECURITY_ID", eFZGPGateInOutUpdateInput.getGateuser());
        params.put("IS_VALID", 0);
        params.put("CREATED_BY", eFZGPGateInOutUpdateInput.getGateuser());
        params.put("CREATED_DATE", new Date());
        params.put("REMARKS", eFZGPGateInOutUpdateInput.getPremark());

        databases.sql(selected).insert("insertGCExtTrkMove", params);
    }



    public void setEfzGatePassDS(DataSource efzGatePassDS) {
        DataSource selected=marineDS;
        this.efzGatePassDS = efzGatePassDS;
    }

    public DataSource getEfzGatePassDS() {
        DataSource selected=marineDS;
        return efzGatePassDS;
    }


    public SealResType prevSealDetails(SealReqType req) {
        DataSource selected=marineDS;
        DataSource defaul = selected;
        SealResType resType = new SealResType();

        Map params = new HashMap();
        params.put("PI_CONTR_NO", req.getContrNo());
        params.put("PI_TOKEN_NO", req.getTokenNo());
        params.put("PO_STATUS", "");
        params.put("PO_RESULT", "");

        selected=getCtmsJADatasource();
        databases.sql(selected).queryForList("prevSealDetails", params);

        List<SealType> recordList = (List<SealType>) params.get("PO_RESULT");
        resType.setStatus( (String) params.get("PO_STATUS"));
        if(recordList!=null && recordList.size() > 0) {
            SealType[] sealTypeArray = new SealType[recordList.size()];
            recordList.toArray(sealTypeArray);
            resType.setRecordList(sealTypeArray);
        }

        logger.info("HhtServiceImpl.prevSealDetails - Status :" + resType.getStatus() );

        selected=defaul;
        return resType;
    }

    public DamageResType prevDamageDetails(DamageReqType req) {
        DataSource selected=marineDS;
        DataSource defaul = selected;
        DamageResType resType = new DamageResType();

        Map params = new HashMap();
        params.put("PI_CONTR_NO", req.getContrNo());
        params.put("PI_TOKEN_NO", req.getTokenNo());
        params.put("PO_STATUS", "");
        params.put("PO_RESULT", "");

        selected=getCtmsJADatasource();
        databases.sql(selected).queryForList("prevDamageDetails", params);

        resType.setStatus( (String) params.get("PO_STATUS"));
        List<DamageType> recordList = (List<DamageType>) params.get("PO_RESULT");
        if(recordList!=null && recordList.size() > 0) {
            DamageType[] damageTypeArray = new DamageType[recordList.size()];
            recordList.toArray(damageTypeArray);
            resType.setRecordList(damageTypeArray);
        }

            logger.info("HhtServiceImpl.prevDamageDetails - Status :" + resType.getStatus() );

        selected=defaul;
        return resType;
    }


    public CodeResType getMajorDamages(boolean includeNonMajor) {
        DataSource selected=marineDS;
        DataSource defaul = selected;
        CodeResType resType = new CodeResType();
        Map params = new HashMap();
        params.put("includeNonMajor", includeNonMajor);
        selected=getCtmsJADatasource();
        List<CodeType> recordList = (List<CodeType>)databases.sql(selected).queryForList("getMajorDamages", params);
        if(recordList!=null && recordList.size() > 0) {
            CodeType[] codeTypeArray = new CodeType[recordList.size()];
            recordList.toArray(codeTypeArray);
            resType.setRecordList(codeTypeArray);
        }
        selected=defaul;
        return resType;
    }



        public ContainerDamageRespType getContainerDamages(ContainerDamageReqType containers) {
        DataSource selected=marineDS;
            DataSource defaul = selected;
            ContainerDamageRespType resType = new ContainerDamageRespType();

            Map params = new HashMap();
            params.put("PI_CONTR_NO", containers.getContainerNo());
            params.put("PO_STATUS", "");
            params.put("PO_RESULT", "");

            selected=getCtmsJADatasource();
            databases.sql(selected).queryForList("getContainerDamages", params);

            resType.setStatus( (String) params.get("PO_STATUS"));
            List<ContainerDamageType> recordList = (List<ContainerDamageType>) params.get("PO_RESULT");
            if(recordList!=null && recordList.size() > 0) {
                ContainerDamageType[] containerDamageTypeArray = new ContainerDamageType[recordList.size()];
                recordList.toArray(containerDamageTypeArray);
                resType.setContainerDamageTypesList(containerDamageTypeArray);
            }

            logger.info("HhtServiceImpl.getContainerDamages - Status :" + resType.getStatus() );

            selected=defaul;
            return resType;
        }

        public UpdateStdDmgDtlsRespType updateStdDmgDetails(UpdateStdDmgDtlsReqType stdDmgDtl) {
        DataSource selected=marineDS;
            DataSource defaul = selected;
            UpdateStdDmgDtlsRespType resType = new UpdateStdDmgDtlsRespType();
            resType.setStdInstructionSpecId(stdDmgDtl.getStdInstructionSpecId());

            Map params = new HashMap();
            params.put("PI_STD_INSTR_ID", stdDmgDtl.getStdInstructionId());
            params.put("PI_STD_INSTR_SPE_ID", stdDmgDtl.getStdInstructionSpecId());
            params.put("PI_USER_ID", stdDmgDtl.getUserId());
            params.put("PO_STATUS", "");

            selected=getCtmsJADatasource();
            databases.sql(selected).queryForObject("updateStdDmgDetails", params);
            resType.setStatus( (String) params.get("PO_STATUS"));

            logger.info("HhtServiceImpl.updateStdDmgDetails - Status :" + resType.getStatus() );

            selected=defaul;
            return resType;
        }

    public ComTruckNoRespType getTokenContrDtlsForTruck(ComTruckNoReqType truckNoReqType) {
        DataSource selected=marineDS;
        DataSource defaul = selected;
        ComTruckNoRespType truckNoRespType = new ComTruckNoRespType();
        try{
            Map params = new HashMap();
            params.put("PI_VEHICLE_NO", truckNoReqType.getTruckNo());
            params.put("PO_STATUS", "");
            params.put("PO_RESULT", "");
            selected=getCtmsJADatasource();
            databases.sql(selected).queryForList("getTokenContrDtlsForTruck", params);
            truckNoRespType.setStatus((String) params.get("PO_STATUS"));
            List<DummyTokenContrType> recordList = (List<DummyTokenContrType>) params.get("PO_RESULT");
            if(!Utilities.isListNullOrEmpty(recordList)) {
                DummyTokenContrType[] dummyTokenContrArray = new DummyTokenContrType[recordList.size()];
                recordList.toArray(dummyTokenContrArray);
                truckNoRespType.setDummyTokenContrList(dummyTokenContrArray);
            }
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SystemException("Commercial truck lookup failed",e);
        } finally {
            selected=defaul;
        }
        logger.info("HhtServiceImpl.getTokenContrDtlsForTruck - Status :" + truckNoRespType.getStatus());
        return truckNoRespType;
    }

    public VerifyUserRespType verifyUser(VerifyUserReqType verifyUserInput) {
        DataSource selected=marineDS;
        DataSource defaul = selected;
        VerifyUserRespType verifyUserRespType = new VerifyUserRespType();
        try{
            Map params = new HashMap();
            params.put("PI_USER_NAME", verifyUserInput.getUserName());
            params.put("PI_USER_PWD", verifyUserInput.getPassword());
            params.put("PO_VALID", new Integer(0));
            params.put("PO_STATUS", "");
            selected=getCtmsJADatasource();
            databases.sql(selected).queryForList("verifyUser", params);
            verifyUserRespType.setStatus((String) params.get("PO_STATUS"));
            verifyUserRespType.setVaild((Integer) params.get("PO_VALID"));
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            verifyUserRespType.setStatus(e.getMessage());
            verifyUserRespType.setVaild(0);
        } finally {
            selected=defaul;
        }
        logger.info("HhtServiceImpl.getTokenContrDtlsForTruck - Status :" + verifyUserRespType.getStatus());
        return verifyUserRespType;
    }


    public

    Map getContrLocation(ContrLocationReqType contrLocReqType) {
        DataSource selected=marineDS;
        DataSource defaul = selected;
        Map params = new HashMap();

        params.put("contrno", contrLocReqType.getContrno());
        params.put("vehicleno", contrLocReqType.getVehicleno());
        params.put("regplate", contrLocReqType.getRegplate());
        params.put("platecode", contrLocReqType.getPlatecode());
        params.put("status", "");
        params.put("contrlocres", new ArrayList());
        selected=getCtmsJADatasource();
        databases.sql(selected).queryForList("getContrLocation", params);

        logger.info("HhtServiceImpl.getContrLocation - Status :" +
                    params.get("status"));
        selected=defaul;
        return params;
    }

    public Map printEir(PrintEirReqType printEirReqType) {
        DataSource selected=marineDS;
        DataSource defaul = selected;
        Map params = new HashMap();

        params.put("contrno", printEirReqType.getContrno());
        params.put("regplace", printEirReqType.getRegplace());
        params.put("vehicleno", printEirReqType.getVehicleno());
        params.put("platecode", printEirReqType.getPlatecode());
        params.put("param1", printEirReqType.getParam1());
        params.put("param2", printEirReqType.getParam2());
        params.put("param3", printEirReqType.getParam3());
        params.put("status", "");
        params.put("printeirres", new ArrayList());

        selected=getCtmsJADatasource();
        databases.sql(selected).queryForList("printEir", params);

        logger.info("HhtServiceImpl.uploadSignature - Status :" +
                    (String)params.get("status"));

        selected=defaul;
        return params;
    }


    public Map getNoticeDetails(NoticeDetailsReqType noticeDetailsReq) {
        DataSource selected=marineDS;
         DataSource ds = selected;
         Map params = new HashMap();

         try {
             params.put("rotationNumber", noticeDetailsReq.getRotationNumber());
             params.put("terminalId", noticeDetailsReq.getTerminalId());
             params.put("vesselRS", new ArrayList());
             params.put("noticeDetailsRS", new ArrayList());
             params.put("status", "");
             selected=getPromisMainDS();
             databases.sql(selected).queryForList("getNoticeDetails", params);
             selected=ds;

         } catch (Exception e) {
             logger.error(e.getMessage(), e);
         } finally {
             selected=ds;
         }
         return params;
     }

    public Map updateNoticeDetails(UpdateNoticeDetailsReqType updateNoticeDetailsReq) {
        DataSource selected=marineDS;
         DataSource defaul = selected;
         Map params = new HashMap();
         selected=getPromisMainDS();
         Integer rotn = updateNoticeDetailsReq.getRotationNumber();
         String terminalId = updateNoticeDetailsReq.getTerminalId();
         NoticeTypeList[] noticeList = updateNoticeDetailsReq.getNoticeList();
         for (NoticeTypeList notice: noticeList) {
             if (notice != null) {
                 params.put("rotationNumber", rotn);
                 params.put("terminalId", terminalId);
                 params.put("noticeType", notice.getNoticeType());
                 params.put("etcDate", notice.getEtcDate());
                 params.put("procStatus", "N");
                 params.put("userId", notice.getUserId());
                 params.put("status", "");
                 databases.sql(selected).queryForList("updateNoticeDetails", params);
             }
         }
         selected=defaul;
         return params;
     }

    public List<TokenSlotType> getTokenSlotList(TokenTimeSlotReqType tokenTimeSlot){
        DataSource selected=marineDS;
         DataSource defaul = selected;
         Map params = new HashMap();
         params.put("vehicleno",tokenTimeSlot.getVehicleno());
         params.put("regplate",tokenTimeSlot.getRegplate());
         params.put("tokenSlotRs",new ArrayList());

         selected=getCtmsJADatasource();
         databases.sql(selected).queryForList("getTokenSlot", params);
         List<TokenSlotType> tokenSlotList =(List<TokenSlotType>) params.get("tokenSlotRs");
         selected=defaul;
         return tokenSlotList;
     }


    public List<BerthType> getBerthList(){
        DataSource selected=marineDS;
         DataSource defaul = selected;
         Map params = new HashMap();
         params.put("berthRS",new ArrayList());
         params.put("errmessage","");

         selected=getPromisMainDS();
         databases.sql(selected).queryForList("getBerths",params);
         List<BerthType> berthTypeList =(List<BerthType>) params.get("berthRS");
         logger.info("HhtServiceImpl.getBerthList - errmessage :" + params.get("errmessage") );
         selected=defaul;
         return berthTypeList;
     }
      private boolean isGpNoExists(String gpno) {
        DataSource selected=marineDS;
        boolean gpNoStatus = false;
        Map param = new HashMap();
        DataSource defaul = selected;
        selected=getGcDS();

        param.put("gpno", gpno);
        List result = databases.sql(selected).queryForList("gpnoStatus", param);
        selected=defaul;

        if (!Utilities.isListNullOrEmpty(result) && result.size() > 0)
            gpNoStatus = true;
        return gpNoStatus;
    }

    private FZGPGateInOutSearchReqType getTruckNoForGpNo(FZGPGateInOutSearchReqType fzRequest) {
        DataSource selected=marineDS;
        Map params = new HashMap();
        DataSource defaul = selected;

        params.put("GPNO",fzRequest.getGatepassno());
        params.put("trucknoRS", new ArrayList());

        selected=getGcDS();
        if (Utilities.isNullOrEmpty(fzRequest.getVehicleno()) ||
            Utilities.isNullOrEmpty(fzRequest.getRegplace())) {
             List<FZGPGateInOutSearchReqType> result=  (List<FZGPGateInOutSearchReqType>)databases.sql(selected).queryForList("fztruckno", params );
            if (result != null && result.size()>0){
                FZGPGateInOutSearchReqType request = result.get(0);
                fzRequest.setRegplace(request.getRegplace());
                fzRequest.setPlatecode(request.getPlatecode());
                fzRequest.setVehicleno(request.getVehicleno());
            }
        }
        selected=defaul;
        return fzRequest;
    }

    private HashMap getGenCargoTrucks(FZGPGateInOutSearchReqType eFZGPGateInOutSearchInput) {
        DataSource selected=gcDS;
        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        String gatePassNo = eFZGPGateInOutSearchInput.getGatepassno();
        String gateInOut = eFZGPGateInOutSearchInput.getInOut();
        String regPlace = eFZGPGateInOutSearchInput.getRegplace();
        String vehicleNo = eFZGPGateInOutSearchInput.getVehicleno();
        String plateCode = eFZGPGateInOutSearchInput.getPlatecode();
        String truckRegNo = null;
        List gcList = new ArrayList() ;
        Map inputMap = new HashMap();
        Map crgtypeMap = null;

        if (!Utilities.isNullOrEmpty(gateInOut) && "I".equalsIgnoreCase(gateInOut)) {
            inputMap.put("VEH_NO", vehicleNo);
            if (!Utilities.isNullOrEmpty(plateCode))
                inputMap.put("PLT_CODE", plateCode);
            inputMap.put("CITY_CODE", regPlace);
            gcList =  databases.sql(selected).queryForList("getPGADetails", inputMap);
        } else if (!Utilities.isNullOrEmpty(gateInOut) &&  "O".equalsIgnoreCase(gateInOut)) {
            if(!Utilities.isNullOrEmpty(regPlace))
                regPlace = regPlace.trim();
            if(!Utilities.isNullOrEmpty(vehicleNo))
                vehicleNo = vehicleNo.trim();


            if (!Utilities.isNullOrEmpty(plateCode)) {
                plateCode = plateCode.trim();

                truckRegNo = regPlace + " " + plateCode + " " + vehicleNo;
            } else {
                truckRegNo = regPlace + "%" + vehicleNo;
            }
            inputMap.put("TRUCK_REG_NO", truckRegNo);

             gcList = databases.sql(selected).queryForList("getGPDetailsGCRORO",inputMap);
            if (gcList == null) {
                resultMap.put("error", "No matching entries found");
            }
        }
        resultMap.put("result", gcList);
        return resultMap;
    }

    public TruckInfoResType getTruckInfoByContainer(TruckInfoReqType truckInfoReqType){
        DataSource selected=marineDS;
         TruckInfoResType truckInfoResType = null;
         DataSource defaul = selected;
         Map params = new HashMap();
         params.put("containerNumber",truckInfoReqType.getContainerNumber());
         params.put("trunkInfoRs",new ArrayList());

         selected=getCtmsJADatasource();
         databases.sql(selected).queryForList("getTruckInfoByContainer", params);
         if(params.containsKey("trunkInfoRs")) {
             List<TruckInfoResType> truckInfoList =(List<TruckInfoResType>) params.get("trunkInfoRs");
             if(null != truckInfoList && truckInfoList.size()>0) {
                 truckInfoResType = truckInfoList.get(0);
             }
         }
         selected=defaul;
         return truckInfoResType;
     }


     public AdjustTimeSlotRespType getAdjustTimeSlot(AdjustTimeSlotReqType req) {
        DataSource selected=marineDS;
         DataSource defaul = selected;
         AdjustTimeSlotRespType resType = new AdjustTimeSlotRespType();

         Map params = new HashMap();
         if(req != null){
         logger.info("getAdjustTimeSlot .container no." +req.getContainerNo()+" ..token.."+req.getTokenNo()+"..user code.." + req.getUserCode());
         params.put("PI_CONTR_NO", req.getContainerNo());
         params.put("PI_TOKEN_NO", req.getTokenNo());
         params.put("PI_USER_CODE", req.getUserCode());
         params.put("PO_RESULT", "");
         params.put("PO_REMARKS", "");
         }
         selected=getCtmsJADatasource();
         databases.sql(selected).queryForList("getAdjustTimeSlot", params);

         resType.setResult((Integer) params.get("PO_RESULT"));
         resType.setRemarks((String) params.get("PO_REMARKS"));

         logger.info("HhtServiceImpl.getAdjustTimeSlot - setResult :" + resType.getResult() + "..Remarks.." +  resType.getRemarks());
         selected=defaul;
         return resType;
     }



    public String getMajorDamageFlag() {
        DataSource selected=marineDS;
        DataSource defaul = selected;
        selected=getPromisMainDS();
        String majorDamageFlag = (String)databases.sql(selected).queryForObject("getMajorDamageFlag");
        selected=defaul;
        return majorDamageFlag;
    }


    private String getDSGatePassLGPNo(String gpNo){
        DataSource selected=marineDS;
        Map params = new HashMap();
        params.put("gpno",gpNo);
        selected=getEfzGatePassDS();
        String lgpNo = (String) databases.sql(selected).queryForObject("getDSGatePassLGPNo", params);
        return lgpNo;
    }



     public UpdateDamagesResType updateContainerWithDamages(UpdateDamagesReqType updateDamagesReqType)
     {
        DataSource selected=marineDS;
         DataSource defaul = selected;

         UpdateDamagesResType updateDamagesResType = new UpdateDamagesResType();
         Map params = new HashMap();
         params.put("tokenno",updateDamagesReqType.getTokenno());
         params.put("containerno",updateDamagesReqType.getContainerno());
         params.put("sealno",updateDamagesReqType.getSealno());
         params.put("movetype",updateDamagesReqType.getMovetype());
         params.put("regplate",updateDamagesReqType.getRegplate());
         params.put("vehicleno",updateDamagesReqType.getVehicleno());
         if (updateDamagesReqType.getDamagecode() == -1)
             params.put("damagecode",null);
         else
             params.put("damagecode",updateDamagesReqType.getDamagecode());
         params.put("damagedescr",updateDamagesReqType.getDamagedescr());
         params.put("mtinspflag",updateDamagesReqType.getMtinspflag() );
         params.put("customseal",updateDamagesReqType.getCustomseal());
         params.put("dpwseal",updateDamagesReqType.getDpwseal());
         params.put("agentseal",updateDamagesReqType.getAgentseal());
         params.put("usercode",updateDamagesReqType.getUsercode());
         params.put("atdate",updateDamagesReqType.getAtdate());
         params.put("devid",updateDamagesReqType.getDevid());
         params.put("tipmsg",updateDamagesReqType.getTipmsg());
         params.put("cancelstatus",updateDamagesReqType.getCancelstatus());
         params.put("gate",updateDamagesReqType.getGate());

         params.put("isSealInvalid",updateDamagesReqType.getIsSealInvalid());
         params.put("isImcoLabelInvalid",updateDamagesReqType.getIsImcoLabelInvalid());
         params.put("mtOutSeatIssued",updateDamagesReqType.getMtOutSeatIssued());
         params.put("chassisType",updateDamagesReqType.getChassisType());
         params.put("contrChassisPos",updateDamagesReqType.getContrChassisPos());
         params.put("oogStatus",updateDamagesReqType.getOogStatus());
         params.put("status","");
         selected=getCtmsJADatasource();
         String ctmsupdresult =  (String) databases.sql(selected).queryForObject("updateContainerWithDamages",params);
         ctmsupdresult= (String)params.get("status");
         updateDamagesResType.setStatus(ctmsupdresult);

         logger.info("HhtIntegrationsDAOImpl.updateContainerWithDamages - Status :" + ctmsupdresult);

         selected=defaul;
         return updateDamagesResType;
     }

         public void setGcDS(DataSource gcDS) {
        DataSource selected=marineDS;
             this.gcDS = gcDS;
         }

         public DataSource getGcDS() {
        DataSource selected=marineDS;
             return gcDS;
         }

    public void setRsisDS(DataSource rsisDS) {
        DataSource selected=marineDS;
        this.rsisDS = rsisDS;
    }

    public DataSource getRsisDS() {
        DataSource selected=marineDS;
        return rsisDS;
    }
}
