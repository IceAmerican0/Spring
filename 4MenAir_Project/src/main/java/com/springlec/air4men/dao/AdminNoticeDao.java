package com.springlec.air4men.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.springlec.air4men.dto.AdminNoticeDto;

public interface AdminNoticeDao {
	
	public ArrayList<AdminNoticeDto> list();//공지사항 리스트 불러오기
	
	public void AdminNoticeWriteAction(String board_name,String board_contents); // 공지사항 작성하기
	
	public AdminNoticeDto AdminNoticeSelectedAction(int boardNum);
			
	public void AdminNoticeModifyAction(String board_name,String board_contents,int boardNum);// 선택한 문의 내역 수정하기		
		
	public void AdminNoticeDeleteAction(String board_num);// 선택한 문의 내역 삭제하기
		
	
}
