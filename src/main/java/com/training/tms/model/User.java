package com.training.tms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	
	private String password;		
	
	private String userName;		
	
	private String firstname;	
	
	private String lastname;	
	
	private String emailid;
	
	public User() {
		 
	 }


	public User(int userID, String password, String userName, String firstname, String lastname, String emailid) {
		super();
		this.userID = userID;
		this.password = password;
		this.userName = userName;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
	
}	