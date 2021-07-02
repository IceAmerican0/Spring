package com.jsplec.Air4men.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.Air4men.dto.ReservationDto;
import com.jsplec.Air4men.dto.UserDto;

public class ReservationDao {
	DataSource datasource;
	
	public ReservationDao() {
		try {
			Context context = new InitialContext();
			datasource=(DataSource) context.lookup("java:comp/env/jdbc/4menair");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
	//========================예약 정보 불러오기===================
	
	public ArrayList<ReservationDto> list(String userId) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		ArrayList<ReservationDto> dtos=new ArrayList<ReservationDto>();
		
		try {
			connection=datasource.getConnection();
			
			String query="select r.reservation_code, f.departures, f.arrivals, f.flights_code,"
					+ " f.departures_date, f.arrivals_date, r.reservation_create_date, r.reservation_cancel_date"
					+ " from reservation r,flights f where r.userinfo_userid=? and r.flights_flights_code=f.flights_code order by r.reservation_create_date desc";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,userId);
			resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				String reservation_code=resultSet.getString("r.reservation_code");
				String departures=resultSet.getString("f.departures");
				String arrivals=resultSet.getString("f.arrivals");
				String flights_code=resultSet.getString("f.flights_code");
				Timestamp departures_date=resultSet.getTimestamp("f.departures_date");
				Timestamp arrivals_date=resultSet.getTimestamp("f.arrivals_date");
				Timestamp reservation_create_date=resultSet.getTimestamp("r.reservation_create_date");
				Timestamp reservation_cancel_date=resultSet.getTimestamp("r.reservation_cancel_date");
				
				ReservationDto dto=new ReservationDto(departures, flights_code,departures_date, arrivals, arrivals_date, 
						reservation_code, reservation_create_date, reservation_cancel_date);
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return dtos;
	}

	//===========================결제 하기=========================
	
		public void userPaymentAction(String userId,String flightCode,String cardnumber) {
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			
			
			try {
				connection=datasource.getConnection();
				
				String query="insert into reservation (userinfo_userid, flights_flights_code, reservation_cardnumber, reservation_create_date) values (?,?,?,now())";
				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setString(1,userId);
				preparedStatement.setString(2,flightCode);
				preparedStatement.setString(3,cardnumber);				
				preparedStatement.executeUpdate();
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(preparedStatement!=null) preparedStatement.close();
					if(connection!=null) connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}	
		}
	
	
	

	//===========================결제한 정보 불러오기=========================
	
	public ReservationDto userPaymentInfo(String flightCode) {
		ReservationDto dto=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		
		try {
			connection=datasource.getConnection();
			
			String query="select r.reservation_code,f.departures, f.arrivals, f.departures_date, f.payments, r.reservation_cardnumber,"
					+ " f.arrivals_date, r.reservation_create_date, r.reservation_cancel_date, r.flights_flights_code"
					+ " from reservation r,flights f where f.flights_code=? and f.flights_code=r.flights_flights_code";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,flightCode);
			resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				String reservation_code=resultSet.getString("r.reservation_code");
				String departures=resultSet.getString("f.departures");
				String arrivals=resultSet.getString("f.arrivals");
				String payments=resultSet.getString("f.payments");
				String reservation_cardnumber=resultSet.getString("r.reservation_cardnumber");
				Timestamp departures_date=resultSet.getTimestamp("f.departures_date");
				Timestamp arrivals_date=resultSet.getTimestamp("f.arrivals_date");
				Timestamp reservation_create_date=resultSet.getTimestamp("r.reservation_create_date");
				Timestamp reservation_cancel_date=resultSet.getTimestamp("r.reservation_cancel_date");
				String reservation_flights_code=resultSet.getString("r.flights_flights_code");
				
				
				dto=new ReservationDto(reservation_code,departures, departures_date, arrivals,
						arrivals_date, payments, reservation_cardnumber, reservation_create_date, reservation_cancel_date,reservation_flights_code);
				
				return dto;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) resultSet.close();
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
		
		return dto;
	}


//===========================결제 취소하기=========================
	public void userPayCancelAction(String reservation_code) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
			connection=datasource.getConnection();
			
			String query="update reservation set reservation_cancel_date=now() where flights_flights_code=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,reservation_code);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
