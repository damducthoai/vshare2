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
</head>
<body>
<form>
    <div class="col-md-12 form-group">
        <div class="col-md-4">
            <label class="control-label">Username <strong class="cl-force">*</strong></label>
        </div>
        <div class="col-md-8">
            <input type="text" class="form-control w-100">
        </div>
    </div>
    <div class="col-md-12 form-group">
        <div class="col-md-4">
            <label class="control-label">Email <strong class="cl-force">*</strong></label>
        </div>
        <div class="col-md-8">
            <input type="text" class="form-control w-100">
        </div>
    </div>
    <div class="col-md-12 form-group">
        <div class="col-md-4">
            <label class="control-label">Password <strong class="cl-force">*</strong></label>
        </div>
        <div class="col-md-8 ">
            <input type="text" class="form-control w-100">
        </div>
    </div>
    <div class="col-md-12 form-group">
        <div class="col-md-4">
            <label class="control-label">Confirm password <strong class="cl-force">*</strong></label>
        </div>
        <div class="col-md-8">
            <input type="text" class="form-control w-100">
        </div>
    </div>
</form>
<div class="text-right">
    <button type="button" class="btn btn-default" data-dismiss="modal">Sign up</button>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
