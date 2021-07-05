package com.springlec.air4men.dto;

import java.sql.Timestamp;

public class AdminQnaDto {
	
	String QnA_Code;
	int Board_Num;
	String QnAReply;
	String QnAAdminId;
	String Board_Name;
	String Board_Contents;
	Timestamp Board_Create_Date;
	Timestamp QnARepDate;
	
	//===========Constructor========================
	
	public AdminQnaDto() {
		
	}

	public AdminQnaDto(String qnA_Code, int board_Num, String qnAReply, String qnAAdminId, String board_Name,
			String board_Contents, Timestamp board_Create_Date, Timestamp qnARepDate) {
		super();
		this.QnA_Code = qnA_Code;
		this.Board_Num = board_Num;
		this.QnAReply = qnAReply;
		this.QnAAdminId = qnAAdminId;
		this.Board_Name = board_Name;
		this.Board_Contents = board_Contents;
		this.Board_Create_Date = board_Create_Date;
		this.QnARepDate = qnARepDate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//====================Getter Setter=============================

	public String getQnA_Code() {
		return QnA_Code;
	}

	public void setQnA_Code(String qnA_Code) {
		QnA_Code = qnA_Code;
	}

	public int getBoard_Num() {
		return Board_Num;
	}

	public void setBoard_Num(int board_Num) {
		Board_Num = board_Num;
	}

	public String getQnAReply() {
		return QnAReply;
	}

	public void setQnAReply(String qnAReply) {
		QnAReply = qnAReply;
	}

	public String getQnAAdminId() {
		return QnAAdminId;
	}

	public void setQnAAdminId(String qnAAdminId) {
		QnAAdminId = qnAAdminId;
	}

	public String getBoard_Name() {
		return Board_Name;
	}

	public void setBoard_Name(String board_Name) {
		Board_Name = board_Name;
	}

	public String getBoard_Contents() {
		return Board_Contents;
	}

	public void setBoard_Contents(String board_Contents) {
		Board_Contents = board_Contents;
	}

	public Timestamp getBoard_Create_Date() {
		return Board_Create_Date;
	}

	public void setBoard_Create_Date(Timestamp board_Create_Date) {
		Board_Create_Date = board_Create_Date;
	}

	public Timestamp getQnARepDate() {
		return QnARepDate;
	}

	public void setQnARepDate(Timestamp qnARepDate) {
		QnARepDate = qnARepDate;
	}

	
	
}
