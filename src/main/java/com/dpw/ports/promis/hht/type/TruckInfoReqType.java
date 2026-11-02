package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class TruckInfoReqType implements java.io.Serializable {
    protected java.lang.String containerNumber;

    public TruckInfoReqType() {
    }

    public java.lang.String getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(java.lang.String containerNumber) {
        this.containerNumber = containerNumber;
    }
}
