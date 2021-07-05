package com.springlec.air4men.dao;

import java.sql.Connection;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.springlec.air4men.dto.Flights_List_Dto;

public interface Flights_List_dao {
	
	public ArrayList<Flights_List_Dto> Flights_List(String date_value);

//		ArrayList<Flights_List_Dto> arrayList = new ArrayList<Flights_List_Dto>();
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		System.out.println(date_value);
//		try {
//			connection = dataSource.getConnection(); // dataSource 경로의 디비 실행
//
//			String select1 = "SELECT distinct DATE_FORMAT(Departures_Date,'%m월 %d일') AS SELECT_DATE , DATE_FORMAT(Departures_Date, '%Y-%m-%d') AS SEARCH_DATE \n";
//			String from1 = "FROM 4menAir.Flights \n";
//			String where1 = "WHERE Departures_Date BETWEEN DATE_ADD(" + date_value + ", INTERVAL -3 DAY) AND DATE_ADD("
//					+ date_value + ", INTERVAL 4 DAY)";
//			PreparedStatement preparedStatement2 = connection.prepareStatement(select1 + from1 + where1);
//			ResultSet resultSet2 = preparedStatement2.executeQuery();
//			System.out.println(select1 + from1 + where1);
//
//			while (resultSet2.next()) {
//				String select_date = resultSet2.getString("SELECT_DATE");
//				String search_date = resultSet2.getString("SEARCH_DATE");
//
//				Flights_List_Dto flights_Date_List_Dto = new Flights_List_Dto(select_date, search_date);
//
//				arrayList.add(flights_Date_List_Dto);
//			}
//
//			String select2_1 = "SELECT Flights_Code, Departures, ";
//			String select2_2 = "CAST(Departures_Date AS date) AS Departures_Date, CAST(Departures_Date AS time) AS Departures_Time, Arrivals, CAST(Arrivals_Date AS date) AS Arrivals_Date, CAST(Arrivals_Date AS time) AS Arrivals_Time, ";
//			String select2_3 = "Passengers, Payments, Create_Date, DATE_FORMAT(Departures_Date,'%m월 %d일') AS SELECT_DATE \n";
//			String from2 = "FROM 4menAir.Flights \n";
//			String where2 = "WHERE DATE_FORMAT(Departures_Date, '%Y%m%d') = " + date_value;
//			preparedStatement = connection.prepareStatement(select2_1 + select2_2 + select2_3 + from2 + where2);
//			resultSet = preparedStatement.executeQuery();
//			System.out.println(select2_1 + select2_2 + select2_3 + from2 + where2);
//
//			while (resultSet.next()) {
//				int flights_Code = resultSet.getInt("Flights_Code");
//				String departures = resultSet.getString("Departures");
//				String departures_Date = resultSet.getString("Departures_Date");
//				String departures_Time = resultSet.getString("Departures_Time");
//				String arrivals = resultSet.getString("Arrivals");
//				String arrivals_Date = resultSet.getString("Arrivals_Date");
//				String arrivals_Time = resultSet.getString("Arrivals_Time");
//				String passengers = resultSet.getString("Passengers");
//				String payments = resultSet.getString("Payments");
//				String create_Date2 = resultSet.getString("Create_Date");
//
//				Flights_List_Dto flights_List_Dto = new Flights_List_Dto(flights_Code, departures, departures_Date,
//						departures_Time, arrivals, arrivals_Date, arrivals_Time, passengers, payments, create_Date2);
//
//				arrayList.add(flights_List_Dto);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (resultSet != null) {
//					resultSet.close();
//				}
//				if (preparedStatement != null) {
//					preparedStatement.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return arrayList;
//	}

	public Flights_List_Dto Flights_passengers(String param_flights_Code);	
			
	public Flights_List_Dto user_Info(String id_value);
		
			
}
