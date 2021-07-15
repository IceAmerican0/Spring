<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/flights_List.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<title>운항 정보</title>
</head>
<body>
    <%@ include file="flights_top.jsp" %>
    <div class="margin_auto_1000 middle">
        <div class="container mt-3">
            <div class="row btn-group procedure">
                <input type="button" class="btn col-lg-3 button1" value="검색" onclick="location.href='userLogin?userId=${param.userId }'">
                <input type="button" class="btn col-lg-3 button2" id="select" value="항공편 검색">
                <input type="button" class="btn col-lg-3 button3" value="탑승객">
                <input type="button" class="btn col-lg-3 button4" value="결재">
            </div>
        </div>
        <div class="container flights_Date_List mt-5">
            <div class="row">
                <c:forEach items="${flights_List}" var="flights_List_dto">
                    <c:if test="${not empty flights_List_dto.select_Date}">
                        <form class="col-xl-1 flights_Date_List_div" action="flights_List" method="get">
                            <c:if test="${param.fromDate eq flights_List_dto.search_date}">
                                <input class=" select_Date" type="submit" value="${flights_List_dto.select_Date}">
                            </c:if>
                            <c:if test="${param.fromDate ne flights_List_dto.search_date}">
                                <input class=" not_select_Date " type="submit" value="${flights_List_dto.select_Date}">
                            </c:if>
                            <input type="hidden" name="userId" value="${param.userId }">
                            <input type="hidden" name="from" value="${param.from }">
                            <input type="hidden" name="fromDate" value="${flights_List_dto.search_date}">
                        </form>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <div class="flite_schedule">
            <div class="container  mt-5 coloms">
                <div class="row">
                    <div class="col-lg-3 schedule">
                        <img alt="출발" class="tabkeoff" src="images/Takeoff.png"> 출발
                    </div>
                    <div class="col-lg-3 schedule">
                        <img alt="도착" class="landing" src="images/Landing.png"> 도착
                    </div>
                    <div class="col-lg-3 schedule">탑승가능인원</div>
                    <div class="col-lg-3 schedule">운임 (원)</div>
                </div>
            </div>
            <form action="flights_passengers" method="post" id="frm">
                <div class="container">
                    <input type="hidden" name="userId" value="${param.userId }">
                    <input type="hidden" name="date_value" value="${param.date_value}">
                    <c:forEach items="${flights_List2}" var="flights_List_dto" varStatus="flights_count">
                        <c:if test="${not empty flights_List_dto.departures}">
                            <c:if test="${param.from eq flights_List_dto.departures}">
                                <label class="row flite_schedule_lable">
                                    <div class="col-lg-3 departures schedule">
                                        <div>${flights_List_dto.departures }</div>
                                        <div>${flights_List_dto.departures_Date }</div>
                                        <div>${flights_List_dto.departures_Time }</div>
                                    </div>
                                    <div class="col-lg-3 arrivals schedule">
                                        <div>${flights_List_dto.arrivals }</div>
                                        <div>${flights_List_dto.arrivals_Date }</div>
                                        <div>${flights_List_dto.arrivals_Time }</div>
                                    </div>
                                    <div class="col-lg-3 schedule">
                                        <div>&nbsp;</div>
                                        <div>${flights_List_dto.passengers }</div>
                                    </div>
                                    <div class="col-lg-3 schedule">
                                        <div>&nbsp;</div>
                                        <div>${flights_List_dto.payments }</div>
                                        <div><input type="radio" name="flights_select" ng-model="flights_Code" value="${flights_List_dto.flights_Code} "></div>
                                    </div>
                                </label>
                            </c:if>
                        </c:if>
                    </c:forEach>
                    <input class="input-submit" type="submit" value="다음 페이지">
                </div>
            </form>
        </div>
    </div>
</body>
</html>