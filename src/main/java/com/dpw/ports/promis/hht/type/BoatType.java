package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class BoatType implements java.io.Serializable {
    protected java.lang.String boatId;
    protected java.lang.String boatType;
    protected java.lang.String boatName;

    public BoatType() {
    }

    public java.lang.String getBoatId() {
        return boatId;
    }

    public void setBoatId(java.lang.String boatId) {
        this.boatId = boatId;
    }

    public java.lang.String getBoatType() {
        return boatType;
    }

    public void setBoatType(java.lang.String boatType) {
        this.boatType = boatType;
    }

    public java.lang.String getBoatName() {
        return boatName;
    }

    public void setBoatName(java.lang.String boatName) {
        this.boatName = boatName;
    }
}
