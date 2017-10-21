<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.js"></script>
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
<div class="container">
    <div class="row">
        <form:form modelAttribute="card" action="${contextPath}/upgrade" method="post">
            <div class="col-md-12 form-group">
                <div class="col-md-3"></div>
                <div class="col-md-2 no-padding">
                    <form:label cssClass="control-label mar-top-lb" path="cardCode">Enter card code</form:label>
                </div>
                <div class="col-md-3">
                    <form:input cssClass="form-control" path="cardCode"/>
                    <input type="hidden" name="upgrade" value="point"/>
                </div>
                <div class="col-md-2">
                    <button class="btn btn-primary">Active</button>
                </div>
                <div class="col-md-2"></div>
            </div>
        </form:form>
        <div class="col-md-12 form-group">
            <div class="col-md-3"></div>
            <div class="col-md-2 no-padding">
                <label>
                    <input type="checkbox" onclick="toggle('.myClass', this)"/> Upgrade Premium
                </label>
            </div>
            <div class="col-md-3">
                <input type="hidden" name="upgrade" value="vip"/>
                <form:select path="size" cssClass="form-control">
                    <form:options items="${premiumSizeData}"></form:options>
                </form:select>
            </div>
            <div class="col-md-2">
            </div>
            <div class="col-md-2"></div>
        </div>
        <form:form modelAttribute="premiumSize" action="${contextPath}/upgrade" method="post">
            <div class="col-md-12 myClass form-group" style="display: none">
                <div class="col-md-3"></div>
                <div class="col-md-2 no-padding">
                </div>
                <div class="col-md-3 text-right">

                </div>
                <div class="col-md-2">
                    <button class="btn btn-primary">Update VIP</button>
                </div>
                <div class="col-md-2"></div>
            </div>
        </form:form>
    </div>
</div>
</body>
<script>
    function toggle(className, obj) {
        var $input = $(obj);
        if ($input.prop('checked')) $(className).show();
        else $(className).hide();
    }
</script>
</html>