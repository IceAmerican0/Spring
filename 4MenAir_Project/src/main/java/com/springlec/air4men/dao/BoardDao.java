package com.springlec.air4men.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.springlec.air4men.dto.BoardDto;

public interface BoardDao {
	
	public ArrayList<BoardDto> list(String userId);// 문의 내역 리스트 불러오기
	
	public void userQnaWriteAction(String userId,String board_name,String board_contents); // 문의 사항 작성하기 1
	
	public void userQnaWriteAction2(String userId,String board_name,String board_contents); // 문의 사항 작성하기 2(qna 빈 답변 만들기)	

	public BoardDto userQnaSelectedAction(int boardNum);// 선택한 문의 내역 불러오기
	
	public void userQnaModifyAction(String board_name,String board_contents,int boardNum);// 선택한 문의 내역 수정하기
		
	public void userQnaDeleteAction(String board_num);// 선택한 문의 내역 삭제하기
	
	
}
