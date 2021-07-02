package com.jsplec.Air4men.boardcommand;

import javax.servlet.http.HttpServletRequest	;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.BoardDao;

public class UserQnaModifyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userId=request.getParameter("userId");
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		String board_name=request.getParameter("board_name");
		String board_contents=request.getParameter("board_contents");
		
		BoardDao dao=new BoardDao();
		dao.userQnaModifyAction(board_num,board_name,board_contents);
	}

}
