<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

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
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Vshare Account</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"><img alt="User Pic"
                                                                            src="http://kysucaunoi.vn/uploads/Images/cuder4-01.png"
                                                                            class="img-circle img-responsive"></div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Username</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td><a href="mailto:info@vshare.com">info@vshare.com</a></td>
                                </tr>

                                <tr>
                                    <td>Premium expired</td>
                                    <td>${premiumData.dueTo}</td>
                                </tr>
                                </tbody>
                            </table>
                            <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#add-premium">Upgrade
                                premium</a>
                            <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#add-card">Add premium
                                point</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="add-card" role="dialog">
    <div class="modal-dialog">
        <form:form modelAttribute="card" action="${contextPath}/upgrade" method="post" id="addPoint">
            <form:label cssClass="control-label mar-top-lb" path="cardCode">Enter card code</form:label>
            <form:input cssClass="form-control" path="cardCode"/>
            <input type="hidden" value="point" name="upgrade"/>
            <button type="submit">OK</button>
        </form:form>
    </div>
</div>

<div class="modal fade" id="add-premium" role="dialog">
    <div class="modal-dialog">
        <!-- Popup content-->
        <form:form modelAttribute="premiumSize" action="${contextPath}/upgrade" method="post">
            <input type="hidden" name="upgrade" value="vip"/>
            <form:select path="size" cssClass="form-control" cssStyle="width: auto !important;">
                <form:options items="${premiumSizeData}"></form:options>
            </form:select>
            <button type="submit">OK</button>
        </form:form>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
<script>

</script>


</html>