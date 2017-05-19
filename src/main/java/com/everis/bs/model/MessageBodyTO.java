package com.everis.bs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageBodyTO {

	@JsonProperty("Description")
	private String description; 
	
	@JsonProperty("Detail")
	private String detail;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
