package com.springlec.air4men.admincommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.AdminDao;
import com.springlec.air4men.dto.AdminUserDto;

public class DeleteClientListCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		AdminDao adminDao=sqlSession.getMapper(AdminDao.class);
		ArrayList<AdminUserDto> dtos = adminDao.Deletelist();
		model.addAttribute("list", dtos);
	}

}
