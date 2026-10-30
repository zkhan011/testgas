package com.dpw.gasws.type;

import com.pcfc.ports.promis.common.Utilities;

public class EirLocDetailsRequestType implements java.io.Serializable {
    protected String portCode;
    protected String rfIdNo;  
    protected String truckNo;  
    protected String regPlace;  
    protected String chassisType;  
    protected TokenDetailsReqType[] tokenDetails;  
    protected ContrDetailsReqType[] contrDetails; 
    protected String laneId; 
    protected String visitId; 
    
    protected LoginInfoRequestType userCredentials;
            
    
    public EirLocDetailsRequestType() {
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

    public void setPortCode(String portCode) {
        this.portCode = portCode;
    }

    public String getPortCode() {
        if(Utilities.isNullOrEmpty(this.portCode))
            this.portCode = "J";
        return this.portCode;
    }
  
    public void setLaneId(String laneId) {
        this.laneId = laneId;
    }

    public String getLaneId() {
        return laneId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getVisitId() {
        return visitId;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer("");
        sb.append("\n----EirLocDetailsRequestType----\n");
        sb.append("PORT CODE:")
        .append(getPortCode())
        .append(" ## ")
        .append("RFID NO:")
        .append(this.rfIdNo)            
        .append(" ## ")
        .append("TRUCK NO:")
        .append(this.truckNo)            
        .append(" ## ")
        .append("REG PLACE:")
        .append(this.regPlace)   
        .append(" ## ")
        .append("LANE ID:")
        .append(this.laneId)
        .append(" ## ")
        .append("VISIT ID:")
        .append(this.visitId)        
        .append(" ## ")
        .append("CHASSIS TYPE:")        
        .append(this.chassisType)        
        .append(" ## ");
        if(tokenDetails != null && tokenDetails.length > 0) {
            sb.append("TOKEN DETAILS:");
            for(TokenDetailsReqType obj:tokenDetails){
              sb.append(obj.toString()).append("#####");
            }
        }
        if(contrDetails != null && contrDetails.length > 0) {
            sb.append("CONTR DETAILS:");
            for(ContrDetailsReqType obj:contrDetails){
              sb.append(obj.toString()).append("#####");
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    public void setTokenDetails(TokenDetailsReqType[] tokenDetails) {
        this.tokenDetails = tokenDetails;
    }

    public TokenDetailsReqType[] getTokenDetails() {
        return tokenDetails;
    }

    public void setContrDetails(ContrDetailsReqType[] contrDetails) {
        this.contrDetails = contrDetails;
    }

    public ContrDetailsReqType[] getContrDetails() {
        if(contrDetails != null)
            return contrDetails;
         else
            return new ContrDetailsReqType[]{}; 
    }

    public void setChassisType(String chassisType) {
        this.chassisType = chassisType;
    }

    public String getChassisType() {
        return chassisType;
    }
}
