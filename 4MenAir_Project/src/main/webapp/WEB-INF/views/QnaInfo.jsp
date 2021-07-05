<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.springlec.air4men.dto.AdminQnaDto"%>
<%@page import="com.springlec.air4men.dto.AdminUserDto"%>
<%@page import="com.springlec.air4men.dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp"/>
</head>
<body>
<%
	//해당 게시글번호를 통하여 게시글을 수정
	String qnA_Code = request.getParameter("qnA_Code");

	//하나의 게시글의 대한 정보를 리턴
	SqlSession sqlSession=null;
	
	AdminDao dao=sqlSession.getMapper(AdminDao.class);
	AdminQnaDto dto = dao.oneSelectQnaMember(qnA_Code);
%>

<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<h2 class="text-center">문의 답하기</h2><p>&nbsp;</p>
			<div class="table table-responsive">
			<form action="QnA_Reply" method="post">
					  <table class="table table-striped">
		
		 	<tr>
		 		<td class="danger">제목</td>
		 		<td colspan="3"><input type="text"  class="form-control" name="subject" value="${QnaInfo.board_Name }" readonly></td>
		 	</tr>
		 	
		 	<tr>
		 		<td class="danger">내용</td>
		 		<td colspan="20"><input type="text"  class="form-control" name="content" value="${QnaInfo.board_Contents }" readonly></td>
		 	</tr>
		 	
		 	<tr>
		 		<td class="danger">답변</td>
		 		<td colspan="12"><textarea  name="qnareply" class="form-control">${QnaInfo.qnAReply }</textarea></td>
		 	</tr>
		 	
		 	<tr>
				<td class="danger">작성일</td>
				<td colspan="3"><input type="text"  class="form-control" name="board_create_date" value="${QnaInfo.board_Create_Date }" readonly></td>
		 	</tr>
			<tr>
				<td class="danger">답변일</td>
				<td colspan="3"><input type="text"  class="form-control" name="qnarepdate" value="${QnaInfo.qnARepDate }" readonly></td>
		 	</tr>
		 	
		  	<tr>	
		 		<td colspan="4"  class="text-center">
		 			<input type="hidden" name="num"  value="${QnaInfo.board_Num}">
		 			<input type="submit" class="btn btn-warning" value="답변하기" >
		 		</td>
		 	</tr>
		  </table>
		</form>
		 			<input type="button" class="btn btn-primary" onclick="location.href='QnA_List'" value="목록으로">
	
			</div>
	</div>
</div>




</body>
</html>