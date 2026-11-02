package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class NoticeDetailsResType implements java.io.Serializable {
    protected java.lang.String status;
    protected java.lang.Integer rotationNumber;
    protected java.lang.String vesselName;
    protected java.lang.String berthNumber;
    protected java.lang.String voyageNumber;
    protected java.lang.String pinNumber;
    protected com.dpw.ports.promis.hht.type.NoticeTypeList[] noticeList;
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;

    public NoticeDetailsResType() {
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public java.lang.Integer getRotationNumber() {
        return rotationNumber;
    }

    public void setRotationNumber(java.lang.Integer rotationNumber) {
        this.rotationNumber = rotationNumber;
    }

    public java.lang.String getVesselName() {
        return vesselName;
    }

    public void setVesselName(java.lang.String vesselName) {
        this.vesselName = vesselName;
    }

    public java.lang.String getBerthNumber() {
        return berthNumber;
    }

    public void setBerthNumber(java.lang.String berthNumber) {
        this.berthNumber = berthNumber;
    }

    public java.lang.String getVoyageNumber() {
        return voyageNumber;
    }

    public void setVoyageNumber(java.lang.String voyageNumber) {
        this.voyageNumber = voyageNumber;
    }

    public java.lang.String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(java.lang.String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public com.dpw.ports.promis.hht.type.NoticeTypeList[] getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(com.dpw.ports.promis.hht.type.NoticeTypeList[] noticeList) {
        this.noticeList = noticeList;
    }

    public com.dpw.ports.promis.hht.type.ServiceExceptionType getException() {
        return exception;
    }

    public void setException(com.dpw.ports.promis.hht.type.ServiceExceptionType exception) {
        this.exception = exception;
    }
}
