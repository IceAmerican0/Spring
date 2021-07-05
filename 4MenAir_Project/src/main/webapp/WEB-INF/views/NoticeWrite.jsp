<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp"/>
<title>공지사항</title>
</head>
<body>
<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<h2 class="text-center">공지 작성하기</h2><p>&nbsp;</p>
			<form action="filetest.jsp" method="post" enctype="multipart/form-data">
			<div class="table table-responsive">
					  <table class="table table-striped">
		
		 	<tr>
		 		<td class="danger">제목</td>
		 		<td colspan="3"><input type="text"  class="form-control" name="subject" ></td>
		 	</tr>
		 	
		 	<tr>
		 		<td class="danger">내용</td>
		 		<td colspan="12"><textarea  rows="10" name="content" class="form-control"></textarea></td>
		 	</tr>
		 	
		 	<tr>
		 		<td class="danger">파일</td>
		 		<td colspan="12"><input type="file" name="fileName"></td>
		 	</tr>
		 	
		  	<tr>	
		 		<td colspan="4"  class="text-center">
		 			<input type="submit" class="btn btn-warning" value="작성하기" >
		 			<input type="button" class="btn btn-primary" onclick="location.href='AdminNotice_List'" value="목록으로">
		 		</td>
		 	</tr>
		  </table>
		</div>
		</form>
		
		<!-- <form action="Notice_Write" method="post" enctype="multipart/form-data">
		 		파일 <input type="file" name="File">
		</form> -->
	</div>
</div>
</body>
</html>