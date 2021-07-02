<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Q & A</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/userPayment.css">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
	<script type="text/javascript" src="Qna/userQna.js">
	</script>
<body>
    <%@ include file="../flights_List/flights_top.jsp"%>
    <div class="container">
        <div class="userInfo-top row">
            <div class="userInfo col-xl-10">Q & A</div>
            <div class="toMain col-xl-2">
                <a href="main_view.do?userId=${param.userId }">메인으로</a>
            </div>
        </div>
    </div>
	<div class="container">
		<form action="userQnaDelete.do?userId=${param.userId}" class="boardForm" name="boardForm" method="post">
			<input type="hidden" name="board_num" value="${board.board_num}">
			<div class="form-group">
				<label for="board_name">제목</label>
				<input type="text" name="board_name" class="form-control"  value="${board.board_name}">
			</div>
			<div class="form-group">
				<label for="board_contents">문의내용</label>
				<textarea class="form-control" name="board_contents" rows="10" >${board.board_contents}</textarea>
			</div>
			<div class="form-group">
				<input type="button" value="삭제하기" onclick="deleteAction()">
			</div>
		</form>
<%
	if(request.getAttribute("qnareply")!=null){//답변이 있으면 띄우고 없으면 안띄움
%>
			<div class="form-group">
				<label for="admin">답변자</label>
				<input type="text" name="admin" class="form-control"  value="${board.qnaAdminId}" readonly>
			</div>
			<div class="form-group">
				<label for="qnarepdate">답변날짜</label>
				<input type="text" name="qnarepdate" class="form-control"  value="${board.qnarepdate}" readonly>
			</div>
			<div class="form-group">
				<label for="qnareply">답변내용</label>
				<textarea class="form-control" name="qnareply" rows="10"  readonly>${board.qna_reply}</textarea>
			</div>
			
<%
	}
%>
	</div>
</body>
</html>