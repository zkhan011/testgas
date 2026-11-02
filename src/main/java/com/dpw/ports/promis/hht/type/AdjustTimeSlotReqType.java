package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class AdjustTimeSlotReqType implements java.io.Serializable {
    protected java.lang.String containerNo;
    protected java.lang.Integer tokenNo;
    protected java.lang.String userCode;

    public AdjustTimeSlotReqType() {
    }

    public java.lang.String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(java.lang.String containerNo) {
        this.containerNo = containerNo;
    }

    public java.lang.Integer getTokenNo() {
        return tokenNo;
    }

    public void setTokenNo(java.lang.Integer tokenNo) {
        this.tokenNo = tokenNo;
    }

    public java.lang.String getUserCode() {
        return userCode;
    }

    public void setUserCode(java.lang.String userCode) {
        this.userCode = userCode;
    }
}
