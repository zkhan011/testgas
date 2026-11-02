package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class TOSMsgReqType implements java.io.Serializable {
    protected java.lang.String msgID;
    protected java.lang.String msgAction;
    protected java.lang.String lineCode;
    protected java.lang.String contrNo;
    protected java.lang.String isoType;
    protected java.lang.String contrSize;
    protected java.lang.String newIsoCode;
    protected java.lang.String truckCode;
    protected java.lang.String scheduleId;
    protected java.lang.String slotId;
    protected java.lang.String haulCode;
    protected java.lang.String terminalId;

    public TOSMsgReqType() {
    }

    public java.lang.String getMsgID() {
        return msgID;
    }

    public void setMsgID(java.lang.String msgID) {
        this.msgID = msgID;
    }

    public java.lang.String getMsgAction() {
        return msgAction;
    }

    public void setMsgAction(java.lang.String msgAction) {
        this.msgAction = msgAction;
    }

    public java.lang.String getLineCode() {
        return lineCode;
    }

    public void setLineCode(java.lang.String lineCode) {
        this.lineCode = lineCode;
    }

    public java.lang.String getContrNo() {
        return contrNo;
    }

    public void setContrNo(java.lang.String contrNo) {
        this.contrNo = contrNo;
    }

    public java.lang.String getIsoType() {
        return isoType;
    }

    public void setIsoType(java.lang.String isoType) {
        this.isoType = isoType;
    }

    public java.lang.String getContrSize() {
        return contrSize;
    }

    public void setContrSize(java.lang.String contrSize) {
        this.contrSize = contrSize;
    }

    public java.lang.String getNewIsoCode() {
        return newIsoCode;
    }

    public void setNewIsoCode(java.lang.String newIsoCode) {
        this.newIsoCode = newIsoCode;
    }

    public java.lang.String getTruckCode() {
        return truckCode;
    }

    public void setTruckCode(java.lang.String truckCode) {
        this.truckCode = truckCode;
    }

    public java.lang.String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(java.lang.String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public java.lang.String getSlotId() {
        return slotId;
    }

    public void setSlotId(java.lang.String slotId) {
        this.slotId = slotId;
    }

    public java.lang.String getHaulCode() {
        return haulCode;
    }

    public void setHaulCode(java.lang.String haulCode) {
        this.haulCode = haulCode;
    }

    public java.lang.String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(java.lang.String terminalId) {
        this.terminalId = terminalId;
    }
}
