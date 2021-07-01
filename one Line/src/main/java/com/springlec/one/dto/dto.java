package com.springlec.one.dto;

import java.sql.Timestamp;

public class dto {

	int bId;
	String bName;
	String bTitle;
	String bContent;
	Timestamp bDate;
	
	public dto() {
		// TODO Auto-generated constructor stub
	}
	
	public dto(int bId, String bName, String bTitle, String bContent, java.sql.Timestamp bDate) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public java.sql.Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(java.sql.Timestamp bDate) {
		this.bDate = bDate;
	}
	
	
	
	
	
}
