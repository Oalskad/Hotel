<%-- 
    Document   : home
    Created on : Mar 5, 2023, 8:15:10 PM
    Author     : Oalskad
--%>


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
<html>
    <head>
        <link href="<%=url%>/css/newcss.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:if test="${sessionScope.userDTO != null}">
             
        <form action="/Hotel/Access/logout" method="POST">
            <input class="btn btn-outline-danger"  type="submit" value="Logout"></input>
        </form>
        </c:if>
        <c:if test="${sessionScope.userDTO == null}">
            
        <a class="btn btn-outline-danger" href="<%=url%>">Login</a>
        </c:if>
        
        
        <c:out value="${sessionScope.userDTO.userID}" ></c:out>




        <% List<RoomDTO> listRoom = (List<RoomDTO>) request.getAttribute("listRoom"); %>

        <% for (RoomDTO a : listRoom) { %>
        <% for (ImageDTO b : a.getListImg()){ %>
        <image src="<%= b.getImgSrc() %>" />
        <% } %>
        <form action="/Hotel/Book/detail" method="POST">
            <%
                out.println(a.toString());
                String room = a.getRoomID();
            %>
            <input type="hidden" name="roomID" value="<%=room%>">  
            <input type='submit' value='go'>
            <br></br>
        </form>

        <% }%>








        <h1>Hello World!</h1>
    </body>
</html>
