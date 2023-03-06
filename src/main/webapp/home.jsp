<%-- 
    Document   : home
    Created on : Mar 5, 2023, 8:15:10 PM
    Author     : Oalskad
--%>


<%@page import="Model.UserDTO"%>
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

        <%= url%>
        <form action="/Hotel/Access/logout" method="POST">
            <input class="btn btn-outline-danger"  type="submit" value="Logout"></input>
        </form>
        <% }%>




        <h1>Hello World!</h1>
    </body>
</html>
