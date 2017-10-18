<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: thoai
  Date: 10/17/2017
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form action="${contextPath}/upload" method="post" enctype="multipart/form-data" modelAttribute="file"
           id="uploadFile">
    <input type="hidden" value="${curlFolderId}" name="folderId"/>
    <input type="file" name="file" id="file"/>
    <button>Upload File</button>
</form:form>
