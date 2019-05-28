<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/books/add" method="post" modelAttribute="book">
    <label for="titleId">Title:</label>
    <form:input type="text" path="title" id="titleId"/>

    <br><br>

    <label for="ratingId">Rating:</label>
    <form:input type="number" path="rating" id="ratingId"/>

    <br><br>

    <label for="descriptionId">Description:</label>
    <form:textarea rows="3" cols="60" path="description" id="descriptionId"/>

    <br><br>

    <label for="publisherId">Publisher:</label>
    <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" id="publisherId"/>

    <br><br>

    <input type="submit" value="Send">
</form:form>
</body>
</html>
