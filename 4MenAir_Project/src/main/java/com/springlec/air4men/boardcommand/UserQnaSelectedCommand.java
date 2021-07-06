package com.springlec.air4men.boardcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.BoardDao;
import com.springlec.air4men.dto.BoardDto;

public class UserQnaSelectedCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userId=request.getParameter("userId");
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		
		BoardDao dao=sqlSession.getMapper(BoardDao.class);
		BoardDto dto=dao.userQnaSelectedAction(board_num);

		model.addAttribute("board", dto);
		if(dto.getQna_reply()!=null)
			model.addAttribute("qnareply", dto.getQna_reply());
	}

}
