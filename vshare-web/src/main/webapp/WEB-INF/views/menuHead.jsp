<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AnhTu
  Date: 20-Oct-17
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-inverse navbar-fixed-top" id="menuMain">
    <div class="container-fluid row">
        <div class="navbar-header col-lg-2">
            <a class="navbar-brand" href="${contextPath}/home"><i class="fa fa-superpowers" aria-hidden="true"></i><b>VShare</b></a>
        </div>
        <security:authorize access="hasRole('ROLE_USER')">

            <ul class="nav navbar-nav col-lg-7">
                <li class="active"><a href="${contextPath}/home" class="top-bar">Home</a></li>
                <li><a href="${contextPath}/upgrade" class="top-bar">Upgrade</a></li>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <ul class="nav navbar-nav col-lg-3">
                        <li><a href="${contextPath}/cards" class="top-bar" >Cards</a></li>
                        <li><a href="${contextPath}/servers" class="top-bar">Servers</a></li>
                    </ul>
                </security:authorize>
            </ul>
            <ul class="nav navbar-nav navbar-right col-lg-3" id="hide-logout">
                <li><a href="${contextPath}/changepassword" class="top-bar">Change Password</a></li>
                <li><a href="${contextPath}/login?logout" data-toggle="modal"><span
                        class="glyphicon glyphicon-log-out"></span> Logout </a></li>
            </ul>

        </security:authorize>

    </div>
</nav>

