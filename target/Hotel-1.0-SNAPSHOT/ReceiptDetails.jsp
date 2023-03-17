<%@page import="dbmanager.ReceiptDAO"%>
<%@page import="Model.ReceiptDTO"%>
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
    <%

        List<ReceiptDTO> listReceipt = (List<ReceiptDTO>) request.getAttribute("listReceipt");

    %>

    <body>
        <!-- Header Section Start -->
        <header id="header">
            <div class="mobile-menu-btn"><i class="fa fa-bars"></i></div>
        <nav class="main-menu top-menu">
            <ul>
                <li ><a href="<%= url %>/HomePage">Home</a></li>
                <li><a href="about.html">About Us</a></li>
                <li><a href="room.html">Rooms</a></li>
                <li><a href="amenities.html">Amenities</a></li>
                <li><a href="booking.html">Booking</a></li>
                <li><a href="contact.html">Contact Us</a></li>
                    <c:if test="${sessionScope.userDTO != null}">
                    <li class="active">
                        <a href="<%= url %>/Profile.jsp">
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

        <table class="table">
            <thead>
                <tr>

                    <th scope="col">Receipt ID</th>
                    <th scope="col">Room ID</th>
                    <th scope="col">Coupon Name</th>
                    <th scope="col">Service Name</th>
                    <th scope="col">Check-In</th>
                    <th scope="col">Check-Out</th>
                    <th scope="col">Price</th>
                </tr>
            </thead>
            <tbody>
                <% if (listReceipt != null) {
                        for (ReceiptDTO receiptDTO : listReceipt) {
                %>
                <tr>
                    <th scope="row"><%= receiptDTO.getReceiptID()%></th>
                    <td><%= receiptDTO.getRoomDTO().getRoomID()%></td>
                    <% if (receiptDTO.getCouponDTO().getCouponID() != null) {%>
                    <td><%= receiptDTO.getCouponDTO().getName()%></td>

                    <% } else { %>
                    <td> </td>
                    <% } %>
                    <% if (receiptDTO.getServiceDTO() != null) {%>
                    <td><%= receiptDTO.getServiceDTO().getServName()%></td>

                    <% } else { %>
                    <td> </td>
                    <% }%>


                    <td><%= receiptDTO.getStartDate()%></td>
                    <td><%= receiptDTO.getEndDate()%></td>
                    <td><%= receiptDTO.getFinalPrice()%></td>
                </tr>
                <% }
                } else {%>
                <tr>
                    <th scope="row"></th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <% } %>
        </table>



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