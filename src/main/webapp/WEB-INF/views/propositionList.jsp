<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function confirmDelete(id, title) {
            if (confirm("Do you want to delete a proposition '" + title + "'?")) {
                window.location.href = "/propositions/delete/" + id;
            }
        }
    </script>
</head>
<body>

<a href="/propositions/add">Add proposition</a>

<br><br>

<table border="1">
    <tr>
        <th>Title</th>
        <th>Rating</th>
        <th>Description</th>
        <th>Publisher</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${propositions}" var="proposition">
        <tr>
            <td>${proposition.title}</td>
            <td>${proposition.rating}</td>
            <td>${proposition.description}</td>
            <td>${proposition.publisher.name}</td>
            <td>
                <a href="/propositions/update/${proposition.id}">Edit</a>
                <a href="#" onclick="confirmDelete(${proposition.id}, '${proposition.title}')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
