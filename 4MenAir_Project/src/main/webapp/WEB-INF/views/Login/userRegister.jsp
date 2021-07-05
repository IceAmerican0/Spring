<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/userLogin.css">
<link rel="stylesheet" type="text/css" href="css/userRegister_view.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript" src="Login/Login_Js/userRegister.js">
	
</script>
<body>
    <div class="container-login">
        <div class="container-img">
            <a href="userLogin_view"><img src="images/air4men.jpeg" ></a>
        </div>
    </div>
    <div class="container">
        <h3>회원가입</h3>
        <form action="userRegister" class="registerForm mt-5" name="registerForm" method="post">
            <div class="form-group row">
                <div class="col-xl-3">
                    <label for="userId">아이디</label>
                </div>
                <div class="col-xl-9">
                    <input type="text" name="userId" class="form-control" placeholder="아이디를 입력해주세요">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xl-3">
                    <label for="userPw1">비밀번호</label>
                </div>
                <div class="col-xl-9">
                    <input type="password" name="userPw1" class="form-control" placeholder="비밀번호를 입력해주세요">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xl-3">
                    <label for="userPw2">비밀번호 확인</label>
                </div>
                <div class="col-xl-9">
                    <input type="password" name="userPw2" class="form-control" placeholder="비밀번호를 한번 더 입력해주세요">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xl-3">
                    <label for="userName">이름</label>
                </div>
                <div class="col-xl-9">
                    <input type="text" name="userName" class="form-control" placeholder="이름을 입력해주세요">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xl-3">
                    <label for="userTel">전화번호</label>
                </div>
                <div class="col-xl-9">
                    <input type="text" name="userTel" class="form-control" placeholder="전화번호를 입력해주세요 ex)01000000000">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xl-3">
                    <label for="userBirthday">생일</label>
                </div>
                <div class="col-xl-9">
                    <input type="text" name="userBirthday" class="form-control" placeholder="생일을 입력해주세요 ex)891210">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-xl-3">
                    <label for="userEmail1">이메일</label>
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
            <div class="form-group row">
                <div class="col-xl-3">
                    <label for="userAdd">주소</label>
                </div>
                <div class="col-xl-7">
                    <input type="text" name="userAdd" placeholder="주소 찾기 버튼을 눌러주세요" class="form-control" readonly>
                </div>
                <div class="col-xl-2 findButton">
                    <input type="button" name="findButton" onclick="goPopup()" value="주소찾기" />
                </div>
            </div>
            <div class="form-group row mt-5">
                <div class="col-xl-12">
                    <input type="button" value="회원가입" onclick="inputCheck()">
                </div>
            </div>
        </form>
    </div>
</body>
</html>