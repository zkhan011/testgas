package com.dpw.ports.promis.aqoperations.dao;
import java.sql.*;import java.util.*;import javax.sql.DataSource;
import com.dpw.ports.promis.common.integration.domain.Voyage;
import com.dpw.ports.promis.aqoperations.ProcedureConstants;
import org.springframework.jdbc.core.*;import org.springframework.jdbc.support.JdbcTransactionManager;import org.springframework.transaction.support.TransactionTemplate;
public final class VoyageCreationStoredProc {
 private final DataSource ds;
 public VoyageCreationStoredProc(DataSource ds){this.ds=ds;}
 public Map execute(Voyage voyage,String serialNumber)throws SQLException {
  return new TransactionTemplate(new JdbcTransactionManager(ds)).execute(status ->new JdbcTemplate(ds).execute((ConnectionCallback<Map>) connection ->{
   var oracle=connection.unwrap(oracle.jdbc.OracleConnection.class);boolean ja="J".equalsIgnoreCase(voyage.getPortCode());String schema=ja?"OPCTJAD_AQ":"OPCTPRD_AQ";
   Object[] attributes=new Object[]{voyage.getPortCode(), voyage.getTerminalId(), voyage.getRotationNo(), voyage.getVesselName(), voyage.getVoyageType(), voyage.getCallType(), voyage.getCallReason(), voyage.getVoyageRoute(), voyage.getVoyageNoIn(), voyage.getVoyageNoOut(), voyage.getEtaDate(), voyage.getEtdDate(), voyage.getPortArrivalDate(), voyage.getArrivalfrom(), voyage.getSailTo(), voyage.getSailDate(), voyage.getPlannedBerth(), voyage.getCurrentBerth(), voyage.getStayHours(), voyage.getArrivalDraft(), voyage.getFirstCallDate(), voyage.getReadyToSailDate(), voyage.getSailDraft(), voyage.getLineCode(), voyage.getCreatedBy()};
   for(int i=0;i<attributes.length;i++)if(attributes[i] instanceof java.util.Date d)attributes[i]=new Timestamp(d.getTime());
   Struct detail=oracle.createStruct(schema+".MARINE_VOYAGE_DTL_OBJTYP",attributes);java.sql.Array details=oracle.createOracleArray(schema+".MARINE_VOYAGE_DTL_TABTYP",new Object[]{detail});
   try{
    Struct header=oracle.createStruct(schema+".MSG_HDR_OBJTYP",new Object[]{serialNumber,"VOYAGE","I",new Timestamp(System.currentTimeMillis()),1,null,"Marine",ja?"CTMS-JA":"CTMS-PR","MA",ja?"JA":"PR",null});
    Struct message=oracle.createStruct(schema+".MARINE_VOYAGE_MSG_OBJTYP",new Object[]{header,details});
    try(CallableStatement call=connection.prepareCall("{call ctms_marine_int_pkg.receive_voyage_create(?,?,?,?,?)}")){
     call.setObject(1,message);call.setString(2,"N");call.registerOutParameter(3,Types.NUMERIC);call.registerOutParameter(4,Types.VARCHAR);call.registerOutParameter(5,Types.VARCHAR);call.execute();
     Map result=new HashMap();result.put(ProcedureConstants.ROT_GEN_PROC_PARAM_ROTN_NO,call.getBigDecimal(3));result.put(ProcedureConstants.ROT_GEN_PROC_PARAM_ERROR_CODE,call.getString(4));result.put(ProcedureConstants.ROT_GEN_PROC_PARAM_ERROR_DESC,call.getString(5));if(call.getString(4)!=null && !call.getString(4).isBlank())status.setRollbackOnly();return result;
    }
   }finally{details.free();}
  }));
 }
}
