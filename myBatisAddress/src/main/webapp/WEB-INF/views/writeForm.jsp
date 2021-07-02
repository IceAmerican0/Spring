<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table cellpadding="0" cellspacing="0" border="1">
		<form action="write" method="post">
			<tr>
				<td > 이름 </td>
				<td> <input type="text" name="name" size = "10"> </td>
			</tr>
			<tr>
				<td> 전화번호 </td>
				<td> <input type="text" name="telno" size = "13" > </td>
			</tr>
			<tr>
				<td > 주소 </td>
				<td> <input type="text" name="address" size = "30"> </td>
			</tr>
			<tr>
				<td > 전자우편 </td>
				<td> <input type="text" name="email" size = "30"> </td>
			</tr>
			<tr>
				<td > 관계 </td>
				<td> <input type="text" name="relation" size = "30"> </td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit" value="입력"> &nbsp;&nbsp; <a href="list">목록보기</a></td>
			</tr>
		</form>
</table>
</body>
</html>