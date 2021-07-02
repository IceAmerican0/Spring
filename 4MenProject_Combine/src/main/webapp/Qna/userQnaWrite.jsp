<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Q & A</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
	<script type="text/javascript" src="Qna/userQna.js">
	</script>
<body>
    <%@ include file="../flights_List/flights_top.jsp"%>
	<div class="container">
		<br><h3 style=text-align:center>Q & A</h3><br>
		<a href="main_view.do?userId=${param.userId}">메인으로</a>
		<form action="userQnaWrite.do?userId=${param.userId}" class="qnawrite" name="qnawrite" method="post">
			<div class="form-group">
				<label for="board_name">제목</label>
				<input type="text" name="board_name" class="form-control" >
			</div>
			<div class="form-group">
				<label for="board_contents">문의내용</label>
				<textarea class="form-control" name="board_contents" rows="10" ></textarea>
			</div>
			<div class="form-group">
				<input type="submit" value="작성하기" >
			</div>
		</form>
	</div>
</body>
</html>