package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class UpdateVGMReqType implements java.io.Serializable {
    protected java.lang.String containerno;
    protected java.lang.Float liftedWt;
    protected java.lang.String craneId;
    protected java.lang.String userName;

    public UpdateVGMReqType() {
    }

    public java.lang.String getContainerno() {
        return containerno;
    }

    public void setContainerno(java.lang.String containerno) {
        this.containerno = containerno;
    }

    public java.lang.Float getLiftedWt() {
        return liftedWt;
    }

    public void setLiftedWt(java.lang.Float liftedWt) {
        this.liftedWt = liftedWt;
    }

    public java.lang.String getCraneId() {
        return craneId;
    }

    public void setCraneId(java.lang.String craneId) {
        this.craneId = craneId;
    }

    public java.lang.String getUserName() {
        return userName;
    }

    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }
}
