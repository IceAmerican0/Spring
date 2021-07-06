package com.springlec.air4men.dao;

import com.springlec.air4men.dto.UserDto;

public interface UserDao {
	
	
	// 회원가입
	
	public void RegisterAction(String userId,String userPw,String userName,String userTel,String userEmail,String userAdd,String userBirthday);		
	
	// 아이디 찾기
	
	public UserDto IdfindAction(String userName,String userTel,String userEmail);
	
	// 비밀번호찾기
	
	public UserDto PwfindAction(String userId,String userTel,String userEmail);	
	
	// 사용자 정보 불러오기
	
	public UserDto  LoginAction(String userId);	
	
	// 유저 로그인 체크 
	
	public UserDto LoginCheck(String id, String pw);
	
	
}
