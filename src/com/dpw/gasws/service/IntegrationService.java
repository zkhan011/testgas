package com.dpw.gasws.service;

import com.dpw.gasws.type.ContainerDetailsRequestType;
import com.dpw.gasws.type.ContainerDetailsResponseType;
import com.dpw.gasws.type.EirLocDetailsRequestType;
import com.dpw.gasws.type.EirLocDetailsResponseType;
import com.dpw.gasws.type.ExceptionDataRequestType;
import com.dpw.gasws.type.ExceptionDataResponseType;
import com.dpw.gasws.type.GetTokenRequestType;
import com.dpw.gasws.type.GetTokenResponseType;


public interface IntegrationService {

    /**
     * 
     * @param tokenReqType
     * @return
     */
    GetTokenResponseType getTokenDetails(GetTokenRequestType tokenReqType);  
    
    /**
     * 
     * @param contrDtlsReqType
     * @return
     */
    ContainerDetailsResponseType getContainerDetails(ContainerDetailsRequestType contrDtlsReqType);
    
    /**
     * 
     * @param eirLocReqType
     * @return
     */
    EirLocDetailsResponseType getEirLocationDetails(EirLocDetailsRequestType eirLocReqType);
    
    /**
     * 
     * @param exceptionDataReqType
     * @return
     */
    ExceptionDataResponseType postExceptionData(ExceptionDataRequestType exceptionDataReqType);
   
}
