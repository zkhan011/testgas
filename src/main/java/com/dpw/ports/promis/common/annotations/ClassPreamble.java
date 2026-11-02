/*
 * Decompiled with CFR 0.152.
 */
package com.dpw.ports.promis.common.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target(value={ElementType.TYPE})
public @interface ClassPreamble {
    public String author();

    public String description();

    public String revision() default "1.0";

    public String lastModifiedBy() default "N/A";

    public String lastModified() default "N/A";

    public String[] reviewers();
}
