package com.everis.bs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MicroServiceTO {

	@JsonProperty("JvmName")
	private String jvmName; 
	
	@JsonProperty("MicroServiceID")
	private String microServiceID; 
	
	@JsonProperty("MicroServiceType")
	private String microServiceType; 
	
	@JsonProperty("MicroServiceName")
	private String microServiceName; 
	
	@JsonProperty("MsOperationName")
	private String msOperationName; 
	
	@JsonProperty("RequestMapping")
	private String requestMapping;
	
	
	public String getJvmName() {
		return jvmName;
	}
	public void setJvmName(String jvmName) {
		this.jvmName = jvmName;
	}
	public String getMicroServiceID() {
		return microServiceID;
	}
	public void setMicroServiceID(String microServiceID) {
		this.microServiceID = microServiceID;
	}
	public String getMicroServiceType() {
		return microServiceType;
	}
	public void setMicroServiceType(String microServiceType) {
		this.microServiceType = microServiceType;
	}
	public String getMicroServiceName() {
		return microServiceName;
	}
	public void setMicroServiceName(String microServiceName) {
		this.microServiceName = microServiceName;
	}
	public String getMsOperationName() {
		return msOperationName;
	}
	public void setMsOperationName(String msOperationName) {
		this.msOperationName = msOperationName;
	}
	public String getRequestMapping() {
		return requestMapping;
	}
	public void setRequestMapping(String requestMapping) {
		this.requestMapping = requestMapping;
	}
		
}
