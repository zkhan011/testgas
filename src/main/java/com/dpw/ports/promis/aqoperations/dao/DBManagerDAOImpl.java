package com.dpw.ports.promis.aqoperations.dao;

import com.dpw.ports.promis.common.integration.IntegrationConstants;
import com.dpw.ports.promis.aqoperations.ProcedureConstants;
import com.dpw.ports.promis.common.annotations.ClassPreamble;
import com.dpw.services.exception.ApplicationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


@com.dpw.ports.promis.common.annotations.ClassPreamble(
    author ="Kamesh Rao",
    description = "DAO implementation class for DBManager services",
    reviewers = {"Kamesh Rao"})
public class DBManagerDAOImpl implements DBManagerDAO {

    private Log logger = LogFactory.getLog(DBManagerDAOImpl.class);

    private StartVoyageSchedulerStoredProc startVoyageSchStoredProcedure;

    private StopVoyageSchedulerStoredProc stopVoyageSchStoredProcedure;

    private StartTWSSchedulerStoredProc startTWSVoyageSchedulerStoredProc;

    private StopTWSSchedulerStoredProc stopTWSVoyageSchedulerStoredProc;

    private JdbcTemplate jdbcTemplate;

    public DBManagerDAOImpl(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public void setStartVoyageSchStoredProcedure(StartVoyageSchedulerStoredProc startQueueStoredProcedure) {
        this.startVoyageSchStoredProcedure = startQueueStoredProcedure;
    }

    public StartVoyageSchedulerStoredProc getStartVoyageSchStoredProcedure() {
        return startVoyageSchStoredProcedure;
    }

    public void setStopVoyageSchStoredProcedure(StopVoyageSchedulerStoredProc stopQueueStoredProcedure) {
        this.stopVoyageSchStoredProcedure = stopQueueStoredProcedure;
    }

    public StopVoyageSchedulerStoredProc getStopVoyageSchStoredProcedure() {
        return stopVoyageSchStoredProcedure;
    }

    public void setStartTWSVoyageSchedulerStoredProc(StartTWSSchedulerStoredProc startTWSVoyageSchedulerStoredProc) {
        this.startTWSVoyageSchedulerStoredProc =
                startTWSVoyageSchedulerStoredProc;
    }

    public StartTWSSchedulerStoredProc getStartTWSVoyageSchedulerStoredProc() {
        return startTWSVoyageSchedulerStoredProc;
    }

    public void setStopTWSVoyageSchedulerStoredProc(StopTWSSchedulerStoredProc stopTWSVoyageSchedulerStoredProc) {
        this.stopTWSVoyageSchedulerStoredProc =
                stopTWSVoyageSchedulerStoredProc;
    }

    public StopTWSSchedulerStoredProc getStopTWSVoyageSchedulerStoredProc() {
        return stopTWSVoyageSchedulerStoredProc;
    }

    /**
     * @see {@link com.dpw.ports.promis.aqoperations.dao.DBManagerDAO#startVoyageScheduler()}
     */
    public String startVoyageScheduler() {
        try {
            Map outputMap = getStartVoyageSchStoredProcedure().execute();
            return (String)outputMap.get(ProcedureConstants.START_VOY_SCH_PROC_PARAM_ERR_DESC);
        } catch (DataAccessException dax) {
            logger.error(new StringBuilder("Error occurred while starting voyage scheduler job").toString());
            logger.error(dax);
            throw new ApplicationException(IntegrationConstants.CTMS_ERROR_CODE,
                                           dax.getMessage());
        }
    }

    /**
     * @see {@link com.dpw.ports.promis.aqoperations.dao.DBManagerDAO#stopVoyageScheduler()}
     */
    public String stopVoyageScheduler() {
        try {
            Map outputMap = getStopVoyageSchStoredProcedure().execute();
            return (String)outputMap.get(ProcedureConstants.STOP_VOY_SCH_PROC_PARAM_ERR_DESC);
        } catch (DataAccessException dax) {
            logger.error(new StringBuilder("Error occurred while stopping voyage scheduler job").toString());
            logger.error(dax);
            throw new ApplicationException(IntegrationConstants.CTMS_ERROR_CODE,
                                           dax.getMessage());
        }
    }

    /**
     * @see {@link com.dpw.ports.promis.aqoperations.dao.DBManagerDAO#startTWSScheduler()}
     */
    public String startTWSScheduler() {
        try {
            Map outputMap = getStartTWSVoyageSchedulerStoredProc().execute();
            return (String)outputMap.get(ProcedureConstants.START_TWS_SCH_PROC_PARAM_ERR_DESC);
        } catch (DataAccessException dax) {
            logger.error(new StringBuilder("Error occurred while starting TWS scheduler job").toString());
            logger.error(dax);
            throw new ApplicationException(IntegrationConstants.CTMS_ERROR_CODE,
                                           dax.getMessage());
        }
    }

    /**
     * @see {@link com.dpw.ports.promis.aqoperations.dao.DBManagerDAO#stopTWSScheduler()}
     */
    public String stopTWSScheduler() {
        try {
            Map outputMap = getStopTWSVoyageSchedulerStoredProc().execute();
            return (String)outputMap.get(ProcedureConstants.STOP_TWS_SCH_PROC_PARAM_ERR_DESC);
        } catch (DataAccessException dax) {
            logger.error(new StringBuilder("Error occurred while stopping TWS scheduler job").toString());
            logger.error(dax);
            throw new ApplicationException(IntegrationConstants.CTMS_ERROR_CODE,
                                           dax.getMessage());
        }
    }

    /**
     * @see {@link com.dpw.ports.promis.aqoperations.dao.DBManagerDAO#getConfiguredJobsForMarineAQ()}
     */
    public List<String> getConfiguredJobsForMarineAQ() {
        List<String> jobNames = new ArrayList<String>();
        jobNames.add(IntegrationConstants.VOYAGE_SCHEDULER_JOB);
        jobNames.add(IntegrationConstants.TWS_SCHEDULER_JOB);
        return jobNames;

    }


}
