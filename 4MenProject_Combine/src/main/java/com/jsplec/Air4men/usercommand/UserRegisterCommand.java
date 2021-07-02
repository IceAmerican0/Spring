package com.jsplec.Air4men.usercommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.UserDao;

public class UserRegisterCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		String userPw1=request.getParameter("userPw1");
		String userName=request.getParameter("userName");
		String userTel=request.getParameter("userTel");
		String userEmail1=request.getParameter("userEmail1");
		String userEmail2=request.getParameter("userEmail2");
		String userEmail=userEmail1+userEmail2;
		String userAdd=request.getParameter("userAdd");
		String userBirthday=request.getParameter("userBirthday");
		
		UserDao userRegisterDao=new UserDao();
		userRegisterDao.RegisterAction(userId, userPw1, userName, userTel, userEmail, userAdd,userBirthday);
	}

}
