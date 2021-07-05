<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.springlec.air4men.dto.AdminUserDto"%>
<%@page import="com.springlec.air4men.dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp" />
</head>
<body>
    

	<!-- 1.데이터 베이스에서 한회원의 정보를 가져옴 2. table태그를 이용하며 화면에 회원의 정보를 출력 -->
<%
	String userId =request.getParameter("userId");	//memberlist id 를 받아줌

	SqlSession sqlSession=null;
	
	AdminDao dao=sqlSession.getMapper(AdminDao.class);
	AdminUserDto dto = dao.oneSelectMember(userId); //해당하는 id의 화원정보를 리턴
%>
<div class="container marketing" id="marketing2">
<div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="Admin_Index.jsp">4menAir</a>
        </div>     
</div>

<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<div class="col-sm-2"></div>
				<div class="col-sm-9">
					<h2 class="text-center">회원 정보</h2>
					<table class="table table-striped" >
					  
					  <tr>
						<td>아이디</td>
						<td>${MemberInfo.userId }</td>
					  </tr>
					  
					  <tr>
						<td>비밀번호</td>
						<td>${MemberInfo.userPw }</td>
					  </tr>
					  
					  <tr>
						<td>이름</td>
						<td>${MemberInfo.userName }</td>
					  </tr>
					  
					  <tr>
						<td>전화번호</td>
						<td>${MemberInfo.userTel }</td>
					  </tr>
					  
					  <tr>
						<td>이메일</td>
						<td>${MemberInfo.userEmail }</td>
					  </tr>
					  
					 <tr>
						<td>주소</td>
						<td>${MemberInfo.userAdd }</td>
					  </tr>
					  
					  <tr>
						<td>생성일</td>
						<td>${MemberInfo.userCRDate }</td>
					  </tr>
					 
					  <tr>
						<td>탈퇴일</td>
						<td>${MemberInfo.userDLDate }</td>
					  </tr>
					  
					  
					<tr>
						 <td class="text-center" colspan="2">
	<button onclick="location.href='Delete_Member?userId=${MemberInfo.userId }'" class="btn btn-danger">회원탈퇴</button>
	<button onclick="location.href='Client_List'" class="btn btn-warning">목록보기</button>						 
						 </td>	
					</tr>	
				</table>
				
			
		
				
				</div>
			</div>	
		</div>
	</div>
</div>	
<script>
function refreshPage(){
    window.location.reload();
} 
</script>

</body>
</html>
