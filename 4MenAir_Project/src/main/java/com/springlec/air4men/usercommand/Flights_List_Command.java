package com.springlec.air4men.usercommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.AdminNoticeDao;
import com.springlec.air4men.dao.Flights_List_dao;
import com.springlec.air4men.dto.Flights_List_Dto;
import com.springlec.air4men.dto.UserDto;

public class Flights_List_Command implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		StringBuffer date=new StringBuffer(request.getParameter("fromDate"));//main에서 받아온 날짜
		date.deleteCharAt(4);// 날짜에서 - 빼는 작업
		date.deleteCharAt(6);
		String date_value=date.toString();//StringBuffer String으로
		
		if(("".equals(request.getParameter("date_value")))) date_value=request.getParameter("date_value"); // 날짜 변경했을시 날짜값 변경해주는 작업
		
		Flights_List_dao dao=sqlSession.getMapper(Flights_List_dao.class);
		ArrayList<Flights_List_Dto> arrayList = dao.Flights_List(date_value);
		request.setAttribute("flights_List", arrayList);
	}
}
