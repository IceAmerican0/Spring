package com.springlec.air4men.usercommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.UserDao;
import com.springlec.air4men.dto.UserDto;

public class UserPwfindCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userId=request.getParameter("userId");
		String userTel=request.getParameter("userTel");
		String userEmail1=request.getParameter("userEmail1");
		String userEmail2=request.getParameter("userEmail2");
		String userEmail=userEmail1+userEmail2;
		
		
		UserDao userDao=sqlSession.getMapper(UserDao.class);
		UserDto dto=userDao.PwfindAction(userId, userTel, userEmail);
		String userPw=dto.getUserPw();
		model.addAttribute("userId", userId);
		model.addAttribute("FinduserPw", userPw);

	}

}
