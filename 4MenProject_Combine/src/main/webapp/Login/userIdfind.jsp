<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/userLogin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript" src="Login/Login_Js/userIdfind.js">
	
</script>
<body>
    <div class="container-login">
        <div class="container-img">
            <img src="images/AIR4men.jpeg">
        </div>
    </div>
    <div class="container">
        <h3>아이디찾기</h3>
        <form action="userIdfind.do" class="idFindForm mt-5" name="idFindForm" method="post">
            <div class="form-group row">
                <div class="col-xl-3">
                    <label for="userName">이름 : </label>
                </div>
                <div class="col-xl-9">
                    <input type="text" name="userName" class="form-control" placeholder="이름을 입력해주세요">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xl-3">
                    <label for="userTel">전화번호 : </label>
                </div>
                <div class="col-xl-9">
                    <input type="text" name="userTel" class="form-control" placeholder="전화번호를 입력해주세요">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xl-3">
                    <label for="userEmail">이메일 : </label>
                </div>
                <div class="col-xl-6">
                    <input type="text" name="userEmail1" class="form-control" placeholder="이메일을 입력해주세요">
                </div>
                <div class="col-xl-3">
                    <select name="userEmail2">
                        <option value="@naver.com" selected>naver.com</option>
                        <option value="@daum.net">daum.net</option>
                        <option value="@gmail.com">gmail.com</option>
                    </select>
                </div>
            </div>
            <div class="form-group row mt-5">
            <div class="col-xl-12">
                <input type="button" value="&nbsp;&nbsp;&nbsp;&nbsp;찾기&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" onclick="inputCheck()">
            </div>
            </div>
            <div class="form-group">
                <a href="userLogin_view.do">로그인화면으로</a>
            </div>
        </form>
    </div>
</body>
</html>