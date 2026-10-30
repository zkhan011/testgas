package com.dpw.gasws.dao;


import com.dpw.gasws.type.ContainerDetailsRequestType;
import com.dpw.gasws.type.EirLocDetailsRequestType;
import com.dpw.gasws.type.ExceptionDataRequestType;
import com.dpw.gasws.type.GetTokenRequestType;
import java.util.Map;


public interface IntegrationDAO {
    /**
     * 
     * @param tokenReqType
     * @return
     */
    Map getTokenDetails(GetTokenRequestType tokenReqType);
    
    /**
     * 
     * @param contrDtlsReqType
     * @return
     */
    Map getContainerDetails(ContainerDetailsRequestType contrDtlsReqType);
    
    /**
     * 
     * @param eirLocReqType
     * @return
     */
    Map getEirLocationDetails(EirLocDetailsRequestType eirLocReqType);
    
    /**
     * 
     * @param exceptionDataReqType
     * @return
     */
    Map postExceptionData(ExceptionDataRequestType exceptionDataReqType);
}
