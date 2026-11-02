package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class TruckEIRType implements java.io.Serializable {
    protected java.lang.String contrno;
    protected java.lang.String eirDate;
    protected java.lang.String moverecdate;
    protected java.lang.String actmovedate;
    protected java.lang.String eirNo;
    protected java.lang.Integer tokenno;
    protected java.lang.String desig;
    protected java.lang.String lineCode;
    protected java.lang.String vehicleno;
    protected java.lang.String regplace;
    protected java.lang.String terminalId;
    protected java.lang.String mobNo;

    public TruckEIRType() {
    }

    public java.lang.String getContrno() {
        return contrno;
    }

    public void setContrno(java.lang.String contrno) {
        this.contrno = contrno;
    }

    public java.lang.String getEirDate() {
        return eirDate;
    }

    public void setEirDate(java.lang.String eirDate) {
        this.eirDate = eirDate;
    }

    public java.lang.String getMoverecdate() {
        return moverecdate;
    }

    public void setMoverecdate(java.lang.String moverecdate) {
        this.moverecdate = moverecdate;
    }

    public java.lang.String getActmovedate() {
        return actmovedate;
    }

    public void setActmovedate(java.lang.String actmovedate) {
        this.actmovedate = actmovedate;
    }

    public java.lang.String getEirNo() {
        return eirNo;
    }

    public void setEirNo(java.lang.String eirNo) {
        this.eirNo = eirNo;
    }

    public java.lang.Integer getTokenno() {
        return tokenno;
    }

    public void setTokenno(java.lang.Integer tokenno) {
        this.tokenno = tokenno;
    }

    public java.lang.String getDesig() {
        return desig;
    }

    public void setDesig(java.lang.String desig) {
        this.desig = desig;
    }

    public java.lang.String getLineCode() {
        return lineCode;
    }

    public void setLineCode(java.lang.String lineCode) {
        this.lineCode = lineCode;
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

    public java.lang.String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(java.lang.String terminalId) {
        this.terminalId = terminalId;
    }

    public java.lang.String getMobNo() {
        return mobNo;
    }

    public void setMobNo(java.lang.String mobNo) {
        this.mobNo = mobNo;
    }
}
