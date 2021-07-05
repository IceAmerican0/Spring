<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>4menAir</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/userLogin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="main.js">
	
</script>
<%
if (request.getParameter("userId") == null)
	response.sendRedirect("userLogin_view");
else {
%>
</head>
<body>
    <div class="container-login">
        <div class="container-img">
            <a href="main_view"><img src="images/air4men.jpeg" ></a>
        </div>
        <div class="container mt-3">
            <h3>${param.userId }님,안녕하세요!</h3>
            <div class="menuButton mt-5">
                <input type="button" value="회원정보" onClick="location.href='user_myPage_view?userId=${param.userId }'">
                <input type="button" value="예약정보" onClick="location.href='userReservationList_view?userId=${param.userId }'">
                <input type="button" value="Q & A" onClick="location.href='userQnaList_view?userId=${param.userId }'">
                <input type="button" value="공지사항" onClick="location.href='Notice_List?userId=${param.userId }'">
            </div>
            <form action="flights_List?userId=${param.userId}" class="flightFindForm" name="flightFindForm" method="post">
                <div class="mt-5">
                    <label for="from">출발지 : </label>
                    <select name="from" class="custom-select " onchange="Change(this)">
                        <option value="">출발지를 선택해주세요</option>
                        <option value="ICN(인천)">ICN(인천)</option>
                        <option value="CJU(제주)">CJU(제주)</option>
                    </select>
                </div>
                <div class="mt-2">
                    <label for="to">도착지 : </label>
                    <select name="to" id="to" class="custom-select " onchange="Change(this)">
                        <option value="">출발지를 먼저 선택해주세요</option>
                        <option value="ICN(인천)">ICN(인천)</option>
                        <option value="CJU(제주)">CJU(제주)</option>
                    </select>
                </div>
                <div class="calendar mt-2">
                    <label for="fromDate">출발 날짜 : </label>
                    <input type="date" class="custom-calendar " name="fromDate" id="today" placeholder="예약 날짜 선택">
                </div>
            </form>
            <div class="form-group mt-2">
                <input class="flights_search" type="button" onclick="formChk()" value="항공편 조회">
            </div>
            <div class="form-group mt-5">
                <input class="logout" type="button" value="로그아웃" onclick="user_Logout()" />
            </div>
        </div>
    </div>
</body>
<%
}
%>
</html>