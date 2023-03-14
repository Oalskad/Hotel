<%@page import="java.util.ArrayList"%>
<%@page import="dbmanager.RoomDAO"%>
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
        <link rel="stylesheet" href="css/home2.css" media="screen">
        <link rel="stylesheet" href="css/Home1.css" media="screen">
        <script class="u-script" type="text/javascript" src="home2.js" defer=""></script>
        <script class="u-script" type="text/javascript" src="home1.js" defer=""></script>
        <meta name="generator" content="Nicepage 5.6.2, nicepage.com">
        <meta name="referrer" content="origin">
        <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">




        <script type="application/ld+json">{
            "@context": "http://schema.org",
            "@type": "Organization",
            "name": "",
            "logo": "lmht.png"
            }</script>
        <meta name="theme-color" content="#478ac9">
        <meta property="og:title" content="Home">
        <meta property="og:type" content="website">
        <meta data-intl-tel-input-cdn-path="intlTelInput/"></head>

    <!-- Favicons -->
    <link href="img/favicon.ico" rel="icon">
    <link href="img/apple-favicon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900" rel="stylesheet"> 

    <!-- Vendor CSS File -->
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

<body>
    <% RoomDAO roomDAO = new RoomDAO();%>



    <!-- Header Section Start -->
    <header id="header">





        <div class="mobile-menu-btn"><i class="fa fa-bars"></i></div>
        <nav class="main-menu top-menu">
            <ul>
                <li class="active"><a href="index.html">Home</a></li>
                <li><a href="about.html">About Us</a></li>
                <li><a href="room.html">Rooms</a></li>
                <li><a href="amenities.html">Amenities</a></li>
                <li><a href="booking.html">Booking</a></li>
                <li><a href="contact.html">Contact Us</a></li>
                    <c:if test="${sessionScope.userDTO != null}">
                    <li>
                        <a href="./Profile.jsp">
                            ${sessionScope.userDTO.userName} 
                        </a></li>
                    </li>
                </c:if>
                <c:if test="${sessionScope.userDTO != null}">
                    <li>
                        <form action="/Hotel/Access/logout" method="POST">

                            <input class="btn btn-outline-danger"  type="submit" value="Logout"></input>

                        </form>
                    </li>
                </c:if>

                <c:if test="${sessionScope.userDTO == null}">
                    <li>
                        <div class="">
                            <a class="btn btn-outline-danger" href="<%=url%>">Login</a>
                        </div>
                    </li>
                </c:if>
            </ul>
        </nav>
    </header>


    <% List<RoomDTO> listRoom = (List<RoomDTO>) request.getAttribute("listRoom"); %>


    <div id="welcome">
        <div class="container">
            <h3>Welcome to Royal Hotel</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas gravida sollicitudin turpis id posuere. Fusce nec rhoncus nibh. Fusce arcu libero, euismod eget commodo at, venenatis a nisi. Sed faucibus metus sed leo vulputate blandit.</p>
            <a href="#">Book Now</a>
        </div>
    </div>

    <div id="rooms">
        <div class="container">
            <div class="section-header">
                <h2>Our Rooms</h2>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas in mi libero. Quisque convallis, enim at venenatis tincidunt.
                </p>
            </div>
            <div class="row">



                <br></br>

                <% for (RoomDTO a : listRoom) {%>
                <form action="/Hotel/Book/detail" method="POST">
                    <div class="row">
                        <div class="col-md-3">
                            <%  List<ImageDTO> listImg = new ArrayList();
                                listImg = roomDAO.getListImg(a.getRoomID());%>

                            <div class="room-img">
                                <div class="box12">
                                    <img src="<%= listImg.get(0).getImgSrc()%>">
                                    <div class="box-content">
                                        <h3 class="title">Standard Single</h3>
                                        <ul class="icon">
                                            <li><a href="#" data-toggle="modal" data-target="#modal-id"><i class="fa fa-link"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="col-md-6">
                            <div class="room-des">
                                <h3><a href="#" data-toggle="modal" data-target="#modal-id"><%= a.getType()%></a></h3>
                                <p><%= a.getDescription()%></p>
                                <ul class="room-size">
                                    <li><i class="fa fa-arrow-right"></i>BedType <%= a.getBedType()%> </li>
                                    <li><i class="fa fa-arrow-right"></i>Beds: <%= a.getNumberOfBed()%> </li>
                                </ul>
                                <ul class="room-icon">
                                    <li class="icon-1"></li>
                                    <li class="icon-2"></li>
                                    <li class="icon-3"></li>
                                    <li class="icon-4"></li>
                                    <li class="icon-5"></li>
                                    <li class="icon-6"></li>
                                    <li class="icon-7"></li>
                                    <li class="icon-8"></li>
                                    <li class="icon-9"></li>
                                    <li class="icon-10"></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="room-rate">
                                <% String disable = "";
                                    String value = "Book";
                                    String backgroundColor = "";
                                    if (!a.isStatus()) {
                                        disable = "disabled";
                                        value = "Booked";
                                        backgroundColor = "red";
                                    }
                                %>
                                <h3>From</h3>
                                <h1>$<%= a.getDailyPrice()%></h1>
                                <input type="hidden" name="roomID" value="<%= a.getRoomID()%>">  

                                <input class="btn btn-outline-danger" type='submit' value='<%= value%>' <%= disable + ""%>>

                            </div>
                        </div>
                    </div>
                </form>
                <hr>


                <% }%>
            </div>



            <!-- Modal for Room Section End -->


            <!-- Booking Section End -->


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