<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/userPayment.css">
<title>공지사항</title>
</head>
<body>
    <%@ include file="../flights_List/flights_top.jsp"%>
    <div class="container">
        <div class="userInfo-top row">
            <div class="userInfo col-xl-10">공지 보기</div>
            <div class="toMain col-xl-2">
                <a href="main_view?userId=${param.userId }">메인으로</a>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <p>&nbsp;</p>
                <div class="table table-responsive">
                    <table class="table table-striped">
                        <tr>
                            <td class="danger">제목</td>
                            <td colspan="3">
                                <input type="text" class="form-control" name="subject" value="${notice.board_name}" readonly="readonly">
                            </td>
                        </tr>
                        <tr>
                            <td class="danger">내용</td>
                            <td colspan="12">
                                <textarea rows="10" name="content" class="form-control" readonly="readonly">${notice.board_contents}</textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="danger">파일</td>
                            <td colspan="12">
                                <input type="file" name="File">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4" class="text-center">
                                <input type="button" class="btn btn-primary" onclick="location.href='Notice_List'" value="목록으로">
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>