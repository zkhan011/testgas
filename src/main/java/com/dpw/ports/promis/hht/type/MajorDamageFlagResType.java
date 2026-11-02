package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class MajorDamageFlagResType implements java.io.Serializable {
    protected java.lang.String flag;

    public MajorDamageFlagResType() {
    }

    public java.lang.String getFlag() {
        return flag;
    }

    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }
}
