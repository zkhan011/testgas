package com.dpw.ports.promis.aqoperations.service;

import com.dpw.ports.promis.common.integration.IntegrationConstants;
import com.dpw.ports.promis.common.integration.service.DBManagerService;
import com.dpw.ports.promis.common.annotations.ClassPreamble;
import com.dpw.ports.promis.aqoperations.dao.DBManagerDAO;
import com.dpw.services.exception.ApplicationException;

import java.util.List;


@com.dpw.ports.promis.common.annotations.ClassPreamble(
    author ="Kamesh Rao",
    description = "Service class implementation for DBManagement Services",
    reviewers = {"Kamesh Rao"})
public class DBManagerServiceImpl implements DBManagerService {

    private DBManagerDAO dbManagerDAO;

    public void setDbManagerDAO(DBManagerDAO queueManagerDAO) {
        this.dbManagerDAO = queueManagerDAO;
    }

    public DBManagerDAO getDbManagerDAO() {
        return dbManagerDAO;
    }


    /**
     * @see {@link com.dpw.ports.promis.common.integration.service.DBManagerService#getConfiguredJobsForMarineAQ()}
     */
    public List<String> getConfiguredJobsForMarineAQ() {
        return getDbManagerDAO().getConfiguredJobsForMarineAQ();
    }

    /**
     * @see {@link com.dpw.ports.promis.common.integration.service.DBManagerService#startScheduler(String)}
     */
    public String startScheduler(String schedulerName) {
        if (schedulerName.equalsIgnoreCase(IntegrationConstants.VOYAGE_SCHEDULER_JOB)) {
            return getDbManagerDAO().startVoyageScheduler();
        } else if (schedulerName.equalsIgnoreCase(IntegrationConstants.TWS_SCHEDULER_JOB)) {
            return getDbManagerDAO().startTWSScheduler();
        } else {
            throw new ApplicationException("No Such scheduler exists");
        }
    }

    /**
     * @see {@link com.dpw.ports.promis.common.integration.service.DBManagerService#stopScheduler(String)}
     */
    public String stopScheduler(String schedulerName) {
        if (schedulerName.equalsIgnoreCase(IntegrationConstants.VOYAGE_SCHEDULER_JOB)) {
            return getDbManagerDAO().stopVoyageScheduler();
        } else if (schedulerName.equalsIgnoreCase(IntegrationConstants.TWS_SCHEDULER_JOB)) {
            return getDbManagerDAO().stopTWSScheduler();
        } else {
            throw new ApplicationException("No Such scheduler exists");
        }
    }
}
