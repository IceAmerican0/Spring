package com.jsplec.Air4men.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.dao.AdminDao;
import com.jsplec.Air4men.dto.AdminQnaDto;

public class AdminQnAListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		AdminDao adminDao = new AdminDao();
		ArrayList<AdminQnaDto> dtos = adminDao.Qnalist();
		request.setAttribute("list", dtos);
	}

}
