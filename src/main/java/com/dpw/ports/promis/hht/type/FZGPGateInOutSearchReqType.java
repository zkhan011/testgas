package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class FZGPGateInOutSearchReqType implements java.io.Serializable {
    protected java.lang.String vehicleno;
    protected java.lang.String regplace;
    protected java.lang.String platecode;
    protected java.lang.String gatepassno;
    protected java.lang.String inOut;

    public FZGPGateInOutSearchReqType() {
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

    public java.lang.String getPlatecode() {
        return platecode;
    }

    public void setPlatecode(java.lang.String platecode) {
        this.platecode = platecode;
    }

    public java.lang.String getGatepassno() {
        return gatepassno;
    }

    public void setGatepassno(java.lang.String gatepassno) {
        this.gatepassno = gatepassno;
    }

    public java.lang.String getInOut() {
        return inOut;
    }

    public void setInOut(java.lang.String inOut) {
        this.inOut = inOut;
    }
}
