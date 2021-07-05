package com.springlec.air4men.dao;


import java.util.ArrayList;


import com.springlec.air4men.dto.ReservationDto;

public interface ReservationDao {	
	
	public ArrayList<ReservationDto> list(String userId); // 예약 정보 불러오기
	
	public void userPaymentAction(String userId,String flightCode,String cardnumber); // 결제 하기
	
	public ReservationDto userPaymentInfo(String flightCode); // 결제한 정보 불러오기
			
	public void userPayCancelAction(String reservation_code); // 결제 취소하기
		
}
