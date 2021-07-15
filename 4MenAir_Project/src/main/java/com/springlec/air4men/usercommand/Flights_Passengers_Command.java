package com.springlec.air4men.usercommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.FlightsListDao;
import com.springlec.air4men.dto.Flights_List_Dto;

public class Flights_Passengers_Command implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		FlightsListDao dao=sqlSession.getMapper(FlightsListDao.class);
		System.out.println(request.getParameter("flights_select"));
		Flights_List_Dto flights_passengers = dao.Flights_passengers(request.getParameter("flights_select"));
		Flights_List_Dto user_Info = dao.user_Info(request.getParameter("userId"));
		model.addAttribute("flights_passengers", flights_passengers);
		model.addAttribute("user_Info", user_Info);
	}
}
