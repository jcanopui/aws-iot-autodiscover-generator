package com.everis.bs.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class IotMessageTO implements Serializable {

	private static final long serialVersionUID = -6914812685534077807L;
    private static final double LONGITUDE_BCN = 41.3818;
    private static final double LATITUDE_BCN = 2.1685;
    private static final int RADIUS_BCN = 1000;
    
	private String thingId;
	private String thingType;
	private GeoLocationTO position;
	private Date date;
	
	public IotMessageTO() {
		super();
		this.position = new GeoLocationTO();
		this.position.calculateLocation(LONGITUDE_BCN, LATITUDE_BCN, RADIUS_BCN);
	}

	public String getThingId() {
		return thingId;
	}

	public void setThingId(String thingId) {
		this.thingId = thingId;
	}

	public String getThingType() {
		return thingType;
	}

	public void setThingType(String thingType) {
		this.thingType = thingType;
	}

	public GeoLocationTO getPosition() {
		return position;
	}

	public void setPosition(GeoLocationTO position) {
		this.position = position;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
