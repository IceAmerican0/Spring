package com.jsplec.Air4men.noticecommand;

import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.NoticeDao;
import com.jsplec.Air4men.dto.NoticeDto;

public class UserNoticeSelectedCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		
		NoticeDao dao=new NoticeDao();
		NoticeDto dto=dao.AdminNoticeSelectedAction(board_num);
		request.setAttribute("notice", dto);
	}

}
