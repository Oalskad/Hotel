 

<div class="mobile-menu-btn"><i class="fa fa-bars"></i></div>
        <nav class="main-menu top-menu">
            <ul>
                <li ><a href="./HomePage">Home</a></li>
                <li><a href="about.html">About Us</a></li>
                <li><a href="room.html">Rooms</a></li>
                <li><a href="amenities.html">Amenities</a></li>
                <li><a href="booking.html">Booking</a></li>
                <li><a href="contact.html">Contact Us</a></li>
                    <c:if test="${sessionScope.userDTO != null}">
                    <li class="active">
                        <a href="/Profile.jsp">
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