package com.jsplec.Air4men.noticecommand;

import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.AdminNoticeDao;

public class AdminNoticeWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		AdminNoticeDao dao=new AdminNoticeDao();
		dao.AdminNoticeWriteAction(subject, content);
	}

}
