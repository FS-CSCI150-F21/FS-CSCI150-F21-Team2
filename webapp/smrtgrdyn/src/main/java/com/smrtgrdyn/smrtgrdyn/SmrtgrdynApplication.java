package com.smrtgrdyn.smrtgrdyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
Main Class for Smrt Grdyn Server


Current Status: DB disabled to allow launch
 */

@SpringBootApplication
public class SmrtgrdynApplication {

	public static void main(String[] args) {
		System.setProperty("user.timezone", "UTC");
		SpringApplication.run(SmrtgrdynApplication.class, args);
	}

}
