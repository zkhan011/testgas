package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class VGMWtReqType implements java.io.Serializable {
    protected java.lang.String regplate;
    protected java.lang.String platecode;
    protected java.lang.String vehicleno;
    protected java.lang.String containerno;
    protected java.lang.String terminalid;

    public VGMWtReqType() {
    }

    public java.lang.String getRegplate() {
        return regplate;
    }

    public void setRegplate(java.lang.String regplate) {
        this.regplate = regplate;
    }

    public java.lang.String getPlatecode() {
        return platecode;
    }

    public void setPlatecode(java.lang.String platecode) {
        this.platecode = platecode;
    }

    public java.lang.String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(java.lang.String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public java.lang.String getContainerno() {
        return containerno;
    }

    public void setContainerno(java.lang.String containerno) {
        this.containerno = containerno;
    }

    public java.lang.String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(java.lang.String terminalid) {
        this.terminalid = terminalid;
    }
}
