package com.jsplec.Air4men.usercommand;

import java.util.ArrayList;	

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.Flights_List_dao;
import com.jsplec.Air4men.dto.Flights_List_Dto;

public class Flights_Passengers_Command implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Flights_List_dao flights_List_dao = new Flights_List_dao();
		Flights_List_Dto flights_passengers = flights_List_dao.Flights_passengers(request.getParameter("flights_select"));
		Flights_List_Dto user_Info = flights_List_dao.user_Info(request.getParameter("userId"));
		request.setAttribute("flights_passengers", flights_passengers);
		request.setAttribute("user_Info", user_Info);
	}
}
