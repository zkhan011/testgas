package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class CtmsHHTRotnResp implements java.io.Serializable {
    protected java.lang.String portcode;
    protected java.lang.String terminalid;
    protected java.lang.Integer rotationnumber;
    protected java.lang.String vesselname;
    protected java.lang.String startworkdt;
    protected java.lang.String endworkdt;

    public CtmsHHTRotnResp() {
    }

    public java.lang.String getPortcode() {
        return portcode;
    }

    public void setPortcode(java.lang.String portcode) {
        this.portcode = portcode;
    }

    public java.lang.String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(java.lang.String terminalid) {
        this.terminalid = terminalid;
    }

    public java.lang.Integer getRotationnumber() {
        return rotationnumber;
    }

    public void setRotationnumber(java.lang.Integer rotationnumber) {
        this.rotationnumber = rotationnumber;
    }

    public java.lang.String getVesselname() {
        return vesselname;
    }

    public void setVesselname(java.lang.String vesselname) {
        this.vesselname = vesselname;
    }

    public java.lang.String getStartworkdt() {
        return startworkdt;
    }

    public void setStartworkdt(java.lang.String startworkdt) {
        this.startworkdt = startworkdt;
    }

    public java.lang.String getEndworkdt() {
        return endworkdt;
    }

    public void setEndworkdt(java.lang.String endworkdt) {
        this.endworkdt = endworkdt;
    }
}
