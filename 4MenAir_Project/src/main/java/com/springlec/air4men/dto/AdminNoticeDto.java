package com.springlec.air4men.dto;

import java.sql.Timestamp;

public class AdminNoticeDto {
	int board_num;
	String board_category;
	String board_user_name;
	String board_name;
	String board_contents;
	Timestamp board_create_date;
	Timestamp board_delete_date;
	
	
	
	//====================Constructor========================
	
	
	public AdminNoticeDto() {
		
	}


	//==========================공지사항 리스트 불러오기=======================
	public AdminNoticeDto(int board_num, String board_name, String board_contents, Timestamp board_create_date) {
		super();
		this.board_num = board_num;
		this.board_name = board_name;
		this.board_contents = board_contents;
		this.board_create_date = board_create_date;
	}
	
	
	
	
	
	
	
	//=================Getter Setter===========================




	public int getBoard_num() {
		return board_num;
	}



	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}



	public String getBoard_category() {
		return board_category;
	}



	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}



	public String getBoard_user_name() {
		return board_user_name;
	}



	public void setBoard_user_name(String board_user_name) {
		this.board_user_name = board_user_name;
	}



	public String getBoard_name() {
		return board_name;
	}



	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}



	public String getBoard_contents() {
		return board_contents;
	}



	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}



	public Timestamp getBoard_create_date() {
		return board_create_date;
	}



	public void setBoard_create_date(Timestamp board_create_date) {
		this.board_create_date = board_create_date;
	}



	public Timestamp getBoard_delete_date() {
		return board_delete_date;
	}



	public void setBoard_delete_date(Timestamp board_delete_date) {
		this.board_delete_date = board_delete_date;
	}
	
	
	
	
	
	
	
	
}
