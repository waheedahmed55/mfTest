package com.mftest.mftestread.model;

public class User {
	String first_name;
	String last_name;
	String siblings;
	String favourite_food;
	String birth_timezone;
	String birth_timestamp;
	
	private User() {
		// No args constructor to handle jackson library exception
	}

	public User(String first_name, String last_name, String siblings, String favourite_food, String birth_timezone,
			String birth_timestamp) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.siblings = siblings;
		this.favourite_food = favourite_food;
		this.birth_timezone = birth_timezone;
		this.birth_timestamp = birth_timestamp;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getSiblings() {
		return siblings;
	}
	public String getFavourite_food() {
		return favourite_food;
	}
	public String getBirth_timezone() {
		return birth_timezone;
	}
	public String getBirth_timestamp() {
		return birth_timestamp;
	}
	
}
