package com.jsplec.Air4men.usercommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.UserDao;

public class UserIdfindCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String userName=request.getParameter("userName");
		String userEmail1=request.getParameter("userEmail1");
		String userEmail2=request.getParameter("userEmail2");
		String userEmail=userEmail1+userEmail2;
		String userTel=request.getParameter("userTel");
		
		
		UserDao userDao=new UserDao();
		String userId=userDao.IdfindAction(userName, userTel, userEmail);
		request.setAttribute("userName", userName);
		request.setAttribute("FinduserId", userId);
	}

}
