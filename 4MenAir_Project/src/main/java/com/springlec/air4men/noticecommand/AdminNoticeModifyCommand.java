package com.springlec.air4men.noticecommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.AdminNoticeDao;

public class AdminNoticeModifyCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		String board_name=request.getParameter("subject");
		String board_contents=request.getParameter("content");
		
		System.out.println(board_num+"<br>"+board_name+"<br>"+board_contents);
		
		AdminNoticeDao dao=sqlSession.getMapper(AdminNoticeDao.class);
		dao.AdminNoticeModifyAction(board_name, board_contents,board_num);

	}

}
