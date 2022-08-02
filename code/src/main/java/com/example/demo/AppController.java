package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping
	public String getUTC() {
		Date date = new Date();
		//HH:mm:ss 24 hour format
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm aa");

		// Use Madrid's time zone to format the date in
		df.setTimeZone(TimeZone.getTimeZone("America/Chicago"));

		String message = "UTC Date and Time " + df.format(date) + "<br>";
		
		StringBuilder result = showTimeZones(message);
		
		return result.toString();
	}
	
	
//	@GetMapping(value = "/users/{id}")
//	public String getUser(@PathVariable("id") String id) {
//		return id;
//	}
	
	@PostMapping(value = "/")
	public String postTimeZone(@RequestBody TimeZonePacket packet) {
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm aa");

		// Use Madrid's time zone to format the date in
		df.setTimeZone(TimeZone.getTimeZone(packet.getTimezone()));
		String message = "Date and Time for "+ packet.getTimezone() +": "  + df.format(date) + "<br>";
		StringBuilder result = showTimeZones(message);
		
		return result.toString() ;
	}
	
	
	private StringBuilder showTimeZones(String message) {
		
		
		StringBuilder html = new StringBuilder(message);
	
		html.append("<br>");
		html.append("<b>List of Available Time Zones: </b> <br>");
		html.append("<br>");
		
	    String[] id = TimeZone.getAvailableIDs();
	  
	    for (int i = 0; i< id.length; i++) {
	    	html.append(id[i] + "<br>");
	    }
		
		return html;
	}
}
