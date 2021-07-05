package com.springlec.air4men.admincommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.AdminDao;

public class AdminQnAReplyCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String num = request.getParameter("num");
		String qnAReply = request.getParameter("qnareply");
		
		AdminDao adminDao=sqlSession.getMapper(AdminDao.class);
		adminDao.QnaReply(qnAReply,num);
	}

}
