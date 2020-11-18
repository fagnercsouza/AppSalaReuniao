package com.appreuniao.exception;

import java.util.Date;

public class ErroDetails {
	
	private Date timestamp;
	private String message;
	private String details;
	
	
	public ErroDetails(Date timespam, String message, String details) {
		super();
		this.timestamp = timespam;
		this.message = message;
		this.details = details;
	}


	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
