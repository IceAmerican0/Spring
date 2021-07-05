<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<div class="container">
    <div class="row">
        <c:forEach items="${flights_List}" var="flights_List_dto">
            <c:if test="${not empty flights_List_dto.select_Date}">
                <form action="flights_List" method="get">
                    <input type="hidden" name="userId" value="${param.userId }">
                    <button class="col-xl-1" type="submit">
                        <input type="hidden" name="fromDate" value="${flights_List_dto.search_date}">${flights_List_dto.select_Date}
                    </button>
                </form>
            </c:if>
        </c:forEach>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-xl-3">출발</div>
        <div class="col-xl-3">도착</div>
        <div class="col-xl-1">탑승가능인원</div>
        <div class="col-xl-1">운임</div>
        <div class="col-xl-4">선택 내역</div>
    </div>
</div>
<div class="container" ng-app="">
    <form action="flights_passengers" method="post" id="frm">
        <input type="hidden" name="userId" value="${param.userId}">
        <input type="hidden" name="date_value" value="${param.date_value}">
        <c:forEach items="${flights_List}" var="flights_List_dto" varStatus="flights_count">
            <c:if test="${not empty flights_List_dto.departures}">
                <label class="row">
                    <div class="col-xl-3">${flights_List_dto.departures } ${flights_List_dto.departures_Date } ${flights_List_dto.departures_Time }</div>
                    <div class="col-xl-3">${flights_List_dto.arrivals } ${flights_List_dto.arrivals_Date } ${flights_List_dto.arrivals_Time }</div>
                    <div class="col-xl-1">${flights_List_dto.passengers }</div>
                    <div class="col-xl-1">
                        ${flights_List_dto.payments }
                        <input type="radio" name="flights_select" ng-model="flights_Code" value="${flights_List_dto.flights_Code} ">
                    </div>
                    <div class="col-xl-4"></div>
                </label>
            </c:if>
        </c:forEach>
    </form>
</div>
<input type="submit" onclick="document.getElementById('frm').submit();" data-target="#myModal" data-toggle="modal">