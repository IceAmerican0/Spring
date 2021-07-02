package com.jsplec.Air4men.noticecommand;

import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.AdminNoticeDao;

public class AdminNoticeDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String board_num=request.getParameter("board_num");
		
		AdminNoticeDao dao=new AdminNoticeDao();
		dao.AdminNoticeDeleteAction(board_num);

	}

}
