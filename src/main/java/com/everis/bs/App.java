package com.everis.bs;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.everis.bs.service.ServiceLogs;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	
    public static void main( String[] args )
    {
    	int numThreads = Integer.valueOf(args[0]);
		int numTasks = Integer.valueOf(args[1]);
		int numLoop = Integer.valueOf(args[2]);
		int queriesPerSecond = Integer.valueOf(args[3]);
		String rutaLogs = args[4];

		String fechaInit = args[5];
		
		if(rutaLogs == null){
			System.setProperty("logPath", "./logs");
		} else {
			System.setProperty("logPath", rutaLogs);
		}
    	ApplicationContext ctx = SpringApplication.run(App.class, args);
    	ExecutorService executor = Executors.newFixedThreadPool(numThreads);
    	ZonedDateTime localStart = ZonedDateTime.now();

    		
		System.out.println("Start: " + localStart.format(DateTimeFormatter.ISO_INSTANT));
        ZonedDateTime dateInit = ZonedDateTime.parse(fechaInit + "T00:00:00.000Z");
        for (Integer i=0; i<numTasks;i++) {
	        ServiceLogs serviceLogs = ctx.getBean(ServiceLogs.class);
	        serviceLogs.setLoop(numLoop);
	        serviceLogs.setCount(numTasks);
	        serviceLogs.setLocalStart(localStart);
	        serviceLogs.setDelayTimeInMs(getDelayTimeInMs(queriesPerSecond, numTasks, numLoop));
        	serviceLogs.setDateInit(dateInit.plusDays(i));
        	executor.execute(serviceLogs);
        }
        try{
        	executor.shutdown();
        	executor.awaitTermination((numTasks * numLoop * 2), TimeUnit.SECONDS);
        }catch (InterruptedException e) {
        	logger.error("Error:",e);
		}finally{
			if(executor.isTerminated()){
				System.out.println("Shutdown now: " + ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
			}
			executor.shutdownNow();
			
		}
    	
    }
    
	private static int getDelayTimeInMs(int queriesPerSecond, int numTasks, int numLoop) {
		int delayTimeInMs = 0;
		
		if (queriesPerSecond > 0) {
			delayTimeInMs = (1000 * numTasks) / queriesPerSecond;
		}

		return delayTimeInMs;
	}

	@Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ObjectMapper getObjectMapper() {
    	return new ObjectMapper();
    }
}
