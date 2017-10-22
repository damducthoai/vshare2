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
<link href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<jsp:include page="menuHead.jsp"></jsp:include>
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
        <br/>
        <fieldset>
            <legend>Danh sách card</legend>
            <table id="list" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <td>Card Serial</td>
                    <td>Card Code</td>
                    <td>Created</td>
                    <td>Point</td>
                    <td>Last Modified</td>
                    <td>Card Status</td>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <td>Card Serial</td>
                    <td>Card Code</td>
                    <td>Created</td>
                    <td>Point</td>
                    <td>Last Modified</td>
                    <td>Card Status</td>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="card" items="${cards}">
                    <tr>
                        <td>${card.cardSerial}</td>
                        <td>${card.cardCode}</td>
                        <td>${card.created}</td>
                        <td>${card.point}</td>
                        <td>${card.lastModified}</td>
                        <td>${card.cardStatus}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </fieldset>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $('#list').DataTable();
    });
</script>


