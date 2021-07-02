package com.jsplec.Air4men.reservationcommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.ReservationDao;
import com.jsplec.Air4men.dto.ReservationDto;

public class UserPaymentInfoCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String flight=request.getParameter("flight");

		ReservationDao dao=new ReservationDao();
		ReservationDto dto=dao.userPaymentInfo(flight);
		
		request.setAttribute("paymentInfo", dto);
	}

}
