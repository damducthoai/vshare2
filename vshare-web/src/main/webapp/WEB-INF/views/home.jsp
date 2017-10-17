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

    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.js"></script>

</head>

<body>

<%--<form:form action="${contextPath}/folders" method="post" id="createFolder" modelAttribute="newFolder">
    <form:hidden path="parrentId" value="${curlFolderId}"/>
    <form:label path="name">Folder Name</form:label>
    <form:input path="name"/>
    <button>Create Folder</button>
</form:form>
<form action="${contextPath}/upload" method="post" enctype="multipart/form-data" id="uploadFile">
    <input type="hidden" value="${curlFolderId}" name="folderId"/>
    <input type="file" name="file"/>
    <button>Upload file</button>
</form>--%>
<jsp:include page="create_folder.jsp"/>
<jsp:include page="upload_file.jsp"/>
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
<div id="tool-box">

    <h4>Add new folder</h4>
    <td>
        <button id="btn-add" data-toggle="modal" data-target="#add-folder">add new folder</button>

    </td>
</div>

<div id="tool-box">
    <h4>Upload File</h4>
    <td>
        <button id="btn-add" data-toggle="modal" data-target="#add-file">add new file</button>
    </td>

    <%--<form action="${contextPath}/upload" method="post" enctype="multipart/form-data" id="uploadFile">
        <tr>
            <input type="hidden" value="${curlFolderId}" name="folderId"/>
        <td><input type="file" name="file"/></td>
        <td><button id="btn-upFile" >Upload file</button></td>
        </tr>
    </form>--%>
</div>




<table id="folder-list" class="table table-bordered table-hover">
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
            <td>${file.filePhysicalName}</td>
            <td>update</td>
            <td><button onclick="deleteFile(file.id)">Delete</button></td>
        </tr>
    </c:forEach>
    <c:forEach var="folder" items="${folders}">
        <tr>
            <td class="item-file"><a>folder </a> ${folder.folderName}</td>
            <td></td>
            <td>Update</td>
            <td><button onclick="deleteRowFolder(folder.id)">Delete</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<hr>

<%--<ul>--%>
<%--<c:forEach var="file" items="${files}">--%>
<%--<li class="item-file item">--%>
<%--${file.fileOriginalName}--%>
<%--</li>--%>
<%--</ul>--%>

<%--<ul>--%>
<%--</c:forEach>--%>
<%--<c:forEach var="folder" items="${folders}">--%>
<%--<li class="item-folder item">${folder.folderName}</li>--%>
<%--</c:forEach>--%>
<%--</ul>--%>

<%--<table id="file-list">--%>


<%--<c:forEach var="file" items="${files}">--%>
<%--<tr>--%>
<%--<td>${file.fileOriginalName}</td>--%>
<%--<td>${file.filePhysicalName}</td>--%>
<%--<td>update</td>--%>
<%--</c:forEach>--%>
<%--</table>--%>



<!--<div id="friend-list" >
        <a href="/">
                    <i class="fa fa-music" aria-hidden="true"></i> <span>Music</span>
                </a>
    </div>
    <div  id="friend-list">
                <a href="/">
                    <i class="fa fa-camera-retro" aria-hidden="true"></i> <span>Photo</span>
                </a>
    </div>-->
<div class="modal fade" id="add-folder" role="dialog">
    <div class="modal-dialog">

        <!-- Popup content add-->
        <form:form action="${contextPath}/folders" method="post" id="createFolder" modelAttribute="newFolder">
            <form:hidden path="parrentId" value="${curlFolderId}"/>
            <div class="modal-content">
                <form:hidden path="parrentId" value="${curlFolderId}"/>
                <form:label path="name">Folder Name</form:label>
                <form:input path="name"/>
                <button>Create Folder</button>
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
                <td><button id="btn-upFile" >Upload file</button></td>
            </tr>
        </form>
    </div>
</div>



<script src="${contextPath}/resources/js/app.js"></script>
</body>
</html>
