package com.springlec.air4men.noticecommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.AdminNoticeDao;
import com.springlec.air4men.dto.AdminNoticeDto;

public class AdminNoticeSelectedCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		
		AdminNoticeDao dao=sqlSession.getMapper(AdminNoticeDao.class);
		AdminNoticeDto dto=dao.AdminNoticeSelectedAction(board_num);
		request.setAttribute("notice", dto);
	}

}