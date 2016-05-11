package org.tkzc.aaabase.util;

public class User {

	private String userid;
	
	private String username;
	
	private String gender;

	public User(String userid, String username, String gender) {
		super();
		this.userid = userid;
		this.username = username;
		this.gender = gender;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
