<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <form:hidden path="proposition"/>

    <label for="titleId">Title:</label>
    <form:input type="text" path="title" id="titleId"/>
    <form:errors path="title" element="div"/>

    <br><br>

    <label for="pagesId">Pages:</label>
    <form:input type="number" path="pages" id="pagesId"/>
    <form:errors path="pages" element="div"/>

    <br><br>

    <label for="ratingId">Rating:</label>
    <form:input type="number" path="rating" id="ratingId"/>
    <form:errors path="rating" element="div"/>

    <br><br>

    <label for="descriptionId">Description:</label>
    <form:textarea rows="3" cols="60" path="description" id="descriptionId"/>
    <form:errors path="description" element="div"/>

    <br><br>

    <label for="publisherId">Publisher:</label>
    <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" id="publisherId"/>
    <form:errors path="publisher" element="div"/>

    <br><br>

    <label for="authorId">Authors:</label>
    <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id" id="authorId"/>
    <form:errors path="authors" element="div"/>

    <br><br>

    <label for="categoryId">Category:</label>
    <form:select path="category.id" items="${categories}" itemLabel="name" itemValue="id" id="categoryId"/>

    <br><br>

    <input type="submit" value="Send">
</form:form>
</body>
</html>
