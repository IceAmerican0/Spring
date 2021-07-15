<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 로그인</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<script type="text/javascript">
	function valid_check(){

	if (document.LoginInfo.adminId.value == "")
	{
		alert("아이디를 입력하여 주시기 바랍니다.");
		document.LoginInfo.adminId.focus();
		return false;
	}

	if (document.LoginInfo.adminPw.value == "")
	{
		alert("비밀번호를 입력하여 주시기 바랍니다.");
		document.LoginInfo.adminPw.focus();
		return false;
	}

	document.LoginInfo.submit();

}

 </script>

<body>
	<div class="container">
		<h3>관리자 로그인</h3>
		<form name="LoginInfo" method="get" action="Admin_LoginChk" 
                onsubmit="return valid_check()">
			<div class="form-group" >
				<label for="adminId">아이디 : </label>
				<input type="text" name="adminId" class="form-control" placeholder="아이디를 입력해주세요">
			</div>
			<div class="form-group">
				<label for="adminPw">비밀번호 : </label>
				<input type="password" name="adminPw"  class="form-control">
			</div>
			<div class="form-group">
				<input type="submit" value="로그인">
			</div>
		</form>
	</div>

<% 
     // 아이디, 비밀번호가 틀릴경우 화면에 메시지 표시
            // LoginPro.jsp에서 로그인 처리 결과에 따른 메시지를 보낸다.
            String msg=request.getParameter("msg");
            
            if(msg!=null && msg.equals("0")) 
            {
                out.println("<br>");
                out.println("<font color='red' size='3'>비밀번호를 확인해 주세요.</font>");
            }
            else if(msg!=null && msg.equals("-1"))
            {    
                out.println("<br>");
                out.println("<font color='red' size='3'>아이디를 확인해 주세요.</font>");
            }
%>    

</body>
</html>
