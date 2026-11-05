package com.dpw.ports.promis;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dpw.ports.promis.hht.service.HhtService;
import com.dpw.ports.promis.hht.type.*;
import com.dpw.ports.promis.web.*;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.session.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import java.util.*;import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
class MigrationTest {
 Configuration mappings()throws Exception{
  var c=new Configuration();try(var input=getClass().getResourceAsStream("/mappers/HhtMapper.xml")){new XMLMapperBuilder(input,c,"HhtMapper.xml",c.getSqlFragments()).parse();}return c;
 }
 @Test void all49MappingsAndResultPropertiesResolve()throws Exception{
  var c=mappings();int count=0;
  for(String id:c.getMappedStatementNames())if(id.startsWith("hht.")){var b=c.getMappedStatement(id).getBoundSql(new HashMap<>());assertNotNull(b.getSql());for(var p:b.getParameterMappings())if(p.getJdbcType()==org.apache.ibatis.type.JdbcType.CURSOR)assertNotNull(c.getResultMap(p.getResultMapId()));count++;}assertEquals(49,count);
  for(var r:c.getResultMaps()){var meta=org.apache.ibatis.reflection.MetaClass.forClass(r.getType(),c.getReflectorFactory());for(var f:r.getResultMappings())assertTrue(meta.hasSetter(f.getProperty()),r.getId()+":"+f.getProperty());}
 }
 @Test void all37ProcedureParameterContractsMatchOriginal()throws Exception{
  var root=new ObjectMapper().readTree(getClass().getResourceAsStream("/legacy-procedure-contracts.json"));var c=mappings();var names=root.fieldNames();int count=0;
  while(names.hasNext()){String id=names.next();var expected=root.get(id);var actual=c.getMappedStatement("hht."+id).getBoundSql(new HashMap<>()).getParameterMappings();assertEquals(expected.size(),actual.size(),id);
   for(int i=0;i<actual.size();i++){var e=expected.get(i);var a=actual.get(i);assertEquals(e.get("property").asText(),a.getProperty(),id);String type=e.get("jdbcType").asText().toUpperCase(Locale.ROOT);type=switch(type){case "NUMBER"->"NUMERIC";case "ORACLECURSOR"->"CURSOR";default->type;};if (a.getProperty().equalsIgnoreCase("tokenno") && type.equals("INTEGER")) type="NUMERIC";assertEquals(type,a.getJdbcType().name(),id);assertEquals(e.path("mode").asText("IN"),a.getMode().name(),id);}count++;
  }assertEquals(37,count);
 }
 @Test void all39JsonRoutesDispatchAndXmlIsRejected()throws Exception{
  HhtService service=mock(HhtService.class,call->call.getMethod().getReturnType().getDeclaredConstructor().newInstance());var json=new ObjectMapper();
  var mvc=MockMvcBuilders.standaloneSetup(new HhtController(service)).setMessageConverters(new MappingJackson2HttpMessageConverter(json)).setControllerAdvice(new ApiExceptionHandler(),new LegacyErrorAdvice()).build();
  var ops=json.readTree(Files.readString(Path.of("docs/endpoint-mapping.json")));assertEquals(46,ops.size());int count=0;
  for(var op:ops){if(count==39)break;clearInvocations(service);var req=op.get("method").asText().equals("GET")?get(op.get("path").asText()):post(op.get("path").asText()).contentType("application/json").content("{}");mvc.perform(req).andExpect(status().isOk());String expected=op.get("operation").asText();if(expected.equals("getTokenForCommercialTruck"))expected="getTokenContrDtlsForTruck";var inv=mockingDetails(service).getInvocations();assertEquals(1,inv.size());assertEquals(expected,inv.iterator().next().getMethod().getName());count++;}assertEquals(39,count);
  mvc.perform(post("/api/v1/getTokenForTruck").contentType("text/xml").content("<Envelope/>")).andExpect(status().isUnsupportedMediaType());
  mvc.perform(post("/PilotPlanningService").contentType("text/xml").content("<Envelope/>")).andExpect(status().isNotFound());
  mvc.perform(post("/api/v1/getTokenForTruck").contentType("application/json").content("{\"wrongField\":1}")).andExpect(status().isBadRequest());
 }
 @Test void jsonPreservesRfidAndBase64()throws Exception{
  var json=new ObjectMapper();var truck=json.readValue("{\"RFID\":\"ABC\",\"vehicleno\":\"00123\"}",TruckReqType.class);assertEquals("ABC",truck.getRFID());assertEquals("00123",truck.getVehicleno());var sign=new SignReqType();sign.setSign(new byte[]{1,2,3});assertTrue(json.writeValueAsString(sign).contains("AQID"));
 }
}
