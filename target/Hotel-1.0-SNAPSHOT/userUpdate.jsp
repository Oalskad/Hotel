<%-- 
    Document   : userUpdate
    Created on : Mar 13, 2023, 10:16:21 AM
    Author     : iba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/signupCSS.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    
    
    <c:url var="updateProfileLink" value="${request.contextPath}/Access/edit"/>
    
    <body>
        <section class="vh-100 gradient-custom">
            <div class="container py-5 h-100">
                <div class="row justify-content-center align-items-center h-100">
                    <div class="col-12 col-lg-9 col-xl-7">
                        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                            <div class="card-body p-4 p-md-5">
                                <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Updating Profile</h3>
                                
                                <form action="/Hotel/Profile/edit" method="POST">
                                    <div class="row">
                                        <div class="col-md-6 mb-4">

                                            <div class="form-outline">
                                                <input type="text" id="userName" class="form-control form-control-lg" name="userName" value="${sessionScope.userDTO.userName}" required="required"/>
                                                <label class="form-label" for="userName">User Name</label>
                                                <div style="color: red; font-weight: BOLD">
                                                <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
                                                <% if (errorMessage != null) {%> <%= errorMessage%> <% }%>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="col-md-6 mb-4">

                                            <div class="form-outline">
                                                <input type="password" id="password" class="form-control form-control-lg" name="password" value="${sessionScope.userDTO.password}" required="required" onkeyup='check();'/>
                                                <label class="form-label" for="password">Password</label>
                                            </div>
                                            <div class="form-outline">
                                                <input type="password" id="confirmPassword" class="form-control form-control-lg" name="confirmPassword" value="${sessionScope.userDTO.password}" required="required" onkeyup='check();'/>
                                                <label class="form-label" for="confirmPassword">Repeat Password</label>
                                                <span id='message'></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">

                                            <div class="form-outline">
                                                <input type="text" id="firstName" class="form-control form-control-lg" name="fname" value="${sessionScope.userDTO.fname}"/>
                                                <label class="form-label" for="firstName">First Name</label>
                                            </div>

                                        </div>
                                        <div class="col-md-6 mb-4">

                                            <div class="form-outline">
                                                <input type="text" id="lastName" class="form-control form-control-lg" name="lname" value="${sessionScope.userDTO.lname}" />
                                                <label class="form-label" for="lastName">Last Name</label>
                                            </div>

                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-6 mb-4 pb-2">

                                            <div class="form-outline">
                                                <input type="email" id="emailAddress" class="form-control form-control-lg" name="email" value="${sessionScope.userDTO.email}" required="required"/>
                                                <label class="form-label" for="emailAddress">Email</label>
                                            </div>

                                        </div>
                                        <div class="col-md-6 mb-4 pb-2">

                                            <div class="form-outline">
                                                <input type="tel" placeholder="xxx-xxx-xxx" pattern="[0-9]{9}" id="phoneNumber" class="form-control form-control-lg" name="phoneNumber" value ="${sessionScope.userDTO.phoneNumber.trim()}" required="required" />
                                                <label class="form-label" for="phoneNumber">Phone Number</label>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="mb-1">
                                        
                                        <div class="mt-4 pt-2">
                                            <input class="btn btn-outline-danger" type="submit" value="Submit" id="submit" />
                                        </div>
                                    </div>
                                </form>
                                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>                
    </body>

    <script>
        var check = function () {
            if (document.getElementById('password').value ==
                document.getElementById('confirmPassword').value) {
                document.getElementById('message').style.color = 'green';
                document.getElementById('message').innerHTML = 'Password matched';
                document.getElementById('message').style.fontWeight= 'bold';
                document.getElementById('submit').disabled = false;
            } else {
                document.getElementById('message').style.color = 'red';
                document.getElementById('message').innerHTML = 'Password not matched';
                document.getElementById('message').style.fontWeight= 'bold';
                document.getElementById('submit').disabled = true;
            }
        }
    </script>
</html>
