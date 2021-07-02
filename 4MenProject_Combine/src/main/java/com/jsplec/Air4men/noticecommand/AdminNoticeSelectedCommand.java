package com.jsplec.Air4men.noticecommand;

import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.AdminNoticeDao;
import com.jsplec.Air4men.dto.AdminNoticeDto;

public class AdminNoticeSelectedCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		
		AdminNoticeDao dao=new AdminNoticeDao();
		AdminNoticeDto dto=dao.AdminNoticeSelectedAction(board_num);
		request.setAttribute("notice", dto);
	}

}
