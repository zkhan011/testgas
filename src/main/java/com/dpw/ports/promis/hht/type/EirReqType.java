package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class EirReqType implements java.io.Serializable {
    protected java.lang.String contrno;
    protected java.lang.String regplace;
    protected java.lang.String vehicleno;
    protected java.lang.String platecode;
    protected java.lang.String param1;
    protected java.lang.String param2;
    protected java.lang.String param3;

    public EirReqType() {
    }

    public java.lang.String getContrno() {
        return contrno;
    }

    public void setContrno(java.lang.String contrno) {
        this.contrno = contrno;
    }

    public java.lang.String getRegplace() {
        return regplace;
    }

    public void setRegplace(java.lang.String regplace) {
        this.regplace = regplace;
    }

    public java.lang.String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(java.lang.String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public java.lang.String getPlatecode() {
        return platecode;
    }

    public void setPlatecode(java.lang.String platecode) {
        this.platecode = platecode;
    }

    public java.lang.String getParam1() {
        return param1;
    }

    public void setParam1(java.lang.String param1) {
        this.param1 = param1;
    }

    public java.lang.String getParam2() {
        return param2;
    }

    public void setParam2(java.lang.String param2) {
        this.param2 = param2;
    }

    public java.lang.String getParam3() {
        return param3;
    }

    public void setParam3(java.lang.String param3) {
        this.param3 = param3;
    }
}
