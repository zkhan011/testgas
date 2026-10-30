package com.dpw.gasws.type;


public class ContainerDetailsRequestType implements java.io.Serializable {
      
    protected String terminalId;    
    
    protected LoginInfoRequestType userCredentials;
            
    
    public ContainerDetailsRequestType() {
    }
    
    public void setUserCredentials(LoginInfoRequestType userCredentials) {
        this.userCredentials = userCredentials;
    }

    public LoginInfoRequestType getUserCredentials() {
        return userCredentials;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalId() {
        return terminalId;
    }
}
