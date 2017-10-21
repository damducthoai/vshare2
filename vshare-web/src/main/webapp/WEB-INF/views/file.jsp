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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <title>File Download</title>
</head>
<body>
<jsp:include page="menuHead.jsp"></jsp:include>
<form:form modelAttribute="file" action="${contextPath}/download" method="post">
<div class="container mar-top">
    <div class="row">
        <fieldset>
            <legend>Download File</legend>
            <div class="col-md-12 form-group">
                <div class="col-md-4  text-right">
                    <form:label cssClass="control-label" path="fileOriginalName">File Name:</form:label>
                </div>
                <div class="col-md-8">
                    <form:input cssClass="form-control" path="fileOriginalName" cssStyle="display: none"/>
                    <label class="control-label">${file.fileOriginalName}</label>
                </div>
            </div>
            <div class="col-md-12 form-group">
                <div class="col-md-4 text-right">
                    <form:hidden path="filePhysicalName"/>
                    <form:label cssClass="control-label" path="fileSize">File Size:</form:label>
                </div>
                <div class="col-md-8">
                    <form:input cssClass="form-control" path="fileSize" cssStyle="display: none"/>
                    <label class="control-label">${file.fileSize}</label>
                </div>
            </div>
            <div class="col-md-12 form-group">
                <div class="col-md-4 mar-top-lb">

                </div>
                <div class="col-md-8">
                    <button class="btn btn-primary"><i class="fa fa-download" aria-hidden="true"></i> Download</button>
                </div>
            </div>
        </fieldset>
    </div>
</div>
</form:form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $("#hide-logout").hide();
    });
</script>
</body>
</html>
