package com.example.myapp.Model;

public class Location {
	private int Id;
	private String name;
	private double latitude;
	private double longitude;
	
	public Location(int id, String name, double latitude, double longitude) {
		Id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
