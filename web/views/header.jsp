<%@ page import="com.labus.mycinema.Constants" %><%--
  Created by IntelliJ IDEA.
  User: labus
  Date: 09.09.2019
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <meta name="msapplication-TileColor" content="#0061da">
    <meta name="theme-color" content="#1643a3">
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="HandheldFriendly" content="True">
    <meta name="MobileOptimized" content="320">
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico">


    <!-- Title -->
    <title>Vobilet - a responsive, flat and full featured admin template</title>
    <link rel="stylesheet" href="/views/assets/fonts/fonts/font-awesome.min.css">

    <!-- Font Family -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

    <!-- Dashboard Css -->
    <link href="/views/assets/css/dashboard.css" rel="stylesheet">

    <!-- c3.js Charts Plugin -->
    <link href="/views/assets/plugins/charts-c3/c3-chart.css" rel="stylesheet">

    <!-- select2 Plugin -->
    <link href="/views/assets/plugins/select2/select2.min.css" rel="stylesheet">

    <!-- Time picker Plugin -->
    <link href="/views/assets/plugins/time-picker/jquery.timepicker.css" rel="stylesheet">

    <!-- Date Picker Plugin -->
    <link href="/views/assets/plugins/date-picker/spectrum.css" rel="stylesheet">

    <!-- Custom scroll bar css-->
    <link href="/views/assets/plugins/scroll-bar/jquery.mCustomScrollbar.css" rel="stylesheet">

    <!---Font icons-->
    <link href="/views/assets/plugins/iconfonts/plugin.css" rel="stylesheet">
</head>
<body>
<div class="header py-4">
    <div class="container">
        <div class="d-flex">
            <a class="header-brand" href="/pages">
                <%= Constants.WEB.CINEMANAME.value()%>
            </a>
            <div class="d-flex order-lg-2 ml-auto">
                <div class="dropdown">
                    <c:if test="${user == null}"><a href="/pages/login">Log in</a></c:if>
                    <c:if test="${user != null}">
                        <div class="nav-link pr-0 leading-none" data-toggle="dropdown">
                            <span class="avatar-md brround"></span>
                            <span class="ml-2 d-none d-lg-block"><span class="text-dark">${user.firstName} ${user.secondName}</span></span>
                        </div>
                        <form action="logout" method="post" class="card">
                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                <input type="submit"  class="dropdown-item" value="Выход">
                            </div>
                        </form>
                    </c:if>
                </div>
            </div>
            <a href="#" class="header-toggler d-lg-none ml-3 ml-lg-0" data-toggle="collapse" data-target="#headerMenuCollapse">
                <span class="header-toggler-icon"></span>
            </a>
        </div>
    </div>
</div>
</body>
</html>
