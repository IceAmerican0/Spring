package com.jsplec.Air4men.noticecommand;

import java.util.ArrayList;	

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.NoticeDao;
import com.jsplec.Air4men.dto.NoticeDto;

public class UserNoticeListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		NoticeDao dao=new NoticeDao();
		ArrayList<NoticeDto> dtos=dao.list();
		request.setAttribute("list", dtos);
	}

}
