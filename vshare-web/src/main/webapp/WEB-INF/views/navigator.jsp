<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/home" var="homeUrl" htmlEscape="true"/>
<spring:url value="/upgrade" var="upgradeUrl" htmlEscape="true"/>
<%--
  Created by IntelliJ IDEA.
  User: thoai
  Date: 10/19/2017
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul>
    <li><a href="${homeUrl}">Home</a></li>
    <li><a href="${upgradeUrl}">Upgrade</a></li>
</ul>
