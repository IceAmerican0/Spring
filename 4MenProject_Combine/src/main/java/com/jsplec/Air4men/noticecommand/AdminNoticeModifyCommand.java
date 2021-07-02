package com.jsplec.Air4men.noticecommand;

import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.AdminNoticeDao;

public class AdminNoticeModifyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		String board_name=request.getParameter("subject");
		String board_contents=request.getParameter("content");
		
		System.out.println(board_num+"<br>"+board_name+"<br>"+board_contents);
		
		AdminNoticeDao dao=new AdminNoticeDao();
		dao.AdminNoticeModifyAction(board_num, board_name, board_contents);

	}

}
