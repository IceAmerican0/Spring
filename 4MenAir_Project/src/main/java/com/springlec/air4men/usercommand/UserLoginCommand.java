package com.springlec.air4men.usercommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.UserDao;
import com.springlec.air4men.dto.UserDto;

public class UserLoginCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession,Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		
		System.out.println("userId : "+userId+"\n userPw : "+userPw);
		
		UserDao userDao=sqlSession.getMapper(UserDao.class);
		UserDto dto=userDao.LoginCheck(userId, userPw);
		
		if(dto.getUserId().equals(userId)&&dto.getUserPw().equals(userPw))
			model.addAttribute("userId",userId);

	}

}
