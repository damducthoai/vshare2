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
        <link href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <%--<link href="${contextPath}/resources/css/datatable/dataTables.bootstrap.css" type="text/css" media="screen" rel="stylesheet">--%>
        <%--<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">--%>

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
        <title>Server List</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.js"></script>
        <%--<script src="${contextPath}/resources/js/datatable/dataTables.bootstrap.min.js"></script>--%>
        <%--<script src="${contextPath}/resources/js/datatable/jquery.dataTables.min.js"></script>--%>
        <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
    </head>
    <div>
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
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <td>Server Ip</td>
                    <td>Alias</td>
                    <td>Useable</td>
                </tr>

                </tfoot>
                <tbody>
                <tr>
                    <td>Garrett Winters</td>
                    <td>Accountant</td>
                    <td>Tokyo</td>

                </tr>
                <tr>
                    <td>Ashton Cox</td>
                    <td>Junior Technical Author</td>
                    <td>San Francisco</td>

                </tr>
                <tr>
                    <td>Cedric Kelly</td>
                    <td>Senior Javascript Developer</td>
                    <td>Edinburgh</td>

                </tr>
                <tr>
                    <td>Airi Satou</td>
                    <td>Accountant</td>
                    <td>Tokyo</td>

                </tr>
                <tr>
                    <td>Brielle Williamson</td>
                    <td>Integration Specialist</td>
                    <td>New York</td>

                </tr>
                <c:forEach var="server" items="${servers}">
                    <tr>
                        <td><a href="${contextPath}/servers/${server.serverIp}">${server.serverIp}</a></td>
                        <td>${server.serverAlias}</td>
                        <td>${server.serverUseableSize}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </fieldset>

    </div>
</div>
</body>
</html>
