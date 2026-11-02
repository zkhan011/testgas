package com.dpw.ports.promis.common;
public final class Utilities {
 private Utilities(){}
 public static boolean isNullOrEmpty(Object v){return v==null || (v instanceof String s && s.trim().isEmpty()) || (v instanceof java.util.Collection<?> c && c.isEmpty());}
 public static boolean isListNullOrEmpty(java.util.List<?> v){return v==null || v.isEmpty();}
}
