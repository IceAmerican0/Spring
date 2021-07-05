<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/userLogin_view.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript" src="Login/Login_Js/userLogin.js">
	
</script>
<body>
    <div class="container-login">
        <div class="container-img">
            <img src="images/air4men.jpeg">
        </div>
        <div class="container">
            <h3>로그인</h3>
            <form action="userLogin" name="loginForm" method="post">
                <div class="form-group">
                    <label for="userId">아이디 </label>
                    <input type="text" name="userId" class="form-control" placeholder="아이디를 입력해주세요">
                </div>
                <div class="form-group">
                    <label for="userPw">비밀번호 </label>
                    <input type="password" name="userPw" class="form-control" placeholder="비밀번호를 입력해주세요">
                </div>
                <div class="form-group">
                    <input class="login-button" type="button" value="로그인" onclick="inputCheck()">
                </div>
                <ul class="nav">
                    <li class="nav-item"><a class="nav-link" href="userRegister_view">회원가입</a></li>
                    <li class="nav-item"><a class="nav-link" href="userIdfind_view">아이디찾기</a></li>
                    <li class="nav-item"><a class="nav-link" href="userPwfind_view">비밀번호찾기</a></li>
                    <div>${msg}</div>
                </ul>
            </form>
            <%-- <%
		// 아이디, 비밀번호가 틀릴경우 화면에 메시지 표시
        // LoginPro.jsp에서 로그인 처리 결과에 따른 메시지를 보낸다.
        String msg=(String)request.getAttribute("msg");

        if(msg!=null && msg.equals("0")){
            out.println("<br>");
            out.println("<font color='red' size='5'>비밀번호를 확인해 주세요.</font>");
        }else if(msg!=null && msg.equals("-1")){    
            out.println("<br>");
            out.println("<font color='red' size='5'>아이디를 확인해 주세요.</font>");
        }else if(msg!=null&&msg.equals("1")){
        	response.sendRedirect("main_view");
        }
        
%> --%>
        </div>
    </div>
</body>
</html>