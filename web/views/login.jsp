<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fonts/fonts/font-awesome.min.css">

    <!-- Font Family -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

    <!-- Dashboard Css -->
    <link href="${pageContext.request.contextPath}/assets/css/dashboard.css" rel="stylesheet">

    <!-- c3.js Charts Plugin -->
    <link href="${pageContext.request.contextPath}/assets/plugins/charts-c3/c3-chart.css" rel="stylesheet">

    <!-- select2 Plugin -->
    <link href="${pageContext.request.contextPath}/assets/plugins/select2/select2.min.css" rel="stylesheet">

    <!-- Time picker Plugin -->
    <link href="${pageContext.request.contextPath}/assets/plugins/time-picker/jquery.timepicker.css" rel="stylesheet">

    <!-- Date Picker Plugin -->
    <link href="${pageContext.request.contextPath}/assets/plugins/date-picker/spectrum.css" rel="stylesheet">

    <!-- Custom scroll bar css-->
    <link href="${pageContext.request.contextPath}/assets/plugins/scroll-bar/jquery.mCustomScrollbar.css" rel="stylesheet">

    <!---Font icons-->
    <link href="${pageContext.request.contextPath}/assets/plugins/iconfonts/plugin.css" rel="stylesheet">

</head>
<body class="">
<div id="global-loader"></div>
<div class="page">
    <div class="page-main">
        <div class="header py-4">
            <div class="container">
                <div class="d-flex">
                    <a class="header-brand" href="#">
                        Якийсь кінотеатр
                    </a>
                    <div class="d-flex order-lg-2 ml-auto">
                        <div class="dropdown">
                            <a href="#" class="nav-link pr-0 leading-none" data-toggle="dropdown">
                                <span class="avatar-md brround"></span>
                                <span class="ml-2 d-none d-lg-block"><span class="text-dark">Реєстрація</span></span>
                            </a>
                            <!--    <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                   <a class="dropdown-item" href="">
                                       Выход
                                   </a>
                               </div> -->
                        </div>
                    </div>
                    <a href="#" class="header-toggler d-lg-none ml-3 ml-lg-0" data-toggle="collapse" data-target="#headerMenuCollapse">
                        <span class="header-toggler-icon"></span>
                    </a>
                </div>
            </div>
        </div>
        <div class="my-3 my-md-5">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <form method="post" class="card">
                            <div class="card-header">
                                <h3 class="card-title">Вхід</h3>
                            </div>
                            <div class="card-body">
                                <div class="row d-flex justify-content-center">
                                    <div class="col-8 mx-auto">
                                        <div class="row">
                                            <div class=" col-md-8 col-lg-8 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Ваш логін [${pageContext.request.contextPath}] </label>
                                                    <input type="text" class="form-control" name="name" placeholder="Ваш логін">
                                                </div>
                                            </div>
                                            <div class="col-md-8 col-lg-8 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Ваш пароль</label>
                                                    <input type="password" class="form-control" name="pass" placeholder="Ваш пароль">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="card-footer text-right">
                                <div class="d-flex">
                                    <!-- <a href="javascript:void(0)" class="btn btn-link">Cancel</a> -->
                                    <button type="submit" class="btn btn-primary ml-auto">Send data</button>
                                </div>
                            </div>
                        </form>

                        <!--footer-->
                        <!--    <footer class="footer">
                             <div class="container">
                               <div class="row align-items-center flex-row-reverse">
                                 <div class="col-lg-12 col-sm-12 mt-3 mt-lg-0 text-center">
                                   Copyright © 2018 <a href="#">Vobilet</a>. Designed by <a href="#">Spruko</a> All rights reserved.
                                 </div>
                               </div>
                             </div>
                           </footer> -->
                        <!-- End Footer-->
                    </div>

                    <!-- Back to top -->
                    <!-- <a href="#top" id="back-to-top" style="display: inline;"><i class="fa fa-angle-up"></i></a> -->
                    <!-- Dashboard Css -->
                    <script src="${pageContext.request.contextPath}/assets/js/vendors/jquery-3.2.1.min.js"></script>
                    <script src="${pageContext.request.contextPath}/assets/js/vendors/bootstrap.bundle.min.js"></script>
                    <script src="${pageContext.request.contextPath}/assets/js/vendors/jquery.sparkline.min.js"></script>
                    <script src="${pageContext.request.contextPath}/assets/js/vendors/selectize.min.js"></script>
                    <script src="${pageContext.request.contextPath}/assets/js/vendors/jquery.tablesorter.min.js"></script>
                    <script src="${pageContext.request.contextPath}/assets/js/vendors/circle-progress.min.js"></script>
                    <script src="${pageContext.request.contextPath}/assets/plugins/rating/jquery.rating-stars.js"></script>
                    <!--Select2 js -->
                    <script src="${pageContext.request.contextPath}/assets/plugins/select2/select2.full.min.js"></script>

                    <!-- Timepicker js -->
                    <script src="${pageContext.request.contextPath}/assets/plugins/time-picker/jquery.timepicker.js"></script>
                    <script src="${pageContext.request.contextPath}/assets/plugins/time-picker/toggles.min.js"></script>

                    <!-- Datepicker js -->
                    <script src="${pageContext.request.contextPath}/assets/plugins/date-picker/spectrum.js"></script>
                    <script src="${pageContext.request.contextPath}/assets/plugins/date-picker/jquery-ui.js"></script>
                    <script src="${pageContext.request.contextPath}/assets/plugins/input-mask/jquery.maskedinput.js"></script>

                    <!-- Inline js -->
                    <script src="${pageContext.request.contextPath}/assets/js/select2.js"></script>

                    <!-- Custom scroll bar Js-->
                    <script src="${pageContext.request.contextPath}/assets/plugins/scroll-bar/jquery.mCustomScrollbar.concat.min.js"></script>

                    <!-- Custom Js-->
                    <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>

</body>
</html>


