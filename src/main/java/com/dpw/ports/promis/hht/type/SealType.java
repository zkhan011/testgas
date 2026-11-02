package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class SealType implements java.io.Serializable {
    protected java.lang.String sealNo;
    protected java.lang.String sealDate;
    protected java.lang.String moveType;
    protected java.lang.String moveTypeDesc;

    public SealType() {
    }

    public java.lang.String getSealNo() {
        return sealNo;
    }

    public void setSealNo(java.lang.String sealNo) {
        this.sealNo = sealNo;
    }

    public java.lang.String getSealDate() {
        return sealDate;
    }

    public void setSealDate(java.lang.String sealDate) {
        this.sealDate = sealDate;
    }

    public java.lang.String getMoveType() {
        return moveType;
    }

    public void setMoveType(java.lang.String moveType) {
        this.moveType = moveType;
    }

    public java.lang.String getMoveTypeDesc() {
        return moveTypeDesc;
    }

    public void setMoveTypeDesc(java.lang.String moveTypeDesc) {
        this.moveTypeDesc = moveTypeDesc;
    }
}
