package com.dpw.ports.promis.common.util;

import org.apache.commons.lang.StringUtils;

public final class PromisUtil {

    public PromisUtil() {

    }

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

}
