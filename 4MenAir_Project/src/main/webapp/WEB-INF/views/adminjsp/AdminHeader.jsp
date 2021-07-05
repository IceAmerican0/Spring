<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <title>관리자 페이지</title>
        <!-- Bootstrap -->
        <link href="admincss/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="admincss/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="admincss/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
        <link href="admincss/styles.css" rel="stylesheet" media="screen">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="adminjs/modernizr-2.6.2-respond-1.1.0.min.js"></script>

<c:if test="${empty sessionScope.wokerid  or sessionScope.wokerid ==''}">
  <c:redirect url="MacaronicsServlet?command=index" />
</c:if> 

 