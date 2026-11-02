package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class ComTruckNoReqType implements java.io.Serializable {
    protected java.lang.String truckNo;

    public ComTruckNoReqType() {
    }

    public java.lang.String getTruckNo() {
        return truckNo;
    }

    public void setTruckNo(java.lang.String truckNo) {
        this.truckNo = truckNo;
    }
}
