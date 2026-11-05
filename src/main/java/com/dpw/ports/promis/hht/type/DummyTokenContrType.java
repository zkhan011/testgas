package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class DummyTokenContrType implements java.io.Serializable {
    protected java.lang.String vehicleNo;
    protected java.math.BigInteger tokenNo;
    protected java.lang.String contrNo;
    protected java.lang.String yardLoc;
    protected java.lang.String desig;
    protected java.lang.String terminalId;
    protected java.lang.String mtype;
    protected java.lang.String isoCode;
    protected java.lang.Float weight;
    protected java.lang.String destTerminal;
    protected java.lang.String haulType;

    public DummyTokenContrType() {
    }

    public java.lang.String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(java.lang.String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public java.math.BigInteger getTokenNo() {
        return tokenNo;
    }

    public void setTokenNo(java.math.BigInteger tokenNo) {
        this.tokenNo = tokenNo;
    }

    public java.lang.String getContrNo() {
        return contrNo;
    }

    public void setContrNo(java.lang.String contrNo) {
        this.contrNo = contrNo;
    }

    public java.lang.String getYardLoc() {
        return yardLoc;
    }

    public void setYardLoc(java.lang.String yardLoc) {
        this.yardLoc = yardLoc;
    }

    public java.lang.String getDesig() {
        return desig;
    }

    public void setDesig(java.lang.String desig) {
        this.desig = desig;
    }

    public java.lang.String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(java.lang.String terminalId) {
        this.terminalId = terminalId;
    }

    public java.lang.String getMtype() {
        return mtype;
    }

    public void setMtype(java.lang.String mtype) {
        this.mtype = mtype;
    }

    public java.lang.String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(java.lang.String isoCode) {
        this.isoCode = isoCode;
    }

    public java.lang.Float getWeight() {
        return weight;
    }

    public void setWeight(java.lang.Float weight) {
        this.weight = weight;
    }

    public java.lang.String getDestTerminal() {
        return destTerminal;
    }

    public void setDestTerminal(java.lang.String destTerminal) {
        this.destTerminal = destTerminal;
    }

    public java.lang.String getHaulType() {
        return haulType;
    }

    public void setHaulType(java.lang.String haulType) {
        this.haulType = haulType;
    }
}
