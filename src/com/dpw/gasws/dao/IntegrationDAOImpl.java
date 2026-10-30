package com.dpw.gasws.dao;

import com.dpw.gasws.type.ContainerDetailsRequestType;
import com.dpw.gasws.type.ContrDetailsReqType;
import com.dpw.gasws.type.EirLocDetailsRequestType;
import com.dpw.gasws.type.ExceptionDataRequestType;
import com.dpw.gasws.type.GetTokenRequestType;
import com.dpw.gasws.type.TokenDetailsReqType;
import com.dpw.gasws.util.GaswsIntegrationConstants;

import com.pcfc.ports.promis.common.Utilities;

import com.pcfc.services.exception.SystemException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import oracle.jdbc.OracleConnection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


public class IntegrationDAOImpl extends SqlMapClientDaoSupport implements IntegrationDAO {

    private Log log = LogFactory.getLog(IntegrationDAOImpl.class);
    
    private DataSource promisDS;  
        
    private DataSource goldDS;
    
    private GetEirLocationDetailsProc getEirLocationDetailsProc;
    
    private GetEirLocationDetailsProc getEirLocationDetailsProcGold;
    
  
    /**
     * 
     * @param tokenReqType    
     * @return
     */
    public Map getTokenDetails(GetTokenRequestType tokenReqType) {
            /* Need to enable redirect flag once the GOLD DB is ready */
            if(GaswsIntegrationConstants.DB_REDIRECT) {
               setDataSource(getAvailableDataSource());
            } else {
               setDataSource(getPromisDS());
            }
            
            Map paramMap = new HashMap();          
            paramMap.put("PI_RFID_NO", tokenReqType.getRfIdNo());
            paramMap.put("PI_TRUCK_NO", tokenReqType.getTruckNo()); 
            paramMap.put("PI_REG_PLACE", tokenReqType.getRegPlace());
            paramMap.put("PI_TERMINAL_ID", tokenReqType.getTerminalId());           
            paramMap.put("PO_TOKEN_DTL", new ArrayList());
            paramMap.put("PO_ERROR", "");

            getSqlMapClientTemplate().queryForList("getTokenDetails", paramMap);

            return paramMap;
    }  
    
    /**
     * 
     * @param contrDtlsReqType    
     * @return
     */
    public Map getContainerDetails(ContainerDetailsRequestType contrDtlsReqType) {
        /* Need to enable redirect flag once the GOLD DB is ready */
        if(GaswsIntegrationConstants.DB_REDIRECT) {
           setDataSource(getAvailableDataSource());
        } else {
           setDataSource(getPromisDS());
        }
        
        Map paramMap = new HashMap();          
        paramMap.put("PI_TERMINAL_ID", contrDtlsReqType.getTerminalId());                   
        paramMap.put("PO_CONTAINER_DTL", new ArrayList());
        paramMap.put("PO_ERROR", "");

        getSqlMapClientTemplate().queryForList("getContainerDetails", paramMap);

        return paramMap;
    }  
    
    /**
     * 
     * @param eirLocReqType    
     * @return
     */
    public Map getEirLocationDetails(EirLocDetailsRequestType eirLocReqType) {
        Map resultMap ; 
        OracleConnection con = null;
        boolean promis = true;
        try {
            /* Need to enable redirect flag once the GOLD DB is ready */
            if(GaswsIntegrationConstants.DB_REDIRECT) {            
                  try {
                      con =(OracleConnection)getPromisDS().getConnection();                   
                   } catch (Exception e) {
                       log.info("calling gold ds");
                       promis = false;                   
                   } finally {
                       try {
                           if(con != null) 
                                con.close(); 
                        } catch (SQLException e) {
                            log.error("Error while closing connection "+e.getMessage());   
                        }
                   }
                   if(promis) {
                       resultMap = getGetEirLocationDetailsProc().execute(eirLocReqType); 
                   } else {
                       resultMap = getGetEirLocationDetailsProcGold().execute(eirLocReqType); 
                   }               
             } else {
                resultMap = getGetEirLocationDetailsProc().execute(eirLocReqType);
             }           
        } catch (SQLException e) {
            throw new SystemException(e.getCause());
        }
        return resultMap;
    }  
    
    /**
     * 
     * @param exceptionDataReqType    
     * @return
     */
    public Map postExceptionData(ExceptionDataRequestType exceptionDataReqType) {
            /* Need to enable redirect flag once the GOLD DB is ready */
            if(GaswsIntegrationConstants.DB_REDIRECT) {
               setDataSource(getAvailableDataSource());
            } else {
               setDataSource(getPromisDS());
            }
            
            Map paramMap = new HashMap();          
            paramMap.put("PI_CAMCO_ERR_DATE", exceptionDataReqType.getErrorDate());
            paramMap.put("PI_TRUCK_NO", exceptionDataReqType.getTruckNo()); 
            paramMap.put("PI_REG_PLACE", exceptionDataReqType.getRegPlace());
            paramMap.put("PI_CONTR_NO", exceptionDataReqType.getContainerNo());   
            paramMap.put("PI_TOKEN_NO", exceptionDataReqType.getTokenNo());             
            paramMap.put("PI_LANE_ID", exceptionDataReqType.getLaneId());
            paramMap.put("PI_ERR_CODE", exceptionDataReqType.getErrorCode());
            paramMap.put("PI_ERR_DESC", exceptionDataReqType.getErrorDesc());
            paramMap.put("PO_ERROR", "");

            getSqlMapClientTemplate().queryForObject("postExceptionData", paramMap);

            return paramMap;
    }  
       
    /*
     * return DataSource based on availability of database PROMIS/GOLD
     */ 
    private DataSource getAvailableDataSource() {  
        OracleConnection con = null;
        try {
            con =(OracleConnection)getPromisDS().getConnection();            
            return getPromisDS();
        } catch (Exception e) {
            log.error("Error getting PROMIS DS "+e.getMessage());             
            try { //close above opened con if not null
                if(con != null) 
                     con.close(); 
             } catch (SQLException e1) {
                 log.error("Error getting PROMIS DS "+e1.getMessage());
             }             
            
            try {
               con =(OracleConnection)getGoldDS().getConnection(); 
               return getGoldDS();
            } catch (Exception e1) {
                log.error("Error getting GOLD DS "+e1.getMessage());                 
            }
            
        } finally {
           try {
               if(con != null) 
                    con.close(); 
            } catch (SQLException e) {
                log.error("Error getting PROMIS DS "+e.getMessage());   
            }
        }
        return getPromisDS();
    }
    
    /*
     * return OracleConnection based on availability of database PROMIS/GOLD
     */
    private OracleConnection getConnection(OracleConnection con ,boolean redirect) {
        try {
            con =(OracleConnection)getPromisDS().getConnection(); 
        } catch (Exception e) {
            log.error("Error getting PROMIS DS "+e.getMessage());
            if(redirect) {
                try {
                  con =(OracleConnection)getGoldDS().getConnection(); 
                } catch (Exception e1) {
                    log.error("Error getting GOLD DS "+e1.getMessage());                     
                }
            }
        }
        return con;
    }

    public void setGoldDS(DataSource goldDS) {
        this.goldDS = goldDS;
    }

    public DataSource getGoldDS() {
        return goldDS;
    }

    public void setPromisDS(DataSource promisDS) {
        this.promisDS = promisDS;
    }

    public DataSource getPromisDS() {
        return promisDS;
    }


    public void setGetEirLocationDetailsProc(GetEirLocationDetailsProc getEirLocationDetailsProc) {
        this.getEirLocationDetailsProc = getEirLocationDetailsProc;
    }

    public GetEirLocationDetailsProc getGetEirLocationDetailsProc() {
        return getEirLocationDetailsProc;
    }

    public void setGetEirLocationDetailsProcGold(GetEirLocationDetailsProc getEirLocationDetailsProcGold) {
        this.getEirLocationDetailsProcGold = getEirLocationDetailsProcGold;
    }

    public GetEirLocationDetailsProc getGetEirLocationDetailsProcGold() {
        return getEirLocationDetailsProcGold;
    }
}

