package com.jsplec.Air4men.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.dao.AdminDao;
import com.jsplec.Air4men.dto.AdminUserDto;

public class AdminClientListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		

		AdminDao adminDao = new AdminDao();
		ArrayList<AdminUserDto> dtos = adminDao.list();
		request.setAttribute("list", dtos);
		
	}

}
