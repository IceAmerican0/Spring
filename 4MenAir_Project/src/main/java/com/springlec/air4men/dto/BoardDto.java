package com.springlec.air4men.dto;

import java.sql.Timestamp;

public class BoardDto {
//==============게시글 전체============================
	int board_num;
	String board_category;
	String board_user_name;
	String board_name;
	String board_contents;
	Timestamp board_create_date;
	Timestamp board_delete_date;
	
	
	
//===================1대1문의 답변========================
	int qna_code;
	String qna_reply;
	String qnaAdminId;
	Timestamp qnarepdate;
	
	
//=====================Constructor======================
	
	
	public BoardDto() {
		
	}


	//=============================1대1 문의 리스트 ========================================
	public BoardDto(int board_num, String board_name, Timestamp board_create_date, Timestamp qnarepdate) {
		super();
		this.board_num = board_num;
		this.board_name = board_name;
		this.board_create_date=board_create_date;
		this.qnarepdate=qnarepdate;
	}
	
	
	
//============================선택한 1대1 문의 내용 불러오기=========================================
	public BoardDto(int board_num, String board_name, String board_contents, int qna_code, String qna_reply,
			String qnaAdminId, Timestamp qnarepdate) {
		super();
		this.board_num = board_num;
		this.board_name = board_name;
		this.board_contents = board_contents;
		this.qna_code = qna_code;
		this.qna_reply = qna_reply;
		this.qnaAdminId = qnaAdminId;
		this.qnarepdate = qnarepdate;
	}
	
	
	
	
	
	
//====================Getter Setter======================
	


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


	public int getQna_code() {
		return qna_code;
	}


	public void setQna_code(int qna_code) {
		this.qna_code = qna_code;
	}


	public String getQna_reply() {
		return qna_reply;
	}


	public void setQna_reply(String qna_reply) {
		this.qna_reply = qna_reply;
	}


	public String getQnaAdminId() {
		return qnaAdminId;
	}


	public void setQnaAdminId(String qnaAdminId) {
		this.qnaAdminId = qnaAdminId;
	}


	public Timestamp getQnarepdate() {
		return qnarepdate;
	}


	public void setQnarepdate(Timestamp qnarepdate) {
		this.qnarepdate = qnarepdate;
	}
	
	
}
