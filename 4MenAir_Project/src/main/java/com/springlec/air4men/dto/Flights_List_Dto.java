package com.springlec.air4men.dto;

public class Flights_List_Dto {
	int flights_Code;
	String departures;
	String departures_Date;
	String departures_Time;
	String arrivals;
	String arrivals_Date;
	String arrivals_Time;
	String passengers;
	String payments;
	String create_Date;
	String select_Date;
	String search_date;
	/*
	 * 위쪽은 리스트를 위한 bean 변수 아래쪽은 선택정보페이지를 위한 bean 변수
	 */
	int select_flights_Code;
	String select_departures;
	String select_departures_Date;
	String select_departures_Time;
	String select_arrivals;
	String select_arrivals_Date;
	String select_arrivals_Time;
	String select_passengers;
	String select_payments;
	/*
	 * 해당 주석의 아래쪽은 유저 정보를 위한 bean 변수들
	 */
	String userName;
	String userTel;
	String userEmail;
	String userAdd;
	String userBirthday;

	public Flights_List_Dto() {
		// TODO Auto-generated constructor stub
	}

// 날짜를 위한 bean
	public Flights_List_Dto(String select_Date, String search_date) {
		super();
		this.select_Date = select_Date;
		this.search_date = search_date;
	}

	// 날짜에 맞춰서 리스트를 출력할 bean
	public Flights_List_Dto(int flights_Code, String departures, String departures_Date, String departures_Time,
			String arrivals, String arrivals_Date, String arrivals_Time, String passengers, String payments,
			String create_Date) {
		super();
		this.flights_Code = flights_Code;
		this.departures = departures;
		this.departures_Date = departures_Date;
		this.departures_Time = departures_Time;
		this.arrivals = arrivals;
		this.arrivals_Date = arrivals_Date;
		this.arrivals_Time = arrivals_Time;
		this.passengers = passengers;
		this.payments = payments;
		this.create_Date = create_Date;
	}

	// 선택한 정보를 가져올 bean
	public Flights_List_Dto(int select_flights_Code, String select_departures, String select_departures_Date,
			String select_departures_Time, String select_arrivals, String select_arrivals_Date,
			String select_arrivals_Time, String select_passengers, String select_payments) {
		super();
		this.select_flights_Code = select_flights_Code;
		this.select_departures = select_departures;
		this.select_departures_Date = select_departures_Date;
		this.select_departures_Time = select_departures_Time;
		this.select_arrivals = select_arrivals;
		this.select_arrivals_Date = select_arrivals_Date;
		this.select_arrivals_Time = select_arrivals_Time;
		this.select_passengers = select_passengers;
		this.select_payments = select_payments;
	}

	// 유저의 정보
	public Flights_List_Dto(String userName, String userTel, String userEmail, String userAdd, String userBirthday) {
		super();
		this.userName = userName;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.userAdd = userAdd;
		this.userBirthday = userBirthday;
	}

	public String getDepartures_Time() {
		return departures_Time;
	}

	public void setDepartures_Time(String departures_Time) {
		this.departures_Time = departures_Time;
	}

	public String getArrivals_Time() {
		return arrivals_Time;
	}

	public void setArrivals_Time(String arrivals_Time) {
		this.arrivals_Time = arrivals_Time;
	}

	public int getFlights_Code() {
		return flights_Code;
	}

	public void setFlights_Code(int flights_Code) {
		this.flights_Code = flights_Code;
	}

	public String getDepartures() {
		return departures;
	}

	public void setDepartures(String departures) {
		this.departures = departures;
	}

	public String getDepartures_Date() {
		return departures_Date;
	}

	public void setDepartures_Date(String departures_Date) {
		this.departures_Date = departures_Date;
	}

	public String getArrivals() {
		return arrivals;
	}

	public void setArrivals(String arrivals) {
		this.arrivals = arrivals;
	}

	public String getArrivals_Date() {
		return arrivals_Date;
	}

	public void setArrivals_Date(String arrivals_Date) {
		this.arrivals_Date = arrivals_Date;
	}

	public String getPassengers() {
		return passengers;
	}

	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}

	public String getPayments() {
		return payments;
	}

	public void setPayments(String payments) {
		this.payments = payments;
	}

	public String getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(String create_Date) {
		this.create_Date = create_Date;
	}

	public String getSelect_Date() {
		return select_Date;
	}

	public void setSelect_Date(String select_Date) {
		this.select_Date = select_Date;
	}

	public String getSearch_date() {
		return search_date;
	}

	public void setSearch_date(String search_date) {
		this.search_date = search_date;
	}

	public int getSelect_flights_Code() {
		return select_flights_Code;
	}

	public void setSelect_flights_Code(int select_flights_Code) {
		this.select_flights_Code = select_flights_Code;
	}

	public String getSelect_departures() {
		return select_departures;
	}

	public void setSelect_departures(String select_departures) {
		this.select_departures = select_departures;
	}

	public String getSelect_departures_Date() {
		return select_departures_Date;
	}

	public void setSelect_departures_Date(String select_departures_Date) {
		this.select_departures_Date = select_departures_Date;
	}

	public String getSelect_departures_Time() {
		return select_departures_Time;
	}

	public void setSelect_departures_Time(String select_departures_Time) {
		this.select_departures_Time = select_departures_Time;
	}

	public String getSelect_arrivals() {
		return select_arrivals;
	}

	public void setSelect_arrivals(String select_arrivals) {
		this.select_arrivals = select_arrivals;
	}

	public String getSelect_arrivals_Date() {
		return select_arrivals_Date;
	}

	public void setSelect_arrivals_Date(String select_arrivals_Date) {
		this.select_arrivals_Date = select_arrivals_Date;
	}

	public String getSelect_arrivals_Time() {
		return select_arrivals_Time;
	}

	public void setSelect_arrivals_Time(String select_arrivals_Time) {
		this.select_arrivals_Time = select_arrivals_Time;
	}

	public String getSelect_passengers() {
		return select_passengers;
	}

	public void setSelect_passengers(String select_passengers) {
		this.select_passengers = select_passengers;
	}

	public String getSelect_payments() {
		return select_payments;
	}

	public void setSelect_payments(String select_payments) {
		this.select_payments = select_payments;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAdd() {
		return userAdd;
	}

	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

}
