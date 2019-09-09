<%@ page import="com.labus.mycinema.entity.User" %>
<%@ page import="com.labus.mycinema.Constants" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en" dir="ltr">
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
    <link rel="stylesheet" href="\views\assets\fonts\fonts\font-awesome.min.css">

    <!-- Font Family -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

    <!-- Dashboard Css -->
    <link href="\views\assets\css\dashboard.css" rel="stylesheet">

    <!-- c3.js Charts Plugin -->
    <link href="\views\assets\plugins\charts-c3\c3-chart.css" rel="stylesheet">

    <!-- select2 Plugin -->
    <link href="\views\assets\plugins\select2\select2.min.css" rel="stylesheet">

    <!-- Time picker Plugin -->
    <link href="\views\assets\plugins\time-picker\jquery.timepicker.css" rel="stylesheet">

    <!-- Date Picker Plugin -->
    <link href="\views\assets\plugins\date-picker\spectrum.css" rel="stylesheet">

    <!-- Custom scroll bar css-->
    <link href="\views\assets\plugins\scroll-bar\jquery.mCustomScrollbar.css" rel="stylesheet">

    <!---Font icons-->
    <link href="\views\assets\plugins\iconfonts\plugin.css" rel="stylesheet">
</head>
<body class="">
<div id="global-loader"></div>
<div class="page">
    <div class="page-main">
        <jsp:include page="header.jsp" />
        <div class="my-3 my-md-5">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <form method="post" class="card">
                            <div class="card-header">
                                <h3 class="card-title">Список фільмів</h3>
                            </div>
                            <div class="card-body">
                                <div class="row d-flex justify-content-center">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="card">
                                            <ul class="list-group">
                                                        <c:forEach var="movieInfo" items="${timetable}">
                                                            <c:if test="${movieInfo.visible == 1}">
                                                            <a href="#3">
                                                                <li class="list-group-item justify-content-between">
                                                                    <span class="badgetext badge badge-success badge-pill">${movieInfo.time}</span>
                                                                    <span class="badgetext badge badge-danger badge-pill">+${movieInfo.ageLimit}</span>
                                                                    <span class="badgetext badge badge-primary badge-pill">${movieInfo.dimension}</span>
                                                                        ${movieInfo.movieName}
                                                                </li>
                                                            </a>
                                                            </c:if>
                                                        </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--footer-->
    <footer class="footer">
        <div class="container">
            <div class="row align-items-center flex-row-reverse">
                <div class="col-lg-12 col-sm-12 mt-3 mt-lg-0 text-center">
                    Copyright © 2018 <a href="#">Vobilet</a>. Designed by <a href="#">Spruko</a> All rights reserved.
                </div>
            </div>
        </div>
    </footer>
    <!-- End Footer-->
</div>

<!-- Back to top -->
<!-- <a href="#top" id="back-to-top" style="display: inline;"><i class="fa fa-angle-up"></i></a> -->
<!-- Dashboard Css -->
<script src="\views\assets\js\vendors\jquery-3.2.1.min.js"></script>
<script src="\views\assets\js\vendors\bootstrap.bundle.min.js"></script>
<script src="\views\assets\js\vendors\jquery.sparkline.min.js"></script>
<script src="\views\assets\js\vendors\selectize.min.js"></script>
<script src="\views\assets\js\vendors\jquery.tablesorter.min.js"></script>
<script src="\views\assets\js\vendors\circle-progress.min.js"></script>
<script src="\views\assets\plugins\rating\jquery.rating-stars.js"></script>
<!--Select2 js -->
<script src="\views\assets\plugins\select2\select2.full.min.js"></script>

<!-- Timepicker js -->
<script src="\views\assets\plugins\time-picker\jquery.timepicker.js"></script>
<script src="\views\assets\plugins\time-picker\toggles.min.js"></script>

<!-- Datepicker js -->
<script src="\views\assets\plugins\date-picker\spectrum.js"></script>
<script src="\views\assets\plugins\date-picker\jquery-ui.js"></script>
<script src="\views\assets\plugins\input-mask\jquery.maskedinput.js"></script>

<!-- Inline js -->
<script src="\views\assets\js\select2.js"></script>

<!-- Custom scroll bar Js-->
<script src="\views\assets\plugins\scroll-bar\jquery.mCustomScrollbar.concat.min.js"></script>

<!-- Custom Js-->
<script src="\views\assets\js\custom.js"></script>

</body>
</html>


