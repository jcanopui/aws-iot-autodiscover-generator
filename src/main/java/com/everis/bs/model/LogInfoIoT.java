package com.everis.bs.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class LogInfoIoT {
	
	@JsonProperty("IoT")
	private IotMessageTO iotMessage;
	
	

	public LogInfoIoT() {
		iotMessage = new IotMessageTO();
	}



	public IotMessageTO getIotMessage() {
		return iotMessage;
	}



	public void setIotMessage(IotMessageTO iotMessage) {
		this.iotMessage = iotMessage;
	}
	
}
