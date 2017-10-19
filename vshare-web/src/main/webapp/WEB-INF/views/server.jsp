<%--
  Created by IntelliJ IDEA.
  User: thoai
  Date: 10/19/2017
  Time: 7:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Server List</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.js"></script>
</head>
<body>
<jsp:include page="create_server.jsp"/>
<table>
    <thead>
    <tr>
        <td>Server Ip</td>
        <td>Alias</td>
        <td>Useable</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="server" items="${servers}">
        <tr>
            <td><a href="${contextPath}/servers/${server.serverIp}">${server.serverIp}</a></td>
            <td>${server.serverAlias}</td>
            <td>${server.serverUseableSize}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
