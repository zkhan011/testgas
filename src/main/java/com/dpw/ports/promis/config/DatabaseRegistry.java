package com.dpw.ports.promis.config;
import java.util.*;import javax.sql.DataSource;import com.zaxxer.hikari.*;
import org.springframework.core.io.ClassPathResource;import org.springframework.jdbc.support.JdbcTransactionManager;
import org.mybatis.spring.SqlSessionFactoryBean;import org.mybatis.spring.SqlSessionTemplate;
import org.apache.ibatis.mapping.SqlCommandType;import org.apache.ibatis.session.LocalCacheScope;
/** Each template stays bound to its pool. DAO selection is local to each call. */
public final class DatabaseRegistry implements AutoCloseable{
 private final Map<String,HikariDataSource> pools=new LinkedHashMap<>();private final Map<DataSource,Queries> queries=new IdentityHashMap<>();private final Map<String,JdbcTransactionManager> managers=new HashMap<>();
 public DatabaseRegistry(DatabaseProperties properties)throws Exception{
  try{for(String name:List.of("ctms-ja","ctms-pr","marine-aq","marine","efz-gate-pass","promis-main","general-cargo","rsis")){
   var p=Objects.requireNonNull(properties.getDatabases().get(name),"Missing gate.databases."+name);var c=new HikariConfig();c.setPoolName(name);c.setJdbcUrl(p.getUrl());c.setUsername(p.getUsername());c.setPassword(p.getPassword());c.setDriverClassName("oracle.jdbc.OracleDriver");c.setMaximumPoolSize(p.getMaximumPoolSize());c.setMinimumIdle(0);c.setConnectionTimeout(10000);c.setInitializationFailTimeout(-1);
   var ds=new HikariDataSource(c);pools.put(name,ds);managers.put(name,new JdbcTransactionManager(ds));
   var config=new org.apache.ibatis.session.Configuration();config.setCacheEnabled(false);config.setLocalCacheScope(LocalCacheScope.STATEMENT);config.setDefaultStatementTimeout(60);config.setJdbcTypeForNull(org.apache.ibatis.type.JdbcType.NULL);
   var factory=new SqlSessionFactoryBean();factory.setDataSource(ds);factory.setConfiguration(config);factory.setMapperLocations(new ClassPathResource("mappers/HhtMapper.xml"));queries.put(ds,new Queries(new SqlSessionTemplate(Objects.requireNonNull(factory.getObject()))));
  }}catch(Exception e){close();throw e;}
 }
 public DataSource dataSource(String name){return Objects.requireNonNull(pools.get(name),"Unknown database "+name);}
 public Queries sql(DataSource ds){return Objects.requireNonNull(queries.get(ds),"Unregistered database");}
 public JdbcTransactionManager transactions(String name){return managers.get(name);}
 public void close(){pools.values().forEach(HikariDataSource::close);}
 public static final class Queries{
  private final SqlSessionTemplate session;Queries(SqlSessionTemplate s){session=s;}
  public List queryForList(String id,Object parameters){
   String name="hht."+id;if(session.getConfiguration().getMappedStatement(name).getSqlCommandType()==SqlCommandType.INSERT){session.insert(name,parameters);return List.of();}
   List rows=session.selectList(name,parameters);if(id.equals("getvoyages") && parameters instanceof Map m && m.get("pcontainerres") instanceof List cursor)return cursor;return rows;
  }
  public Object queryForObject(String id,Object parameters){return session.selectOne("hht."+id,parameters);}
  public Object queryForObject(String id){return queryForObject(id,null);}
  public Object insert(String id,Object parameters){return session.insert("hht."+id,parameters);}
 }
}
