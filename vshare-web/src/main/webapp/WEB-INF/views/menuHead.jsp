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
<nav class="navbar navbar-inverse navbar-fixed-top" id="menuMain">
    <div class="container-fluid row">
        <div class="navbar-header col-lg-3">
            <a class="navbar-brand" href="${contextPath}/home"><i class="fa fa-superpowers" aria-hidden="true"></i><b>VShare</b></a>
        </div>
        <ul class="nav navbar-nav col-lg-6" id="hide-upgrade">
            <li class="active"><a href="${contextPath}/upgrade">Upgrade</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right col-lg-3" id="hide-logout">
            <li><a href="#" data-toggle="modal"><span class="glyphicon glyphicon-log-out" ></span> Logout </a></li>
        </ul>
    </div>
</nav>

