package com.springlec.air4men.boardcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest	;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.BoardDao;

public class UserQnaModifyCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userId=request.getParameter("userId");
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		String board_name=request.getParameter("board_name");
		String board_contents=request.getParameter("board_contents");
		
		BoardDao dao=sqlSession.getMapper(BoardDao.class);
		dao.userQnaModifyAction(board_name,board_contents,board_num);
	}

}
