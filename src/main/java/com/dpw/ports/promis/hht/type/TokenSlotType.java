package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class TokenSlotType implements java.io.Serializable {
    protected java.lang.String regPlace;
    protected java.lang.String vehicleNo;
    protected java.lang.String tokenNo;
    protected java.lang.String containerNo;
    protected java.lang.String slotStartTime;
    protected java.lang.String slotEndTime;
    protected java.lang.String terminalId;
    protected java.lang.String timeSlotValid;
    protected java.lang.String stopInspection;
    protected java.lang.String satisfyAnyOne;
    protected java.lang.String validThreshold;
    protected java.lang.String thresholdError;

    public TokenSlotType() {
    }

    public java.lang.String getRegPlace() {
        return regPlace;
    }

    public void setRegPlace(java.lang.String regPlace) {
        this.regPlace = regPlace;
    }

    public java.lang.String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(java.lang.String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public java.lang.String getTokenNo() {
        return tokenNo;
    }

    public void setTokenNo(java.lang.String tokenNo) {
        this.tokenNo = tokenNo;
    }

    public java.lang.String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(java.lang.String containerNo) {
        this.containerNo = containerNo;
    }

    public java.lang.String getSlotStartTime() {
        return slotStartTime;
    }

    public void setSlotStartTime(java.lang.String slotStartTime) {
        this.slotStartTime = slotStartTime;
    }

    public java.lang.String getSlotEndTime() {
        return slotEndTime;
    }

    public void setSlotEndTime(java.lang.String slotEndTime) {
        this.slotEndTime = slotEndTime;
    }

    public java.lang.String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(java.lang.String terminalId) {
        this.terminalId = terminalId;
    }

    public java.lang.String getTimeSlotValid() {
        return timeSlotValid;
    }

    public void setTimeSlotValid(java.lang.String timeSlotValid) {
        this.timeSlotValid = timeSlotValid;
    }

    public java.lang.String getStopInspection() {
        return stopInspection;
    }

    public void setStopInspection(java.lang.String stopInspection) {
        this.stopInspection = stopInspection;
    }

    public java.lang.String getSatisfyAnyOne() {
        return satisfyAnyOne;
    }

    public void setSatisfyAnyOne(java.lang.String satisfyAnyOne) {
        this.satisfyAnyOne = satisfyAnyOne;
    }

    public java.lang.String getValidThreshold() {
        return validThreshold;
    }

    public void setValidThreshold(java.lang.String validThreshold) {
        this.validThreshold = validThreshold;
    }

    public java.lang.String getThresholdError() {
        return thresholdError;
    }

    public void setThresholdError(java.lang.String thresholdError) {
        this.thresholdError = thresholdError;
    }
}
