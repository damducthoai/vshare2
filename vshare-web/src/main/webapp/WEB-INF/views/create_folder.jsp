<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: thoai
  Date: 10/17/2017
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form action="${contextPath}/folders" method="post" id="createFolder" modelAttribute="newFolder">
    <form:hidden path="parrentId" value="${curlFolderId}"/>
    <form:label path="name">Folder Name</form:label>
    <form:input path="name"/>
    <button>Create Folder</button>
</form:form>