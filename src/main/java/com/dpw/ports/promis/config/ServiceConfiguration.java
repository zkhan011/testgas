package com.dpw.ports.promis.config;
import com.dpw.ports.promis.hht.dao.*;import com.dpw.ports.promis.hht.service.*;import com.dpw.ports.promis.aqoperations.dao.*;import com.dpw.ports.promis.aqoperations.service.*;
import org.springframework.context.annotation.*;import org.springframework.boot.context.properties.EnableConfigurationProperties;import org.springframework.beans.factory.annotation.Value;
@Configuration @EnableConfigurationProperties(DatabaseProperties.class)
public class ServiceConfiguration{
 @Bean(destroyMethod="close") DatabaseRegistry databases(DatabaseProperties p)throws Exception{return new DatabaseRegistry(p);}
 @Bean HhtIntegrationsDAO hhtDao(DatabaseRegistry r){return new HhtIntegrationsDAOImpl(r);}
 @Bean HhtService hhtService(HhtIntegrationsDAO dao,@Value("${gate.inspection.message}")String message,@Value("${gate.inspection.flag}")String flag){return new HhtServiceImpl(dao,message,flag);}
 @Bean ManageVoyageServiceImpl voyages(DatabaseRegistry r){
  var dao=new ManageVoyageDAOImpl(r.dataSource("marine-aq"));dao.setVoyCreateJAStoredProc(new VoyageCreationStoredProc(r.dataSource("ctms-ja")));dao.setVoyCreatePRStoredProc(new VoyageCreationStoredProc(r.dataSource("ctms-pr")));dao.setVoyUpdatedStoredProc(new VoyageUpdatedStoredProc(r.dataSource("marine-aq")));dao.setVoyCancelStoredProc(new VoyageCancellationStoredProc(r.dataSource("marine-aq")));dao.setVoyBillingStoreProc(new VoyageBillingStoredProc(r.dataSource("marine-aq")));var s=new ManageVoyageServiceImpl();s.setVoyagesDAO(dao);return s;
 }
 @Bean DBManagerServiceImpl schedulers(DatabaseRegistry r){
  var ds=r.dataSource("marine-aq");var dao=new DBManagerDAOImpl(ds);dao.setStartVoyageSchStoredProcedure(new StartVoyageSchedulerStoredProc(ds));dao.setStopVoyageSchStoredProcedure(new StopVoyageSchedulerStoredProc(ds));dao.setStartTWSVoyageSchedulerStoredProc(new StartTWSSchedulerStoredProc(ds));dao.setStopTWSVoyageSchedulerStoredProc(new StopTWSSchedulerStoredProc(ds));var s=new DBManagerServiceImpl();s.setDbManagerDAO(dao);return s;
 }
}
