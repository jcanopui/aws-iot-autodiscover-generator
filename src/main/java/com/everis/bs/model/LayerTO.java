package com.everis.bs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LayerTO {

	@JsonProperty("MicroService")
	private MicroServiceTO microService;

	public LayerTO() {
		microService = new MicroServiceTO();
		// TODO Auto-generated constructor stub
	}

	public MicroServiceTO getMicroService() {
		return microService;
	}

	public void setMicroService(MicroServiceTO microService) {
		this.microService = microService;
	}
	
	
}
