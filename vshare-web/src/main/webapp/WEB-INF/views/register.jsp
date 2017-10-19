<%--
  Created by IntelliJ IDEA.
  User: thoai
  Date: 10/15/2017
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/js/bootstrap.min.js" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</head>
<body>
<div class="container">
    <div class="row">
        <fieldset>
            <legend>Thông tin đăng ký</legend>
            <form:form action="registration" method="post" enctype="application/x-www-form-urlencoded"
                       modelAttribute="user">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="col-md-12 form-group">
                        <div class="col-md-4">
                            <form:label path="userName" cssClass="control-label mar-top-lb">User name <strong class="cl-force">*</strong></form:label>
                        </div>
                        <div class="col-md-8">
                            <form:input path="userName" cssClass="form-control w-100"/>
                        </div>
                    </div>
                    <div class="col-md-12 form-group">
                        <div class="col-md-4">
                            <form:label path="userEmail" cssClass="control-label mar-top-lb">Email <strong class="cl-force">*</strong></form:label>
                        </div>
                        <div class="col-md-8">
                            <form:input path="userEmail" cssClass="form-control w-100"/>
                        </div>
                    </div>
                    <div class="col-md-12 form-group">
                        <div class="col-md-4">
                            <form:label path="userPassword" cssClass="control-label mar-top-lb">Password <strong class="cl-force">*</strong></form:label>
                        </div>
                        <div class="col-md-8 ">
                            <form:input path="userPassword" cssClass="form-control w-100"/>
                        </div>
                    </div>
                    <div class="col-md-12 form-group">
                        <div class="col-md-4">
                            <form:label path="userConfirmPassword" cssClass="control-label mar-top-lb">Confirm Password</form:label>
                        </div>
                        <div class="col-md-8">
                            <form:input path="userConfirmPassword" cssClass="form-control w-100"/>
                        </div>
                    </div>
                    <div class="col-md-12 form-group text-right padd-button">
                        <button type="submit" class="btn btn-primary " data-dismiss="modal">Sign up</button>
                    </div>
                </div>
                <div class="col-md-2"></div>
            </form:form>
        </fieldset>

    </div>
</div>
</body>
</html>
