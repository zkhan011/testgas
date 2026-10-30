package com.dpw.gasws.repository;

public class ProcedureRejectedException extends RuntimeException {
    public ProcedureRejectedException() {
        super("The database rejected the gate operation");
    }
}
