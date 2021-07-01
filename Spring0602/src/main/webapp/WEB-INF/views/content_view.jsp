<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<form action="edit" method="post">
		<input type="hidden" name="bId" value="${content.bId}">
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" size="20" value="${content.bName}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" size="50" value="${content.bTitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bContent" rows="10">${content.bContent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;<a href="list">목록</a> &nbsp;&nbsp;<a href="delete?bId=${content.bId}">삭제</a>
			</tr>
		</form>
	</table>
</body>
</html>