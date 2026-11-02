package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class UpdateSealReqType implements java.io.Serializable {
    protected java.lang.Integer tokenno;
    protected java.lang.String containerno;
    protected java.lang.String sealno;
    protected java.lang.Integer movetype;
    protected java.lang.String regplate;
    protected java.lang.String vehicleno;
    protected java.lang.Integer damagecode;
    protected java.lang.String damagedescr;
    protected java.lang.String usercode;
    protected java.lang.String atdate;
    protected java.lang.String devid;
    protected java.lang.String tipmsg;
    protected java.lang.String cancelstatus;
    protected java.lang.String mtinspflag;
    protected java.lang.String customseal;
    protected java.lang.String dpwseal;
    protected java.lang.String agentseal;
    protected java.lang.String gate;
    protected java.lang.String isSealInvalid;
    protected java.lang.String isImcoLabelInvalid;
    protected java.lang.String mtOutSeatIssued;
    protected java.lang.Integer chassisType;
    protected java.lang.Integer contrChassisPos;
    protected java.lang.String oogStatus;
    protected java.lang.String oogReason;

    public UpdateSealReqType() {
    }

    public java.lang.Integer getTokenno() {
        return tokenno;
    }

    public void setTokenno(java.lang.Integer tokenno) {
        this.tokenno = tokenno;
    }

    public java.lang.String getContainerno() {
        return containerno;
    }

    public void setContainerno(java.lang.String containerno) {
        this.containerno = containerno;
    }

    public java.lang.String getSealno() {
        return sealno;
    }

    public void setSealno(java.lang.String sealno) {
        this.sealno = sealno;
    }

    public java.lang.Integer getMovetype() {
        return movetype;
    }

    public void setMovetype(java.lang.Integer movetype) {
        this.movetype = movetype;
    }

    public java.lang.String getRegplate() {
        return regplate;
    }

    public void setRegplate(java.lang.String regplate) {
        this.regplate = regplate;
    }

    public java.lang.String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(java.lang.String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public java.lang.Integer getDamagecode() {
        return damagecode;
    }

    public void setDamagecode(java.lang.Integer damagecode) {
        this.damagecode = damagecode;
    }

    public java.lang.String getDamagedescr() {
        return damagedescr;
    }

    public void setDamagedescr(java.lang.String damagedescr) {
        this.damagedescr = damagedescr;
    }

    public java.lang.String getUsercode() {
        return usercode;
    }

    public void setUsercode(java.lang.String usercode) {
        this.usercode = usercode;
    }

    public java.lang.String getAtdate() {
        return atdate;
    }

    public void setAtdate(java.lang.String atdate) {
        this.atdate = atdate;
    }

    public java.lang.String getDevid() {
        return devid;
    }

    public void setDevid(java.lang.String devid) {
        this.devid = devid;
    }

    public java.lang.String getTipmsg() {
        return tipmsg;
    }

    public void setTipmsg(java.lang.String tipmsg) {
        this.tipmsg = tipmsg;
    }

    public java.lang.String getCancelstatus() {
        return cancelstatus;
    }

    public void setCancelstatus(java.lang.String cancelstatus) {
        this.cancelstatus = cancelstatus;
    }

    public java.lang.String getMtinspflag() {
        return mtinspflag;
    }

    public void setMtinspflag(java.lang.String mtinspflag) {
        this.mtinspflag = mtinspflag;
    }

    public java.lang.String getCustomseal() {
        return customseal;
    }

    public void setCustomseal(java.lang.String customseal) {
        this.customseal = customseal;
    }

    public java.lang.String getDpwseal() {
        return dpwseal;
    }

    public void setDpwseal(java.lang.String dpwseal) {
        this.dpwseal = dpwseal;
    }

    public java.lang.String getAgentseal() {
        return agentseal;
    }

    public void setAgentseal(java.lang.String agentseal) {
        this.agentseal = agentseal;
    }

    public java.lang.String getGate() {
        return gate;
    }

    public void setGate(java.lang.String gate) {
        this.gate = gate;
    }

    public java.lang.String getIsSealInvalid() {
        return isSealInvalid;
    }

    public void setIsSealInvalid(java.lang.String isSealInvalid) {
        this.isSealInvalid = isSealInvalid;
    }

    public java.lang.String getIsImcoLabelInvalid() {
        return isImcoLabelInvalid;
    }

    public void setIsImcoLabelInvalid(java.lang.String isImcoLabelInvalid) {
        this.isImcoLabelInvalid = isImcoLabelInvalid;
    }

    public java.lang.String getMtOutSeatIssued() {
        return mtOutSeatIssued;
    }

    public void setMtOutSeatIssued(java.lang.String mtOutSeatIssued) {
        this.mtOutSeatIssued = mtOutSeatIssued;
    }

    public java.lang.Integer getChassisType() {
        return chassisType;
    }

    public void setChassisType(java.lang.Integer chassisType) {
        this.chassisType = chassisType;
    }

    public java.lang.Integer getContrChassisPos() {
        return contrChassisPos;
    }

    public void setContrChassisPos(java.lang.Integer contrChassisPos) {
        this.contrChassisPos = contrChassisPos;
    }

    public java.lang.String getOogStatus() {
        return oogStatus;
    }

    public void setOogStatus(java.lang.String oogStatus) {
        this.oogStatus = oogStatus;
    }

    public java.lang.String getOogReason() {
        return oogReason;
    }

    public void setOogReason(java.lang.String oogReason) {
        this.oogReason = oogReason;
    }
}
