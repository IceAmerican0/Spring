package com.jsplec.Air4men.reservationcommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.Flights_List_dao;
import com.jsplec.Air4men.dao.ReservationDao;
import com.jsplec.Air4men.dao.UserDao;
import com.jsplec.Air4men.dto.Flights_List_Dto;
import com.jsplec.Air4men.dto.ReservationDto;
import com.jsplec.Air4men.dto.UserDto;

public class UserPaymentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userId=request.getParameter("userId");
		String flight_code=request.getParameter("flight");
		
		request.setAttribute("userId", userId);
		request.setAttribute("flight", flight_code);

		Flights_List_dao flights_List_dao = new Flights_List_dao();
		Flights_List_Dto flights_passengers = flights_List_dao.Flights_passengers(flight_code);
		Flights_List_Dto user_Info = flights_List_dao.user_Info(userId);
		request.setAttribute("flights_passengers", flights_passengers);
		
		request.setAttribute("payments", flights_passengers.getSelect_payments());
		
		request.setAttribute("user_Info", user_Info);
		
		request.setAttribute("userName", user_Info.getUserName());
		request.setAttribute("userEmail", user_Info.getUserEmail());
		request.setAttribute("userAdd", user_Info.getUserAdd());
		request.setAttribute("userTel", user_Info.getUserTel());
	}

}
