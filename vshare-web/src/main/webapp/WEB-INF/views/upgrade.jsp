<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <button class="btn btn-primary" data-toggle="modal" data-target="#add-card" >add new card</button>
        <button class="btn btn-primary" data-toggle="modal" data-target="#add-premium" >add new premium</button>
    </div>
</div>

<div class="modal fade" id="add-card" role="dialog">
    <div class="modal-dialog">

        <!-- Popup content-->
        <div class="modal-content">
            <div class="modal-header ">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Sign Up</h4>
            </div>

            <div class="modal-body ">
                <form:form modelAttribute="card" action="${contextPath}/upgrade" method="post">
                    <div class="col-md-12 form-group">
                        <div class="col-md-4 no-padding">
                            <form:label cssClass="control-label mar-top-lb" path="cardCode">Enter card code</form:label>
                        </div>
                        <div class="col-md-6">
                            <form:input cssClass="form-control" path="cardCode"/>
                            <input type="hidden" name="upgrade" value="point"/>
                        </div>
                        <div class="col-md-2">
                            <button class="btn btn-primary">Active</button>
                        </div>
                    </div>
                    <div class="col-md-12 form-group">
                            <label>
                                <input type="checkbox"/> Upgrade Premium
                            </label>
                    </div>

                </form:form>
            </div>
            <div class="modal-footer mar-popup-card ">
                <button type="button" class="btn btn-default" data-dismiss="modal">Add card</button>
            </div>
        </div>

    </div>
</div>
<div class="modal fade" id="add-premium" role="dialog">
    <div class="modal-dialog">
        <!-- Popup content-->
        <div class="modal-content">
            <div class="modal-header ">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Sign Up</h4>
            </div>

            <div class="modal-body ">
                <form:form modelAttribute="premiumSize" action="${contextPath}/upgrade" method="post">
                    <div class="col-md-12 form-group">
                        <div class="col-md-5"></div>
                        <div class="col-md-3 text-right">
                            <div class="col-md-3">
                                <input type="hidden" name="upgrade" value="vip" />
                                <form:select path="size" >
                                    <form:options items="${premiumSizeData}"></form:options>
                                </form:select>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <button class="btn btn-primary">Update VIP</button>
                        </div>
                    </div>
                </form:form>
            </div>
            <div class="modal-footer mar-popup-card ">
                <button type="button" class="btn btn-default" data-dismiss="modal">Add premium</button>
            </div>
        </div>

    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
<script>
    function toggle(className, obj) {
        var $input = $(obj);
        if ($input.prop('checked')) $(className).show();
        else $(className).hide();
    }
</script>


</html>