/*
 * Decompiled with CFR 0.152.
 */
package com.dpw.ports.promis.common.integration.service;

import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface DBManagerService {
    public String startScheduler(String var1);

    public String stopScheduler(String var1);

    public List<String> getConfiguredJobsForMarineAQ();
}
