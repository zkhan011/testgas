package test.com.dpw.service;

import com.dpw.gasws.service.IntegrationService;
import com.dpw.gasws.type.ContainerDetailsRequestType;
import com.dpw.gasws.type.ContainerDetailsResponseType;
import com.dpw.gasws.type.ContrDetailsReqType;
import com.dpw.gasws.type.EirLocDetailsRequestType;
import com.dpw.gasws.type.EirLocDetailsResponseType;
import com.dpw.gasws.type.ExceptionDataRequestType;
import com.dpw.gasws.type.ExceptionDataResponseType;
import com.dpw.gasws.type.GetTokenRequestType;
import com.dpw.gasws.type.GetTokenResponseType;
import com.dpw.gasws.type.LoginInfoRequestType;

import com.dpw.gasws.type.TokenDetailsReqType;

import com.pcfc.ports.promis.common.Utilities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class IntegrationServiceTestCase {
    public IntegrationServiceTestCase() {
    }   
   
    
    public static void main(String[] args) {
        try {
            ApplicationContext beanFactory =  new ClassPathXmlApplicationContext(new String[]{"dao-applicationContext.xml","service-applicationContext.xml"});
            IntegrationService service = (IntegrationService)beanFactory.getBean("integrationService");
            
//            GetTokenRequestType obj = new GetTokenRequestType();      
//            obj.setTerminalId("T1");
//            obj.setTruckNo("246");
//            obj.setRegPlace("DXB");
//                           
//            LoginInfoRequestType crede = new LoginInfoRequestType();
//            crede.setUsername("CAMCOTST");
//            crede.setPassword("XNmrh1j+uKQ=");
//            
//            obj.setUserCredentials(crede);
//            GetTokenResponseType resp= service.getTokenDetails(obj);

//             ContainerDetailsRequestType obj = new ContainerDetailsRequestType();      
//             obj.setTerminalId("T3");
//             
//             LoginInfoRequestType crede = new LoginInfoRequestType();
//             crede.setUsername("CAMCOTST");
//             crede.setPassword("XNmrh1j+uKQ=");
//             
//             obj.setUserCredentials(crede);
//             ContainerDetailsResponseType resp= service.getContainerDetails(obj);
           
            
            EirLocDetailsRequestType obj = new EirLocDetailsRequestType();   
            obj.setPortCode("J");
            obj.setLaneId("2IB01");
            obj.setRegPlace("DXB");
            obj.setTruckNo("95284");
            
            ContrDetailsReqType r = new ContrDetailsReqType();
            r.setContainerNo("MSKUJ12345");
            r.setIsoCode("2200");
            r.setContrPosition("2");
            r.setDoorDirection("front");
            r.setChassisNo("1");
            r.setSealPresence("Y");
            obj.setContrDetails(new ContrDetailsReqType[]{r});
            
            TokenDetailsReqType e= new TokenDetailsReqType();           
            obj.setTokenDetails(new TokenDetailsReqType[]{e});
            
            LoginInfoRequestType crede = new LoginInfoRequestType();
            crede.setUsername("CAMCOTST");
            crede.setPassword("XNmrh1j+uKQ=");
            
            obj.setUserCredentials(crede);
            EirLocDetailsResponseType resp= service.getEirLocationDetails(obj);


//             ExceptionDataRequestType obj = new ExceptionDataRequestType();   
//             obj.setErrorDate("15-DEC-2015 15:30:22");
//             obj.setLaneId("2IB01");
//             obj.setRegPlace("DXB");
//             obj.setTruckNo("95284");
//            obj.setContainerNo("MSKUJ12345");
//            obj.setErrorCode("CAMC234");
//            obj.setErrorDesc("Test");
//                                     
//                        
//             LoginInfoRequestType crede = new LoginInfoRequestType();
//             crede.setUsername("CAMCOTST");
//             crede.setPassword("XNmrh1j+uKQ=");
//             
//             obj.setUserCredentials(crede);
//             ExceptionDataResponseType resp= service.postExceptionData(obj);
           
            System.out.println(resp.getErrorMessage());
            
        } catch(Exception e11){
            e11.printStackTrace();    
        }
        
    } 
    
}
