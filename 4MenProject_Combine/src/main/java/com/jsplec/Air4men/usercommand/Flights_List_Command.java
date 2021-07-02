package com.jsplec.Air4men.usercommand;

import java.util.ArrayList;	

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.Flights_List_dao;
import com.jsplec.Air4men.dto.Flights_List_Dto;
import com.jsplec.Air4men.dto.UserDto;

public class Flights_List_Command implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		StringBuffer date=new StringBuffer(request.getParameter("fromDate"));//main에서 받아온 날짜
		date.deleteCharAt(4);// 날짜에서 - 빼는 작업
		date.deleteCharAt(6);
		String date_value=date.toString();//StringBuffer String으로
		
		if(("".equals(request.getParameter("date_value")))) date_value=request.getParameter("date_value"); // 날짜 변경했을시 날짜값 변경해주는 작업
		
		Flights_List_dao flights_List_dao = new Flights_List_dao();
		ArrayList<Flights_List_Dto> arrayList = flights_List_dao.Flights_List(date_value);
		request.setAttribute("flights_List", arrayList);
	}
}
