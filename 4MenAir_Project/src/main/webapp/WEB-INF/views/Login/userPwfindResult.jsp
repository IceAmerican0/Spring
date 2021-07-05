<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>비밀번호찿기 결과</title>
	<link rel="stylesheet" href="Main.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<style>
	.container{
		position:absolute;
		text-align:center;
		width:100%;
		height:100%;
		top:0;
		left:0;
	}
	.container .result{
		display:inline-block;
		vertical-align: middle;
	}
	.container .blank{
		display: inline-block;
		width: 0;
		height: 100%;
		vertical-align: middle
	}
</style>
<body>
	<div class="container">
		<h1 class="result">${userId }님의 비밀번호는 ${FinduserPw } 입니다!!</h1>
		<a href="userLogin_view">로그인화면으로</a>
		<span class="blank"></span>
	</div>
</body>
</html>