package com.training.tms.model;

public class TokenBean {

	private String key;
	private String token;
	
	public TokenBean() {
		
	}
	
	public TokenBean(String key, String token) {
		super();
		this.key = key;
		this.token = token;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
