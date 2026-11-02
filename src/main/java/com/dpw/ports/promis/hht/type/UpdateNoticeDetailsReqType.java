package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class UpdateNoticeDetailsReqType implements java.io.Serializable {
    protected java.lang.Integer rotationNumber;
    protected java.lang.String terminalId;
    protected com.dpw.ports.promis.hht.type.NoticeTypeList[] noticeList;

    public UpdateNoticeDetailsReqType() {
    }

    public java.lang.Integer getRotationNumber() {
        return rotationNumber;
    }

    public void setRotationNumber(java.lang.Integer rotationNumber) {
        this.rotationNumber = rotationNumber;
    }

    public java.lang.String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(java.lang.String terminalId) {
        this.terminalId = terminalId;
    }

    public com.dpw.ports.promis.hht.type.NoticeTypeList[] getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(com.dpw.ports.promis.hht.type.NoticeTypeList[] noticeList) {
        this.noticeList = noticeList;
    }
}
