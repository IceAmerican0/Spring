package com.jsplec.Air4men.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.Air4men.dto.NoticeDto;

public class NoticeDao {
	DataSource datasource;
	
	public NoticeDao() {
		try {
			Context context = new InitialContext();
			datasource=(DataSource) context.lookup("java:comp/env/jdbc/4menair");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//===============================공지사항 리스트 불러오기=====================
	
	public ArrayList<NoticeDto> list(){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		ArrayList<NoticeDto> dtos=new ArrayList<NoticeDto>();
		
		try {
			connection=datasource.getConnection();
			
			String query="select board_num, board_name, board_contents, board_create_date from bulletin_board where board_category=? and board_delete_date is null order by board_create_date desc";
			String board_category="notice";
			
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,board_category);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int board_num=Integer.parseInt(resultSet.getString("board_num"));
				String board_contents=resultSet.getString("board_contents");
				String board_name=resultSet.getString("board_name");
				Timestamp board_create_date=resultSet.getTimestamp("board_create_date");
				
				
				NoticeDto dto=new NoticeDto(board_num, board_name, board_contents, board_create_date);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
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
	
	//================================공지사항 작성하기================================
	public void AdminNoticeWriteAction(String board_name,String board_contents) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
			connection=datasource.getConnection();
			
			String query="insert into bulletin_board (board_category,board_user_name,board_name,board_contents,board_create_date) values (?,?,?,?,now())";
			String board_category="notice";
			String board_user_name="관리자";
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1,board_category);
			preparedStatement.setString(2,board_user_name);
			preparedStatement.setString(3,board_name);
			preparedStatement.setString(4,board_contents);
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
	
	//=======================선택한 공지사항 불러오기=====================	
	
			public NoticeDto AdminNoticeSelectedAction(int boardNum) {
				Connection connection=null;
				PreparedStatement preparedStatement=null;
				ResultSet resultSet=null;
				NoticeDto dto=null;
				
				
				try {
					connection=datasource.getConnection();
					
					String query="select board_num, board_name, board_contents,board_create_date from bulletin_board where board_num=?";
					preparedStatement=connection.prepareStatement(query);
					preparedStatement.setInt(1,boardNum);
					resultSet=preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						int board_num=Integer.parseInt(resultSet.getString("board_num"));
						String board_name=resultSet.getString("board_name");
						String board_contents=resultSet.getString("board_contents");
						Timestamp board_create_date=resultSet.getTimestamp("board_create_date");
						
						dto=new NoticeDto(board_num, board_name, board_contents, board_create_date);
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
			
			
			
			
			
	//=======================선택한 문의 내역 수정하기=====================		
			
			public void AdminNoticeModifyAction(int boardNum,String board_name,String board_contents) {
				Connection connection=null;
				PreparedStatement preparedStatement=null;
				
				try {
					connection=datasource.getConnection();
				
					String query="update bulletin_board set board_name=?, board_contents=?, board_create_date=now() where board_num=?";
					preparedStatement=connection.prepareStatement(query);
					preparedStatement.setString(1,board_name);
					preparedStatement.setString(2,board_contents);
					preparedStatement.setInt(3,boardNum);
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


			
	//=======================선택한 문의 내역 삭제하기=====================
			public void AdminNoticeDeleteAction(String board_num) {
				Connection connection=null;
				PreparedStatement preparedStatement=null;
				
				try {
					connection=datasource.getConnection();
					
					String query="update bulletin_board set board_delete_date=now() where board_num=?";
					preparedStatement=connection.prepareStatement(query);
					preparedStatement.setString(1,board_num);
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
