<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp" />
</head>
<body>


<div class="row">
	<div class="col-sm-2"></div>
	
	
	<div class="col-sm-9">
		<br><h2 class="text-center">회원 관리</h2>
		<br><br>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
				  <td>아이디</td>
				  <td>비밀번호</td>
				  <td>이름</td>
				  <td>이메일</td>
				  <td>전화번호</td>
				  <td>주소</td>
				  <td>생성일</td>
				  <td>탈퇴일</td>
				  <td>사진</td>
				</tr>
				<c:forEach items="${list }" var="dto" >
				 <tr>
				    <td><a href="/4men_KDS/Client_View?userId=${dto.userId }">${dto.userId }</a></td>
				    <td>${dto.userPw }</td>
				    <td>${dto.userName }</td>
				    <td>${dto.userTel }</td>
				    <td>${dto.userEmail }</td>
				    <td>${dto.userAdd }</td>
				    <td>${dto.userCRDate }</td>
				    <td>${dto.userDLDate }</td>
				 </tr>
				</c:forEach>
			</table>
		</div>
		
	</div>
	
</div>
<script>
function Refresh(){  
       location.reload();
}
</script>


</body>
</html>