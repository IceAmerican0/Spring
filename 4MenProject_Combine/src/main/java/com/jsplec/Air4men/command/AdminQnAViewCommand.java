package com.jsplec.Air4men.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.dao.AdminDao;
import com.jsplec.Air4men.dto.AdminQnaDto;

public class AdminQnAViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String board_num = request.getParameter("board_num");
		
		AdminDao dao = new AdminDao();
		AdminQnaDto dto = dao.oneSelectQnaMember(board_num);
		
		request.setAttribute("QnaInfo", dto);
		
	}

}
