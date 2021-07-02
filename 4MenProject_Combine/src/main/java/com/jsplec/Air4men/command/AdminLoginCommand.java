package com.jsplec.Air4men.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.AdminLoginCommand;
import com.jsplec.Air4men.dao.AdminDao;
import com.jsplec.Air4men.dto.AdminDto;

public class AdminLoginCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String adminId = request.getParameter("AdminId");
		String adminPw = request.getParameter("AdminPw");
		
		AdminDao adminDao = new AdminDao();
		AdminDto adminDto = adminDao.AdminLogin(adminId, adminPw);
		
		request.setAttribute("adminInfo", adminDto);

	}


}
