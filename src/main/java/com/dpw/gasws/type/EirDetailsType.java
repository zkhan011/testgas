package com.dpw.gasws.type;


public class EirDetailsType implements java.io.Serializable {
    protected String terminalId;
    protected String plateNo;
    protected String plateEmirate;
    protected String tokenNo;
    protected String containerNo;
    protected String load;
    protected String handling;
    protected String consignee;
    protected String dpaSeal;    
    protected String seal;
    protected String agentSeal;
    protected String customsSeal;
    protected String eirNo;
    protected String eirDate;
    protected String remarks;
    protected String remarks2;
    protected String remarks3;
    protected String location;
    protected String movType;
    protected String printEir;
  
    public EirDetailsType() {
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

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setDpaSeal(String dpaSeal) {
        this.dpaSeal = dpaSeal;
    }

    public String getDpaSeal() {
        return dpaSeal;
    }

    public void setSeal(String seal) {
        this.seal = seal;
    }

    public String getSeal() {
        return seal;
    }

    public void setAgentSeal(String agentSeal) {
        this.agentSeal = agentSeal;
    }

    public String getAgentSeal() {
        return agentSeal;
    }

    public void setCustomsSeal(String customsSeal) {
        this.customsSeal = customsSeal;
    }

    public String getCustomsSeal() {
        return customsSeal;
    }

    public void setEirNo(String eirNo) {
        this.eirNo = eirNo;
    }

    public String getEirNo() {
        return eirNo;
    }

    public void setEirDate(String eirDate) {
        this.eirDate = eirDate;
    }

    public String getEirDate() {
        return eirDate;
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

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer("");       
        sb.append("##EIR NO:")
        .append(this.eirNo)
        .append(" ## ")
        .append("EIR DATE:")
        .append(this.eirDate)            
        .append(" ## ")
        .append("LOC:")
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
        .append("CONSIGNEE:")
        .append(this.consignee)
        .append(" ## ")
        .append("DPA SEAL:")
        .append(this.dpaSeal)
        .append(" ## ")
        .append("SEAL:")
        .append(this.seal)
        .append(" ## ")
        .append("AGENT SEAL:")
        .append(this.agentSeal)
        .append(" ## ")
        .append("CUSTOMS SEAL:")
        .append(this.customsSeal)
        .append(" ## ")
        .append("REMARKS:")
        .append(this.remarks)
        .append(" ## ")
        .append("REMARKS2:")
        .append(this.remarks2)
        .append(" ## ")
        .append("REMARKS3:")
        .append(this.remarks3)
        .append(" ## ")
        .append("MOVE TYPE:")
        .append(this.movType)
        .append(" ## ")
        .append("PRINT EIR:")
        .append(this.printEir)
        .append(" ##\n");          
        return sb.toString();
    }

    public void setMovType(String movType) {
        this.movType = movType;
    }

    public String getMovType() {
        return movType;
    }

    public void setPrintEir(String printEir) {
        this.printEir = printEir;
    }

    public String getPrintEir() {
        return printEir;
    }
}
