/*
 * Decompiled with CFR 0.152.
 */
package com.dpw.ports.promis.common.integration.service;

import com.dpw.ports.promis.common.integration.domain.Voyage;

public interface ManageVoyageService {
    public Long generateRotationNo(Voyage var1);

    public String adviceVoyage(Long var1, String var2);

    public String cancelVoyage(Long var1, String var2);

    public String billVoyage(Long var1);
}
