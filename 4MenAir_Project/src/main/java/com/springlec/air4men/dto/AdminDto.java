package com.springlec.air4men.dto;

public class AdminDto {
	
	String AdminId;
	String AdminPw;
	String AdminTel;
	String AdminEmail;
	
	
	//===========Constructor========================
	
	public AdminDto() {
		
	}
	

	public AdminDto(String adminId, String adminPw, String adminTel, String adminEmail) {
		super();
		this.AdminId = adminId;
		this.AdminPw = adminPw;
		this.AdminTel = adminTel;
		this.AdminEmail = adminEmail;
	}

	//=========Getter Setter========================

	public String getAdminId() {
		return AdminId;
	}


	public void setAdminId(String adminId) {
		AdminId = adminId;
	}


	public String getAdminPw() {
		return AdminPw;
	}


	public void setAdminPw(String adminPw) {
		AdminPw = adminPw;
	}


	public String getAdminTel() {
		return AdminTel;
	}


	public void setAdminTel(String adminTel) {
		AdminTel = adminTel;
	}


	public String getAdminEmail() {
		return AdminEmail;
	}


	public void setAdminEmail(String adminEmail) {
		AdminEmail = adminEmail;
	}
	
	
}
