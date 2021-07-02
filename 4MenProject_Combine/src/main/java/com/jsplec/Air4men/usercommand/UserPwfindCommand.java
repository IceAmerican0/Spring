package com.jsplec.Air4men.usercommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.UserDao;

public class UserPwfindCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String userId=request.getParameter("userId");
		String userTel=request.getParameter("userTel");
		String userEmail1=request.getParameter("userEmail1");
		String userEmail2=request.getParameter("userEmail2");
		String userEmail=userEmail1+userEmail2;
		
		
		UserDao userDao=new UserDao();
		String userPw=userDao.PwfindAction(userId, userTel, userEmail);
		request.setAttribute("userId", userId);
		request.setAttribute("FinduserPw", userPw);

	}

}
