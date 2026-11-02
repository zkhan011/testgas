package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class TruckInfoResType implements java.io.Serializable {
    protected java.lang.String containerNumber;
    protected java.lang.String moveType;
    protected java.lang.String designation;
    protected java.lang.String yardLocation;
    protected java.lang.String tokenNo;
    protected java.lang.String terminalId;
    protected java.lang.String regPlate;
    protected java.lang.String vehicleNo;
    protected java.lang.String lineCode;
    protected java.lang.String errorMsg;
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;

    public TruckInfoResType() {
    }

    public java.lang.String getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(java.lang.String containerNumber) {
        this.containerNumber = containerNumber;
    }

    public java.lang.String getMoveType() {
        return moveType;
    }

    public void setMoveType(java.lang.String moveType) {
        this.moveType = moveType;
    }

    public java.lang.String getDesignation() {
        return designation;
    }

    public void setDesignation(java.lang.String designation) {
        this.designation = designation;
    }

    public java.lang.String getYardLocation() {
        return yardLocation;
    }

    public void setYardLocation(java.lang.String yardLocation) {
        this.yardLocation = yardLocation;
    }

    public java.lang.String getTokenNo() {
        return tokenNo;
    }

    public void setTokenNo(java.lang.String tokenNo) {
        this.tokenNo = tokenNo;
    }

    public java.lang.String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(java.lang.String terminalId) {
        this.terminalId = terminalId;
    }

    public java.lang.String getRegPlate() {
        return regPlate;
    }

    public void setRegPlate(java.lang.String regPlate) {
        this.regPlate = regPlate;
    }

    public java.lang.String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(java.lang.String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public java.lang.String getLineCode() {
        return lineCode;
    }

    public void setLineCode(java.lang.String lineCode) {
        this.lineCode = lineCode;
    }

    public java.lang.String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public com.dpw.ports.promis.hht.type.ServiceExceptionType getException() {
        return exception;
    }

    public void setException(com.dpw.ports.promis.hht.type.ServiceExceptionType exception) {
        this.exception = exception;
    }
}
