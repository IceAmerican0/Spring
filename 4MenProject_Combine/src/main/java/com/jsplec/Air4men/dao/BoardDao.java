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

import com.jsplec.Air4men.dto.BoardDto;

public class BoardDao {
	DataSource datasource;
	
	public BoardDao() {
		try {
			Context context = new InitialContext();
			datasource=(DataSource) context.lookup("java:comp/env/jdbc/4menair");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
//=======================문의 내역 리스트 불러오기=====================
	
		public ArrayList<BoardDto> list(String userId) {
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;
			ArrayList<BoardDto> dtos=new ArrayList<BoardDto>();
			
			try {
				connection=datasource.getConnection();
				
				String query="select b.board_num, b.board_name, b.board_create_date, q.qnarepdate from qna_answer q, bulletin_board b where b.board_num=q.board_num and b.board_user_name=? and b.board_delete_date is null order by board_create_date desc";
				//최근 문의 내역이 맨위로 오도록 정렬
				
				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setString(1,userId);
				resultSet=preparedStatement.executeQuery();
				
				
				while(resultSet.next()) {
					int board_num=Integer.parseInt(resultSet.getString("b.board_num"));
					String board_name=resultSet.getString("b.board_name");
					Timestamp board_create_date=resultSet.getTimestamp("b.board_create_date");
					Timestamp qnarepdate=resultSet.getTimestamp("q.qnarepdate");
					
					BoardDto dto=new BoardDto(board_num, board_name, board_create_date, qnarepdate);
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
		
//=======================문의 사항 작성하기 1=========================
		
		public void userQnaWriteAction(String userId,String board_name,String board_contents) {
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			
			try {
				connection=datasource.getConnection();
				
				String query="insert into bulletin_board (board_category,board_user_name,board_name,board_contents,board_create_date) values (?,?,?,?,now())";
				String board_category="qna";
				preparedStatement=connection.prepareStatement(query);
				
				preparedStatement.setString(1,board_category);
				preparedStatement.setString(2,userId);
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
		
//=======================문의 사항 작성하기 2(qna 빈 답변 만들기)=========================
		
		public void userQnaWriteAction2(String userId,String board_name,String board_contents) {
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			
			try {
				connection=datasource.getConnection();
				
				String query="insert into qna_answer (qna_code,board_num,qnareply,qnaadminid,qnarepdate) " + 
						"select b.board_num, b.board_num,null,null,null " + 
						"from bulletin_board b " + 
						"where b.board_user_name=? and b.board_name=? and board_contents=?";
				preparedStatement=connection.prepareStatement(query);
				
				preparedStatement.setString(1,userId);
				preparedStatement.setString(2,board_name);
				preparedStatement.setString(3,board_contents);
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
		
		
		
		
//=======================선택한 문의 내역 불러오기=====================	
	
		public BoardDto userQnaSelectedAction(int boardNum) {
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;
			BoardDto dto=null;
			
			
			try {
				connection=datasource.getConnection();
				
				String query="select b.board_num, b.board_name, b.board_contents, q.qna_code, q.qnaadminid, q.qnareply, q.qnarepdate from qna_answer q, bulletin_board b where b.board_num=? and b.board_num=q.board_num";
				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setInt(1,boardNum);
				resultSet=preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					int board_num=resultSet.getInt("b.board_num");
					String board_name=resultSet.getString("b.board_name");
					String board_contents=resultSet.getString("b.board_contents");
					int qna_code=resultSet.getInt("q.qna_code");
					String qnaAdminId=resultSet.getString("q.qnaadminid");
					String qnareply=resultSet.getString("q.qnareply");
					Timestamp qnarepdate=resultSet.getTimestamp("q.qnarepdate");
					
					dto=new BoardDto(board_num, board_name, board_contents, qna_code, qnareply, qnaAdminId, qnarepdate);
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
		
		public void userQnaModifyAction(int boardNum,String board_name,String board_contents) {
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			
			try {
				connection=datasource.getConnection();
			
				String query="update bulletin_board set board_name=?, board_contents=? where board_num=?";
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
		public void userQnaDeleteAction(String board_num) {
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
