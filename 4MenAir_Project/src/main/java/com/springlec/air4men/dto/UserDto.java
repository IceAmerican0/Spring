package com.springlec.air4men.dto;

import java.sql.Timestamp;

public class UserDto {
	String userId;
	String userPw;
	String userName;
	String userTel;
	String userEmail;
	String userAdd;
	Timestamp userCRDate;
	Timestamp userDLDate;
	String userBirthday;
	
	
	
	//===========Constructor========================
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(String userId, String userPw, String userName,String userTel, String userEmail, String userAdd, Timestamp userDLDate, String userBirthday) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName=userName;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.userAdd = userAdd;
		this.userBirthday=userBirthday;
	}
	
	
	
	
	//=========Getter Setter========================

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAdd() {
		return userAdd;
	}

	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}

	public Timestamp getUserCRDate() {
		return userCRDate;
	}

	public void setUserCRDate(Timestamp userCRDate) {
		this.userCRDate = userCRDate;
	}

	public Timestamp getUserDLDate() {
		return userDLDate;
	}

	public void setUserDLDate(Timestamp userDLDate) {
		this.userDLDate = userDLDate;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	
	
	
	
}
