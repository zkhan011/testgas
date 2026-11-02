package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class StandardReqType implements java.io.Serializable {
    protected com.dpw.ports.promis.hht.type.LoginInfoReqType userCredentials;

    public StandardReqType() {
    }

    public com.dpw.ports.promis.hht.type.LoginInfoReqType getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(com.dpw.ports.promis.hht.type.LoginInfoReqType userCredentials) {
        this.userCredentials = userCredentials;
    }
}
