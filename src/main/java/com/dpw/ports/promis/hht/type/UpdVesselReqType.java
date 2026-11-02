package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class UpdVesselReqType implements java.io.Serializable {
    protected java.lang.String rotationnumber;
    protected java.lang.String startworkdt;
    protected java.lang.String endworkdt;
    protected java.lang.String berthdt;
    protected java.lang.String deviceid;
    protected java.lang.String userid;

    public UpdVesselReqType() {
    }

    public java.lang.String getRotationnumber() {
        return rotationnumber;
    }

    public void setRotationnumber(java.lang.String rotationnumber) {
        this.rotationnumber = rotationnumber;
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

    public java.lang.String getBerthdt() {
        return berthdt;
    }

    public void setBerthdt(java.lang.String berthdt) {
        this.berthdt = berthdt;
    }

    public java.lang.String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(java.lang.String deviceid) {
        this.deviceid = deviceid;
    }

    public java.lang.String getUserid() {
        return userid;
    }

    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
}
