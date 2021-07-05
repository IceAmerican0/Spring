package com.springlec.air4men.dao;

import com.springlec.air4men.dto.UserDto;

public interface UserDao {
	
	
	// 회원가입
	
	public void RegisterAction(String userId,String userPw,String userName,String userTel,String userEmail,String userAdd,String userBirthday);		
	
	// 아이디 찾기
	
	public String IdfindAction(String userName,String userTel,String userEmail);
	
	// 비밀번호찾기
	
	public String PwfindAction(String userId,String userTel,String userEmail);	
	
	// 사용자 정보 불러오기
	
	public UserDto  LoginAction(String userId);	
	
	// 유저 로그인 체크 
	
	public int LoginCheck(String id, String pw);
 
//            if (resultSet.next()) // 입려된 아이디에 해당하는 비번 있을경우
//            {
//                dbPW = resultSet.getString("userPw"); // 비번을 변수에 넣는다.
// 
//                if (dbPW.equals(pw)) 
//                    x = 1; // 넘겨받은 비번과 꺼내온 배번 비교. 같으면 인증성공
//                else                  
//                    x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
//                
//            } else {
//                x = -1; // 해당 아이디가 없을 경우
//            }
	
	
}
