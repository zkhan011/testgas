package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class FZGPGateInOutUpdateReqType implements java.io.Serializable {
    protected java.lang.String pgpno;
    protected java.lang.String pgprefno;
    protected java.lang.String gateno;
    protected java.lang.String gateuser;
    protected java.lang.String sourcesys;
    protected java.lang.String premark;
    protected java.lang.String srcApp;
    protected java.lang.String vehicleno;
    protected java.lang.String regplace;
    protected java.lang.String platecode;

    public FZGPGateInOutUpdateReqType() {
    }

    public java.lang.String getPgpno() {
        return pgpno;
    }

    public void setPgpno(java.lang.String pgpno) {
        this.pgpno = pgpno;
    }

    public java.lang.String getPgprefno() {
        return pgprefno;
    }

    public void setPgprefno(java.lang.String pgprefno) {
        this.pgprefno = pgprefno;
    }

    public java.lang.String getGateno() {
        return gateno;
    }

    public void setGateno(java.lang.String gateno) {
        this.gateno = gateno;
    }

    public java.lang.String getGateuser() {
        return gateuser;
    }

    public void setGateuser(java.lang.String gateuser) {
        this.gateuser = gateuser;
    }

    public java.lang.String getSourcesys() {
        return sourcesys;
    }

    public void setSourcesys(java.lang.String sourcesys) {
        this.sourcesys = sourcesys;
    }

    public java.lang.String getPremark() {
        return premark;
    }

    public void setPremark(java.lang.String premark) {
        this.premark = premark;
    }

    public java.lang.String getSrcApp() {
        return srcApp;
    }

    public void setSrcApp(java.lang.String srcApp) {
        this.srcApp = srcApp;
    }

    public java.lang.String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(java.lang.String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public java.lang.String getRegplace() {
        return regplace;
    }

    public void setRegplace(java.lang.String regplace) {
        this.regplace = regplace;
    }

    public java.lang.String getPlatecode() {
        return platecode;
    }

    public void setPlatecode(java.lang.String platecode) {
        this.platecode = platecode;
    }
}
