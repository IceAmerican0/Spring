package com.jsplec.Air4men.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.dao.AdminDao;
import com.jsplec.Air4men.dto.AdminUserDto;

public class ClientViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		AdminDao dao = new AdminDao();
		AdminUserDto dto = dao.oneSelectMember(userId);
		
		request.setAttribute("MemberInfo", dto);
	}

}
