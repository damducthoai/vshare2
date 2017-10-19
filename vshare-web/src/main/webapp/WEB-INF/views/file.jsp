<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thoai
  Date: 10/19/2017
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>File Download</title>
</head>
<body>
<form:form modelAttribute="file" action="${contextPath}/download" method="post">
    <form:label path="fileOriginalName">File Name</form:label>
    <form:input path="fileOriginalName"/>
    <form:hidden path="filePhysicalName"/>
    <form:label path="fileSize">File Size</form:label>
    <form:input path="fileSize"/>
    <br>
    <button>Download</button>
</form:form>
</body>
</html>
