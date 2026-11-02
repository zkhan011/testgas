package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class NoticeTypeList implements java.io.Serializable {
    protected java.lang.String noticeType;
    protected java.lang.String etcDate;
    protected java.lang.String userId;

    public NoticeTypeList() {
    }

    public java.lang.String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(java.lang.String noticeType) {
        this.noticeType = noticeType;
    }

    public java.lang.String getEtcDate() {
        return etcDate;
    }

    public void setEtcDate(java.lang.String etcDate) {
        this.etcDate = etcDate;
    }

    public java.lang.String getUserId() {
        return userId;
    }

    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }
}
