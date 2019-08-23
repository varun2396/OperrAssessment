package com.example.myapp.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Location {
	@Id
	private ObjectId _id;
	private String name;
	private double latitude;
	private double longitude;
    private double position[];
 
    public Location(ObjectId _id, String name, double latitude, double longitude, double[] position) {
		this._id = _id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.position = new double[]{latitude,longitude};
	}

    
    
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
		this.position[0] = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
		this.position[1] = longitude;
	}
	
	
	
}
