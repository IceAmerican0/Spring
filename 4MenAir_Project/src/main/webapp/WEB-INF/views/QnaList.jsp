<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp" />
</head>
<body>


<div class="row">
	<div class="col-sm-2"></div>
	
	
	<div class="col-sm-9">
		<br><h2 class="text-center">1:1 문의 관리</h2>
		<br><br>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
				  <td>번호</td>
				  <td>제목</td>
				  <td>답변</td>
				  <td>작성일</td>
				  <td>답변일</td>
				</tr>
			
				<c:forEach items="${list }" var="dto"  varStatus="status">
				 <tr>
				    <td><a href="QnA_View?board_num=${dto.board_Num }"><c:out value="${status.count }"/></a></td>
				    <td>${dto.board_Name }</td>
				    <td>${dto.qnAReply }</td>
				    <td>${dto.board_Create_Date }</td>
				    <td>${dto.qnARepDate }</td>
				 </tr>
				</c:forEach>
			</table>
		</div>
		
	</div>
	
</div>



</body>
</html>