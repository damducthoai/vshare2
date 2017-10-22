<%--
  Created by IntelliJ IDEA.
  User: thoai
  Date: 10/19/2017
  Time: 7:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <%--<link href="${contextPath}/resources/css/datatable/dataTables.bootstrap.css" type="text/css" media="screen" rel="stylesheet">--%>
        <%--<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">--%>

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
        <title>Server List</title>

    </head>
    <div>
        <jsp:include page="menuHead.jsp"></jsp:include>
        <jsp:include page="create_server.jsp"/>
        <br/>
        <fieldset>
            <legend>Danh sách</legend>
            <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <td>Server Ip</td>
                    <td>Alias</td>
                    <td>Useable</td>
                    <td></td>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <td>Server Ip</td>
                    <td>Alias</td>
                    <td>Useable</td>
                    <td></td>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="server" items="${servers}">
                    <tr>
                        <td>
                            <a href="${contextPath}/servers/${server.serverIp}?ip=${server.serverIp}">${server.serverIp}</a>
                        </td>
                        <td>${server.serverAlias}</td>
                        <td>${server.serverUseableSize}</td>
                        <td class="text-center" style="width: 25px">
                            <i class="fa fa-trash-o" aria-hidden="true"></i>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </fieldset>

    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>

<script>
    $(document).ready(function () {
        var tableOption = $('#example').DataTable();
        $('#example tbody').on( 'click', 'i.fa-trash-o', function () {
            tableOption
                .row( $(this).parents('tr') )
                .remove()
                .draw();
        } );
    });
</script>
</body>
</html>
