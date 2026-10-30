package com.dpw.gasws.type;


public class ContainerDetailsType implements java.io.Serializable { 
   protected String containerNo;
   protected String terminalId;
   protected String plateNo;
   protected String plateEmirate;
   protected String tokenNo;
   protected String rfIdNo;
             
    public ContainerDetailsType() {
    }  

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateEmirate(String plateEmirate) {
        this.plateEmirate = plateEmirate;
    }

    public String getPlateEmirate() {
        return plateEmirate;
    }

    public void setTokenNo(String tokenNo) {
        this.tokenNo = tokenNo;
    }

    public String getTokenNo() {
        return tokenNo;
    }

    public void setRfIdNo(String rfIdNo) {
        this.rfIdNo = rfIdNo;
    }

    public String getRfIdNo() {
        return rfIdNo;
    }
}
