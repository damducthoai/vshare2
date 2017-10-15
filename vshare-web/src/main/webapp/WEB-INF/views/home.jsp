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

<html>
<head>
    <title>My Vshare</title>

    <%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/js/bootstrap.min.js" rel="stylesheet">
--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
<div id="tool-box">
    <h4>Add new folder</h4>

    <!--<table id="folder-table">
            <tr>
                <td>name</td>
                <td><input type="text" id="folder-name"></td>
            </tr>
            <tr>
                <td>type</td>
                <td><input type="email" id="folder-type"></td>
            </tr>
            <tr>
                <td>note</td>
                <td><input type="text" id="folder-size"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button id="btn-add" onclick="addFolder()">add new</button>

                </td>
            </tr>
        </table>-->
    <td>
        <button id="btn-add" data-toggle="modal" data-target="#add-folder">add new</button>

    </td>
</div>

<div id="tool-box">
    <h4>Upload File</h4>

    <table>
        <tr>
            <td></td>
            <td>
                <button id="btn-upFile" onclick="uploadFile()">Upload File</button>

            </td>
        </tr>
    </table>
</div>


<table id="folder-list">

    <tr>
        <td>name</td>
        <td>size</td>
        <td>update</td>
</table>

<hr>

<table id="file-list">
    <c:forEach var="file" items="${files}">
    <tr>
        <td>${file.fileOriginalName}</td>
        <td>${file.filePhysicalName}</td>
        <td>update</td>
        </c:forEach>
</table>
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
        <div class="modal-content">
            <div class="modal-header ">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Sign Up</h4>
            </div>
            <div class="modal-body ">
                <table id="folder-table">
                    <tr>
                        <td>name</td>
                        <td><input type="text" id="folder-name"></td>
                    </tr>
                    <tr>
                        <td>type</td>
                        <td><input type="email" id="folder-type"></td>
                    </tr>
                    <tr>
                        <td>note</td>
                        <td><input type="text" id="folder-size"></td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer mar-top-signup ">
                <button id="btnAddFolder" type="button" class="btn btn-default" data-dismiss="modal" onclick="addFolder()">add new</button>
            </div>
        </div>

    </div>
</div>

<script src="${contextPath}/resources/js/app.js"></script>
</body>
</html>
