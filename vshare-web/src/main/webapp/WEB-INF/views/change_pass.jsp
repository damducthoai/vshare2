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
    <link href="${contextPath}/resources/css/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <title>Change pass</title>
</head>
<body>
<jsp:include page="menuHead.jsp"></jsp:include>
<div class="container mar-top">
    <div class="row">
        <div class="box-wmc co-bd-01">
            <div class="wrap-title-mc">
                <div class="title-mc">Change password</div>
            </div>
            <div class="row form-group ">
                <form:form modelAttribute="info" method="post" action="${contextPath}/changepassword" id="changepass">
                <div class="col-md-12 form-group">
                    <div class="col-md-4 mar-top-lb">
                        <form:label path="currentPassword" cssClass="control-label">Current password</form:label>
                    </div>
                    <div class="col-md-8">
                        <form:input path="currentPassword" type="password" cssClass="form-control"/>
                    </div>
                </div>
                <div class="col-md-12 form-group">
                    <div class="col-md-4 mar-top-lb">
                        <form:label path="newPassword" cssClass="control-label">New Password</form:label>
                    </div>
                    <div class="col-md-8">
                        <form:input path="newPassword" type="password" cssClass="form-control"/>
                    </div>
                </div>
                <div class="col-md-12 form-group">
                    <div class="col-md-4 mar-top-lb">
                        <form:label path="confirmNewPassword" cssClass="control-label">Confirm new pass</form:label>
                    </div>
                    <div class="col-md-8">
                        <form:input path="confirmNewPassword" type="password" cssClass="form-control"/>
                    </div>
                </div>
                <div class="col-md-12 form-group">
                    <div class="col-md-4 mar-top-lb">
                    </div>
                    <div class="col-md-8 text-right">
                        <button type="submit" class="btn btn-primary"><i class="fa fa-repeat" aria-hidden="true"></i> Change</button>
                    </div>
                </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.js"></script>
</body>








<script>
    $('#changepw').css({"border-left" : "3px solid #2e6da4","color":"white","background":"black"  });
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
