package com.dpw.gasws.dao;


import com.dpw.gasws.domain.ContrDetailsSqlType;

import com.dpw.gasws.type.ContrDetailsReqType;
import com.dpw.gasws.type.EirDetailsType;

import com.dpw.gasws.type.EirLocDetailsRequestType;
import com.dpw.gasws.type.LocDetailsType;

import com.dpw.gasws.type.TokenDetailsReqType;

import com.pcfc.ports.promis.common.Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import oracle.sql.ARRAY;

import oracle.sql.ArrayDescriptor;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.object.StoredProcedure;


/**
 * @author ambili
 * 
 */
public class GetEirLocationDetailsProc extends StoredProcedure {
    private Log log = LogFactory.getLog(GetEirLocationDetailsProc.class);
    
    public static final String PROC = "GAS_WEB_SERVICE_INTERFACE.GET_EIR_LOC_DATA";
    public static final String CAMCO_CONTR_SQL_TAB_TYPE = "TBL_CAMCO_CONTR_OBJ";
    private DataSource dataSource;
    
    /**
     * @param ds DataSource
     */
    public GetEirLocationDetailsProc(DataSource ds) {
        super(ds, PROC);
        super.setFunction(Boolean.FALSE);
        this.dataSource = ds;
        declareParameter(new SqlParameter("PI_PORT_CODE", Types.VARCHAR));
        declareParameter(new SqlParameter("PI_RFID_NO", Types.VARCHAR));
        declareParameter(new SqlParameter("PI_TRUCK_NO", Types.VARCHAR));
        declareParameter(new SqlParameter("PI_REG_PLACE", Types.VARCHAR));
        declareParameter(new SqlParameter("PI_TOKEN_NO", Types.VARCHAR));
        declareParameter(new SqlParameter("PI_CHASSIS_TYPE", Types.VARCHAR));
        declareParameter(new SqlParameter("PI_CONTR_TBL" , Types.ARRAY));
        declareParameter(new SqlParameter("PI_LANE_ID", Types.VARCHAR));
        declareParameter(new SqlParameter("PI_VISIT_ID", Types.VARCHAR));
        declareParameter(new SqlOutParameter("PO_EIR_DTL", OracleTypes.CURSOR, new RowMapper() {

                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    EirDetailsType eirDetail = new EirDetailsType();                           
                    eirDetail.setTerminalId(rs.getString("terminal_id"));
                    eirDetail.setPlateNo(rs.getString("PLATE_NO"));
                    eirDetail.setPlateEmirate(rs.getString("PLATE_EMIRATE"));
                    eirDetail.setTokenNo(rs.getString("TOKEN_NO"));
                    eirDetail.setContainerNo(rs.getString("CONTR_NO"));
                    eirDetail.setLoad(rs.getString("load"));
                    eirDetail.setHandling(rs.getString("handling"));
                    eirDetail.setConsignee(rs.getString("consignee"));
                    eirDetail.setDpaSeal(rs.getString("dpa_seal"));                          
                    eirDetail.setSeal(rs.getString("SEAL"));
                    eirDetail.setAgentSeal(rs.getString("AGENT_SEAL"));
                    eirDetail.setCustomsSeal(rs.getString("customs_seal"));
                    eirDetail.setEirNo(rs.getString("eir_no"));
                    eirDetail.setEirDate(rs.getString("EIR_DATE"));
                    eirDetail.setRemarks(rs.getString("REMARKS"));
                    eirDetail.setRemarks2(rs.getString("REMARKS2"));
                    eirDetail.setRemarks3(rs.getString("REMARKS3"));
                    eirDetail.setLocation(rs.getString("LOCATION"));
                    eirDetail.setMovType(rs.getString("MOVE_TYPE"));  
                    eirDetail.setPrintEir(rs.getString("print_eir")); 
                    return eirDetail;
                }
             }));              
        declareParameter(new SqlOutParameter("PO_LOC_DTL", OracleTypes.CURSOR, new RowMapper() {

                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    LocDetailsType locDetails = new LocDetailsType();                           
                    locDetails.setTerminalId(rs.getString("terminal_id"));
                    locDetails.setPlateNo(rs.getString("PLATE_NO"));
                    locDetails.setPlateEmirate(rs.getString("PLATE_EMIRATE"));
                    locDetails.setTokenNo(rs.getString("TOKEN_NO"));
                    locDetails.setContainerNo(rs.getString("CONTR_NO"));                    
                    locDetails.setLoad(rs.getString("load"));
                    locDetails.setHandling(rs.getString("handling")); 
                    locDetails.setLocation(rs.getString("LOCATION"));
                    locDetails.setSeal(rs.getString("SEAL"));                   
                    locDetails.setRemarks(rs.getString("REMARKS"));
                    locDetails.setRemarks2(rs.getString("REMARKS2"));
                    locDetails.setRemarks3(rs.getString("REMARKS3")); 
                    return locDetails;
                }
             }));   
        declareParameter(new SqlOutParameter("PO_ERROR", Types.VARCHAR));
        super.compile();
    }

    /**
     * @param  eirLocReqType
     * @return execute result map
     * @throws SQLException db exception
     */
    public Map execute(EirLocDetailsRequestType eirLocReqType) throws SQLException {
        Map paramMap = new HashMap();
        paramMap.put("PI_PORT_CODE", eirLocReqType.getPortCode());
        paramMap.put("PI_RFID_NO", eirLocReqType.getRfIdNo());
        paramMap.put("PI_TRUCK_NO", eirLocReqType.getTruckNo());
        paramMap.put("PI_REG_PLACE", eirLocReqType.getRegPlace());
        paramMap.put("PI_CHASSIS_TYPE", eirLocReqType.getChassisType());
        paramMap.put("PI_LANE_ID", eirLocReqType.getLaneId());
        paramMap.put("PI_VISIT_ID", eirLocReqType.getVisitId());
        
        TokenDetailsReqType[] tokenDtls = eirLocReqType.getTokenDetails();
        StringBuilder  tokenStr = new StringBuilder(); 
        if(tokenDtls != null && tokenDtls.length >0) {
          for(TokenDetailsReqType obj: (TokenDetailsReqType[]) tokenDtls) {
              if(!Utilities.isNullOrEmpty(obj.getTokenNo()))
                   tokenStr.append(obj.getTokenNo()).append(",");
          }
        }    
        paramMap.put("PI_TOKEN_NO", tokenStr.length() > 0 ? (tokenStr.deleteCharAt(tokenStr.length()-1)).toString() : null);       
       
        ARRAY arr = createComplexObject(DataSourceUtils.getConnection(this.dataSource), eirLocReqType.getContrDetails());
        paramMap.put("PI_CONTR_TBL", arr);          
        
        return executeProc(paramMap);
    }
    
    private Map executeProc(Map paramMap) {
        Map resultMap = null;
        long startTimeProc = System.currentTimeMillis();
        resultMap = super.execute(paramMap);
        long endTimeProc = System.currentTimeMillis();
        double totalQueryTime = (endTimeProc-startTimeProc)/1000.0;   
        
        log.info("Procedure Execution Details : (" + PROC + 
                ", " + totalQueryTime + " seconds)");
        return resultMap;
    } 
    
    /**
     * Convert list to ARRAY.
     * 
     * @param conn
     * @param contrDetails
     * @return
     * @throws SQLException
     */
    private ARRAY createComplexObject(Connection conn, ContrDetailsReqType[] contrDetails) throws SQLException {
        ArrayDescriptor desc;
        ARRAY arr = null;        
        ContrDetailsSqlType  contrDetailSqlType;
        ContrDetailsSqlType[] contrDetailsSqlTypeArr;
        try {            
            contrDetailsSqlTypeArr = new ContrDetailsSqlType[contrDetails.length];            
            for(int i=0;i<contrDetails.length;i++) {
                contrDetailSqlType = new ContrDetailsSqlType();                
                BeanUtils.copyProperties(contrDetailSqlType,contrDetails[i]);
                contrDetailsSqlTypeArr[i]= contrDetailSqlType;
            }
            desc = ArrayDescriptor.createDescriptor(CAMCO_CONTR_SQL_TAB_TYPE, conn);  
            arr = new ARRAY(desc, conn, contrDetailsSqlTypeArr);                       
        } catch (Exception e) {
            log.error(PROC+"createComplexObject method failed"+e.getMessage());
        } finally {
            DataSourceUtils.doReleaseConnection(conn, this.dataSource); 
        }        
        return arr;
    }
}
