<%--
  Created by IntelliJ IDEA.
  User: AnhTu
  Date: 15-Oct-17
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Home</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
            $('#folderList').DataTable();
        });
    </script>

</head>

<body>

<jsp:include page="menuHead.jsp"></jsp:include>

<jsp:include page="navigator.jsp"/>

<fieldset style="width: 80%" class="container">
    <legend>Add</legend>
    <div id="tool-box">

        <h4>Add new folder</h4>
        <td>
            <button id="btn-add" data-toggle="modal" data-target="#add-folder" class="btn btn-default">add new folder</button>

        </td>
    </div>

    <div id="tool-box">
        <h4>Upload File</h4>
        <td>
            <button id="btn-add" data-toggle="modal" data-target="#add-file" class="btn btn-default">add new file</button>
        </td>

    </div>
</fieldset>
<br>
<fieldset style="width: 80%" class="container">
    <legend>Danh sách</legend>
    <div style="width: 80%" class="container">
        <table id="folderList" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Name</th>
                <th>Size</th>
                <th>Update</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="file" items="${files}">
                <tr>
                    <td class="item-folder"><a>file </a> ${file.fileOriginalName}</td>
                    <td><a href="${contextPath}/files/${file.filePhysicalName}">${file.filePhysicalName}</a></td>
                    <td>update</td>
                    <td>
                        <button onclick="deleteFile(file.id)" class="btn btn-default">Delete</button>
                    </td>
                </tr>
            </c:forEach>
            <c:forEach var="folder" items="${folders}">
                <tr>
                    <td class="item-file"><a>folder </a> ${folder.folderName}</td>
                    <td></td>
                    <td>Update</td>
                    <td>
                        <button onclick="deleteRowFolder(folder.id)" class="btn btn-default">Delete</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</fieldset>

<hr>

<div class="modal fade" id="add-folder" role="dialog">
    <div class="modal-dialog">

        <!-- Popup content add-->
        <form:form action="${contextPath}/folders" method="post" id="createFolder" modelAttribute="newFolder">
            <form:hidden path="parrentId" value="${curlFolderId}"/>

            <div class="modal-content">
                <div class="modal-header ">
                    <h4>aaa</h4>
                </div>
                <div class="modal-body">
                    <form:hidden path="parrentId" value="${curlFolderId}"/>
                    <form:label path="name">Folder Name</form:label>
                    <form:input path="name"/>
                </div>
                <div class="modal-footer mar-top-signup ">
                    <button class="btn btn-primary" onclick="closePopup()" class="btn btn-default">Create Folder</button>
                </div>
            </div>
        </form:form>
    </div>
</div>

<div class="modal fade" id="add-file" role="dialog">
    <div class="modal-dialog">

        <!-- Popup content add-->

        <form action="${contextPath}/upload" method="post" enctype="multipart/form-data" id="uploadFile">
            <tr>
                <input type="hidden" value="${curlFolderId}" name="folderId"/>
                <td><input type="file" name="file"/></td>
                <td>
                    <button id="btn-upFile" class="btn btn-default">Upload file</button>
                </td>
            </tr>
        </form>
    </div>
</div>

<script>
    $('#createFolder').submit(function () {
        $(this).ajaxSubmit();
        return false;
    });
    $('#uploadFile').submit(function () {
        $(this).ajaxSubmit();
        return false;
    });
</script>

<script src="${contextPath}/resources/js/app.js"></script>
</body>
</html>
