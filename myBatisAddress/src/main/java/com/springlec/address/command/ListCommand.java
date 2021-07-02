package com.springlec.address.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.address.dao.IDao;

public class ListCommand implements Command{
		@Override
		public void execute(SqlSession sqlSession, Model model) {
			IDao dao=sqlSession.getMapper(IDao.class);
			model.addAttribute("list",dao.listDao());
	
		}
}
