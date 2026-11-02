package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class ContainerDamageRespType implements java.io.Serializable {
    protected com.dpw.ports.promis.hht.type.ContainerDamageType[] containerDamageTypesList;
    protected java.lang.String status;

    public ContainerDamageRespType() {
    }

    public com.dpw.ports.promis.hht.type.ContainerDamageType[] getContainerDamageTypesList() {
        return containerDamageTypesList;
    }

    public void setContainerDamageTypesList(com.dpw.ports.promis.hht.type.ContainerDamageType[] containerDamageTypesList) {
        this.containerDamageTypesList = containerDamageTypesList;
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }
}
