<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

<jsp:include page="menuHead.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 mar-top">
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
                                    <td>${user.userName}</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td><a href="mailto:${user.userEmail}">${user.userEmail}</a></td>
                                </tr>

                                <tr>
                                    <td>Premium expired</td>
                                    <td>${premiumData.dueTo}</td>
                                </tr>
                                </tbody>
                            </table>
                            <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#add-premium2"><i class="fa fa-arrow-up" aria-hidden="true"></i> Upgrade
                                premium</a>
                            <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#add-card2"><i class="fa fa-plus" aria-hidden="true"></i> Add premium
                                point</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="add-card2" role="dialog">
    <div class="modal-dialog">
        <form:form modelAttribute="card" action="${contextPath}/upgrade" method="post" id="addPoint">
            <!-- Popup content-->
            <div class="modal-content">
                <div class="modal-header ">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Add Card</h4>
                </div>
                <div class="modal-body ">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <form:label cssClass="control-label mar-top-lb" path="cardCode">Enter card code</form:label>
                        </div>
                        <div class="col-md-8">
                            <form:input cssClass="form-control" path="cardCode"/>
                            <input type="hidden" value="point" name="upgrade"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer mar-top-signup mar-popup-card ">
                        <%--<button type="button" class="btn btn-default" data-dismiss="modal">Sign up</button>--%>
                            <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </div>
        </form:form>
    </div>
</div>
<div class="modal fade" id="add-premium2" role="dialog">
    <div class="modal-dialog">
        <form:form modelAttribute="premiumSize" action="${contextPath}/upgrade" method="post">
        <!-- Popup content-->
        <div class="modal-content">
            <div class="modal-header ">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Upgrade premium</h4>
            </div>
            <div class="modal-body ">
                <div class="col-md-12">
                    <div class="col-md-4">
                        <label class="control-label mar-top-lb">Số ngày</label>
                    </div>
                    <div class="col-md-8">
                        <input type="hidden" name="upgrade" value="vip"/>
                        <form:select path="size" cssClass="form-control" cssStyle="width: auto !important;">
                            <form:options items="${premiumSizeData}"></form:options>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="modal-footer mar-top-signup mar-popup-card ">
                <%--<button type="button" class="btn btn-default" data-dismiss="modal">Sign up</button>--%>
                <button type="submit" class="btn btn-primary">Upgrade</button>
            </div>
        </div>
        </form:form>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
<script>
    $(document).ready(function () {
        $('#upgrade').css({"height" : "50px","border-bottom" : "5px solid #2e6da4","color":"white" });
    });
</script>


</html>