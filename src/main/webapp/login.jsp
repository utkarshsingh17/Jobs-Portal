<%-- 
    Author     : kali
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page - Job Portal</title>
        <%@include file="all_components/all_css.jsp" %>
        <link rel="stylesheet" href="all_components/footer.css"/>
    </head>
    <body style="background-color: #f0f1f2">
        <%@include file="all_components/navbar.jsp" %>
        <div class="container-fluid">
            <div class="row p-5">
                <div class="col-md-4 offset-md-4">
                    <div class="card">
                        <div class="card-body">
                            <div class="text-center">
                                <c:if test="${not empty succMsg}">
                                    <div class="container text-center">
                                        <div class="alert alert-success" role="alert">
                                            ${succMsg}
                                        </div>
                                    </div>
                                    <c:remove var="succMsg" />
                                </c:if>
                                <i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
                                <h5>Login</h5>
                            </div>

                            <form action="login" method="post">
                                <div class="form-group">
                                    <label>Enter Email</label>
                                    <input type="email" name="email" required class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Enter Password</label>
                                    <input type="password" name="password" required class="form-control">
                                </div>
                                <button type="submit" class="btn btn-primary badge-pill btn-block">Login</button>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <%@include file="all_components/footer.jsp" %>
    </body>
</html>
