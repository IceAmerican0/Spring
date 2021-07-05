<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <div class="userInfo col-xl-10">공지사항</div>
            <div class="toMain col-xl-2">
                <a href="main_view?userId=${param.userId }">메인으로</a>
            </div>
        </div>
    </div>
    <div class="container list">
        <table class="table table-hover">
            <thead>
                <tr>
                    <td>번호</td>
                    <td>제목</td>
                    <td>작성일</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list }" var="dto" varStatus="status">
                    <tr style="cursor: pointer;" onClick=" location.href='Notice_Selected?board_num=${dto.board_num}&userId=${param.userId} " onMouseOver=" indow.status = 'http://ihouse.so.vc' " onMouseOut=" window.status = '' ">
                        <td>
                            <c:out value="${status.count}" />
                        </td>
                        <td>${dto.board_name}</td>
                        <td>${dto.board_create_date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>