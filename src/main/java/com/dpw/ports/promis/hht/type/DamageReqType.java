package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class DamageReqType implements java.io.Serializable {
    protected java.lang.String contrNo;
    protected java.lang.String tokenNo;

    public DamageReqType() {
    }

    public java.lang.String getContrNo() {
        return contrNo;
    }

    public void setContrNo(java.lang.String contrNo) {
        this.contrNo = contrNo;
    }

    public java.lang.String getTokenNo() {
        return tokenNo;
    }

    public void setTokenNo(java.lang.String tokenNo) {
        this.tokenNo = tokenNo;
    }
}
