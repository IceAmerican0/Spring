package com.jsplec.Air4men.boardcommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.BoardDao;
import com.jsplec.Air4men.dto.BoardDto;

public class UserQnaWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userId=request.getParameter("userId");
		String board_name=request.getParameter("board_name");
		String board_contents=request.getParameter("board_contents");
		
		BoardDao dao=new BoardDao();
		dao.userQnaWriteAction(userId,board_name,board_contents);
		dao.userQnaWriteAction2(userId, board_name, board_contents);
		
	}

}
