<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%--
  Created by IntelliJ IDEA.
  User: Anh
  Date: 10/22/2017
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.js"></script>
    <title>Change pass</title>
</head>
<body>
<form:form modelAttribute="info" method="post" action="${contextPath}/changepassword" id="changepass">
    <form:label path="currentPassword">Current password</form:label>
    <form:input path="currentPassword"/>
    <form:label path="newPassword">New Password</form:label>
    <form:input path="newPassword"/>
    <form:label path="confirmNewPassword">Confirm new pass</form:label>
    <form:input path="confirmNewPassword"/>
    <button type="submit">OK</button>
</form:form>
<script>
    $('#changepass').submit(function () {
        // prepare Options Object
        var options = {

            success: function (res) {
                alert('Change pass success');
            },
            error: function (response) {
                alert('Change pass fail');
            }
        };
        $(this).ajaxSubmit(options);
        return false;
    });
</script>
</body>
</html>
