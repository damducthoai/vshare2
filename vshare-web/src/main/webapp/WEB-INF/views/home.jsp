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

<style>
    .btn-glyphicon {
        padding:8px;
        background:#ffffff;
        margin-right:4px;
    }
    .btn-delete {
        padding: 1px 15px 3px 2px;
        border:0.5px solid red;
    }
    .icon-btn {
        padding: 1px 15px 3px 2px;
        border-radius:50px;
    }
</style>

<body>

<jsp:include page="menuHead.jsp"></jsp:include>

<jsp:include page="navigator.jsp"/>

<%--<fieldset style="width: 80%" class="container">
    <legend>Add</legend>

</fieldset>--%>
<div class="row" style="width: 80%">
    <div class="col-md-8"></div>
    <div class="tool-box col-md-2">

        <td>
            <%--<button id="btn-add" data-toggle="modal" data-target="#add-folder" class="btn btn-default">add new folder</button>--%>

            <a data-toggle="modal" data-target="#add-folder" class="btn icon-btn btn-success" href="#">
                <span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>
                Add Folder
            </a>
        </td>
    </div>

    <div class="tool-box col-md-2">
        <td>
            <%-- <button id="btn-add" data-toggle="modal" data-target="#add-file" class="btn btn-default">add new file</button>--%>
            <a data-toggle="modal" data-target="#add-file" class="btn icon-btn btn-success" href="#">
                <span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>
                Add File
            </a>
        </td>

    </div>
</div>

<br>
<fieldset style="width: 80%" class="container">
    <legend>Danh sách</legend>
    <div style="width: 80%" class="container">
        <table id="folderList" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Name</th>
                <th>Size</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody id="cha">
            <c:forEach var="file" items="${files}">
                <tr>
                    <td class="row">
                        <div class="col-md-2"><i class="fa fa-file-o" aria-hidden="true"></i></div>
                        <a href="${contextPath}/files/${file.filePhysicalName}">
                            <div class="col-md-6">${file.fileOriginalName}</div>
                        </a>
                    </td>
                    <td><a href="${contextPath}/files/${file.filePhysicalName}">${file.filePhysicalName}</a></td>
                    <td>
                        <a data-toggle="modal" data-target="#delete-popup-file" class="btn icon-btn btn-delete" id="${file.fileId}">
                            <span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>
                            Delete
                        </a>
                        <%--<button onclick="deleteFile(${file.fileId})" class="btn btn-default">Delete</button>--%>
                        <div class="modal fade" id="delete-popup-file" role="dialog">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header ">
                                        <h4>Are you sure?</h4>
                                    </div>
                                    <div class="modal-body text-center">
                                        <button onclick="deleteFile(${file.fileId})" data-dismiss="modal" class="btn btn-primary">Accept</button>
                                        <button data-dismiss="modal" class="btn btn-default">Cancel</button>
                                    </div>
                                    <div class="modal-footer mar-top-signup ">

                                    </div>
                                </div>
                                </form>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <c:forEach var="folder" items="${folders}">
                <tr>
                    <td class="row">
                        <div class="col-md-2"><i class="fa fa-folder-open-o" aria-hidden="true"></i></div>
                        <a href="${contextPath}/home/${folder.folderId}">
                            <div class="col-md-6">${folder.folderName}</div>
                        </a>
                    </td>
                    <td></td>
                    <td>
                        <a data-toggle="modal" data-target="#delete-popup-folder" class="btn icon-btn btn-delete" id="${folder.folderId}">
                            <span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>
                            Delete
                        </a>

                        <div class="modal fade" id="delete-popup-folder" role="dialog">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header ">
                                        <h4>Are you sure?</h4>
                                    </div>
                                    <div class="modal-body text-center">
                                        <button onclick="deleteRowFolder(${folder.folderId})" data-dismiss="modal" class="btn btn-primary">Accept</button>
                                        <button data-dismiss="modal" class="btn btn-default">Cancel</button>
                                    </div>
                                    <div class="modal-footer mar-top-signup ">

                                    </div>
                                </div>
                                </form>
                            </div>
                        </div>

                        <%--<button onclick="deleteRowFolder(${folder.folderId})" class="btn btn-default">Delete</button>--%>
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

        <form:form action="${contextPath}/upload" method="post" enctype="multipart/form-data" modelAttribute="file" id="uploadFile">
            <div class="modal-content">
                <div class="modal-header ">
                    <h4>bbbb</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" value="${curlFolderId}" name="folderId"/>
                    <%--<label class="btn btn-default btn-file">
                        Browse
                    </label>--%>
                    <span class="btn btn-primary btn-sm fileinput-button">
                    <span class="glyphicon glyphicon-plus"></span>
                    Thêm tập tin...
                    <input type="file" name="file"/>
                </span>

                    <%--<td><input type="file" name="file" class="btn btn-default"/></td>--%>
                </div>
                <div class="modal-footer mar-top-signup ">
                    <button id="btn-upFile" class="btn btn-default">Upload file</button>
                </div>
            </div>
        </form:form>
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

        function deleteRowFolder(folderId) {
            $.ajax({
                url: "${contextPath}/folders/" + folderId,
                type: 'DELETE',
                success: function (response) {
                    var row = document.getElementById(folderId);
                    var a = row.parentNode.parentNode;
                    var b = a.parentNode;
                    b.removeChild(a);
                },
                error: function (response) {
                    // TODO
                }
            });
        }

        function deleteFile(fileId) {
            $.ajax({
                url: "${contextPath}/files/" + fileId,
                type: 'DELETE',
                success: function (response) {
                    //var deleteData = document.getElementById("folderList");
//                    var row = document.getElementById(fileId);
//                    var a = row.parentNode.parentNode.nodeName;
//                    console.log(a);
//                    var table = document.getElementById("cha");
//                    table.removeChild(a); aaaaaaaaaaaaaaaaaaaaaaa
                    var row = document.getElementById(fileId);
                    var a = row.parentNode.parentNode;
                    var b = a.parentNode;
                    b.removeChild(a);
                    //row.style.display='none';
                },
                error: function (response) {
                    window.alert("co lỗi rồi man!");
                }
            });
        }


</script>

<script src="${contextPath}/resources/js/app.js"></script>
</body>
</html>
