package com.jsplec.Air4men.usercommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.UserDao;
import com.jsplec.Air4men.dto.UserDto;

public class UserMyPageCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userId=request.getParameter("userId");
				
		UserDao userDao=new UserDao();
		UserDto userinfo=userDao.LoginAction(userId);
		
		request.setAttribute("userInfo", userinfo);
		request.setAttribute("userId", userId);
		
		
	}

}
