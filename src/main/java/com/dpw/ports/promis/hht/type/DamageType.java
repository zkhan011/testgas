package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class DamageType implements java.io.Serializable {
    protected java.lang.String damageCode;
    protected java.lang.String damageDesc;
    protected java.lang.String damageDate;
    protected java.lang.String moveTypeCode;
    protected java.lang.String moveTypeDesc;

    public DamageType() {
    }

    public java.lang.String getDamageCode() {
        return damageCode;
    }

    public void setDamageCode(java.lang.String damageCode) {
        this.damageCode = damageCode;
    }

    public java.lang.String getDamageDesc() {
        return damageDesc;
    }

    public void setDamageDesc(java.lang.String damageDesc) {
        this.damageDesc = damageDesc;
    }

    public java.lang.String getDamageDate() {
        return damageDate;
    }

    public void setDamageDate(java.lang.String damageDate) {
        this.damageDate = damageDate;
    }

    public java.lang.String getMoveTypeCode() {
        return moveTypeCode;
    }

    public void setMoveTypeCode(java.lang.String moveTypeCode) {
        this.moveTypeCode = moveTypeCode;
    }

    public java.lang.String getMoveTypeDesc() {
        return moveTypeDesc;
    }

    public void setMoveTypeDesc(java.lang.String moveTypeDesc) {
        this.moveTypeDesc = moveTypeDesc;
    }
}
