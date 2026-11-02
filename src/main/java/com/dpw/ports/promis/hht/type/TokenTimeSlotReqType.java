package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class TokenTimeSlotReqType implements java.io.Serializable {
    protected java.lang.String regplate;
    protected java.lang.String vehicleno;

    public TokenTimeSlotReqType() {
    }

    public java.lang.String getRegplate() {
        return regplate;
    }

    public void setRegplate(java.lang.String regplate) {
        this.regplate = regplate;
    }

    public java.lang.String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(java.lang.String vehicleno) {
        this.vehicleno = vehicleno;
    }
}
