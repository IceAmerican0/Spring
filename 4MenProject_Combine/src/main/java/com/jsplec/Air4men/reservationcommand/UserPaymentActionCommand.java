package com.jsplec.Air4men.reservationcommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.dao.ReservationDao;
import com.jsplec.Air4men.dto.ReservationDto;

public class UserPaymentActionCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userId=request.getParameter("userId");
		String flight=request.getParameter("flight");
		String cardnumber=request.getParameter("cardnumber");

		ReservationDao dao=new ReservationDao();
		dao.userPaymentAction(userId, flight, cardnumber);
		
	}

}
