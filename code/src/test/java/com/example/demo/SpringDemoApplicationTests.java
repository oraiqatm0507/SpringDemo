package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDemoApplicationTests {

	AppController app = new AppController();
	
	@Test
	void contextLoads() {
		Date date = new Date();
		//HH:mm:ss 24 hour format
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm aa");

		// Use Madrid's time zone to format the date in
		df.setTimeZone(TimeZone.getTimeZone("America/Chicago"));

		String correctSol ="Date and Time for " + "UTC" + ": " + df.format(date) + "<br>";
		
		String testResult = app.GetLocalDateTime("UTC","America/Chicago");
		
		assert(testResult.equals(correctSol));
		
	}

	@Test
	void LosAngels() {
		Date date = new Date();
		//HH:mm:ss 24 hour format
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh.mm aa");

		// Use Madrid's time zone to format the date in
		df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));

		String correctSol ="Date and Time for " + "UTC" + ": " + df.format(date) + "<br>";
		
		String testResult = app.GetLocalDateTime("UTC","America/Los_Angeles");
		
		assert(testResult.equals(correctSol));
		
	}

}
