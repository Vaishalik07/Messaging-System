package com.luv2code.springdemo.entity;

public class Event {
	
	public String eventId;
	public String date;
	public String place;
	public String userId;
	
	public Event(String eventId, String date, String place, String userId) {
		this.eventId = eventId;
		this.date = date;
		this.place = place;
		this.userId = userId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getuserId() {
		return userId;
	}

	public void setuserId(String userId) {
		this.userId = userId;
	}
	
	
}
