package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class VGMWtType implements java.io.Serializable {
    protected java.lang.String containerNo;
    protected java.lang.String tokenNo;
    protected java.lang.String terminalId;
    protected java.lang.Float declaredWt;
    protected java.lang.Float actualWt;
    protected java.lang.String eirDate;
    protected java.lang.String eirNo;
    protected java.lang.String desig;

    public VGMWtType() {
    }

    public java.lang.String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(java.lang.String containerNo) {
        this.containerNo = containerNo;
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

    public java.lang.Float getDeclaredWt() {
        return declaredWt;
    }

    public void setDeclaredWt(java.lang.Float declaredWt) {
        this.declaredWt = declaredWt;
    }

    public java.lang.Float getActualWt() {
        return actualWt;
    }

    public void setActualWt(java.lang.Float actualWt) {
        this.actualWt = actualWt;
    }

    public java.lang.String getEirDate() {
        return eirDate;
    }

    public void setEirDate(java.lang.String eirDate) {
        this.eirDate = eirDate;
    }

    public java.lang.String getEirNo() {
        return eirNo;
    }

    public void setEirNo(java.lang.String eirNo) {
        this.eirNo = eirNo;
    }

    public java.lang.String getDesig() {
        return desig;
    }

    public void setDesig(java.lang.String desig) {
        this.desig = desig;
    }
}
