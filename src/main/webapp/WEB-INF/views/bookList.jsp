<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table border="1">
        <tr>
            <th>Title</th>
            <th>Rating</th>
            <th>Description</th>
            <th>Publisher</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.rating}</td>
                <td>${book.description}</td>
                <td>${book.publisher.name}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
