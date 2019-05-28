<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="/persons/add" method="post" modelAttribute="person">
        <label for="loginId">Login:</label>
        <form:input type="text" path="login" id="loginId"/>

        <label for="passwordId">Password:</label>
        <form:password path="password" id="passwordId"/>

        <label for="emailId">Email:</label>
        <form:input type="email" path="email" id="emailId"/>

        <input type="submit" value="Send">
    </form:form>
</body>
</html>
