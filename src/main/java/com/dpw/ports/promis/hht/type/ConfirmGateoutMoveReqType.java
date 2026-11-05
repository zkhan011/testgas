package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class ConfirmGateoutMoveReqType implements java.io.Serializable {
    protected java.math.BigInteger tokenno;
    protected java.lang.Integer eirno;
    protected java.lang.String containerno;
    protected java.lang.String terminalid;
    protected java.lang.String confirm;
    protected java.lang.String usercode;
    protected java.lang.String gate;

    public ConfirmGateoutMoveReqType() {
    }

    public java.math.BigInteger getTokenno() {
        return tokenno;
    }

    public void setTokenno(java.math.BigInteger tokenno) {
        this.tokenno = tokenno;
    }

    public java.lang.Integer getEirno() {
        return eirno;
    }

    public void setEirno(java.lang.Integer eirno) {
        this.eirno = eirno;
    }

    public java.lang.String getContainerno() {
        return containerno;
    }

    public void setContainerno(java.lang.String containerno) {
        this.containerno = containerno;
    }

    public java.lang.String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(java.lang.String terminalid) {
        this.terminalid = terminalid;
    }

    public java.lang.String getConfirm() {
        return confirm;
    }

    public void setConfirm(java.lang.String confirm) {
        this.confirm = confirm;
    }

    public java.lang.String getUsercode() {
        return usercode;
    }

    public void setUsercode(java.lang.String usercode) {
        this.usercode = usercode;
    }

    public java.lang.String getGate() {
        return gate;
    }

    public void setGate(java.lang.String gate) {
        this.gate = gate;
    }
}
