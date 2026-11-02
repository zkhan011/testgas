package com.dpw.ports.promis.hht.type;


@com.fasterxml.jackson.annotation.JsonAutoDetect(fieldVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY,getterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,isGetterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE,setterVisibility=com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE)
public class UpdateStdDmgDtlsRespType implements java.io.Serializable {
    protected java.lang.String stdInstructionId;
    protected java.lang.String stdInstructionSpecId;
    protected java.lang.String status;

    public UpdateStdDmgDtlsRespType() {
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

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }
}
