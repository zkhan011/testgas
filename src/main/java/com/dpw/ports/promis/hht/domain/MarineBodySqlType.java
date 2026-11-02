package com.dpw.ports.promis.hht.domain;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class MarineBodySqlType implements SQLData{
   private String resource_code;
   private String usage_start_time;
   private String usage_end_time;
   private String sqlTypeName;

    public MarineBodySqlType() {
    }

    public String getSQLTypeName() {
        return sqlTypeName;
    }

    public void readSQL(SQLInput stream, String typeName)  throws SQLException{
        resource_code = stream.readString();
        usage_start_time= stream.readString();
        usage_end_time= stream.readString();

    }

    public void writeSQL(SQLOutput stream) throws SQLException{
        stream.writeString(resource_code);
        stream.writeString(usage_start_time);
        stream.writeString(usage_end_time);
    }

    public void setUsage_start_time(String usage_start_time) {
        this.usage_start_time = usage_start_time;
    }

    public String getUsage_start_time() {
        return usage_start_time;
    }

    public void setUsage_end_time(String usage_end_time) {
        this.usage_end_time = usage_end_time;
    }

    public String getUsage_end_time() {
        return usage_end_time;
    }

    public void setSqlTypeName(String sqlTypeName) {
        this.sqlTypeName = sqlTypeName;
    }


    public String getResource_code() {
        return resource_code;
    }

    public void setResource_code(String resource_code) {
        this.resource_code = resource_code;
    }

 public Object[] attributes(){return new Object[]{resource_code,usage_start_time,usage_end_time};}
}
