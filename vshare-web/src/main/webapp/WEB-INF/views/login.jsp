<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 10/14/2017
  Time: 11:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <%--<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    --%>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <![endif]-->
    <style>
        html {
            height: 100%;
        }

        #Main-header {}

        #Main-nav {
            background-image: url(${contextPath}/resources/img/bg_homepage.png);
            background-size: cover;
            height: 365px;
            width: 100%;
        }

        #Main-nav-container {
            vertical-align: middle;
            position: absolute;
            top: 130px;
            left: 50px;
        }

        #Main-nav-nav {}

        #myCarousel {
            height: 100%;
        }

        .item-slide img {
            height: 100%;
            width: 500px;
        }

        #Main-login-form {
            color: #FFF;
            padding: 15px;
            margin: 15px 0;
        }

        #next-btn {
            position: absolute;
            top: 130px;
        }

        #pre-btn {
            position: absolute;
            top: 130px;
            right: 0px;
        }

        /*footer {
            text-align: center;
            padding-top: 10px;
            background-color: #50789b;
        }*/
        /*footer*/

        #footer {
            width: 100%;
            height: auto;
            display: block;
            background-color: rgb(66, 53, 61);
            color: white;
            text-align: center;
        }

        #footer>h4 {
            letter-spacing: 3px;
            font-size: 20px;
            padding-bottom: 10px;
        }

        #footer-text {
            font-size: 11px;
            letter-spacing: 2px;
        }

        #footer-icon {
            width: 100%;
            padding-top: 10px;
        }

        #footer>div>ul {
            width: 10%;
            display: table;
            margin-left: auto;
            margin-right: auto;
            overflow: hidden;
        }

        #footer>div>ul>li {
            display: table-cell;
            cursor: pointer;
            outline: none;
        }

        #footer>div>ul>li>i {
            width: 30px;
        }

        #icon {
            transition: all 0.3s;
        }

        #footer>div>ul>li:hover #sub-icon {
            display: inline-block;
            transform: translateY(-100%);
            opacity: 1;
        }

        #footer>div>ul>li:hover #icon {
            display: inline-block;
            transform: translateY(-100%);
            opacity: 0;
        }

        #footer-footer {
            background-color: rgb(27, 23, 28);
            width: 100%;
            height: 120px;
        }

        #footer-footer>p {
            line-height: 120px;
            letter-spacing: 3px;
            font-size: 11px;
        }

        #sub-icon {
            /*    display: none;*/
            transition: all 0.3s;
            opacity: 0;
        }
    </style>
</head>

<body>
<div id="Main-header" class="header">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header col-md-7">
                <img src="${contextPath}/resources/img/logo_fsharev3.png">
            </div>
            <%--<ul class="nav navbar-nav col-md-5">
                <li><a href="#">Giới thiệu</a></li>
                <li><a href="#">Nâng cấp VIP</a></li>
                <li><a href="#">Tin tức</a></li>
                <li><a href="#">Công cụ</a></li>
                <li><a href="#">Hỗ trợ</a></li>
                <li><a href="#">Liên hệ</a></li>
            </ul>--%>
        </div>
    </nav>
</div>
<div id="Main-nav">
    <div class="container" id="Main-nav-container">
        <div class="row" id="Main-nav-nav">
            <div class="col-md-8">
                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        <div class="item active item-slide">
                            <img src="${contextPath}/resources/img/banner_1.png" alt="Viet Nam">
                        </div>

                        <div class="item item-slide">
                            <img src="${contextPath}/resources/img/banner_follow_home.png">
                        </div>

                        <div class="item item-slide">
                            <img src="${contextPath}/resources/img/banner_1.png">
                        </div>
                        <div class="item item-slide">
                            <img src="${contextPath}/resources/img/banner_follow_home.png">
                        </div>
                    </div>

                    <!-- Left and right controls -->
                    <a class="carousel-control" href="#myCarousel" data-slide="prev">
                        <span id="next-btn"><img src="${contextPath}/resources/img/arrow-prev.png"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <div>
                        <a class="carousel-control" href="#myCarousel" data-slide="next" style="left:600px;">
                            <span id="pre-btn"><img src="${contextPath}/resources/img/arrow-next.png"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                    <div class="slider-nav">
                        <!--  <a href="#" class="arrow-prev"><img src="img/arrow-prev.png"></a>

                        <a href="#" class="arrow-next"><img src="img/arrow-next.png"></a>-->
                    </div>

                </div>
            </div>
            <div id="Main-login-form" class="col-md-4" style="background: #50789b; opacity: 0.9;">
                    <form method="POST" action="${contextPath}/login" class="form-signin">
                        <h2 class="form-heading">Log in</h2>

                        <div class="form-group ${error != null ? 'has-error' : ''}">
                            <span>${message}</span>

                            <input name="username" type="text" class="form-control" placeholder="Username"
                                   autofocus="true"/>
                            <div style="height: 10px;"></div>
                            <input name="password" type="password" class="form-control" placeholder="Password"/>
                            <span>${error}</span>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <div style="height: 10px;"></div>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                            <h4 class="text-center"><a href="${contextPath}/registration" style="color: whitesmoke">Create an account</a></h4>
                        </div>
                    </form>
            </div>
        </div>
    </div>
</div>
<footer id="footer">
    <img src="/image/ico-newsletter.png">
    <h4>
        WEBSITE SHARING DATA
    </h4>
    <p id="footer-text"><br> FPT UNIVERSITY - QUANG TRUNG SOFTWARE CITY - TP . HCM - PHONE. 0999999999 - FAX+ 0999999999- TP . HCM</p>
    <div id="footer-icon">
        <ul>
            <li>
                <i class="fa fa-facebook" aria-hidden="true" id="icon"></i>
                <span>
                        <i class="fa fa-facebook" aria-hidden="true" id="sub-icon"></i>
                            </span>
            </li>
            <li>
                <i class="fa fa-twitter" aria-hidden="true" id="icon"></i>
                <i class="fa fa-twitter" aria-hidden="true" id="sub-icon"></i>
            </li>
            <li>
                <i class="fa fa-google-plus" aria-hidden="true" id="icon"></i>
                <i class="fa fa-google-plus" aria-hidden="true" id="sub-icon"></i>
            </li>
            <li>
                <i class="fa fa-instagram" aria-hidden="true" id="icon"></i>
                <i class="fa fa-instagram" aria-hidden="true" id="sub-icon"></i>
            </li>
            <li>
                <img style="height: 50px; width: 120px" src="${contextPath}/resources/img/dathongbao.png">
            </li>
        </ul>
    </div>
    <div id="footer-footer">
        <p>© Group 3 - C.F. 0123456789 - P.I. IT 0123456789 - CREDITS</p>
    </div>
</footer>

<%--<div class="container">

    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>

    </form>

</div>--%>
<!-- /container -->
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>--%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>