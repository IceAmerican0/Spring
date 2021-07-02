<%@page import="com.jsplec.Air4men.dto.ReservationDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 정보</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/flights_top.css">
<link rel="stylesheet" href="css/userPayment.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript" src="Reservation/Reservation.js">
	
</script>
<body>
    <%@ include file="../flights_List/flights_top.jsp"%>
    <div class="container">
        <div class="userInfo-top row">
            <div class="userInfo col-xl-8">${param.userId}님의 결제완료 정보</div>
            <div class="toMain col-xl-2">
                <%
                String departureDate = (String) request.getAttribute("departureDate");
                if (request.getAttribute("cancelDate") == null) {//이미 취소 됐거나 출발 하루전부터 취소버튼 안뜸
                %>
                <form action="userPayCancel2.do?userId=${param.userId }&flight=${paymentInfo.flights_flights_code}" name="cancelAction" method="post">
                    <input type="button" value="결제취소" onclick="payCancel()">
                </form>
                <%
                }
                %>
            </div>
            <div class="toMain col-xl-2">
                <a href="main_view.do?userId=${param.userId }">메인으로</a>
            </div>
        </div>
        <div class="container">
            <table class="table table-hover">
                <tbody>
                    <tr>
                        <td>예약번호</td>
                        <td>${paymentInfo.reservation_code}</td>
                    </tr>
                    <tr>
                        <td>출발지</td>
                        <td>${paymentInfo.departures}</td>
                    </tr>
                    <tr>
                        <td>목적지</td>
                        <td>${paymentInfo.arrivals}</td>
                    </tr>
                    <tr>
                        <td>출발시간</td>
                        <td>${paymentInfo.departures_date}</td>
                    </tr>
                    <tr>
                        <td>도착시간</td>
                        <td>${paymentInfo.arrivals_date }</td>
                    </tr>
                    <tr>
                        <td>예매날짜</td>
                        <td>${paymentInfo.reservation_create_date}</td>
                    </tr>
                    <tr>
                        <td>예매취소날짜</td>
                        <td>${paymentInfo.reservation_cancel_date}</td>
                    </tr>
                    <tr>
                        <td>결제 가격</td>
                        <td>${paymentInfo.payments}</td>
                    </tr>
                    <tr>
                        <td>결제 카드 정보</td>
                        <td>${paymentInfo.reservation_cardnumber}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>