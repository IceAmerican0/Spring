package com.jsplec.Air4men.dao;

import java.sql.Connection;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.Air4men.dto.Flights_List_Dto;

public class Flights_List_dao {
	DataSource dataSource;

	public Flights_List_dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/4menair");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Flights_List_Dto> Flights_List(String date_value) {
		// TODO Auto-generated method stub

		ArrayList<Flights_List_Dto> arrayList = new ArrayList<Flights_List_Dto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println(date_value);
		try {
			connection = dataSource.getConnection(); // dataSource 경로의 디비 실행

			String select1 = "SELECT distinct DATE_FORMAT(Departures_Date,'%m월 %d일') AS SELECT_DATE , DATE_FORMAT(Departures_Date, '%Y-%m-%d') AS SEARCH_DATE \n";
			String from1 = "FROM 4menAir.Flights \n";
			String where1 = "WHERE Departures_Date BETWEEN DATE_ADD(" + date_value + ", INTERVAL -3 DAY) AND DATE_ADD("
					+ date_value + ", INTERVAL 4 DAY)";
			PreparedStatement preparedStatement2 = connection.prepareStatement(select1 + from1 + where1);
			ResultSet resultSet2 = preparedStatement2.executeQuery();
			System.out.println(select1 + from1 + where1);

			while (resultSet2.next()) {
				String select_date = resultSet2.getString("SELECT_DATE");
				String search_date = resultSet2.getString("SEARCH_DATE");

				Flights_List_Dto flights_Date_List_Dto = new Flights_List_Dto(select_date, search_date);

				arrayList.add(flights_Date_List_Dto);
			}

			String select2_1 = "SELECT Flights_Code, Departures, ";
			String select2_2 = "CAST(Departures_Date AS date) AS Departures_Date, CAST(Departures_Date AS time) AS Departures_Time, Arrivals, CAST(Arrivals_Date AS date) AS Arrivals_Date, CAST(Arrivals_Date AS time) AS Arrivals_Time, ";
			String select2_3 = "Passengers, Payments, Create_Date, DATE_FORMAT(Departures_Date,'%m월 %d일') AS SELECT_DATE \n";
			String from2 = "FROM 4menAir.Flights \n";
			String where2 = "WHERE DATE_FORMAT(Departures_Date, '%Y%m%d') = " + date_value;
			preparedStatement = connection.prepareStatement(select2_1 + select2_2 + select2_3 + from2 + where2);
			resultSet = preparedStatement.executeQuery();
			System.out.println(select2_1 + select2_2 + select2_3 + from2 + where2);

			while (resultSet.next()) {
				int flights_Code = resultSet.getInt("Flights_Code");
				String departures = resultSet.getString("Departures");
				String departures_Date = resultSet.getString("Departures_Date");
				String departures_Time = resultSet.getString("Departures_Time");
				String arrivals = resultSet.getString("Arrivals");
				String arrivals_Date = resultSet.getString("Arrivals_Date");
				String arrivals_Time = resultSet.getString("Arrivals_Time");
				String passengers = resultSet.getString("Passengers");
				String payments = resultSet.getString("Payments");
				String create_Date2 = resultSet.getString("Create_Date");

				Flights_List_Dto flights_List_Dto = new Flights_List_Dto(flights_Code, departures, departures_Date,
						departures_Time, arrivals, arrivals_Date, arrivals_Time, passengers, payments, create_Date2);

				arrayList.add(flights_List_Dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return arrayList;
	}

	public Flights_List_Dto Flights_passengers(String param_flights_Code) {
		Flights_List_Dto dto = new Flights_List_Dto();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			String select1_1 = "SELECT Flights_Code, Departures, ";
			String select1_2 = "CAST(Departures_Date AS date) AS Departures_Date, CAST(Departures_Date AS time) AS Departures_Time, Arrivals, CAST(Arrivals_Date AS date) AS Arrivals_Date, CAST(Arrivals_Date AS time) AS Arrivals_Time, ";
			String select1_3 = "Passengers, Payments, Create_Date, DATE_FORMAT(Departures_Date,'%m월 %d일') AS SELECT_DATE \n";
			String from1 = "FROM 4menAir.Flights \n";
			String where1 = "WHERE Flights_Code = " + param_flights_Code;
			preparedStatement = connection.prepareStatement(select1_1 + select1_2 + select1_3 + from1 + where1);
			resultSet = preparedStatement.executeQuery();
			System.out.println("___________________________");
			System.out.println(preparedStatement);
			System.out.println("___________________________");
			if (resultSet.next()) {
				int select_flights_Code = resultSet.getInt("Flights_Code");
				String select_departures = resultSet.getString("Departures");
				String select_departures_Date = resultSet.getString("Departures_Date");
				String select_departures_Time = resultSet.getString("Departures_Time");
				String select_arrivals = resultSet.getString("Arrivals");
				String select_arrivals_Date = resultSet.getString("Arrivals_Date");
				String select_arrivals_Time = resultSet.getString("Arrivals_Time");
				String select_passengers = resultSet.getString("Passengers");
				String select_payments = resultSet.getString("Payments");

				dto = new Flights_List_Dto(select_flights_Code, select_departures, select_departures_Date,
						select_departures_Time, select_arrivals, select_arrivals_Date, select_arrivals_Time,
						select_passengers, select_payments);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return dto;
	}
	public Flights_List_Dto user_Info(String id_value) {
		Flights_List_Dto dto = new Flights_List_Dto();
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			String select2_1 = "SELECT UserName, UserTel, UserEmail, UserAdd, UserBirthday \n";
			String from2 = "FROM 4menAir.UserInfo \n";
			String where2 = "WHERE UserId = ?";
			PreparedStatement preparedStatement2 = connection.prepareStatement(select2_1 + from2 + where2);
			preparedStatement2.setString(1, id_value);
			System.out.println(preparedStatement2);

			ResultSet resultSet2 = preparedStatement2.executeQuery();
			if (resultSet2.next()) {
				String UserName = resultSet2.getString("UserName");
				String UserTel = resultSet2.getString("UserTel");
				String UserEmail = resultSet2.getString("UserEmail");
				String UserAdd = resultSet2.getString("UserAdd");
				String UserBirthday = resultSet2.getString("UserBirthday");
				
				dto = new Flights_List_Dto(UserName, UserTel, UserEmail, UserAdd, UserBirthday);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return dto;
	}
}
