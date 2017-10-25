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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<jsp:include page="menuHead.jsp"></jsp:include>
<div class="container mar-top">
    <div class="row">
        <div class="box-wmc co-bd-01">
            <div class="wrap-title-mc">
                <div class="title-mc">Create card</div>
            </div>
            <div class="row form-inline">
                <form:form action="${contextPath}/cards" method="post" modelAttribute="card">

                    <div class="col-md-6">
                        <div class="col-md-3">
                            <label class="control-label mar-top-lb">Kind of card</label>
                        </div>
                        <div class="col-md-3 no-padding">
                            <form:select cssClass="form-control" path="point" items="${type}">
                            </form:select>
                        </div>
                        <div class="col-md-2">
                            <button class="btn btn-primary"><i class="fa fa-plus" aria-hidden="true"></i> Create card
                            </button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
        <br/>
        <div class="box-wmc co-bd-01">
            <div class="wrap-title-mc">
                <div class="title-mc">Card's list</div>
            </div>
            <div class="row padd-lr fit-table">
                <div class="col-md-12">
                    <table id="list" class="table table-striped table-bordered " >
                        <thead>
                        <tr>
                            <td>Card Serial</td>
                            <td>Card Code</td>
                            <td>Created</td>
                            <td>Point</td>
                            <td>Card Status</td>
                            <td>Last Modified</td>

                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <td>Card Serial</td>
                            <td>Card Code</td>
                            <td>Created</td>
                            <td>Point</td>
                            <td>Card Status</td>
                            <td>Last Modified</td>

                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach var="card" items="${cards}">
                            <tr>
                                <td>${card.cardSerial}</td>
                                <td>${card.cardCode}</td>
                                <td>${card.created}</td>
                                <td>${card.point}</td>
                                <td>${card.cardStatus}</td>
                                <td>${card.lastModified}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/script.js"></script>
<script>
    $(document).ready(function () {
        $('#list').DataTable();
        $('#card').css({
            "height": "50px",
            "border-bottom": "5px solid #2e6da4",
            "color": "white",
            "background": "black"
        });
        $('.fit-table').each(function () {
            var itemWidthFit = $(this).width();
            var sItemWidthFit = itemWidthFit;
            $(this).find('.wrap-table').attr('style', 'width' + ': ' + sItemWidthFit + 'px !important;');
        });
    });
</script>


