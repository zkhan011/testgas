package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class ComTruckNoRespType implements java.io.Serializable {
    protected com.dpw.ports.promis.hht.type.DummyTokenContrType[] dummyTokenContrList;
    protected java.lang.String status;

    public ComTruckNoRespType() {
    }

    public com.dpw.ports.promis.hht.type.DummyTokenContrType[] getDummyTokenContrList() {
        return dummyTokenContrList;
    }

    public void setDummyTokenContrList(com.dpw.ports.promis.hht.type.DummyTokenContrType[] dummyTokenContrList) {
        this.dummyTokenContrList = dummyTokenContrList;
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }
}
