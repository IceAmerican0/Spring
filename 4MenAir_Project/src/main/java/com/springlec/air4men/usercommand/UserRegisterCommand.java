package com.springlec.air4men.usercommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.UserDao;

public class UserRegisterCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userId=request.getParameter("userId");
		String userPw1=request.getParameter("userPw1");
		String userName=request.getParameter("userName");
		String userTel=request.getParameter("userTel");
		String userEmail1=request.getParameter("userEmail1");
		String userEmail2=request.getParameter("userEmail2");
		String userEmail=userEmail1+userEmail2;
		String userAdd=request.getParameter("userAdd");
		String userBirthday=request.getParameter("userBirthday");
		
		UserDao userDao=sqlSession.getMapper(UserDao.class);
		userDao.RegisterAction(userId, userPw1, userName, userTel, userEmail, userAdd,userBirthday);
	}

}
