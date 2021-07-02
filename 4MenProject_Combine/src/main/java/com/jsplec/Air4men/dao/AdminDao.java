package com.jsplec.Air4men.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.Air4men.dto.AdminDto;
import com.jsplec.Air4men.dto.AdminQnaDto;
import com.jsplec.Air4men.dto.AdminUserDto;

public class AdminDao {

	private static AdminDao instance;

	public static AdminDao getInstance() {
		if (instance == null)
			instance = new AdminDao();
		return instance;
	}

	DataSource dataSource;

	public AdminDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/4menair");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// =============================== 관리자 로그인 ===============================
	public AdminDto AdminLogin(String inputId, String inputPw) {
		AdminDto adminDto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null; // select할 때만 씀

		try {
			connection = dataSource.getConnection();

			String query = "select AdminId, AdminPw, AdminTel, AdminEmail from admininfo where AdminId = ? and AdminPw = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, inputId);
			preparedStatement.setString(2, inputPw);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String AdminId = resultSet.getString("adminId");
				String AdminPw = resultSet.getString("adminPw");
				String AdminTel = resultSet.getString("adminTel");
				String AdminEmail = resultSet.getString("adminEmail");

				adminDto = new AdminDto(AdminId, AdminPw, AdminTel, AdminEmail);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return adminDto;

	}

	// =============================== 관리자 로그인 체크 ===============================
	public int loginCheck(String id, String pw) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null; // select할 때만 씀

		String dbPW = ""; // db에서 꺼낸 비밀번호를 담을 변수
		int x = -1;

		try {
			// 쿼리 - 먼저 입력된 아이디로 DB에서 비밀번호를 조회한다.
			StringBuffer query = new StringBuffer();
			query.append("select AdminPw from admininfo where AdminId=?");

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query.toString());
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) // 입려된 아이디에 해당하는 비번 있을경우
			{
				dbPW = resultSet.getString("AdminPw"); // 비번을 변수에 넣는다.

				if (dbPW.equals(pw))
					x = 1; // 넘겨받은 비번과 꺼내온 배번 비교. 같으면 인증성공
				else
					x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패

			} else {
				x = -1; // 해당 아이디가 없을 경우
			}

			return x;

		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
					preparedStatement = null;
				}
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	// =============================== 회원 리스트 ===============================
	public ArrayList<AdminUserDto> list() {
		ArrayList<AdminUserDto> dtos = new ArrayList<AdminUserDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null; // select할 때만 씀

		try {
			connection = dataSource.getConnection();

			String query = "select UserId, UserPw, UserName, UserTel, UserEmail, UserAdd, UserCRDate, UserDLDate from userinfo where UserDLDate IS NULL";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String userId = resultSet.getString("UserId"); // "bId"는 쿼리 문장에 있는 bId임
				String userPw = resultSet.getString("UserPw");
				String userName = resultSet.getString("UserName");
				String userEmail = resultSet.getString("UserEmail");
				String userTel = resultSet.getString("UserTel");
				String userAdd = resultSet.getString("UserAdd");
				Timestamp userCRDate = resultSet.getTimestamp("UserCRDate");
				Timestamp userDLDate = resultSet.getTimestamp("UserDLDate");

				AdminUserDto dto = new AdminUserDto(userId, userPw, userName, userEmail, userTel, userAdd, userCRDate,
						userDLDate);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}

	// =============================== 회원 보기 ===============================
	public AdminUserDto oneSelectMember(String userid) {
		// 한사람에 대한 정보만 리턴하기에 빈클래스 객체 생성
		AdminUserDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null; // select할 때만 씀
		try {
			// 커넥션연결
			connection = dataSource.getConnection();
			// 쿼리 준비
			String query = "select * from userinfo where UserId =? ";
			preparedStatement = connection.prepareStatement(query);
			// ?에 값을 맵핑
			preparedStatement.setString(1, userid);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String userId = resultSet.getString("UserId"); // "UserId"는 쿼리 문장에 있는 UserId임
				String userPw = resultSet.getString("UserPw");
				String userName = resultSet.getString("UserName");
				String userEmail = resultSet.getString("UserEmail");
				String userTel = resultSet.getString("UserTel");
				String userAdd = resultSet.getString("UserAdd");
				Timestamp userCRDate = resultSet.getTimestamp("UserCRDate");
				Timestamp userDLDate = resultSet.getTimestamp("UserDLDate");

				dto = new AdminUserDto(userId, userPw, userName, userEmail, userTel, userAdd, userCRDate, userDLDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 반납
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					resultSet.close();
				if (connection != null)
					connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	// =============================== 회원 탈퇴 ===============================
	public void deleteMember(String userid) {
		// 한사람에 대한 정보만 리턴하기에 빈클래스 객체 생성
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// 커넥션 연결
			connection = dataSource.getConnection();
			// 쿼리 준비
			String query = "update userinfo set UserDLDate=now() where (UserId=?)";
			// 쿼리실행 객체 선언
			preparedStatement = connection.prepareStatement(query);
			// ?에 값을 맴핑
			preparedStatement.setString(1, userid);
			// 쿼리 실행
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 반납
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// =============================== 탈퇴 회원 리스트 ===============================
	public ArrayList<AdminUserDto> Deletelist() {
		ArrayList<AdminUserDto> dtos = new ArrayList<AdminUserDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null; // select할 때만 씀

		try {
			connection = dataSource.getConnection();

			String query = "select UserId, UserPw, UserName, UserTel, UserEmail, UserAdd, UserCRDate, UserDLDate from userinfo where UserDLDate IS NOT NULL";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String userId = resultSet.getString("UserId"); // "bId"는 쿼리 문장에 있는 bId임
				String userPw = resultSet.getString("UserPw");
				String userName = resultSet.getString("UserName");
				String userEmail = resultSet.getString("UserEmail");
				String userTel = resultSet.getString("UserTel");
				String userAdd = resultSet.getString("UserAdd");
				Timestamp userCRDate = resultSet.getTimestamp("UserCRDate");
				Timestamp userDLDate = resultSet.getTimestamp("UserDLDate");

				AdminUserDto dto = new AdminUserDto(userId, userPw, userName, userEmail, userTel, userAdd, userCRDate,
						userDLDate);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}

	// =============================== 탈퇴한 회원 보기 ===============================
	public AdminUserDto oneSelectDeleteMember(String userid) {
		// 한사람에 대한 정보만 리턴하기에 빈클래스 객체 생성
		AdminUserDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null; // select할 때만 씀
		try {
			// 커넥션연결
			connection = dataSource.getConnection();
			// 쿼리 준비
			String query = "select * from userinfo where UserId =? ";
			preparedStatement = connection.prepareStatement(query);
			// ?에 값을 맵핑
			preparedStatement.setString(1, userid);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String userId = resultSet.getString("UserId"); // "UserId"는 쿼리 문장에 있는 UserId임
				String userPw = resultSet.getString("UserPw");
				String userName = resultSet.getString("UserName");
				String userEmail = resultSet.getString("UserEmail");
				String userTel = resultSet.getString("UserTel");
				String userAdd = resultSet.getString("UserAdd");
				Timestamp userCRDate = resultSet.getTimestamp("UserCRDate");
				Timestamp userDLDate = resultSet.getTimestamp("UserDLDate");

				dto = new AdminUserDto(userId, userPw, userName, userEmail, userTel, userAdd, userCRDate, userDLDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 반납
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					resultSet.close();
				if (connection != null)
					connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	// =============================== 탈퇴한 회원 복구 ===============================
	public void RecoveryMember(String userid) {
		// 한사람에 대한 정보만 리턴하기에 빈클래스 객체 생성
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// 커넥션 연결
			connection = dataSource.getConnection();
			// 쿼리 준비
			String query = "update userinfo set UserDLDate=NULL where (UserId=?)";
			// 쿼리실행 객체 선언
			preparedStatement = connection.prepareStatement(query);
			// ?에 값을 맴핑
			preparedStatement.setString(1, userid);
			// 쿼리 실행
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 반납
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// =============================== 1:1 문의 리스트 ===============================
	public ArrayList<AdminQnaDto> Qnalist() {
		ArrayList<AdminQnaDto> dtos = new ArrayList<AdminQnaDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null; // select할 때만 씀

		try {
			connection = dataSource.getConnection();

			String query = "select q.QnA_Code, b.Board_Num, q.QnAReply, q.QnAAdminId,b.Board_Name, b.Board_Contents, b.Board_Create_Date, q.QnaRepDate "
					+ "from qna_answer q, bulletin_board b " + "where b.board_num=q.board_num and b.board_category='qna' and b.board_delete_date is null group by b.board_num order by board_create_date desc";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String qnaCode = resultSet.getString("q.QnA_Code");
				int boardNum = resultSet.getInt("b.Board_Num");
				String qnAReply = resultSet.getString("q.QnAReply");
				String adminId = resultSet.getString("q.QnAAdminId");
				String board_Name = resultSet.getString("b.Board_Name");
				String board_Contents = resultSet.getString("b.Board_Contents");
				Timestamp BoardCreateDate = resultSet.getTimestamp("b.Board_Create_Date");
				Timestamp QnaRepDate = resultSet.getTimestamp("q.QnaRepDate");

				AdminQnaDto dto = new AdminQnaDto(qnaCode, boardNum, qnAReply, adminId, board_Name, board_Contents,
						BoardCreateDate, QnaRepDate);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}

	// =============================== 1:1 문의 보기 ===============================
	public AdminQnaDto oneSelectQnaMember(String boardNum) {
		// 한사람에 대한 정보만 리턴하기에 빈클래스 객체 생성
		AdminQnaDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null; // select할 때만 씀
		try {
			// 커넥션연결
			connection = dataSource.getConnection();
			// 쿼리 준비
			String query = "select q.QnA_Code, b.Board_Num, q.QnAReply, q.QnAAdminId, b.Board_Name, b.Board_Contents, b.Board_Create_Date, q.QnaRepDate "
					+ "from qna_answer q, bulletin_board b " + "where b.board_num = ? and b.board_num=q.board_num";
			preparedStatement = connection.prepareStatement(query);
			// ?에 값을 맵핑
			preparedStatement.setString(1, boardNum);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String qnaCode = resultSet.getString("q.QnA_Code");
				int board_num = resultSet.getInt("b.Board_Num");
				String qnAReply = resultSet.getString("q.QnAReply");
				String adminId = resultSet.getString("q.QnAAdminId");
				String board_Name = resultSet.getString("b.Board_Name");
				String board_Contents = resultSet.getString("b.Board_Contents");
				Timestamp BoardCreateDate = resultSet.getTimestamp("b.Board_Create_Date");
				Timestamp QnaRepDate = resultSet.getTimestamp("q.QnaRepDate");

				dto = new AdminQnaDto(qnaCode, board_num, qnAReply, adminId, board_Name, board_Contents, BoardCreateDate,
						QnaRepDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 반납
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					resultSet.close();
				if (connection != null)
					connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	// =============================== 1:1 문의 답변하기 ===============================
	public void QnaReply(String QnAReply,String num ) {
		// 한사람에 대한 정보만 리턴하기에 빈클래스 객체 생성
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// 커넥션 연결
			connection = dataSource.getConnection();
			// 쿼리 준비
			String query = "update qna_answer set qnareply=?, qnaadminid='관리자', qnarepdate=now() where board_num=?";
			// 쿼리실행 객체 선언
			preparedStatement = connection.prepareStatement(query);
			// ?에 값을 맴핑
			preparedStatement.setString(1, QnAReply);
			preparedStatement.setString(2, num);
			// 쿼리 실행
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 반납
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}