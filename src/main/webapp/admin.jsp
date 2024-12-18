<%-- 
    Author     : kali
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page - Job Portal</title>
        <%@include file="all_components/all_css.jsp" %>
        <style>
            .back-img{
                background: url("img/adminpanel.jpg");
                width: 100%;
                height: 90vh;
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
    </head>
    <body>
        <c:if test="${userobj.role ne 'admin'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <%@include file="all_components/navbar.jsp" %>
        <div class="container-fluid back-img">
            <div class="text-center">
                <h1 class="text-white p-4">
                    <i class="fa fa-book" aria-hidden="true"></i> Welcome Admin
                </h1>
            </div>
        </div>
    </body>
</html>
