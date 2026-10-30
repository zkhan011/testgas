package com.dpw.gasws.service;

import com.dpw.gasws.service.IntegrationService;
import com.dpw.gasws.type.ContainerDetailsRequestType;
import com.dpw.gasws.type.ContainerDetailsResponseType;
import com.dpw.gasws.type.EirLocDetailsRequestType;
import com.dpw.gasws.type.EirLocDetailsResponseType;
import com.dpw.gasws.type.ExceptionDataRequestType;
import com.dpw.gasws.type.ExceptionDataResponseType;
import com.dpw.gasws.type.GetTokenRequestType;
import com.dpw.gasws.type.GetTokenResponseType;
import com.dpw.gasws.web.SpringBeanLocator;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(name = "GateAutomationService", serviceName = "GateAutomationService")
public class GateAutomationServiceImpl  {

    public IntegrationService getIntegrationService() {
        return (IntegrationService)SpringBeanLocator.getBean("integrationService");
    }  
    
    /**
     * 
     * @param tokenReqType
     * @return
     */
    @WebMethod
    public GetTokenResponseType getTokenDetails(GetTokenRequestType tokenReqType) {
         return getIntegrationService().getTokenDetails(tokenReqType);
    } 
    
    /**
     * 
     * @param contrDtlsReqType
     * @return
     */
    @WebMethod
    public ContainerDetailsResponseType getContainerDetails(ContainerDetailsRequestType contrDtlsReqType) {
         return getIntegrationService().getContainerDetails(contrDtlsReqType);
    }  

    /**
     * 
     * @param eirLocReqType
     * @return
     */
    @WebMethod
    public EirLocDetailsResponseType getEirLocationDetails(EirLocDetailsRequestType eirLocReqType) {
         return getIntegrationService().getEirLocationDetails(eirLocReqType);
    }  
    
    /**
     * 
     * @param exceptionDataReqType
     * @return
     */
    @WebMethod
    public ExceptionDataResponseType postExceptionData(ExceptionDataRequestType exceptionDataReqType) {
         return getIntegrationService().postExceptionData(exceptionDataReqType);
    }      
   
}
