package com.dpw.ports.promis.aqoperations.dao;

import com.dpw.ports.promis.common.annotations.ClassPreamble;

import java.util.List;


@com.dpw.ports.promis.common.annotations.ClassPreamble(
    author ="Kamesh Rao",
    description = "DAO class for DBManager services",
    reviewers = {"Kamesh Rao"})
public interface DBManagerDAO {

    /**
     * Data Access Method to start the job that processes voyages received from
     * CTMS.
     * @return errorDesc in case the procedure encounters an error while starting
     *         the job.
     */
    public String startVoyageScheduler();

    /**
     * Data Access Method to stop the job that processes voyages received from
     * CTMS.
     *
     * @return errorDesc in case the procedure encounters an error while stopping
     *         the Job.
     */
    public String stopVoyageScheduler();

    /**
     * Data Access Method to start the job that processes TWS received from
     * CTMS.
     * @return errorDesc in case the procedure encounters an error while starting
     *         the job.
     */
    public String startTWSScheduler();

    /**
     * Data Access Method to stop the job that processes TWS received from
     * CTMS.
     *
     * @retrn errorDesc in case the procedure encounters an error while stopping
     *        the Job.
     */
    public String stopTWSScheduler();

    /**
     * Returns all the configures Jobs for MARINE_AQ schema.
     *
     * @return
     */
    public List<String> getConfiguredJobsForMarineAQ();
}
