package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class UpdateCustmReqType implements java.io.Serializable {
    protected java.lang.String vehicleRgPlc;
    protected java.lang.String vehicleRgNo;
    protected java.lang.String tokenNo;
    protected java.lang.String containerNo;
    protected java.lang.String source;
    protected java.lang.String userId;
    protected java.lang.String gateCode;
    protected java.lang.String laneCode;
    protected java.lang.String laneType;

    public UpdateCustmReqType() {
    }

    public java.lang.String getVehicleRgPlc() {
        return vehicleRgPlc;
    }

    public void setVehicleRgPlc(java.lang.String vehicleRgPlc) {
        this.vehicleRgPlc = vehicleRgPlc;
    }

    public java.lang.String getVehicleRgNo() {
        return vehicleRgNo;
    }

    public void setVehicleRgNo(java.lang.String vehicleRgNo) {
        this.vehicleRgNo = vehicleRgNo;
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

    public java.lang.String getSource() {
        return source;
    }

    public void setSource(java.lang.String source) {
        this.source = source;
    }

    public java.lang.String getUserId() {
        return userId;
    }

    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    public java.lang.String getGateCode() {
        return gateCode;
    }

    public void setGateCode(java.lang.String gateCode) {
        this.gateCode = gateCode;
    }

    public java.lang.String getLaneCode() {
        return laneCode;
    }

    public void setLaneCode(java.lang.String laneCode) {
        this.laneCode = laneCode;
    }

    public java.lang.String getLaneType() {
        return laneType;
    }

    public void setLaneType(java.lang.String laneType) {
        this.laneType = laneType;
    }
}
