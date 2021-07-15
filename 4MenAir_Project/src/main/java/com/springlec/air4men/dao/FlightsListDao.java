package com.springlec.air4men.dao;


import java.util.ArrayList;


import com.springlec.air4men.dto.Flights_List_Dto;

public interface FlightsListDao {
	
	public ArrayList<Flights_List_Dto> Flights_List(String date_value);
	
	public ArrayList<Flights_List_Dto> Flights_List2(String date_value);


//				Flights_List_Dto flights_Date_List_Dto = new Flights_List_Dto(select_date, search_date);
//
//				arrayList.add(flights_Date_List_Dto);
//
//				Flights_List_Dto flights_List_Dto = new Flights_List_Dto(flights_Code, departures, departures_Date,
//						departures_Time, arrivals, arrivals_Date, arrivals_Time, passengers, payments, create_Date2);


	public Flights_List_Dto Flights_passengers(String param_flights_Code);	
			
	public Flights_List_Dto user_Info(String id_value);
		
			
}
