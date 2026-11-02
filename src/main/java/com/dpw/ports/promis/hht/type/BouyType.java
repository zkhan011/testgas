package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class BouyType implements java.io.Serializable {
    protected java.lang.String bouyPortCode;
    protected java.lang.String bouyId;
    protected java.lang.String bouyName;

    public BouyType() {
    }

    public java.lang.String getBouyPortCode() {
        return bouyPortCode;
    }

    public void setBouyPortCode(java.lang.String bouyPortCode) {
        this.bouyPortCode = bouyPortCode;
    }

    public java.lang.String getBouyId() {
        return bouyId;
    }

    public void setBouyId(java.lang.String bouyId) {
        this.bouyId = bouyId;
    }

    public java.lang.String getBouyName() {
        return bouyName;
    }

    public void setBouyName(java.lang.String bouyName) {
        this.bouyName = bouyName;
    }
}
