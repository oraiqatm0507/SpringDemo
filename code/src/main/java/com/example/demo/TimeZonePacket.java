package com.example.demo;

public class TimeZonePacket {
	
	private String timezone;
	
	public TimeZonePacket() {}
	
	public TimeZonePacket(String timezone) {
		super();
		System.out.println("I am called");
		this.timezone = timezone;
	}
	
	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	
	

	
	
}
