package com.yqz.webapp.model;


public class MyMessage {
	public MyMessage() {
	}

	public MyMessage(String msg) {
		this.message = msg;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
