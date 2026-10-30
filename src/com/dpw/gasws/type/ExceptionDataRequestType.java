package com.dpw.gasws.type;


public class ExceptionDataRequestType implements java.io.Serializable {
   
    protected String errorDate;  //Date format is DD-MMM-YYYY hh:mi:ss
    protected String truckNo;  
    protected String regPlace;  
    protected String containerNo;   
    protected String tokenNo;
    protected String laneId; 
    protected String errorCode; 
    protected String errorDesc; 
     
    protected LoginInfoRequestType userCredentials;
            
    
    public ExceptionDataRequestType() {
    }
    
    public void setUserCredentials(LoginInfoRequestType userCredentials) {
        this.userCredentials = userCredentials;
    }

    public LoginInfoRequestType getUserCredentials() {
        return userCredentials;
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
    
    public String toString(){
        StringBuffer sb = new StringBuffer("");
        sb.append("\n----ExceptionDataRequestType----\n");
        sb.append("ERROR DATE:")
        .append(this.errorDate)
        .append(" ## ")
        .append("REG PLACE:")
        .append(this.regPlace)            
        .append(" ## ")
        .append("TRUCK NO:")
        .append(this.truckNo)            
        .append(" ## ")
        .append("CONTR NO:")
        .append(this.containerNo)   
        .append(" ## ")
        .append("TOKEN NO:")
        .append(this.tokenNo) 
        .append(" ## ")
        .append("LANE ID:")
        .append(this.laneId) 
        .append(" ## ")
        .append("ERROR CODE:")
        .append(this.errorCode) 
        .append(" ## ")
        .append("ERROR DESC:")
        .append(this.errorDesc) 
        .append(" ##\n");          
        return sb.toString();
    }

    public void setErrorDate(String errorDate) {
        this.errorDate = errorDate;
    }

    public String getErrorDate() {
        return errorDate;
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setTokenNo(String tokenNo) {
        this.tokenNo = tokenNo;
    }

    public String getTokenNo() {
        return tokenNo;
    }

    public void setLaneId(String laneId) {
        this.laneId = laneId;
    }

    public String getLaneId() {
        return laneId;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getErrorDesc() {
        return errorDesc;
    }
}
