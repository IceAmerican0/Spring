package com.jsplec.Air4men.reservationcommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.ReservationDao;
import com.jsplec.Air4men.dto.ReservationDto;

public class UserReservationListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userId=request.getParameter("userId");
		
		ReservationDao dao=new ReservationDao();
		ArrayList<ReservationDto> dtos=dao.list(userId);
		request.setAttribute("list", dtos);
	}

}
