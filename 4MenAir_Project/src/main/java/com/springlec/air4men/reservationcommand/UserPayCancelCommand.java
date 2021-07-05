package com.springlec.air4men.reservationcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.AdminNoticeDao;
import com.springlec.air4men.dao.ReservationDao;
import com.springlec.air4men.dto.ReservationDto;

public class UserPayCancelCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String reservation_code=request.getParameter("flight");

		ReservationDao dao=sqlSession.getMapper(ReservationDao.class);
		dao.userPayCancelAction(reservation_code);
	}

}
