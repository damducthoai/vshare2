<%--
  Created by IntelliJ IDEA.
  User: thoai
  Date: 10/19/2017
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<div class="container">
    <div class="row">
        <fieldset>
            <legend>Tạo card</legend>
            <form:form action="${contextPath}/cards" method="post" modelAttribute="card">

                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-6 no-padding">
                        <form:select cssClass="form-control" path="point" items="${type}">
                        </form:select>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-primary">Create card</button>
                    </div>
                    <div class="col-md-2"></div>
                </div>

            </form:form>
        </fieldset>
    </div>
</div>


