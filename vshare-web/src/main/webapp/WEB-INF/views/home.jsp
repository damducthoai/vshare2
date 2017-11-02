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
<%@ page isELIgnored="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Home</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <%--<link href="${contextPath}/resources/css/datatable/dataTables.bootstrap.css" type="text/css" media="screen" rel="stylesheet">--%>
    <%--<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">--%>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <title>Home</title>
    <script src="${contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.js"></script>--%>
    <script src="${contextPath}/resources/js/jquery.form.js"></script>
    <script src="${contextPath}/resources/js/datatable/jquery.dataTables.min.js"></script>
    <script src="${contextPath}/resources/js/datatable/dataTables.bootstrap.min.js"></script>
    <%--<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>--%>
    <%--<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>--%>
    <%--Progess--%>
    <script type="text/javascript" src="${contextPath}/resources/malsup.github.io/jquery.form.js"></script>
    <script>
        $(document).ready(function () {
            $('#folderList').DataTable();
        });
    </script>

</head>

<style>
    .btn-glyphicon {
        padding: 8px;
        background: #ffffff;
        margin-right: 4px;
    }

    .btn-delete {
        padding: 1px 15px 3px 2px;
        border: 0.5px solid red;
    }

    .icon-btn {
        padding: 1px 15px 3px 2px;
        border-radius: 50px;
    }
</style>

<body>

<jsp:include page="menuHead.jsp"></jsp:include>


<%--<fieldset style="width: 80%" class="container">
    <legend>Add</legend>

</fieldset>--%>
<div class="container" style="padding-top: 50px">
    <div class="row">
        <%--<div class="col-md-12 form-group text-right">--%>
           <%----%>
        <%--</div>--%>
        <div class="box-wmc co-bd-01">
            <div class="wrap-title-mc">
                <div class="title-mc">
                    <div class="tool-box text-right">
                        <%-- <button id="btn-add" data-toggle="modal" data-target="#add-file" class="btn btn-default">add new file</button>--%>
                        <a data-toggle="modal" data-target="#add-file" class="btn icon-btn btn-up-add" href="#">
                            <span class="fa fa-cloud-upload img-circle text-success"></span>
                            <%-- <i class="fa fa-cloud-upload" aria-hidden="true"></i>--%>
                            Upload File
                        </a>
                        <a data-toggle="modal" data-target="#add-folder" class="btn icon-btn btn-up-add"
                           href="#">
                            <span class="fa fa-folder img-circle text-success"></span>
                            <%--<i class="fa fa-folder-o" aria-hidden="true"></i>--%>
                            <%--<i class="fa fa-upload" aria-hidden="true"></i>--%>
                            Add Folder
                        </a>
                    </div>
                </div>
            </div>
            <div class="row padd-lr fit-table">
                <div class="col-md-12">
                    <table id="folderList" class="table table-striped table-bordered table-hover" cellspacing="0"
                           width="100%">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Size</th>
                            <th style="width: 20px;">Share</th>
                            <th style="width: 20px;">Action</th>
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
                                <td><a href="${contextPath}/files/${file.filePhysicalName}">${file.fileSize} Byte</a>
                                </td>
                                <td class="" style="width: 25px">
                                    <a data-toggle="modal" data-target="#share-popup-file" class="btn icon-btn"
                                       id="${file.fileId}"
                                       onclick="share(${file.fileId})">
                                        <i class="fa fa-share-square-o" aria-hidden="true"></i>
                                    </a>
                                    <div class="modal fade" id="share-popup-file" role="dialog">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header ">
                                                    <h4>Share ${file.fileOriginalName} file</h4>
                                                </div>
                                                <div class="modal-body text-center">
                                                    <c:set var="req" value="${pageContext.request}"/>
                                                    <c:set var="baseURL"
                                                           value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}"/>
                                                    <h4 id="linkShare">${baseURL}/files/${file.filePhysicalName}</h4>
                                                    <button id="copy-btn" onclick="copyToClipboard('#linkShare')"
                                                            data-dismiss="modal" class="btn btn-primary">Copy link
                                                    </button>
                                                    <button data-dismiss="modal" class="btn btn-default">Cancel</button>
                                                </div>
                                                <div class="modal-footer mar-top-signup ">

                                                </div>
                                            </div>
                                            </form>
                                        </div>
                                    </div>
                                </td>
                                <td class="" style="width: 25px">
                                    <a data-toggle="modal" data-target="#delete-popup-file" class="btn icon-btn"
                                       id="${file.fileId}"
                                       onclick="deleteFile(${file.fileId})">
                                        <i class="fa fa-trash-o cl-force" aria-hidden="true"></i>
                                    </a>
                                        <%--<button onclick="deleteFile(${file.fileId})" class="btn btn-default">Delete</button>--%>
                                        <%-- <div class="modal fade" id="delete-popup-file" role="dialog">
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
                                         </div>--%>
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
                                <td class="" style="width: 25px">

                                </td>
                                <td class="" style="width: 25px">
                                    <a data-toggle="modal" data-target="#delete-popup-folder" class="btn icon-btn"
                                       id="${folder.folderId}"
                                       onclick="deleteRowFolder(${folder.folderId})">
                                        <i class="fa fa-trash-o cl-force" aria-hidden="true"></i>
                                    </a>

                                        <%--<div class="modal fade" id="delete-popup-folder" role="dialog">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header ">
                                                        <h4>Are you sure?</h4>
                                                    </div>
                                                    <div class="modal-body text-center">
                                                        <button onclick="deleteRowFolder('<script></script>')" data-dismiss="modal" class="btn btn-primary">Accept</button>
                                                        <button data-dismiss="modal" class="btn btn-default">Cancel</button>
                                                    </div>
                                                    <div class="modal-footer mar-top-signup ">

                                                    </div>
                                                </div>
                                                </form>
                                            </div>
                                        </div>--%>

                                        <%--<button onclick="deleteRowFolder(${folder.folderId})" class="btn btn-default">Delete</button>--%>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>


        <hr>

        <div class="modal fade" id="add-folder" role="dialog">
            <div class="modal-dialog">

                <!-- Popup content add-->
                <form:form action="${contextPath}/folders" method="post" id="createFolder" modelAttribute="newFolder">
                    <form:hidden path="parrentId" value="${curlFolderId}"/>

                    <div class="modal-content">
                        <div class="modal-header ">
                            <h4>Add new folder</h4>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" value="${curlFolderId}" name="folderId">
                                <%--
                                                    <form:hidden path="parrentId" value="${curlFolderId}"/>
                                --%>
                            <form:label path="name">Folder Name</input></form:label>
                            <form:input path="name" id="folder-name"/>
                        </div>
                        <div class="modal-footer mar-top-signup ">
                            <button class="btn btn-primary" class="btn btn-default">Create Folder</button>
                            <button id="closess1" data-dismiss="modal" style="display: none"></button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>

        <div class="modal fade" id="add-file" role="dialog">
            <div class="modal-dialog">
                <!-- Popup content add-->

                <form:form action="${contextPath}/upload" method="post" enctype="multipart/form-data"
                           modelAttribute="file" id="uploadFile">
                    <div class="modal-content">
                        <div class="modal-header ">
                            <h4>Upload file</h4>
                        </div>
                        <div class="modal-body">
                            <div id="uploadBox"></div><!-- /uploadBox -->

                            <input type="hidden" value="${curlFolderId}" name="folderId"/>
                                <%--<label class="btn btn-default btn-file">
                                    Browse
                                </label>--%>
                            <span class="btn btn-primary btn-sm fileinput-button">
                    <span class="glyphicon glyphicon-plus"></span>
                    Thêm tập tin...
                    <input id="progessFile" type="file" name="file"/>
                </span>

                                <%--<td><input type="file" name="file" class="btn btn-default"/></td>--%>
                        </div>
                        <div class="modal-footer mar-top-signup ">
                                <%--
                                                    <input type="button" id="btn-upFile" class="btn btn-default" onclick="uploadFile()" value="Upload"/>
                                --%>
                            <button id="btn-upFile" class="btn btn-default">Upload file</button>
                            <button id="closess" data-dismiss="modal" style="display: none"></button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>

    </div>
</div>


<script>
    $('#home').css({"height": "52px", "border-bottom": "2px solid #2e6da4", "color": "white", "background": "black"});
    $('#createFolder').submit(function () {
        var options = {

            success: function (res) {
                var folderList = [];
                var fileList = [];
                var name = document.getElementById("folder-name").value;
                var folder = [];

                folder.push(name);

                folderList.push(folder);

                var table = document.getElementById("folderList");
                for (var i = 0; i < folderList.length; i++) {

                    var rowCount = table.rows.length;
                    var row = table.insertRow(rowCount);
                    var cell1 = row.insertCell(0);
                    var cell2 = row.insertCell(1);
                    var cell3 = row.insertCell(2);
                    var cell4 = row.insertCell(3);
                    cell1.innerHTML = '<td class="row sorting_1">\n' +
                        '                        <div class="col-md-2"><i class="fa fa-folder-open-o" aria-hidden="true"></i></div>\n' +
                        '                        <a href="/home/' + res.folderId + '">\n' +
                        '                            <div class="col-md-6">' + folderList[i][0] + '</div>\n' +
                        '                        </a>\n' +
                        '                    </td>';
                    cell2.innerHTML = '<td></td>';
                    cell3.innerHTML = '<td></td>';
                    //cell4.innerHTML = "<button id="+"btn-remove "+"onclick="+"deleteRow("+i+")"+">Delete</button>";   C1
                    //aaaaaaaaacell3.innerHTML = '<td><a class="btn icon-btn btn-delete"><span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span> Delete</a></td>';   //C2
                    cell4.innerHTML = '<td class="text-center" style="width: 25px">\n' +
                        '                        <a data-toggle="modal" onclick="deleteFile(' + res.fileId + ')" data-target="#delete-popup-folder" class="btn icon-btn" id="' + res.folderId + '">\n' +
                        '                            <i class="fa fa-trash-o cl-force" aria-hidden="true"></i>\n' +
                        '                        </a>\n' +
                        '                    </td>';
                }

                $("#closess1").click();

            },
            error: function (response) {
                // TODO
            }
        };
        $(this).ajaxSubmit(options);
        return false;
    });

    $('#uploadFile').submit(function () {
        // prepare Options Object
        var options = {
            beforeSubmit: function () {
                $(this).addClass('loading');
                $('#uploadBox').html('<div class="progress progress-striped active"><div class="progress-bar" id="progressBar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%"><span class="sr-only">0%</span></div></div>');
            },
            uploadProgress: function (event, position, total, percentComplete) {
                if (percentComplete == 100) {
                    $('#progressBar').css('width', percentComplete + '%').html('Processing...');
                } else {
                    $('#progressBar').css('width', percentComplete + '%').html(percentComplete + '%');
                }
            },
            success: function (res) {
                var addFileToFronend = function () {
                    var folderList = [];
                    var fileList = [];
                    var nameOr = res.fileOriginalName;
                    var namePh = res.filePhysicalName;
                    var size = res.fileSize;
                    var folder = [];

                    folder.push(nameOr);
                    folder.push(size);
                    folderList.push(folder);

                    var table = document.getElementById("folderList");
                    for (var i = 0; i < folderList.length; i++) {

                        var rowCount = table.rows.length;
                        var row = table.insertRow(rowCount);
                        var cell1 = row.insertCell(0);
                        var cell2 = row.insertCell(1);
                        var cell3 = row.insertCell(2);
                        var cell4 = row.insertCell(3);
                        cell1.innerHTML = '<td class="row sorting_1">\n' +
                            '                        <div class="col-md-2"><i class="fa fa-file-o" aria-hidden="true"></i></div>\n' +
                            '                        <a href="/files/' + nameOr + '">\n' +
                            '                            <div class="col-md-6">' + folderList[i][0] + '</div>\n' +
                            '                        </a>\n' +
                            '                    </td>';

                        cell2.innerHTML = '<td><a href="/files/' + namePh + '">' + folderList[i][1] + ' Byte</td>';
                        cell3.innerHTML = '<td class="text-center" style="width: 25px; text-align: center">\n' +
                            '                        <a data-toggle="modal" data-target="#delete-popup-file" class="btn icon-btn" id=""\n' +
                            '                           onclick="share()">\n' +
                            '                            <i class="fa fa-share-square-o" aria-hidden="true"></i>\n' +
                            '                        </a>\n' +
                            '                    </td>';
                        //cell4.innerHTML = "<button id="+"btn-remove "+"onclick="+"deleteRow("+i+")"+">Delete</button>";   C1
                        //aaaaaaaaacell3.innerHTML = '<td><a class="btn icon-btn btn-delete"><span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span> Delete</a></td>';   //C2
                        cell4.innerHTML = '<td class="text-center" style="width:25px">\n' +
                            '                        <a data-toggle="modal" onclick="deleteFile(' + res.fileId + ')" data-target="#delete-popup-folder" class="btn icon-btn" id="' + res.fileId + '">\n' +
                            '                            <i class="fa fa-trash-o cl-force" aria-hidden="true"></i>\n' +
                            '                        </a>\n' +
                            '                        \n' +
                            '                    </td>';
                    }
                }
                addFileToFronend();
                $("#closess").click();
//                    colsePopup();
                window.alert("Upload file success!");

                /*Add file to fronend*/

            },
            error: function (response) {
                $("#closess").click();
//                    colsePopup();
                window.alert("Something wrong!!!");

            }
        };

        $(this).ajaxSubmit(options);
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

    function copyToClipboard(element) {
        var $temp = $("<input>");
        $("body").append($temp);
        $temp.val($(element).text()).select();
        document.execCommand("copy");
        $temp.remove();
    }


</script>

<script src="${contextPath}/resources/js/app.js"></script>
</body>
</html>
