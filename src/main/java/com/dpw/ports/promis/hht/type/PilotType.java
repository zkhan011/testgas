package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class PilotType implements java.io.Serializable {
    protected java.lang.String userId;
    protected java.lang.String userPassword;
    protected java.lang.String userDesc;

    public PilotType() {
    }

    public java.lang.String getUserId() {
        return userId;
    }

    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    public java.lang.String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(java.lang.String userPassword) {
        this.userPassword = userPassword;
    }

    public java.lang.String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(java.lang.String userDesc) {
        this.userDesc = userDesc;
    }
}
