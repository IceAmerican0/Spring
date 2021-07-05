package com.springlec.air4men.dao;

import java.util.ArrayList;


import com.springlec.air4men.dto.NoticeDto;

public interface NoticeDao {
	
	public ArrayList<NoticeDto> list();// 공지사항 리스트 불러오기
	
	public void AdminNoticeWriteAction(String board_name,String board_contents); // 공지사항 작성하기

	public NoticeDto AdminNoticeSelectedAction(int boardNum); // 선택한 공지사항 불러오기
	
	public void AdminNoticeModifyAction(String board_name,String board_contents,int boardNum); // 선택한 문의 내역 수정하기	
		
	public void AdminNoticeDeleteAction(String board_num); // 선택한 문의 내역 삭제하기
	
}
