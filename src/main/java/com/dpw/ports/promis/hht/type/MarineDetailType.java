package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class MarineDetailType implements java.io.Serializable {
    protected java.lang.String resource_code;
    protected java.lang.String usage_start_time;
    protected java.lang.String usage_end_time;

    public MarineDetailType() {
    }

    public java.lang.String getResource_code() {
        return resource_code;
    }

    public void setResource_code(java.lang.String resource_code) {
        this.resource_code = resource_code;
    }

    public java.lang.String getUsage_start_time() {
        return usage_start_time;
    }

    public void setUsage_start_time(java.lang.String usage_start_time) {
        this.usage_start_time = usage_start_time;
    }

    public java.lang.String getUsage_end_time() {
        return usage_end_time;
    }

    public void setUsage_end_time(java.lang.String usage_end_time) {
        this.usage_end_time = usage_end_time;
    }
}
