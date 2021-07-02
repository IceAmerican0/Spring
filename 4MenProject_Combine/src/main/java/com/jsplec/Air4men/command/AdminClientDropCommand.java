package com.jsplec.Air4men.command;


import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.dao.AdminDao;

public class AdminClientDropCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		
		AdminDao adminDao = new AdminDao();
		
		adminDao.deleteMember(userId);
	}

}
