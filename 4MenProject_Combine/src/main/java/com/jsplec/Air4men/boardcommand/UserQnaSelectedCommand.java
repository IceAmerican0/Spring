package com.jsplec.Air4men.boardcommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.BoardDao;
import com.jsplec.Air4men.dto.BoardDto;

public class UserQnaSelectedCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String userId=request.getParameter("userId");
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		
		BoardDao dao=new BoardDao();
		BoardDto dto=dao.userQnaSelectedAction(board_num);

		request.setAttribute("board", dto);
		if(dto.getQna_reply()!=null)
			request.setAttribute("qnareply", dto.getQna_reply());
	}

}
