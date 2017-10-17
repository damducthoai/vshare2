<%--
  Created by IntelliJ IDEA.
  User: thoai
  Date: 10/15/2017
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/js/bootstrap.min.js" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <form action="registration" method="post">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="col-md-12 form-group">
                    <div class="col-md-4">
                        <label class="control-label">Username <strong class="cl-force">*</strong></label>
                    </div>
                    <div class="col-md-8">
                        <input type="text" class="form-control w-100" name="userName">
                    </div>
                </div>
                <div class="col-md-12 form-group">
                    <div class="col-md-4">
                        <label class="control-label">Email <strong class="cl-force">*</strong></label>
                    </div>
                    <div class="col-md-8">
                        <input type="text" class="form-control w-100" name="userEmail">
                    </div>
                </div>
                <div class="col-md-12 form-group">
                    <div class="col-md-4">
                        <label class="control-label">Password <strong class="cl-force">*</strong></label>
                    </div>
                    <div class="col-md-8 ">
                        <input type="text" class="form-control w-100" name="userPassword">
                    </div>
                </div>
                <div class="col-md-12 form-group">
                    <div class="col-md-4">
                        <label class="control-label">Confirm password <strong class="cl-force">*</strong></label>
                    </div>
                    <div class="col-md-8">
                        <input type="text" class="form-control w-100" name="userConfirmPassword">
                    </div>
                </div>
                <div class="text-right">
                    <button type="submit" class="btn btn-primary" data-dismiss="modal">Sign up</button>
                </div>
            </div>
            <div class="col-md-2"></div>
        </form>

    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/css/common.css"></script>
<script src="${contextPath}/resources/css/bootstrap.min.css"></script>
</body>
</html>
