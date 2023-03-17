<%@page import="dbmanager.RoomDAO"%>
<%@page import="Model.ServiceDTO"%>
<%@page import="Model.ImageDTO"%>
<%@page import="Model.RoomDTO"%>
<%@page import="java.util.List"%>
<%@page import="Model.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>ROYAL HOTEL | Responsive Travel & Tourism Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Favicons -->
        <link href="img/favicon.ico" rel="icon">
        <link href="img/apple-favicon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900" rel="stylesheet"> 

        <!-- Vendor CSS File -->
        <link rel="stylesheet" href="<%=url%>/css/detail2.css" media="screen">
        <link rel="stylesheet" href="<%=url%>/css/detail1.css" media="screen">
        <script class="u-script" type="text/javascript" src="<%=url%>/js/detail2.js" defer=""></script>
        <script class="u-script" type="text/javascript" src="<%=url%>/js/detail1.js" defer=""></script>
        <meta name="generator" content="Nicepage 5.6.9, nicepage.com">
        <link href="<%= url%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%= url%>/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="<%= url%>/vendor/animate/animate.min.css" rel="stylesheet">
        <link href="<%= url%>/vendor/slick/slick.css" rel="stylesheet">
        <link href="<%= url%>/vendor/slick/slick-theme.css" rel="stylesheet">
        <link href="<%= url%>/vendor/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Main Stylesheet File -->
        <link href="<%= url%>/css/hover-style.css" rel="stylesheet">
        <link href="<%= url%>/css/style.css" rel="stylesheet">
    </head>
    <%
        RoomDAO roomDAO = new RoomDAO();
        RoomDTO roomDTO = roomDAO.selectById(request.getParameter("roomID"));
        List<ImageDTO> listImg = roomDTO.getListImg();
    %>

    <body class="u-body u-xl-mode">
        <!-- Header Section Start -->
        <header id="header">

            <%@include file="header.jsp" %>
        </header>

        <!-- Details Section Start -->

        <section class="u-align-center u-clearfix u-section-1" id="sec-9f66">
            <div class="u-clearfix u-sheet u-sheet-1">
                <h3 class="u-text u-text-default u-text-1">${requestScope.roomDTO.type}</h3>
                <div class="u-carousel u-gallery u-gallery-slider u-layout-carousel u-lightbox u-no-transition u-show-text-on-hover u-gallery-1" id="carousel-d2d5" data-interval="5000" data-u-ride="carousel">
                    <ol class="u-absolute-hcenter u-carousel-indicators u-carousel-indicators-1">
                        <li data-u-target="#carousel-d2d5" data-u-slide-to="0" class="u-active u-grey-70 u-shape-circle" style="width: 10px; height: 10px;"></li>
                        <li data-u-target="#carousel-d2d5" data-u-slide-to="1" class="u-grey-70 u-shape-circle" style="width: 10px; height: 10px;"></li>
                        <li data-u-target="#carousel-d2d5" data-u-slide-to="2" class="u-grey-70 u-shape-circle" style="width: 10px; height: 10px;"></li>
                    </ol>
                    <div class="u-carousel-inner u-gallery-inner" role="listbox">
                        <% for (ImageDTO imgDTOe : listImg) {
                                    int a = 2;%>
                        <div class="u-carousel-item u-effect-fade u-gallery-item u-carousel-item-+<%= a%>">
                            <div class="u-back-slide">
                                <img class="u-back-image u-expanded" src="<%= imgDTOe.getImgSrc()%>">
                            </div>
                            <div class="u-align-center u-over-slide u-shading u-valign-bottom u-over-slide-+<%= a%>">
                                <h3 class="u-gallery-heading">Sample Title</h3>
                                <p class="u-gallery-text">Sample Text</p>
                            </div>
                        </div>
                        <% a++;
                                 }%>
                        <div class="u-active u-carousel-item u-effect-fade u-gallery-item u-carousel-item-3">
                            <div class="u-back-slide">
                                <img class="u-back-image u-expanded" src="https://pix10.agoda.net/hotelImages/124/1246280/1246280_16061017110043391702.jpg?ca=6&ce=1&s=1024x768">
                            </div>
                            <div class="u-align-center u-over-slide u-shading u-valign-bottom u-over-slide-3">
                                <h3 class="u-gallery-heading">Sample Title</h3>
                                <p class="u-gallery-text">Sample Text</p>
                            </div>
                        </div>
                    </div>
                    <a class="u-absolute-vcenter u-carousel-control u-carousel-control-prev u-grey-70 u-icon-circle u-opacity u-opacity-70 u-spacing-10 u-text-white u-carousel-control-1" href="#carousel-d2d5" role="button" data-u-slide="prev">
                        <span aria-hidden="true">
                            <svg viewBox="0 0 451.847 451.847"><path d="M97.141,225.92c0-8.095,3.091-16.192,9.259-22.366L300.689,9.27c12.359-12.359,32.397-12.359,44.751,0
                                                                     c12.354,12.354,12.354,32.388,0,44.748L173.525,225.92l171.903,171.909c12.354,12.354,12.354,32.391,0,44.744
                                                                     c-12.354,12.365-32.386,12.365-44.745,0l-194.29-194.281C100.226,242.115,97.141,234.018,97.141,225.92z"></path></svg>
                        </span>
                        <span class="sr-only">
                            <svg viewBox="0 0 451.847 451.847"><path d="M97.141,225.92c0-8.095,3.091-16.192,9.259-22.366L300.689,9.27c12.359-12.359,32.397-12.359,44.751,0
                                                                     c12.354,12.354,12.354,32.388,0,44.748L173.525,225.92l171.903,171.909c12.354,12.354,12.354,32.391,0,44.744
                                                                     c-12.354,12.365-32.386,12.365-44.745,0l-194.29-194.281C100.226,242.115,97.141,234.018,97.141,225.92z"></path></svg>
                        </span>
                    </a>
                    <a class="u-absolute-vcenter u-carousel-control u-carousel-control-next u-grey-70 u-icon-circle u-opacity u-opacity-70 u-spacing-10 u-text-white u-carousel-control-2" href="#carousel-d2d5" role="button" data-u-slide="next">
                        <span aria-hidden="true">
                            <svg viewBox="0 0 451.846 451.847"><path d="M345.441,248.292L151.154,442.573c-12.359,12.365-32.397,12.365-44.75,0c-12.354-12.354-12.354-32.391,0-44.744
                                                                     L278.318,225.92L106.409,54.017c-12.354-12.359-12.354-32.394,0-44.748c12.354-12.359,32.391-12.359,44.75,0l194.287,194.284
                                                                     c6.177,6.18,9.262,14.271,9.262,22.366C354.708,234.018,351.617,242.115,345.441,248.292z"></path></svg>
                        </span>
                        <span class="sr-only">
                            <svg viewBox="0 0 451.846 451.847"><path d="M345.441,248.292L151.154,442.573c-12.359,12.365-32.397,12.365-44.75,0c-12.354-12.354-12.354-32.391,0-44.744
                                                                     L278.318,225.92L106.409,54.017c-12.354-12.359-12.354-32.394,0-44.748c12.354-12.359,32.391-12.359,44.75,0l194.287,194.284
                                                                     c6.177,6.18,9.262,14.271,9.262,22.366C354.708,234.018,351.617,242.115,345.441,248.292z"></path></svg>
                        </span>
                    </a>
                </div>
            </div>
        </section>
        <section class="u-clearfix u-section-2" id="sec-812d">
            <div class="u-clearfix u-sheet u-sheet-1">
                <div class="u-container-style u-expanded-width u-group u-palette-5-light-2 u-radius-30 u-shape-round u-group-1">
                    <div class="u-container-layout u-container-layout-1">
                        <p class="u-text u-text-1"> &nbsp;<span class="u-file-icon u-icon"><img src="images/3159461.png" alt=""></span>&nbsp;Cable/Satellite TV
                        </p>
                        <p class="u-text u-text-2"> &nbsp;<span class="u-file-icon u-icon u-icon-2"><img src="images/952776.png" alt=""></span>&nbsp; Single Bed
                        </p>
                        <p class="u-text u-text-3"> &nbsp;<span class="u-file-icon u-icon"><img src="images/10029956.png" alt=""></span>&nbsp;Mini Fridge
                        </p>
                        <p class="u-text u-text-4"> &nbsp;<span class="u-file-icon u-icon"><img src="images/3176781.png" alt=""></span>&nbsp;Heating
                        </p>
                        <p class="u-text u-text-5"> &nbsp;<span class="u-file-icon u-icon"><img src="images/159599.png" alt=""></span>&nbsp; Wireless Internet
                        </p>
                        <p class="u-text u-text-6"> &nbsp;<span class="u-file-icon u-icon"><img src="images/9086838.png" alt=""></span>&nbsp;Towers and Linen
                        </p>
                        <p class="u-text u-text-7"> &nbsp;<span class="u-file-icon u-icon"><img src="<%=url%>/images/4483612.png" alt=""></span>&nbsp;Room Service
                        </p>
                        <p class="u-text u-text-8"> &nbsp;<span class="u-file-icon u-icon"><img src="<%=url%>/images/3144969.png" alt=""></span>&nbsp;Hair Dryer
                        </p>
                        <p class="u-text u-text-9"> &nbsp;<span class="u-file-icon u-icon"><img src="<%=url%>/images/2676779.png" alt=""></span>&nbsp;Room Safe
                        </p>
                        <p class="u-text u-text-10"> &nbsp;<span class="u-file-icon u-icon"><img src="<%=url%>/images/4161006.png" alt=""></span>&nbsp;Terrace
                        </p>
                        <p class="u-text u-text-11"> &nbsp;<span class="u-file-icon u-icon"><img src="<%=url%>/images/333447.png" alt=""></span>&nbsp;Shower over bath
                        </p>
                        <p class="u-text u-text-12"> &nbsp;<span class="u-file-icon u-icon"><img src="<%=url%>/images/3891977.png" alt=""></span>&nbsp;Telephone
                        </p>
                        <p class="u-text u-text-13"> &nbsp;<span class="u-file-icon u-icon"><img src="<%=url%>/images/739249.png" alt=""></span>&nbsp;View
                        </p>
                        <p class="u-text u-text-14"> &nbsp;<span class="u-file-icon u-icon"><img src="<%=url%>/images/692015.png" alt=""></span>&nbsp;Air Conditioner
                        </p>
                        <p class="u-text u-text-15"> &nbsp;<span class="u-file-icon u-icon"><img src="<%=url%>/images/561106.png" alt=""></span>&nbsp;Sound proof
                        </p>
                    </div>
                </div>
                <div class="u-container-style u-expanded-width u-group u-white u-group-2">
                    <div class="u-container-layout u-valign-top u-container-layout-2">
                        <p class="u-align-justify u-text u-text-16"><%= roomDTO.getDescription()%> <br>Bed option:<%= roomDTO.getBedType()%> <br> Non smoking room
                            </span>
                            <br>
                            <br>

                        </p>
                        <h5 class="u-align-center u-text u-text-17">Price <%= roomDTO.getDailyPrice()%></h5>
                        <h5 class="u-align-center u-text u-text-18">Guests <%= roomDTO.getNumberOfBed() * 2%></h5>
                        <form action="/Hotel/Book/detail" method="POST">
                            <input type="hidden" name="roomID" value="<%= roomDTO.getRoomID()%>">  

                            <input class="btn btn-outline-danger" type='submit' > 
                        </form>
                    </div>
                </div>
                <section style="background-color: #e7effd;">
                    <div class="container my-5 py-5 text-dark">
                        <div class="row d-flex justify-content-center">
                            <div class="col-md-11 col-lg-9 col-xl-7">
                                
                                

                                <div class="d-flex flex-start">
                                   
                                    <div class="card w-100">
                                        <div class="card-body p-4">
                                            <div class="">
                                                <h5></h5>
                                                <p class="small">5 hours ago</p>
                                                <p>
                                                    Lorem ipsum dolor sit, amet consectetur adipisicing elit. Delectus
                                                    cumque doloribus dolorum dolor repellat nemo animi at iure autem fuga
                                                    cupiditate architecto ut quam provident neque, inventore nisi eos quas?
                                                </p>

                                               
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>

        </section>



        <!-- Details Section End -->


        <!-- Footer Section Start -->
        <div id="footer">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="social">
                            <a href=""><li class="fa fa-instagram"></li></a>
                            <a href=""><li class="fa fa-twitter"></li></a>
                            <a href=""><li class="fa fa-facebook-f"></li></a>
                        </div>
                    </div>
                    <div class="col-12">
                        <p>Copyright &#169; 2045 <a href="">Your Site Name</a> All Rights Reserved.</p>

                        <!--/*** This template is free as long as you keep the footer author?s credit link/attribution link/backlink. If you'd like to use the template without the footer author?s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                        <p>Designed By <a href="https://htmlcodex.com">HTML Codex</a></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer Section End -->

        <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

        <!-- Vendor JavaScript File -->

        <!-- Booking Javascript File -->
        <script src="js/booking.js"></script>
        <script src="js/jqBootstrapValidation.min.js"></script>

        <!-- Main Javascript File -->
        <script src="js/main.js"></script>
    </body>
</html>