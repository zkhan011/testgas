package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class MarineType implements java.io.Serializable {
    protected com.dpw.ports.promis.hht.type.MarineHeaderType marineHeader;
    protected com.dpw.ports.promis.hht.type.MarineDetailType[] marineDetail;

    public MarineType() {
    }

    public com.dpw.ports.promis.hht.type.MarineHeaderType getMarineHeader() {
        return marineHeader;
    }

    public void setMarineHeader(com.dpw.ports.promis.hht.type.MarineHeaderType marineHeader) {
        this.marineHeader = marineHeader;
    }

    public com.dpw.ports.promis.hht.type.MarineDetailType[] getMarineDetail() {
        return marineDetail;
    }

    public void setMarineDetail(com.dpw.ports.promis.hht.type.MarineDetailType[] marineDetail) {
        this.marineDetail = marineDetail;
    }
}
