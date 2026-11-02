package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class ContrLocationType implements java.io.Serializable {
    protected java.lang.String contrno;
    protected java.lang.String terminalid;
    protected java.lang.String movetype;
    protected java.lang.String yardlocn;
    protected java.lang.String yardid;
    protected java.lang.String contrpos;
    protected java.lang.String gateno;

    public ContrLocationType() {
    }

    public java.lang.String getContrno() {
        return contrno;
    }

    public void setContrno(java.lang.String contrno) {
        this.contrno = contrno;
    }

    public java.lang.String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(java.lang.String terminalid) {
        this.terminalid = terminalid;
    }

    public java.lang.String getMovetype() {
        return movetype;
    }

    public void setMovetype(java.lang.String movetype) {
        this.movetype = movetype;
    }

    public java.lang.String getYardlocn() {
        return yardlocn;
    }

    public void setYardlocn(java.lang.String yardlocn) {
        this.yardlocn = yardlocn;
    }

    public java.lang.String getYardid() {
        return yardid;
    }

    public void setYardid(java.lang.String yardid) {
        this.yardid = yardid;
    }

    public java.lang.String getContrpos() {
        return contrpos;
    }

    public void setContrpos(java.lang.String contrpos) {
        this.contrpos = contrpos;
    }

    public java.lang.String getGateno() {
        return gateno;
    }

    public void setGateno(java.lang.String gateno) {
        this.gateno = gateno;
    }
}
