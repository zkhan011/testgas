package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class EirType implements java.io.Serializable {
    protected java.lang.Integer tokenno;
    protected java.lang.Integer eirno;
    protected java.lang.String eirdate;
    protected java.lang.String contrno;
    protected java.lang.String desig;
    protected java.lang.String terminalid;
    protected java.lang.String vehicleno;
    protected java.lang.String regplace;
    protected java.lang.String inspremark;
    protected java.lang.String freezone;
    protected java.lang.String sealno;
    protected java.lang.String custXrayHold;
    protected java.lang.String custXrayHoldRemarks;
    protected java.lang.Boolean inspFlag;
    protected java.lang.String dmInspRemarks;

    public EirType() {
    }

    public java.lang.Integer getTokenno() {
        return tokenno;
    }

    public void setTokenno(java.lang.Integer tokenno) {
        this.tokenno = tokenno;
    }

    public java.lang.Integer getEirno() {
        return eirno;
    }

    public void setEirno(java.lang.Integer eirno) {
        this.eirno = eirno;
    }

    public java.lang.String getEirdate() {
        return eirdate;
    }

    public void setEirdate(java.lang.String eirdate) {
        this.eirdate = eirdate;
    }

    public java.lang.String getContrno() {
        return contrno;
    }

    public void setContrno(java.lang.String contrno) {
        this.contrno = contrno;
    }

    public java.lang.String getDesig() {
        return desig;
    }

    public void setDesig(java.lang.String desig) {
        this.desig = desig;
    }

    public java.lang.String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(java.lang.String terminalid) {
        this.terminalid = terminalid;
    }

    public java.lang.String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(java.lang.String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public java.lang.String getRegplace() {
        return regplace;
    }

    public void setRegplace(java.lang.String regplace) {
        this.regplace = regplace;
    }

    public java.lang.String getInspremark() {
        return inspremark;
    }

    public void setInspremark(java.lang.String inspremark) {
        this.inspremark = inspremark;
    }

    public java.lang.String getFreezone() {
        return freezone;
    }

    public void setFreezone(java.lang.String freezone) {
        this.freezone = freezone;
    }

    public java.lang.String getSealno() {
        return sealno;
    }

    public void setSealno(java.lang.String sealno) {
        this.sealno = sealno;
    }

    public java.lang.String getCustXrayHold() {
        return custXrayHold;
    }

    public void setCustXrayHold(java.lang.String custXrayHold) {
        this.custXrayHold = custXrayHold;
    }

    public java.lang.String getCustXrayHoldRemarks() {
        return custXrayHoldRemarks;
    }

    public void setCustXrayHoldRemarks(java.lang.String custXrayHoldRemarks) {
        this.custXrayHoldRemarks = custXrayHoldRemarks;
    }

    public java.lang.Boolean getInspFlag() {
        return inspFlag;
    }

    public void setInspFlag(java.lang.Boolean inspFlag) {
        this.inspFlag = inspFlag;
    }

    public java.lang.String getDmInspRemarks() {
        return dmInspRemarks;
    }

    public void setDmInspRemarks(java.lang.String dmInspRemarks) {
        this.dmInspRemarks = dmInspRemarks;
    }
}
