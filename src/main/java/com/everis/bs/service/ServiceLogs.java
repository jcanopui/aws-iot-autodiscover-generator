package com.everis.bs.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.rmi.server.UID;
import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.everis.bs.model.AuditMessageTO;
import com.everis.bs.model.CommonTO;
import com.everis.bs.model.IotConstants;
import com.everis.bs.model.IotMessageTO;
import com.everis.bs.model.LayerTO;
import com.everis.bs.model.LogInfoIoT;
import com.everis.bs.model.LogInfoTO;
import com.everis.bs.utils.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Scope("prototype")
public class ServiceLogs implements Runnable {
	
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private LogInfoTO logInfoTO;
//	@Autowired
//	private LogInfoIoT logInfoIoT_TO;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private int count = 0;
	private int numLoop = 1;
	private int delayTimeInMs;

	private ZonedDateTime localStart;
	private ZonedDateTime dateInit;
	
	private static long thingIdCount = 0;

	private Random random;
	
	public ServiceLogs() {
		random = new Random();	
	}

	@Override
	public void run() {
		for (int i = 0; i < numLoop; i++) {
			long dat = dateInit.toInstant().toEpochMilli() + 17;
			dateInit = ZonedDateTime.parse(Instant.ofEpochMilli(dat).toString());
			writelog();
			if (delayTimeInMs > 0) {
				try {
					Thread.sleep(delayTimeInMs);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
//		--count;
//		if(count <=0){ 
//			ZonedDateTime localEnd = ZonedDateTime.now();
//			System.out.println("End: " + localEnd.format(DateTimeFormatter.ISO_INSTANT));
//		    System.out.println("Final Time: " + getFinalTime(localEnd));
//		}
	}

	public void writelog() {
		//Object to JSON in String
		try {
//			logger.info(mapper.writeValueAsString(createAuditMessage()));
			logger.info(mapper.writeValueAsString(createIoTMessage()));
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage(), e);
		}

	}
	
	public LogInfoIoT createIoTMessage() {
    	UID thingId = new UID();
    	LogInfoIoT result = new LogInfoIoT();
    	result.getIotMessage().setDateTime(new Date());
    	result.getIotMessage().setThingId(Long.toString(thingIdCount++));//thingId.toString());
    	result.getIotMessage().setThingType(IotConstants.LISTTHINGTYPE.get(random.nextInt(IotConstants.LISTTHINGTYPE.size())));  
    	result.getIotMessage().setCategory(IotConstants.LISTTHINGCOLOR.get(random.nextInt(IotConstants.LISTTHINGCOLOR.size())));  
    	result.getIotMessage().getPosition().
    		calculateLocation(IotMessageTO.LONGITUDE_BCN, IotMessageTO.LATITUDE_BCN, IotMessageTO.RADIUS_BCN);
    	
    	return result;
	}
	
	public LogInfoTO createAuditMessage(){
		createCommon();
		createMicroService();
		createMessageBody();
		return logInfoTO;
	}
	
	public void createCommon(){
		UID userId = new UID();
		CommonTO common = logInfoTO.getAuditMessage().getCommon();
		
		String timer = dateInit.format(DateTimeFormatter.ISO_INSTANT);
		common.setEventTimestamp(timer);
		common.setEventTimestampDelay(random.nextInt(999));
		common.setEventType(Constants.LISTEVENTTYPE.get(random.nextInt(Constants.LISTEVENTTYPE.size())));
		common.setEventCode(Constants.LISTEVENTCODE.get(random.nextInt(Constants.LISTEVENTCODE.size())));
		common.setHostName("XCUBOSF"+ userId.toString() +".bancsabadell.com");
		common.setTrackingId(UUID.randomUUID().toString());
		common.setSourceApplication(Constants.SOURCEAPPLICATION.get(random.nextInt(Constants.SOURCEAPPLICATION.size())));
		common.setStartLayerTimestamp(timer);
		common.setArchitectureVersion("1.0.0-2");
//		common.setError(); null
		common.setVersion("1.0.0-2");
		common.setUserId(userId.toString());
	}
	
	public void createMicroService(){
		int index = random.nextInt(255);
		LayerTO layer = logInfoTO.getAuditMessage().getLayer();
		layer.getMicroService().setJvmName("1.8.0_73-b02");
		layer.getMicroService().setMicroServiceID("service-"+index);
		layer.getMicroService().setMicroServiceType("architecture");
		layer.getMicroService().setMicroServiceName("service-"+index);
		layer.getMicroService().setMsOperationName("addChannelLogMessage(com.bs.proteo.microservices.architecture.loggingserver.domain.FrontLogDTO)");
		layer.getMicroService().setRequestMapping("/add/Channel/LogMessage");
	}
	
	public void createMessageBody(){
		AuditMessageTO auditMessageTO = logInfoTO.getAuditMessage();
		auditMessageTO.getMessageBody().setDescription("MessageBody with eventCode: " + auditMessageTO.getCommon().getEventCode());
		auditMessageTO.getMessageBody().setDetail("Detail with eventCode: " + auditMessageTO.getCommon().getEventCode());
	}
	
	public void createList(List<String> listValue, String files){
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(files).getFile());
		
		try (Stream<String> stream = Files.lines(file.toPath())) {
		   stream.forEach(listValue::add);
		} catch (IOException e) {
		   e.printStackTrace();
		}
	}
	
	public String getFinalTime(ZonedDateTime localEnd){
		
		Duration duration = Duration.between(localStart, localEnd);

		long millis = duration.toMillis();
		System.out.println("Total time Millis: " + millis);
		System.out.println("Total time Seconds: " + duration.getSeconds());
		long days = TimeUnit.MILLISECONDS.toDays(millis);
	    millis -= TimeUnit.DAYS.toMillis(days);
	    long hours = TimeUnit.MILLISECONDS.toHours(millis);
	    millis -= TimeUnit.HOURS.toMillis(hours);
	    long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
	    millis -= TimeUnit.MINUTES.toMillis(minutes);
	    long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
	    millis -= TimeUnit.SECONDS.toMillis(seconds);
	    return String.format(" %d days, hours: %d:%d:%d.%d ", days, hours, minutes, seconds, millis);
	}
	
	public void setLoop(int numLoop) {
		this.numLoop  = numLoop;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setLocalStart(ZonedDateTime localStart) {
		this.localStart = localStart;
	}

	public int getDelayTimeInMs() {
		return delayTimeInMs;
	}

	public void setDelayTimeInMs(int delayTimeInMs) {
		this.delayTimeInMs = delayTimeInMs;
	}
	
	public ZonedDateTime getDateInit() {
		return dateInit;
	}

	public void setDateInit(ZonedDateTime dateInit) {
		this.dateInit = dateInit;
	}
	
}
