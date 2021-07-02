<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q & A</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/userPayment.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <%@ include file="../flights_List/flights_top.jsp"%>
    <div class="container">
        <div class="userInfo-top row">
            <div class="userInfo col-xl-10">${param.userId}님의 문의내역</div>
            <div class="toMain col-xl-2">
                <a href="main_view.do?userId=${param.userId }">메인으로</a>
            </div>
        </div>
    </div>
    <div class="container list">
        <table class="table table-hover">
            <thead>
                <tr>
                    <td>문의번호</td>
                    <td>제목</td>
                    <td>작성날짜</td>
                    <td>답변날짜</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="dto" varStatus="status">
                    <tr style="cursor: pointer;" onClick=" location.href='userQna_view.do?userId=${param.userId}&board_num=${dto.board_num}' " onMouseOver=" indow.status = 'http://ihouse.so.vc' " onMouseOut=" window.status = '' ">
                        <td>
                                <c:out value="${status.count}" />
                        </td>
                        <td>${dto.board_name}</td>
                        <td>${dto.board_create_date}</td>
                        <td>
                            <c:choose>
                                <c:when test="${empty dto.qnarepdate}"></c:when>
                                <c:otherwise>${dto.qnarepdate }</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="userQnaWrite_view.do?userId=${param.userId}" method="post">
            <input type="submit" value="문의하기">
        </form>
    </div>
s</body>
</html>