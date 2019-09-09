<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                        <form action="regSignIn" method="post" class="card">
                            <div class="card-header">
                                <h3 class="card-title">Реєстрація</h3>
                            </div>
                            <div class="card-body">
                                <div class="row d-flex justify-content-center">
                                    <div class="col-10 mx-auto">
                                        <div class="row">
                                            <div class=" col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Вкажіть логін</label>
                                                    <input type="text" class="form-control" name="login" placeholder="Вкажіть логін">
                                                </div>
                                                <div style="text-align: center;"><b style="color: rgb(128, 0, 0);">${messageRegistrationLogin}</b></div>
                                                <c:remove var="messageRegistrationLogin"/>
                                            </div>
                                            <div class=" col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Вкажіть ваше ім'я</label>
                                                    <input type="text" class="form-control" name="firstName" placeholder="Вкажіть ваше ім'я">
                                                </div>

                                                <div style="text-align: center;"><b style="color: rgb(128, 0, 0);">${messageRegistrationFirstName}</b></div>
                                                <c:remove var="messageRegistrationFirstName"/>
                                            </div>

                                            <div class=" col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Вкажіть ваше прізвище</label>
                                                    <input type="text" class="form-control" name="secondName" placeholder="Вкажіть ваше прізвище">
                                                </div>
                                                <div style="text-align: center;"><b style="color: rgb(128, 0, 0);">${messageRegistrationSecondName}</b></div>
                                                <c:remove var="messageRegistrationSecondName"/>
                                            </div>
                                            <div class=" col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Вкажіть ваш email</label>
                                                    <input type="email" class="form-control" name="email" placeholder="Вкажіть ваш email">
                                                </div>
                                                <div style="text-align: center;"><b style="color: rgb(128, 0, 0);">${messageRegistrationEmail}</b></div>
                                                <c:remove var="messageRegistrationEmail"/>
                                            </div>
                                            <div class=" col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Вкажіть ваш телефон</label>
                                                    <input type="phone" class="form-control" name="phone" placeholder="Вкажіть ваш телефон">
                                                </div>
                                                <div style="text-align: center;"><b style="color: rgb(128, 0, 0);">${messageRegistrationPhone}</b></div>
                                                <c:remove var="messageRegistrationPhone"/>
                                            </div>
                                            <div class="col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Вкажіть пароль</label>
                                                    <input type="password" class="form-control" name="password" placeholder="Вкажіть пароль">
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Повторіть пароль</label>
                                                    <input type="password" class="form-control" name="passwordRepeat" placeholder="Повторіть пароль">
                                                </div>
                                                <div style="text-align: center;"><b style="color: rgb(128, 0, 0);">${messageRegistrationPassword}</b></div>
                                                <div style="text-align: center;"><b style="color: rgb(128, 0, 0);">${messageRegistration}</b></div>
                                                <c:remove var="messageRegistrationPassword"/>
                                                <c:remove var="messageRegistration"/>
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


