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
		<h2 class="text-center">공지 보기</h2><p>&nbsp;</p>
			<form action="Notice_Modify?board_num=${param.board_num}" method="post">
			<div class="table table-responsive">
					  <table class="table table-striped">
		
		 	<tr>
		 		<td class="danger">제목</td>
		 		<td colspan="3"><input type="text"  class="form-control" name="subject"  value="${notice.board_name}"></td>
		 	</tr>
		 	
		 	<tr>
		 		<td class="danger">내용</td>
		 		<td colspan="12"><textarea  rows="10" name="content" class="form-control" >${notice.board_contents}</textarea></td>
		 	</tr>
		 	
		  	<tr>	
		 		<td colspan="4"  class="text-center">
		 			<input type="submit" class="btn btn-warning" value="수정하기" >
		 			<input type="button" class="btn btn-warning" onClick="location.href='Notice_Delete?board_num=${param.board_num}'" value="삭제하기" >
		 			<input type="button" class="btn btn-primary" onclick="location.href='AdminNotice_List'" value="목록으로">
		 		</td>
		 	</tr>
		 	
		  </table>
		
	
	</div>
	</form>
		
	 	<%-- <form action="Notice_Modify?board_num=${param.board_num}" method="post" enctype="multipart/form-data">
	 		
		 		<td class="danger">파일</td>
		 		<td colspan="12"><input type="file" name="File"></td>
		 	
	 	</form> --%>
	</div>
</div>
</body>
</html>