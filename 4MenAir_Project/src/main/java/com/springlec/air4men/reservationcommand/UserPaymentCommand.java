package com.springlec.air4men.reservationcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.Flights_List_dao;
import com.springlec.air4men.dao.ReservationDao;
import com.springlec.air4men.dao.UserDao;
import com.springlec.air4men.dto.Flights_List_Dto;
import com.springlec.air4men.dto.ReservationDto;
import com.springlec.air4men.dto.UserDto;

public class UserPaymentCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userId=request.getParameter("userId");
		String flight_code=request.getParameter("flight");
		
		request.setAttribute("userId", userId);
		request.setAttribute("flight", flight_code);

		Flights_List_dao dao=sqlSession.getMapper(Flights_List_dao.class);
		Flights_List_Dto flights_passengers = dao.Flights_passengers(flight_code);
		Flights_List_Dto user_Info = dao.user_Info(userId);
		model.addAttribute("flights_passengers", flights_passengers);
		
		model.addAttribute("payments", flights_passengers.getSelect_payments());
		
		model.addAttribute("user_Info", user_Info);
		
		model.addAttribute("userName", user_Info.getUserName());
		model.addAttribute("userEmail", user_Info.getUserEmail());
		model.addAttribute("userAdd", user_Info.getUserAdd());
		model.addAttribute("userTel", user_Info.getUserTel());
	}

}
