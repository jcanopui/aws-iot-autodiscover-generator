package com.everis.bs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuditMessageTO {

	@JsonProperty("Common")
	private CommonTO common;
	@JsonProperty("Layer")
	private LayerTO layer;
	@JsonProperty("MessageBody")
	private MessageBodyTO messageBody;
	

	public AuditMessageTO() {
		common = new CommonTO();
		layer = new LayerTO();
		messageBody = new MessageBodyTO();
	}

	public CommonTO getCommon() {
		return common;
	}

	public void setCommon(CommonTO Common) {
		this.common = Common;
	}

	public LayerTO getLayer() {
		return layer;
	}

	public void setLayer(LayerTO Layer) {
		this.layer = Layer;
	}

	public MessageBodyTO getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(MessageBodyTO MessageBody) {
		this.messageBody = MessageBody;
	}
	
	
}
