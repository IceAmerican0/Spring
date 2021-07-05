package com.springlec.air4men.dto;

import java.sql.Timestamp;

public class ReservationDto {
	//운항정보
	String flights_code;
	String departures;
	Timestamp departures_date;
	String arrivals;
	Timestamp arrivals_date;
	String Passengers;
	String payments;
	Timestamp create_date;
	Timestamp delete_date;
	
	// 예약정보
	String reservation_code;
	String userInfo_userId;
	String flights_flights_code;
	String reservation_cardnumber;
	Timestamp reservation_create_date;
	Timestamp reservation_cancel_date;
	
	
	
	//=====================Constructor======================
	
	
	public ReservationDto() {
		
	}
	
	
	//=======================결제할 항공정보 불러오기============================
	public ReservationDto(String flights_code, String departures, Timestamp departures_date, String arrivals,
			Timestamp arrivals_date, String passengers, String payments) {
		super();
		this.flights_code = flights_code;
		this.departures = departures;
		this.departures_date = departures_date;
		this.arrivals = arrivals;
		this.arrivals_date = arrivals_date;
		Passengers = passengers;
		this.payments = payments;
	}















	//================예약 정보 리스트====================
	public ReservationDto(String departures, String flights_code,Timestamp departures_date, String arrivals, Timestamp arrivals_date,
			String reservation_code, Timestamp reservation_create_date, Timestamp reservation_cancel_date) {
		super();
		this.departures = departures;
		this.flights_code=flights_code;
		this.departures_date = departures_date;
		this.arrivals = arrivals;
		this.arrivals_date = arrivals_date;
		this.reservation_code = reservation_code;
		this.reservation_create_date = reservation_create_date;
		this.reservation_cancel_date = reservation_cancel_date;
	}
	
	//===================결제 정보 리스트========================	
	public ReservationDto(String reservation_code,String departures, Timestamp departures_date, String arrivals, Timestamp arrivals_date,
			String payments, String reservation_cardnumber, Timestamp reservation_create_date,
			Timestamp reservation_cancel_date, String flights_flights_code) {
		super();
		this.reservation_code=reservation_code;
		this.departures = departures;
		this.departures_date = departures_date;
		this.arrivals = arrivals;
		this.arrivals_date = arrivals_date;
		this.payments = payments;
		this.reservation_cardnumber = reservation_cardnumber;
		this.reservation_create_date = reservation_create_date;
		this.reservation_cancel_date = reservation_cancel_date;
		this.flights_flights_code = flights_flights_code;
	}


	//====================Getter Setter======================
	
	public String getFlights_code() {
		return flights_code;
	}

	public void setFlights_code(String flights_code) {
		this.flights_code = flights_code;
	}



	public String getDepartures() {
		return departures;
	}



	public void setDepartures(String departures) {
		this.departures = departures;
	}



	public Timestamp getDepartures_date() {
		return departures_date;
	}



	public void setDepartures_date(Timestamp departures_date) {
		this.departures_date = departures_date;
	}



	public String getArrivals() {
		return arrivals;
	}



	public void setArrivals(String arrivals) {
		this.arrivals = arrivals;
	}



	public Timestamp getArrivals_date() {
		return arrivals_date;
	}



	public void setArrivals_date(Timestamp arrivals_date) {
		this.arrivals_date = arrivals_date;
	}



	public String getPassengers() {
		return Passengers;
	}



	public void setPassengers(String passengers) {
		Passengers = passengers;
	}



	public String getPayments() {
		return payments;
	}



	public void setPayments(String payments) {
		this.payments = payments;
	}



	public Timestamp getCreate_date() {
		return create_date;
	}



	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}



	public Timestamp getDelete_date() {
		return delete_date;
	}



	public void setDelete_date(Timestamp delete_date) {
		this.delete_date = delete_date;
	}



	public String getReservation_code() {
		return reservation_code;
	}



	public void setReservation_code(String reservation_code) {
		this.reservation_code = reservation_code;
	}



	public String getUserInfo_userId() {
		return userInfo_userId;
	}



	public void setUserInfo_userId(String userInfo_userId) {
		this.userInfo_userId = userInfo_userId;
	}



	public String getFlights_flights_code() {
		return flights_flights_code;
	}



	public void setFlights_flights_code(String flights_flights_code) {
		this.flights_flights_code = flights_flights_code;
	}



	public Timestamp getReservation_create_date() {
		return reservation_create_date;
	}



	public void setReservation_create_date(Timestamp reservation_create_date) {
		this.reservation_create_date = reservation_create_date;
	}



	public Timestamp getReservation_cancel_date() {
		return reservation_cancel_date;
	}



	public void setReservation_cancel_date(Timestamp reservation_cancel_date) {
		this.reservation_cancel_date = reservation_cancel_date;
	}

	public String getReservation_cardnumber() {
		return reservation_cardnumber;
	}

	public void setReservation_cardnumber(String reservation_cardnumber) {
		this.reservation_cardnumber = reservation_cardnumber;
	}
	
	
	
	
}
