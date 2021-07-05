<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>마이페이지</title>
	<link rel="stylesheet" href="Main.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<br><h2 style="text-align:center">내정보</h2><br>
		<a href="main_view?userId=${param.userId }" style="text-align:right">메인으로</a>
		<a href="userReservationList_view?userId=${param.userId }">예약정보</a>
		<a href="userQnaList_view?userId=${userId }">Q & A</a>		
		<form action="userPw_change">
		<table class="table">
			<tbody>
				<tr>
					<td>아이디 : </td>
					<td>${userId}</td>
				</tr>
				<tr>
					<td>이름 : </td>
					<td>${userInfo.userName}</td>
				</tr>
				<tr>
					<td>주소 : </td>
					<td>${userInfo.userAdd}</td>
				</tr>
				<tr>
					<td>이메일 : </td>
					<td>${userInfo.userEmail}</td>
				</tr>
				<tr>
					<td>전화번호 : </td>
					<td>${userInfo.userTel}</td>
				</tr>
				<tr>
					<td>생일 : </td>
					<td>${userInfo.userBirthday}</td>
				</tr>
				
				<tr>
					<td>현재 비밀번호 : </td>
					<td><input type="password" name="oldPw"/></td>
				</tr>
				<tr>
					<td>새 비밀번호 : </td>
					<td><input type="password" name="newPw1"/></td>
				</tr>
				<tr>
					<td>새 비밀번호 확인 : </td>
					<td><input type="password" name="newPw2"/></td>
				</tr>
				<tr>
					<td><input type="button" value="비밀번호 변경" onclick="inputCheck()"/></td>
				</tr>
				
			</tbody>
		</table>
		</form>		
	</div>
</body>
</html>