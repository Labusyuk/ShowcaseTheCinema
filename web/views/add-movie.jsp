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
                                <span class="ml-2 d-none d-lg-block"><span class="text-dark">Вхід</span></span>
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
                                <h3 class="card-title">Реєстрація</h3>
                            </div>
                            <div class="card-body">
                                <div class="row d-flex justify-content-center">
                                    <div class="col-10 mx-auto">
                                        <div class="row">
                                            <div class=" col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Назва</label>
                                                    <input type="text" class="form-control" name="name" placeholder="Назва">
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Вимірність</label>
                                                    <select class="form-control" name="format">
                                                        <option value="2">2D</option>
                                                        <option value="3">3D</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class=" col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Ціна</label>
                                                    <input type="number" min="0" class="form-control" name="price" placeholder="Ціна">
                                                </div>
                                            </div>
                                            <div class=" col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Тривалість</label>
                                                    <input type="number" min="0" class="form-control" name="long" placeholder="Тривалість">
                                                </div>
                                            </div>
                                            <div class=" col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Жанр</label>
                                                    <input type="text" class="form-control" name="ZHANR" placeholder="Жанр">
                                                </div>
                                            </div>
                                            <div class=" col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Вікове обмеження</label>
                                                    <input type="number" class="form-control" name="year-filter" placeholder="Вікове обмеження">
                                                </div>
                                            </div>
                                            <div class=" col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Країна</label>
                                                    <input type="text" class="form-control" name="country" placeholder="Країна">
                                                </div>
                                            </div>
                                            <div class=" col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Рік випуску</label>
                                                    <input type="number" class="form-control" name="year" placeholder="Рік випуску">
                                                </div>
                                            </div>
                                            <div class=" col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Продюсери</label>
                                                    <input type="text" class="form-control" name="produsers" placeholder="Продюсери">
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Сценарісти</label>
                                                    <input type="text" class="form-control" name="scenarists" placeholder="Сценарісти">
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Актери</label>
                                                    <input type="text" class="form-control" name="stars" placeholder="Актери">
                                                </div>
                                            </div>
                                            <div class=" col-md-6 col-lg-6 mx-auto">
                                                <div class="form-group">
                                                    <label class="form-label">Опис</label>
                                                    <textarea class="form-control" name="text" placeholder="Опис">

                                                    </textarea>
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
                    </div>
                </div>
            </div>
        </div>
    </div>

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


