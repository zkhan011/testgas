package com.dpw.gasws.type;


public class GetTokenRequestType implements java.io.Serializable {
   
    protected String rfIdNo;  
    protected String truckNo;  
    protected String regPlace;  
    protected String terminalId;    
    
    protected LoginInfoRequestType userCredentials;
            
    
    public GetTokenRequestType() {
    }
    
    public void setUserCredentials(LoginInfoRequestType userCredentials) {
        this.userCredentials = userCredentials;
    }

    public LoginInfoRequestType getUserCredentials() {
        return userCredentials;
    }


    public void setRfIdNo(String rfIdNo) {
        this.rfIdNo = rfIdNo;
    }

    public String getRfIdNo() {
        return rfIdNo;
    }

    public void setTruckNo(String truckNo) {
        this.truckNo = truckNo;
    }

    public String getTruckNo() {
        return truckNo;
    }

    public void setRegPlace(String regPlace) {
        this.regPlace = regPlace;
    }

    public String getRegPlace() {
        return regPlace;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalId() {
        return terminalId;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer("");
        sb.append("\n----GetTokenRequestType----\n");
        sb.append("RFID:")
        .append(this.rfIdNo)
        .append(" ## ")
        .append("REG PLACE:")
        .append(this.regPlace)            
        .append(" ## ")
        .append("TRUCK NO:")
        .append(this.truckNo)            
        .append(" ## ")
        .append("TERMINAL ID:")
        .append(this.terminalId)       
        .append(" ##\n");          
        return sb.toString();
    }
}
