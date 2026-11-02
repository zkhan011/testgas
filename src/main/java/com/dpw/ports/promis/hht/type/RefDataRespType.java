package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class RefDataRespType implements java.io.Serializable {
    protected com.dpw.ports.promis.hht.type.PilotType[] pilot;
    protected com.dpw.ports.promis.hht.type.ServiceExceptionType exception;

    public RefDataRespType() {
    }

    public com.dpw.ports.promis.hht.type.PilotType[] getPilot() {
        return pilot;
    }

    public void setPilot(com.dpw.ports.promis.hht.type.PilotType[] pilot) {
        this.pilot = pilot;
    }

    public com.dpw.ports.promis.hht.type.ServiceExceptionType getException() {
        return exception;
    }

    public void setException(com.dpw.ports.promis.hht.type.ServiceExceptionType exception) {
        this.exception = exception;
    }
}
