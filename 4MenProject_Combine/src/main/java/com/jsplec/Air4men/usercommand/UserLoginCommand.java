package com.jsplec.Air4men.usercommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.UserDao;
import com.jsplec.Air4men.dto.UserDto;

public class UserLoginCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		
		UserDao userDao=new UserDao();
		int x=userDao.loginCheck(userId, userPw);
		
		if(x==1) {
			request.setAttribute("userId", userId);
		}else if(x==0) {
			request.setAttribute("msg", x);
		}else {
			request.setAttribute("msg",x);
		}

	}

}
