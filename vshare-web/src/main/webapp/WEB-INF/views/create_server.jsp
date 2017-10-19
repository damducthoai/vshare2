<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%--
  Created by IntelliJ IDEA.
  User: thoai
  Date: 10/19/2017
  Time: 8:01 AM
  To change this template use File | Settings | File Templates.
--%>
<form:form method="post" action="${contextPath}/servers/${serverIp}" modelAttribute="server" id="${formId}">
    <form:label path="serverIp">Server Ip</form:label>
    <form:input path="serverIp"/><br>
    <form:label path="serverSize">Server Size</form:label>
    <form:input path="serverSize" type="number"/><br>
    <form:label path="serverUser">User name</form:label>
    <form:input path="serverUser"/><br>
    <form:label path="serverPassword">Server Password</form:label>
    <form:input path="serverPassword"/><br>
    <form:label path="serverAlias">Alias</form:label>
    <form:input path="serverAlias"/><br>
    <button>${action}</button>
</form:form>