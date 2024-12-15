<%-- 
    Author     : kali
--%>
<%@page import="com.dto.Jobs"%>
<%@page import="com.serviceFactory.JobsServiceFactory"%>
<%@page import="com.service.IJobsService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>More Details - Jobs Portal</title>
        <%@include file="all_components/all_css.jsp" %>
    </head>
    <body style="background-color: #f0f1f2">
        <c:if test="${empty userobj}">
            <c:redirect url="login.jsp" />
        </c:if>
        <%@include file="all_components/navbar.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="text-center text-success mt-3">
                        <i class="fas fa-clipboard fa-3x"></i>

                        <h1>View Jobs</h1>
                    </div>
                    <%
                        Integer id = Integer.parseInt(request.getParameter("id"));
                         IJobsService jobsService = JobsServiceFactory.getJobsService();
                        Jobs j = jobsService.getJobById(id);
                    %>
                    <div class="card mt-5">
                        <div class="card-body">
                            <div class="text-center text-primary">
                                <i class="fas fa-clipboard fa-2x"></i>
                            </div>
                            <h6><%= j.getTitle()%></h6>
                            <p><%= j.getDescription()%></p>
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <input type="text" class="form-control form-control-sm" value="Location: <%= j.getLocation()%>" readonly />
                                </div>
                                <div class="form-group col-md-3">
                                    <input type="text" class="form-control form-control-sm" value="Category <%= j.getCategory()%>" readonly />
                                </div>
                            </div>
                            <h6>Publish Date: <%= j.getPdate().toString()%></h6>
                            <div class="text-center">
                                <a href="home.jsp" class="btn btn-sm bg-success text-white">Back</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
