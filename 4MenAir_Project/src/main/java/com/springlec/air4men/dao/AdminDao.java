package com.springlec.air4men.dao;

import java.util.ArrayList;

import com.springlec.air4men.dto.AdminDto;
import com.springlec.air4men.dto.AdminQnaDto;
import com.springlec.air4men.dto.AdminUserDto;


public interface AdminDao {
	
	public AdminDto AdminLogin(String inputId, String inputPw);// 관리자 로그인

	public int loginCheck(String id, String pw);// 관리자 로그인 체크

	public ArrayList<AdminUserDto> list();//  회원 리스트 
	
	public AdminUserDto oneSelectMember(String userid);// 회원 보기
	
	public void deleteMember(String userid);// 회원 탈퇴
	
	public ArrayList<AdminUserDto> Deletelist();// 탈퇴 회원 리스트
	
	public AdminUserDto oneSelectDeleteMember(String userid);//  탈퇴한 회원 보기	
	
	public void RecoveryMember(String userid);// 탈퇴한 회원 복구
	
	public ArrayList<AdminQnaDto> Qnalist();// 1:1 문의 리스트
	
	public AdminQnaDto oneSelectQnaMember(String boardNum);// 1:1 문의 보기
	
	public void QnaReply(String QnAReply,String num );// 1:1 문의 답변하기
		
}