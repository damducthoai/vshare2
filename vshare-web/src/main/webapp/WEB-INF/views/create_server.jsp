<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%--
  Created by IntelliJ IDEA.
  User: thoai
  Date: 10/19/2017
  Time: 8:01 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="container">
    <div class="row">
        <fieldset>
            <legend>Thông tin</legend>
            <form:form method="post" action="${contextPath}/servers/${serverIp}" modelAttribute="server" id="${formId}">
                <input type="hidden" name="ip" value="${serverIp}"/>
                <div class="col-md-12">
                    <div class="col-md-6 form-group ">
                        <div class="col-md-4 no-padding">
                            <form:label path="serverIp" cssClass="control-label mar-top-lb">Server Ip</form:label>
                        </div>
                        <div class="col-md-8">
                            <form:input path="serverIp" cssClass="form-control w-100"/>
                        </div>
                    </div>
                    <div class="col-md-6 form-group">
                        <div class="col-md-4 no-padding">
                            <form:label path="serverSize" cssClass="control-label mar-top-lb">Server Size</form:label>
                        </div>
                        <div class="col-md-8">
                            <form:input path="serverSize" type="number" cssClass="form-control w-100"/>
                        </div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-6 form-group ">
                        <div class="col-md-4 no-padding">
                            <form:label path="serverUser" cssClass="control-label mar-top-lb">User name</form:label>
                        </div>

                        <div class="col-md-8">
                            <form:input path="serverUser" cssClass="form-control w-100"/>
                        </div>
                    </div>
                    <div class="col-md-6 form-group">
                        <div class="col-md-4 no-padding">
                            <form:label path="serverPassword" cssClass="control-label mar-top-lb">Server Password</form:label>
                        </div>
                        <div class="col-md-8">
                            <form:input path="serverPassword" cssClass="form-control w-100"/>
                        </div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-6 form-group ">
                        <div class="col-md-4 no-padding">
                            <form:label path="serverAlias" cssClass="control-label mar-top-lb">Alias</form:label>
                        </div>
                        <div class="col-md-8">
                            <form:input path="serverAlias" cssClass="form-control w-100"/>
                        </div>
                    </div>
                    <div class="col-md-6 form-group">
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-6 form-group ">
                    </div>
                    <div class="col-md-6 form-group text-right padd-button">
                        <button class="btn btn-primary ch-bt-com ">${action}</button>
                    </div>
                </div>
            </form:form>
        </fieldset>




