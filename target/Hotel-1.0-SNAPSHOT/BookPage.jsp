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
    <% RoomDTO roomDTO = (RoomDTO) request.getAttribute("roomDTO");
        out.print(roomDTO.toString());
    %>

    <body>
        <!-- Header Section Start -->
        <header id="header">
            <c:if test="${sessionScope.userDTO != null}">
                <form action="/Hotel/Access/logout" method="POST">
                    <div class="phone">

                        <input class="btn btn-outline-danger"  type="submit" value="Logout"></input>
                    </div>
                    <div class="phone">
                        <p style="color: red">Hello ${sessionScope.userDTO.userName} </p>

                    </div></form>
                </c:if>
                <c:if test="${sessionScope.userDTO == null}">
                <div class="phone">
                    <a class="btn btn-outline-danger" href="<%=url%>">Login</a>
                </div>
            </c:if>


            <div class="mobile-menu-btn"><i class="fa fa-bars"></i></div>
            <nav class="main-menu top-menu">
                <ul>
                    <li class="active"><a href="index.html">Home</a></li>
                    <li><a href="about.html">About Us</a></li>
                    <li><a href="room.html">Rooms</a></li>
                    <li><a href="amenities.html">Amenities</a></li>
                    <li><a href="booking.html">Booking</a></li>
                    <li><a href="login.html">Login</a></li>
                    <li><a href="contact.html">Contact Us</a></li>
                </ul>
            </nav>
        </header>

        <!-- Booking Section Start -->
        <div id="booking">
            <div class="container">
                <div class="section-header">
                    <h2>Room Booking</h2>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas in mi libero. Quisque convallis, enim at venenatis tincidunt.
                    </p>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="booking-form">
                            <div id="success"></div>


                            <!--                            //-->
                            <form  action="/Hotel/Book/book" method="POST" >
                                <div class="form-row">
                                    <div class="control-group col-sm-6">
                                        <label class="form-label" for="couponName">Coupon Name</label>
                                        <input type="text" id="couponName" class="form-control form-control-lg" name="couponName" />

                                    </div>
                                    <div class="control-group col-sm-6">
                                        <label class="form-label" for="cardNumber">cardNumber</label>
                                        <input type="text" id="cardNumber" class="form-control form-control-lg" name="cardNumber" required="required"/>
                                    </div>

                                    <div class="control-group col-sm-6">
                                        <label>User Name</label>
                                        <input type="text" class="form-control" id="lname" placeholder="${sessionScope.userDTO.userName}" required="required"  />
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="control-group col-sm-6">
                                        <label>Mobile</label>
                                        <input type="text" class="form-control" id="mobile" placeholder="${sessionScope.userDTO.phoneNumber}" required="required" disabled="" />
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="control-group col-sm-6">
                                        <label>Email</label>
                                        <input type="email" class="form-control" id="email" placeholder="${sessionScope.userDTO.email}" required="required" disabled="" />
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="control-group col-sm-6">
                                        <label>Check-In</label>
                                        <input type="Date" class="form-control form-control-lg" id="startDate" name="startDate" required="required" min="${requestScope.date}" placeholder="${requestScope.date}" value="${requestScope.date}" /> 
                                    </div>
                                    <div class="control-group col-sm-6">
                                        <label>Check-Out</label>
                                        <input type="Date" class="form-control form-control-lg" id="endDate" name="endDate"  required="required" min="${requestScope.date}" />
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label>Service:</label>

                                    <% List<ServiceDTO> listService = (List<ServiceDTO>) request.getAttribute("listService"); %>

                                    <% for (ServiceDTO serviceDTO : listService) { %>
                                    <% String name = serviceDTO.getServName();
                                        String value = serviceDTO.getServID();
                                    %>

                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="service" 
                                               value="<%= value%>" checked />
                                        <label class="form-check-label" for="service"><%= name%></label>
                                    </div>

                                    <% }%>
                                </div>
                                <input type="hidden" name="roomID" value="<%= roomDTO.getRoomID()%>">
                                <input class="btn btn-outline-danger"  type="submit" value="book"></input>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
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