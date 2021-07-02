package com.jsplec.Air4men.reservationcommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.ReservationDao;
import com.jsplec.Air4men.dto.ReservationDto;

public class UserPayCancelCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String reservation_code=request.getParameter("flight");

		ReservationDao dao=new ReservationDao();
		dao.userPayCancelAction(reservation_code);
	}

}
