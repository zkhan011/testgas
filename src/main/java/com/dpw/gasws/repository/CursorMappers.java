package com.dpw.gasws.repository;

import com.dpw.gasws.type.*;
import org.springframework.jdbc.core.RowMapper;

final class CursorMappers {
    private CursorMappers() {}
    static final RowMapper<TokenDetailsType> TOKEN = (rs, row) -> {
        var value = new TokenDetailsType();
        value.setTerminalId(rs.getString("terminal_id"));
        value.setTokenNo(rs.getString("token_no"));
        value.setContainerNo(rs.getString("contr_no"));
        value.setStartTime(rs.getTimestamp("lv_start_time"));
        value.setEndTime(rs.getTimestamp("lv_end_time"));
        return value;
    };
    static final RowMapper<ContainerDetailsType> CONTAINER = (rs, row) -> {
        var value = new ContainerDetailsType();
        value.setTerminalId(rs.getString("terminal_id"));
        value.setContainerNo(rs.getString("contr_no"));
        value.setPlateEmirate(rs.getString("PLATE_EMIRATE"));
        value.setPlateNo(rs.getString("PLATE_NO"));
        value.setTokenNo(rs.getString("token_no"));
        value.setRfIdNo(rs.getString("RFID_NO"));
        return value;
    };
    static final RowMapper<EirDetailsType> EIR = (rs, row) -> {
        var value = new EirDetailsType();
        value.setTerminalId(rs.getString("terminal_id"));
        value.setPlateNo(rs.getString("PLATE_NO"));
        value.setPlateEmirate(rs.getString("PLATE_EMIRATE"));
        value.setTokenNo(rs.getString("TOKEN_NO"));
        value.setContainerNo(rs.getString("CONTR_NO"));
        value.setLoad(rs.getString("load"));
        value.setHandling(rs.getString("handling"));
        value.setConsignee(rs.getString("consignee"));
        value.setDpaSeal(rs.getString("dpa_seal"));
        value.setSeal(rs.getString("SEAL"));
        value.setAgentSeal(rs.getString("AGENT_SEAL"));
        value.setCustomsSeal(rs.getString("customs_seal"));
        value.setEirNo(rs.getString("eir_no"));
        value.setEirDate(rs.getString("EIR_DATE"));
        value.setRemarks(rs.getString("REMARKS"));
        value.setRemarks2(rs.getString("REMARKS2"));
        value.setRemarks3(rs.getString("REMARKS3"));
        value.setLocation(rs.getString("LOCATION"));
        value.setMovType(rs.getString("MOVE_TYPE"));
        value.setPrintEir(rs.getString("print_eir"));
        return value;
    };
    static final RowMapper<LocDetailsType> LOCATION = (rs, row) -> {
        var value = new LocDetailsType();
        value.setTerminalId(rs.getString("terminal_id"));
        value.setPlateNo(rs.getString("PLATE_NO"));
        value.setPlateEmirate(rs.getString("PLATE_EMIRATE"));
        value.setTokenNo(rs.getString("TOKEN_NO"));
        value.setContainerNo(rs.getString("CONTR_NO"));
        value.setLoad(rs.getString("load"));
        value.setHandling(rs.getString("handling"));
        value.setLocation(rs.getString("LOCATION"));
        value.setSeal(rs.getString("SEAL"));
        value.setRemarks(rs.getString("REMARKS"));
        value.setRemarks2(rs.getString("REMARKS2"));
        value.setRemarks3(rs.getString("REMARKS3"));
        return value;
    };
}
