<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="edit" method="post">
<table border="1">
	<tr>
	<td>번호</td>
	<td><input type="hidden" name="seqno" value="${content.seqno}">${content.seqno}</td>
	</tr>
	<tr>
	<td>이름</td>
	<td><input type="text" name="name" size="50" value="${content.name }"></td>
	</tr>
	<tr>
	<td>전화번호</td>
	<td><input type="text" name="telno" size="50" value="${content.telno}"></td>
	</tr>
	<tr>
	<td>주소</td>
	<td><input type="text" name="address" size="50" value="${content.address}"></td>
	</tr>
	<tr>
	<td>전자우편</td>
	<td><input type="text" name="email" size="50" value="${content.email}"></td>
	</tr>
	<tr>
	<td>관계</td>
	<td><input type="text" name="relation" size="50" value="${content.relation}"></td>
	</tr>
	<tr>
	<td colspan="2"><input type="submit" value="수정">&nbsp; &nbsp;<a href="delete?seqno=${content.seqno}">삭제</a> </td>
	</tr>
	
</table>
</form>
</body>
</html>