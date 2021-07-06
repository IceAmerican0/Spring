<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호찾기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/userLogin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript" src="Login/Login_Js/userPwfind.js">
	
</script>
<body>
    <div class="container-login">
        <div class="container-img">
            <img src="images/air4men.jpeg">
        </div>
    </div>
    <div class="container">
        <h3>비밀번호찾기</h3>
        <form action="userPwfind" class="pwFindForm mt-5" name="pwFindForm" method="post">
            <div class="form-group row">
                <div class="col-xl-3">
                    <label for="userName">아이디 : </label>
                </div>
                <div class="col-xl-9">
                    <input type="text" name="userId" class="form-control" placeholder="아이디를 입력해주세요">
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
                    <input type="submit" value="찾기">
                </div>
            </div>
            <div class="form-group">
                <a href="userLogin_view">로그인화면으로</a>
            </div>
        </form>
    </div>
</body>
</html>