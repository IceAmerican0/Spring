package com.jsplec.Air4men.dao;

import java.sql.Connection;			
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.catalina.User;

import com.jsplec.Air4men.dto.UserDto;

public class UserDao {
	DataSource datasource;
	
	public UserDao() {
		try {
			Context context = new InitialContext();
			datasource=(DataSource) context.lookup("java:comp/env/jdbc/4menair");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//==============회원가입==================================================
	
	public void RegisterAction(String userId,String userPw,String userName,String userTel,String userEmail,String userAdd,String userBirthday) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
			connection=datasource.getConnection();
			
			String query="insert into userinfo (userId,userPw,userName,userTel,userEmail,userAdd,userCRDate,userBirthday) values (?,?,?,?,?,?,now(),?)";
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPw);
			preparedStatement.setString(3, userName);			
			preparedStatement.setString(4, userTel);
			preparedStatement.setString(5, userEmail);
			preparedStatement.setString(6, userAdd);
			preparedStatement.setString(7, userBirthday);			
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//=================아이디 찾기==========================
	
	public String IdfindAction(String userName,String userTel,String userEmail) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		String userId="";
		
		try {
			connection=datasource.getConnection();
			
			String query="select userId from userinfo where userName=? and userTel=? and userEmail=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,userName);
			preparedStatement.setString(2,userTel);
			preparedStatement.setString(3,userEmail);
			System.out.println(preparedStatement);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) userId=resultSet.getString("userId");

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
		return userId;
	}
	
	
	//==========================비밀번호찾기===================================
	
	public String PwfindAction(String userId,String userTel,String userEmail) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		String userPw="";
		
		try {
			connection=datasource.getConnection();
			
			String query="select userPw from userinfo where userId=? and userTel=? and userEmail=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,userId);
			preparedStatement.setString(2,userTel);
			preparedStatement.setString(3,userEmail);
			resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next()) userPw=resultSet.getString("userPw");

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
		return userPw;
	}
	
	
	
	//============================사용자 정보 불러오기=========================================
	
	public UserDto  LoginAction(String userId) {
		UserDto dto=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		
		try {
			connection=datasource.getConnection();
			
			String query="select userId,userPw,userName,userTel,userEmail,userAdd,userDLDate,userBirthday from UserInfo where UserId=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,userId);
			
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String getuserId=resultSet.getString("userId");
				String userPw=resultSet.getString("userPw");
				String userName=resultSet.getString("userName");
				String userTel=resultSet.getString("userTel");
				String userEmail=resultSet.getString("userEmail");
				String userAdd=resultSet.getString("userAdd");
				Timestamp userDLDate=resultSet.getTimestamp("userDLDate");
				String userBirthday=resultSet.getString("userBirthday");
				
				dto=new UserDto(getuserId, userPw, userName, userTel, userEmail, userAdd, userDLDate,userBirthday);
			}
			
			

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
		
		return dto;
		
	}
	
	
	//=============================== 유저 로그인 체크 ===============================
	
	public int loginCheck(String id, String pw) 
    {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null; // select할 때만 씀
 
        String dbPW = ""; // db에서 꺼낸 비밀번호를 담을 변수
        int x = -1;
 
        try {
            // 쿼리 - 먼저 입력된 아이디로 DB에서 비밀번호를 조회한다.
            String query="select userPw from userinfo where userId=?";
 
            connection = datasource.getConnection();
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
 
            if (resultSet.next()) // 입려된 아이디에 해당하는 비번 있을경우
            {
                dbPW = resultSet.getString("userPw"); // 비번을 변수에 넣는다.
 
                if (dbPW.equals(pw)) 
                    x = 1; // 넘겨받은 비번과 꺼내온 배번 비교. 같으면 인증성공
                else                  
                    x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
                
            } else {
                x = -1; // 해당 아이디가 없을 경우
            }
 
 
        }catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
        
        return x;
    }
	
	
	
	
}
