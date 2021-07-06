package com.springlec.air4men.noticecommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.AdminNoticeDao;
import com.springlec.air4men.dto.AdminNoticeDto;

public class AdminNoticeListCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		AdminNoticeDao dao=sqlSession.getMapper(AdminNoticeDao.class);
		ArrayList<AdminNoticeDto> dtos=dao.list();
		model.addAttribute("list", dtos);
	}

}
