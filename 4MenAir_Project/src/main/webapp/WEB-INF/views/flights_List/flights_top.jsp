<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="css/flights_top.css"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/flights_List.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<div id="navbar">
    <nav class="navbar navbar-expand-lg  navbar-dark ">
        <a class="navbar-brand" href="userLogin?userId=${param.userId }">
            <img src="images/air4men.jpeg">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse  " id="collapsibleNavbar">
            <ul class="container navbar-nav">
                <li class="nav-item"><a class="nav-link" href="main_view?userId=${param.userId }">예약</a></li>
                <li class="nav-item"><a class="nav-link" href="userReservationList_view?userId=${param.userId }">나의 예약</a></li>
                <li class="nav-item"><a class="nav-link" href="Notice_List?userId=${param.userId }">공자 사항</a></li>
                <li class="nav-item"><a class="nav-link" href="userQnaList_view?userId=${param.userId }">Q & A</a></li>
            </ul>
        </div>
    </nav>
</div>