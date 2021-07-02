package com.jsplec.Air4men.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.dao.AdminDao;

public class AdminQnAReplyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		String qnAReply = request.getParameter("qnareply");
		
		AdminDao adminDao = new AdminDao();
		adminDao.QnaReply(qnAReply,num);
	}

}
