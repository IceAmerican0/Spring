<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 리스트</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/flights_top.css">
<link rel="stylesheet" href="css/userPayment.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	
</script>
<body>
    <%@ include file="../flights_List/flights_top.jsp"%>
    <div class="container">
        <div class="userInfo-top row">
            <div class="userInfo col-xl-8">${param.userId}님의 예약현황 리스트</div>
            <div class="toMain col-xl-4">
                <a href="main_view.do?userId=${param.userId }">메인으로</a>
            </div>
        </div>
    </div>
    <div class="container list">
        <table class="table table-hover">
            <thead>
                <tr>
                    <td>번호</td>
                    <td>출발지</td>
                    <td>목적지</td>
                    <td>출발 일정</td>
                    <td>도착 일정</td>
                    <td>예매 날짜</td>
                    <td>예매 취소날짜</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="dto" varStatus="status">
                    <tr style="cursor: pointer;" onClick=" location.href='userPaymentInfo_view.do?userId=${param.userId}&flight=${dto.flights_code}' " onMouseOver=" indow.status = 'http://ihouse.so.vc' " onMouseOut=" window.status = '' ">
                        <td>
                            <c:out value="${status.count}" />
                        </td>
                        <td>${dto.departures}</td>
                        <td>${dto.arrivals}</td>
                        <td>${dto.departures_date}</td>
                        <td>${dto.arrivals_date }</td>
                        <td>${dto.reservation_create_date}</td>
                        <td>${dto.reservation_cancel_date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>