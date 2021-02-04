package com.training.tms.model;

public class AuthRequest {
	
	private String userName;
	private String passWord;
	
	public AuthRequest() {
		
	}
	
	public AuthRequest(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
