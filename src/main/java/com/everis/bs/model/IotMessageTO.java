package com.everis.bs.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class IotMessageTO implements Serializable {

	public static final long serialVersionUID = -6914812685534077807L;
	public static final double LONGITUDE_BCN = 2.1685;
	public static final double LATITUDE_BCN = 41.3818;
	public static final int RADIUS_BCN = 1000000;
    
	private String thingId;
	private String thingType;
	private GeoLocationTO position;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date dateTime;
	private String category;
	
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
