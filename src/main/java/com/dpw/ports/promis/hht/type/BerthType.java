package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class BerthType implements java.io.Serializable {
    protected java.lang.Integer rotationNumber;
    protected java.lang.String vesselName;
    protected java.lang.String terminalId;

    public BerthType() {
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

    public java.lang.String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(java.lang.String terminalId) {
        this.terminalId = terminalId;
    }
}
