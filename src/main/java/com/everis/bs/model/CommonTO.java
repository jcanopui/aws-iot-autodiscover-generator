package com.everis.bs.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonTO {

	@JsonProperty("EventTimestamp")
	private String eventTimestamp;
	
	@JsonProperty("EventTimestampDelay")
	private Integer eventTimestampDelay;
	
	@JsonProperty("EventType")
	private String eventType;
	
	@JsonProperty("EventCode")
	private String eventCode;
	
	@JsonProperty("HostName")
	private String hostName;
	
	@JsonProperty("TrackingId")
	private String trackingId;
	
	@JsonProperty("SourceApplication")
	private String sourceApplication;
	
	@JsonProperty("StartLayerTimestamp")
	private String startLayerTimestamp;
	
	@JsonProperty("ArchitectureVersion")
	private String architectureVersion;
	
	@JsonProperty("Error")
	private String error;
	
	@JsonProperty("Version")
	private String version;
	
	@JsonProperty("UserId")
	private String userId;
	
	
	public String getEventTimestamp() {
		return eventTimestamp;
	}
	public void setEventTimestamp(String eventTimestamp) {
		this.eventTimestamp = eventTimestamp;
	}
	public Integer getEventTimestampDelay() {
		return eventTimestampDelay;
	}
	public void setEventTimestampDelay(Integer eventTimestampDelay) {
		this.eventTimestampDelay = eventTimestampDelay;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}
	public String getSourceApplication() {
		return sourceApplication;
	}
	public void setSourceApplication(String sourceApplication) {
		this.sourceApplication = sourceApplication;
	}
	public String getStartLayerTimestamp() {
		return startLayerTimestamp;
	}
	public void setStartLayerTimestamp(String startLayerTimestamp) {
		this.startLayerTimestamp = startLayerTimestamp;
	}
	public String getArchitectureVersion() {
		return architectureVersion;
	}
	public void setArchitectureVersion(String architectureVersion) {
		this.architectureVersion = architectureVersion;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
