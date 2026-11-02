package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class VerifyUserRespType implements java.io.Serializable {
    protected java.lang.Integer vaild;
    protected java.lang.String status;

    public VerifyUserRespType() {
    }

    public java.lang.Integer getVaild() {
        return vaild;
    }

    public void setVaild(java.lang.Integer vaild) {
        this.vaild = vaild;
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }
}
