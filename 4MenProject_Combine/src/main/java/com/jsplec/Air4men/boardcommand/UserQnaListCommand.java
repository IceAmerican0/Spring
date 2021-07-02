package com.jsplec.Air4men.boardcommand;

import java.util.ArrayList;	

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.BoardDao;
import com.jsplec.Air4men.dto.BoardDto;

public class UserQnaListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userId=request.getParameter("userId");
		
		BoardDao dao=new BoardDao();
		ArrayList<BoardDto> dtos=dao.list(userId);
		request.setAttribute("list", dtos);

	}

}
