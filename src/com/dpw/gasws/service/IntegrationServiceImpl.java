package com.dpw.gasws.service;


import com.dpw.gasws.dao.IntegrationDAO;
import com.dpw.gasws.type.ContainerDetailsRequestType;
import com.dpw.gasws.type.ContainerDetailsResponseType;
import com.dpw.gasws.type.ContainerDetailsType;
import com.dpw.gasws.type.EirDetailsType;
import com.dpw.gasws.type.EirLocDetailsRequestType;
import com.dpw.gasws.type.EirLocDetailsResponseType;
import com.dpw.gasws.type.ExceptionDataRequestType;
import com.dpw.gasws.type.ExceptionDataResponseType;
import com.dpw.gasws.type.ExceptionType;
import com.dpw.gasws.type.GetTokenRequestType;
import com.dpw.gasws.type.GetTokenResponseType;
import com.dpw.gasws.type.LocDetailsType;
import com.dpw.gasws.type.LoginInfoRequestType;
import com.dpw.gasws.type.ServiceExceptionType;
import com.dpw.gasws.type.TokenDetailsType;
import com.dpw.gasws.util.GaswsIntegrationConstants;
import com.dpw.gen.util.EncryptDecryptUtil;
import com.pcfc.ports.promis.common.Utilities;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class IntegrationServiceImpl implements IntegrationService {
  
   Log log = LogFactory.getLog(IntegrationServiceImpl.class);
      
    private IntegrationDAO integrationDAO;  
     
    public IntegrationServiceImpl() {
    }


    public void setIntegrationDAO(IntegrationDAO integrationDAO) {
        this.integrationDAO = integrationDAO;
    }

    public IntegrationDAO getIntegrationDAO() {
        return integrationDAO;
    }
    
    /**
     * 
     * @param tokenReqType
     * @return
     */
    public GetTokenResponseType getTokenDetails(GetTokenRequestType tokenReqType) {
        log.info("Begin IntegrationServiceImpl.getTokenDetails at :" + new Date()+"##"+tokenReqType.toString());
        
        GetTokenResponseType resp = new GetTokenResponseType();        
        ServiceExceptionType serviceException = null;
        try {     
            boolean validLogin = 
                checkIfUserValid(tokenReqType.getUserCredentials());
            if (!validLogin) {                 
                serviceException = new ServiceExceptionType();
                serviceException.setBusinessException(getExceptionType("Invalid  User Credential", 1));
                resp.setException(serviceException);
                return resp;
            }              
                 
             Map resultMap = integrationDAO.getTokenDetails(tokenReqType);
             resp.setErrorMessage((String) resultMap.get("PO_ERROR"));
             
             List<TokenDetailsType> tokenDetails = (List) resultMap.get("PO_TOKEN_DTL");             
             if(!Utilities.isListNullOrEmpty(tokenDetails)) {
                 resp.setTokenDetails(tokenDetails.toArray(new TokenDetailsType[]{}));
             } else {
                 serviceException = new ServiceExceptionType();
                 serviceException.setBusinessException(getExceptionType("Token Details Not Found", 2));
                 resp.setException(serviceException);                 
             }
             
        } catch(Exception e) {
            log.info("Error occured in getTokenDetails method:::"+e.getMessage());            
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(getExceptionType(e.getMessage(),3));
            resp.setException(serviceException);  
        }
        log.info("End IntegrationServiceImpl.getTokenDetails at :" + new Date()+"##"+resp.toString());       
        return resp;
    }     
    
    /**
     * 
     * @param contrDtlsReqType
     * @return
     */
    public ContainerDetailsResponseType getContainerDetails(ContainerDetailsRequestType contrDtlsReqType) {
        log.info("Begin IntegrationServiceImpl.getContainerDetails at :" + new Date()+"##"+contrDtlsReqType.getTerminalId());
        
        ContainerDetailsResponseType resp = new ContainerDetailsResponseType();        
        ServiceExceptionType serviceException = null;
        try {     
            boolean validLogin = 
                checkIfUserValid(contrDtlsReqType.getUserCredentials());
            if (!validLogin) {                 
                serviceException = new ServiceExceptionType();
                serviceException.setBusinessException(getExceptionType("Invalid  User Credential", 1));
                resp.setException(serviceException);
                return resp;
            }  
            
            if(Utilities.isNullOrEmpty(contrDtlsReqType.getTerminalId())) {              
                serviceException = new ServiceExceptionType();
                serviceException.setBusinessException(getExceptionType("One or more mandatory input parameters are missing", 1));
                resp.setException(serviceException);
                return resp; 
            }
                       
             Map resultMap = integrationDAO.getContainerDetails(contrDtlsReqType);
             resp.setErrorMessage((String) resultMap.get("PO_ERROR"));
             
             List<ContainerDetailsType> contrDetails = (List) resultMap.get("PO_CONTAINER_DTL");             
             if(!Utilities.isListNullOrEmpty(contrDetails)) {
                 resp.setContrDetails(contrDetails.toArray(new ContainerDetailsType[]{}));
                 log.info("Result length:"+resp.getContrDetails().length);
             } else {
                 serviceException = new ServiceExceptionType();
                 serviceException.setBusinessException(getExceptionType("Container Details Not Found", 2));
                 resp.setException(serviceException);                  
             }
             
        } catch(Exception e) {
            log.info("Error occured in getContainerDetails method:::"+e.getMessage());            
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(getExceptionType(e.getMessage(),3));
            resp.setException(serviceException);  
        }
        log.info("End IntegrationServiceImpl.getContianerDetails at :" + new Date()+"##"+resp.getErrorMessage());       
        return resp;
    } 
    
    /**
     * 
     * @param eirLocReqType
     * @return
     */
    public EirLocDetailsResponseType getEirLocationDetails(EirLocDetailsRequestType eirLocReqType) {
        log.info("Begin IntegrationServiceImpl.getEirLocationDetails at :" + new Date()+"##"+eirLocReqType.toString());
        
        EirLocDetailsResponseType resp = new EirLocDetailsResponseType();        
        ServiceExceptionType serviceException = null;
        try {     
            boolean validLogin = 
                checkIfUserValid(eirLocReqType.getUserCredentials());
            if (!validLogin) {                 
                serviceException = new ServiceExceptionType();
                serviceException.setBusinessException(getExceptionType("Invalid  User Credential", 1));
                resp.setException(serviceException);
                return resp;
            }   
            
             Map resultMap = integrationDAO.getEirLocationDetails(eirLocReqType);
             resp.setErrorMessage((String) resultMap.get("PO_ERROR"));
             
             List<EirDetailsType> eirDetails = (List) resultMap.get("PO_EIR_DTL");             
             if(!Utilities.isListNullOrEmpty(eirDetails)) {
                 resp.setEirDetails(eirDetails.toArray(new EirDetailsType[]{}));
             }
             
            List<LocDetailsType> locDetails = (List) resultMap.get("PO_LOC_DTL");             
            if(!Utilities.isListNullOrEmpty(locDetails)) {
                resp.setLocDetails(locDetails.toArray(new LocDetailsType[]{}));
            }
             
        } catch(Exception e) {
            log.info("Error occured in getEirLocationDetails method:::"+e.getMessage());            
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(getExceptionType(e.getMessage(),3));
            resp.setException(serviceException);  
        }
        log.info("End IntegrationServiceImpl.getEirLocationDetails at :" + new Date()+"##"+resp.toString());       
        return resp;
    }    
    
    
    /**
     * 
     * @param exceptionDataReqType
     * @return
     */
     public ExceptionDataResponseType postExceptionData(ExceptionDataRequestType exceptionDataReqType) {
        log.info("Begin IntegrationServiceImpl.postExceptionData at :" + new Date()+"##"+exceptionDataReqType.toString());
        
        ExceptionDataResponseType resp = new ExceptionDataResponseType();        
        ServiceExceptionType serviceException = null;
        try {     
            boolean validLogin = 
                checkIfUserValid(exceptionDataReqType.getUserCredentials());
            if (!validLogin) {                 
                serviceException = new ServiceExceptionType();
                serviceException.setBusinessException(getExceptionType("Invalid  User Credential", 1));
                resp.setException(serviceException);
                return resp;
            }   
            
             Map resultMap = integrationDAO.postExceptionData(exceptionDataReqType);
             resp.setErrorMessage((String) resultMap.get("PO_ERROR"));                         
             
        } catch(Exception e) {
            log.info("Error occured in postExceptionData method:::"+e.getMessage());            
            serviceException = new ServiceExceptionType();
            serviceException.setTechnicalException(getExceptionType(e.getMessage(),3));
            resp.setException(serviceException);  
        }
        log.info("End IntegrationServiceImpl.postExceptionData at :" + new Date()+"## "+resp.toString());       
        return resp;
    }     
        
       
    /**
     * 
     * @param cause
     * @param code
     * @return
     */
    private ExceptionType getExceptionType(String cause, long code) {
        ExceptionType exceptionType = new ExceptionType();
        exceptionType.setMessage(cause);
        exceptionType.setId(Long.toString(code));
        return exceptionType;
    }
    
    /**
     * 
     * @param userInfo
     * @return
     */
    private boolean checkIfUserValid(LoginInfoRequestType userInfo) {
        String decrypteduser = null;
        if(!Utilities.isNullOrEmpty(userInfo.getPassword()) && !Utilities.isNullOrEmpty(userInfo.getUsername())) {
           try {
             decrypteduser = EncryptDecryptUtil.decrypt(userInfo.getPassword(),GaswsIntegrationConstants.ENCRYPT_KEY);
           }catch (Exception e) {
               log.error("Decrypt failed"+e.getMessage());
           }
           if(userInfo.getUsername().equalsIgnoreCase(decrypteduser)) 
              return true;
        }
        log.info("In valid user credentials:"+userInfo.getUsername()+"##"+userInfo.getPassword());
        return false;
    }
}


