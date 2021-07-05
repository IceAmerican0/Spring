<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp" />
<title>공지사항</title>
</head>
<body>


<div class="row">
	<div class="col-sm-2"></div>
	
	
	<div class="col-sm-9">
		<br><h2 class="text-center">공지사항</h2>
		<br><br>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
				  <td>번호</td>
				  <td>제목</td>
				  <td>작성일</td>
				</tr>
				<c:forEach items="${list }" var="dto"  varStatus="status">
				 <tr>
				    <td><a href="AdminNotice_Selected?board_num=${dto.board_num}"><c:out value="${status.count}"/></a></td>
				    <td>${dto.board_name}</td>
				    <td>${dto.board_create_date}</td>
				 </tr>
				</c:forEach>
			</table>
			<input type="button" class="btn btn-primary" onclick="location.href='Notice_Write_View'" value="공지 작성하기">
		</div>
		
	</div>
	
</div>
</body>
</html>