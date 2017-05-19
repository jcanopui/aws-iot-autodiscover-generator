package com.everis.bs.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class LogInfoTO {
	
	@JsonProperty("AuditMessage")
	private AuditMessageTO auditMessage;
	
	

	public LogInfoTO() {
		auditMessage = new AuditMessageTO();
	}

	public AuditMessageTO getAuditMessage() {
		return auditMessage;
	}

	public void setAuditMessage(AuditMessageTO AuditMessage) {
		this.auditMessage = AuditMessage;
	}
	
}
