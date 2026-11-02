package com.dpw.ports.promis.aqoperations.dao;

import com.dpw.ports.promis.aqoperations.ProcedureConstants;
import com.dpw.ports.promis.common.annotations.ClassPreamble;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;


@com.dpw.ports.promis.common.annotations.ClassPreamble(
    author ="Kamesh Rao",
    description = "Class that maps stored procedure ctms_queue_intf_pkg.stop_dbms_sch_in_tws",
    reviewers = {"Kamesh Rao"})
public class StopTWSSchedulerStoredProc extends StoredProcedure {
    private static final String SPROC_NAME =
        "ctms_queue_intf_pkg.stop_dbms_sch_in_tws";

    public StopTWSSchedulerStoredProc(DataSource ds) {
        super.setDataSource(ds);
        super.setFunction(Boolean.FALSE);
        super.setSql(SPROC_NAME);
        declareParameter(new SqlOutParameter(ProcedureConstants.STOP_TWS_SCH_PROC_PARAM_ERR_DESC,
                                             Types.VARCHAR));
    }

    public Map execute() {
        Map paramMap = new HashMap();
        return super.execute(paramMap);
    }
}
