package com.jsplec.Air4men.noticecommand;

import java.util.ArrayList;	

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.AdminNoticeDao;
import com.jsplec.Air4men.dto.AdminNoticeDto;

public class AdminNoticeListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		AdminNoticeDao dao=new AdminNoticeDao();
		ArrayList<AdminNoticeDto> dtos=dao.list();
		request.setAttribute("list", dtos);
	}

}
