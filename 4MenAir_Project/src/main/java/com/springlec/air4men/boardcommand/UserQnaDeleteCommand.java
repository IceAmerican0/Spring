package com.springlec.air4men.boardcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.AdminDao;
import com.springlec.air4men.dao.BoardDao;

public class UserQnaDeleteCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userId=request.getParameter("userId");
		String board_num=request.getParameter("board_num");

		BoardDao dao=sqlSession.getMapper(BoardDao.class);
		dao.userQnaDeleteAction(board_num);
	}

}
