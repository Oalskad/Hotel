<%-- 
    Document   : BookPage
    Created on : Mar 11, 2023, 9:24:33 PM
    Author     : Oalskad
--%>

<%@page import="Model.ServiceDTO"%>
<%@page import="java.util.List"%>
<%@page import="Model.UserDTO"%>
<%@page import="Model.RoomDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<%=url%>/css/newcss.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
            if (userDTO == null) {
        %>
        <a class="btn btn-outline-danger" href="<%=url%>">Login</a>
        <% } else {%>   

        <%= userDTO.getUserName()%>
        <form action="/Hotel/Access/logout" method="POST">
            <input class="btn btn-outline-danger"  type="submit" value="Logout"></input>
        </form>




        <% }%>

        <% RoomDTO roomDTO = (RoomDTO) request.getAttribute("roomDTO");
            out.print(roomDTO.toString());
        %>




        <section class="vh-100 gradient-custom">

            <div class="container py-5 h-100">
                <div class="row justify-content-center align-items-center h-100">
                    <div class="col-12 col-lg-9 col-xl-7">
                        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                            <div class="card-body p-4 p-md-5">
                                <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
                                <form action="/Hotel/Book/book" method="POST">
                                    <div class="row">
                                        <div class="col-md-6 mb-4">

                                            <div class="form-outline">


                                                <label class="form-label" for="userName"> <%= userDTO.getUserName()%> </label>


                                            </div>

                                        </div>
                                        <div class="col-md-6 mb-4">

                                            <div class="form-outline">
                                                <input type="text" id="couponName" class="form-control form-control-lg" name="couponName" />
                                                <label class="form-label" for="couponName">couponName</label>
                                            </div>
                                        </div>
                                    </div>
                                    

                                    <div class="row">
                                        <div class="col-md-6 mb-4 d-flex align-items-center">

                                            <div class="form-outline datepicker w-100">
                                                <label for="startDate" class="form-label">${requestScope.date}</label>

                                            </div>

                                        </div>
                                        <div class="col-md-6 mb-4 d-flex align-items-center">

                                            <div class="form-outline datepicker w-100">
                                                <input type="Date" class="form-control form-control-lg" id="endDate" name="endDate" required="required" />
                                                <label for="endDate" class="form-label">endDate</label>
                                                <div style="color: red; font-weight: BOLD">

                                                </div>
                                            </div>

                                        </div>

                                    </div>


                                    <div>
                                        <h6 class="mb-2 pb-1">Service: </h6>
                                        <% List<ServiceDTO> listService = (List<ServiceDTO>) request.getAttribute("listService"); %>

                                        <% for (ServiceDTO serviceDTO : listService) { %>
                                        <% String name = serviceDTO.getServName(); 
                                           String value = serviceDTO.getServID();
                                        %>
                                        
                                         <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="service" 
                                                       value="<%= value %>" checked />
                                                <label class="form-check-label" for="service"><%= name %></label>
                                            </div>

                                        <% }%>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-6 mb-4 pb-2">

                                            <div class="form-outline">
                                                <input type="text" id="cardNumber" class="form-control form-control-lg" name="cardNumber" required="required"/>
                                                <label class="form-label" for="cardNumber">cardNumber</label>
                                            </div>

                                        </div>

                                    </div>
                                    <div class="mb-1">
                                        <input type="checkbox" class="form-check-inline" id="policyCheck" name="policyCheck" required="required">
                                        <label for="policyCheck" class="form-label">I agree with the <a href="" style="color: black">Term and Condition</a> and the <a href="" style="color: black">Privacy Policy</a> </label>


                                        <input type="hidden" name="roomID" value="<%= roomDTO.getRoomID()%>">
                                        <input class="btn btn-outline-danger"  type="submit" value="book"></input>
                                    </div>
                                </form>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section> 

    </body>
</html>
