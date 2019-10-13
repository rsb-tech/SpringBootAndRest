package com.mycomp.cards.exception;

import java.util.Date;

public class CustomExceptionMessage {
	private Date timestamp;
	private String uri;
	private String developerMsg;
	private String exceptionMessage;
	public CustomExceptionMessage(Date timestamp, String uri, String exceptionMessage) {
		this.timestamp = timestamp;
		this.uri = uri;
		this.exceptionMessage = exceptionMessage;
	}
	public CustomExceptionMessage(Date timestamp, String uri, String developerMsg,String exceptionMessage) {
		this.timestamp = timestamp;
		this.uri = uri;
		this.developerMsg = developerMsg;
		this.exceptionMessage = exceptionMessage;
	}
	public Date getTimestamp() {
		return timestamp;
	}

	public String getUri() {
		return uri;
	}
	public String getDeveloperMsg() {
		return developerMsg;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	
}
