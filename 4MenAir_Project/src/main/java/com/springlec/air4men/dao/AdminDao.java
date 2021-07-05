package com.springlec.air4men.dao;

import java.util.ArrayList;

import com.springlec.air4men.dto.AdminDto;
import com.springlec.air4men.dto.AdminQnaDto;
import com.springlec.air4men.dto.AdminUserDto;


public interface AdminDao {
	
	public AdminDto AdminLogin(String inputId, String inputPw);// 관리자 로그인

	public int loginCheck(String id, String pw);// 관리자 로그인 체크
	
//		int x = -1;
//
//			if (resultSet.next()) // 입려된 아이디에 해당하는 비번 있을경우
//			{
//				dbPW = resultSet.getString("AdminPw"); // 비번을 변수에 넣는다.
//
//				if (dbPW.equals(pw))
//					x = 1; // 넘겨받은 비번과 꺼내온 배번 비교. 같으면 인증성공
//				else
//					x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
//
//			} else {
//				x = -1; // 해당 아이디가 없을 경우
//			}


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