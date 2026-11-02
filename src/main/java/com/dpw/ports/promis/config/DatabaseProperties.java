package com.dpw.ports.promis.config;
import java.util.*;import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties(prefix="gate")
public class DatabaseProperties{
 private Map<String,Pool> databases=new LinkedHashMap<>();
 public Map<String,Pool> getDatabases(){return databases;}public void setDatabases(Map<String,Pool> v){databases=v;}
 public static class Pool{
  private String url,username,password;private int maximumPoolSize=5;
  public String getUrl(){return url;}public void setUrl(String v){url=v;}
  public String getUsername(){return username;}public void setUsername(String v){username=v;}
  public String getPassword(){return password;}public void setPassword(String v){password=v;}
  public int getMaximumPoolSize(){return maximumPoolSize;}public void setMaximumPoolSize(int v){maximumPoolSize=v;}
 }
}
