package com.jsplec.Air4men.boardcommand;

import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.BoardDao;

public class UserQnaDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userId=request.getParameter("userId");
		String board_num=request.getParameter("board_num");

		BoardDao dao=new BoardDao();
		dao.userQnaDeleteAction(board_num);
	}

}
