package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class CodeResType implements java.io.Serializable {
    protected com.dpw.ports.promis.hht.type.CodeType[] recordList;
    protected java.lang.String status;

    public CodeResType() {
    }

    public com.dpw.ports.promis.hht.type.CodeType[] getRecordList() {
        return recordList;
    }

    public void setRecordList(com.dpw.ports.promis.hht.type.CodeType[] recordList) {
        this.recordList = recordList;
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }
}
