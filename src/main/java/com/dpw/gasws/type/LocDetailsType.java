package com.dpw.gasws.type;


public class LocDetailsType implements java.io.Serializable {
    protected String terminalId;
    protected String plateNo;
    protected String plateEmirate;
    protected String tokenNo;
    protected String containerNo;
    protected String load;
    protected String handling;
    protected String location;   
    protected String seal;   
    protected String remarks;
    protected String remarks2;
    protected String remarks3;
   
           
    public LocDetailsType() {
    }

    public void setTokenNo(String tokenNo) {
        this.tokenNo = tokenNo;
    }

    public String getTokenNo() {
        return tokenNo;
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

    public void setLoad(String load) {
        this.load = load;
    }

    public String getLoad() {
        return load;
    }

    public void setHandling(String handling) {
        this.handling = handling;
    }

    public String getHandling() {
        return handling;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setSeal(String seal) {
        this.seal = seal;
    }

    public String getSeal() {
        return seal;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks2(String remarks2) {
        this.remarks2 = remarks2;
    }

    public String getRemarks2() {
        return remarks2;
    }

    public void setRemarks3(String remarks3) {
        this.remarks3 = remarks3;
    }

    public String getRemarks3() {
        return remarks3;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer("");                    
        sb.append("##LOC:")
        .append(this.location)            
        .append(" ## ")
        .append("TERMINAL ID:")
        .append(this.terminalId)
        .append(" ## ")
        .append("PLATE NO:")
        .append(this.plateNo)
        .append(" ## ")
        .append("EMIRATE:")
        .append(this.plateEmirate)
        .append(" ## ")
        .append("TOKEN NO:")
        .append(this.tokenNo)
        .append(" ## ")
        .append("CONTR NO:")
        .append(this.containerNo)
        .append(" ## ")
        .append("LOAD:")
        .append(this.load)
        .append(" ## ")
        .append("HANDLING:")
        .append(this.handling)        
        .append(" ## ")
        .append("SEAL:")
        .append(this.seal)       
        .append(" ## ")
        .append("REMARKS:")
        .append(this.remarks)
        .append(" ## ")
        .append("REMARKS2:")
        .append(this.remarks2)
        .append(" ## ")
        .append("REMARKS3:")
        .append(this.remarks3)
        .append(" ##\n");          
        return sb.toString();
    }
}
