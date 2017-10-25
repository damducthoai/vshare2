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
        <security:authorize access="hasRole('ROLE_USER')" >
            <ul class="nav navbar-nav col-lg-7">
                <li ><a href="${contextPath}/home" class="top-bar" id="home" ><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
                <li ><a href="${contextPath}/upgrade" class="top-bar" id="upgrade" ><i class="fa fa-arrow-up" aria-hidden="true"></i> Upgrade</a></li>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <ul class="nav navbar-nav col-lg-6">
                        <li ><a href="${contextPath}/cards" class="top-bar" id="card" ><i class="fa fa-credit-card-alt" aria-hidden="true"></i> Cards</a></li>
                        <li ><a href="${contextPath}/servers" class="top-bar" id="server" ><i class="fa fa-server" aria-hidden="true"></i> Servers</a></li>
                    </ul>
                </security:authorize>
            </ul>
            <ul class="nav navbar-nav navbar-right col-lg-2" id="hide-logout">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Hi, ${user.userName}
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu" style="background: #222">
                        <li ><a href="${contextPath}/changepassword" id="changepw" class="dd" style="color: #9d9d9d"><i class="fa fa-exchange" aria-hidden="true"></i> Change Password</a></li>

                        <li><a href="${contextPath}/login?logout" data-toggle="modal" class="dd" style="color: #9d9d9d" ><span
                                class="glyphicon glyphicon-log-out"></span> Logout </a></li>
                    </ul>
                </li>
            </ul>

        </security:authorize>

    </div>
</nav>

