<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
 
<html>
<head>
    <title>관리자 페이지</title>

    <script type="text/javascript">
        // 로그아웃 담당 JSP로 이동
        function Admin_Logout(){
            location.href="Admin_Logout.jsp";
        }
    </script>
    
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">	
</head>
	<div style="text-align:center">
	<h2>관리자 페이지</h2>
	</div>
	
    <div align="right">
    관리자
    <input type="button" value="로그아웃" onclick="Admin_Logout()" />    
    </div>
   
	<div align="center">
            <button class="btn btn-success" onclick="location.href='Client_List'">회원관리</button> <br/><br/>
            <button class="btn btn-info" onclick="location.href='DeleteClient_List'">탈퇴회원관리</button> <br/><br/>
            <button class="btn btn-warning" onclick="location.href='QnA_List'">1:1 문의 내역</button> <br/><br/>
            <button class="btn btn-danger" onclick="location.href='AdminNotice_List'">공지사항 리스트</button> <br/><br/>
        </div>
	
</body>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</html>

    <%
        if(session.getAttribute("sessionID") == null) // 로그인이 안되었을 때
        { 
            // 로그인 화면으로 이동
            response.sendRedirect("Admin_Login.jsp");
        }
        else // 로그인 했을 경우
        {
    %>
    <%} %>    

