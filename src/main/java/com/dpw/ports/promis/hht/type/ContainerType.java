package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class ContainerType implements java.io.Serializable {
    protected java.lang.String containerNo;
    protected java.lang.String creationDate;
    protected java.lang.String contrLocation;

    public ContainerType() {
    }

    public java.lang.String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(java.lang.String containerNo) {
        this.containerNo = containerNo;
    }

    public java.lang.String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.lang.String creationDate) {
        this.creationDate = creationDate;
    }

    public java.lang.String getContrLocation() {
        return contrLocation;
    }

    public void setContrLocation(java.lang.String contrLocation) {
        this.contrLocation = contrLocation;
    }
}
