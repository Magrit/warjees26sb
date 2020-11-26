<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="animal">
    <h3><form:errors path="*" /></h3>
    <form:input path="name" /><br/>
    <form:errors path="name" cssClass="error" element="p"/><br/>
    <input type="submit"/>
</form:form>
</body>
</html>
