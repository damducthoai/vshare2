<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%--
  Created by IntelliJ IDEA.
  User: thoai
  Date: 10/19/2017
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upgrade</title>
</head>
<body>
<form:form modelAttribute="card" action="${contextPath}/upgrade" method="post">
    <form:label path="cardCode">Enter card code</form:label>
    <form:input path="cardCode"/>
    <input type="hidden" name="upgrade" value="point"/>
    <button>Active</button>
</form:form>
<form:form modelAttribute="premiumSize" action="${contextPath}/upgrade" method="post">
    <input type="hidden" name="upgrade" value="vip"/>
    <form:select path="size">
        <form:options items="${premiumSizeData}"></form:options>
    </form:select>
    <button>Update VIP</button>
</form:form>
</body>
</html>