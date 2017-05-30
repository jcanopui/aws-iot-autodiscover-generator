package com.everis.bs.model;

import java.io.Serializable;
import java.util.Random;

public class GeoLocationTO implements Serializable {

	private static final long serialVersionUID = -4092705993117204184L;
	
	private double lat;
	private double lon;
	
	public GeoLocationTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void calculateLocation(double plongitude, double platitude, int radius) {
	    Random random = new Random();

	    // Convert radius from meters to degrees
	    double radiusInDegrees = radius / 111000f;

	    double u = random.nextDouble();
	    double v = random.nextDouble();
	    double w = radiusInDegrees * Math.sqrt(u);
	    double t = 2 * Math.PI * v;
	    double x = w * Math.cos(t);
	    double y = w * Math.sin(t);

	    // Adjust the x-coordinate for the shrinking of the east-west distances
	    double new_x = x / Math.cos(Math.toRadians(platitude));

	    lon = new_x + plongitude;
	    lat = y + platitude;
	}


	public double getLat() {
		return lat;
	}


	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLon() {
		return lon;
	}


	public void setLon(double lon) {
		this.lon = lon;
	}
}
