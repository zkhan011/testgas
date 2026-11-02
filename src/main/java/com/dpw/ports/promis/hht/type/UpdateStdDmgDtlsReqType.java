package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class UpdateStdDmgDtlsReqType implements java.io.Serializable {
    protected java.lang.String stdInstructionId;
    protected java.lang.String stdInstructionSpecId;
    protected java.lang.String userId;

    public UpdateStdDmgDtlsReqType() {
    }

    public java.lang.String getStdInstructionId() {
        return stdInstructionId;
    }

    public void setStdInstructionId(java.lang.String stdInstructionId) {
        this.stdInstructionId = stdInstructionId;
    }

    public java.lang.String getStdInstructionSpecId() {
        return stdInstructionSpecId;
    }

    public void setStdInstructionSpecId(java.lang.String stdInstructionSpecId) {
        this.stdInstructionSpecId = stdInstructionSpecId;
    }

    public java.lang.String getUserId() {
        return userId;
    }

    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }
}
