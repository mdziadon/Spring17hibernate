<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>

<%@include file="header.jspf" %>

<div class="container">

    <header>Add book</header>

    <div class="card">
        <div class="card-body">
            <a href="/books/list" class="btn btn-primary">Back</a>
        </div>
    </div>

    <div class="card mt-4">

        <div class="card-header">
            Book data
        </div>

        <div class="card-body">

            <form:form method="post" modelAttribute="book">
                <form:hidden path="proposition"/>

                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="titleId">Title:</label>
                        <form:input type="text" path="title" id="titleId" class="form-control"/>
                        <form:errors path="title" element="div" cssClass="error"/>
                    </div>

                    <div class="form-group col-md-3">
                        <label for="pagesId">Pages:</label>
                        <form:input type="number" path="pages" id="pagesId" class="form-control"/>
                        <form:errors path="pages" element="div" cssClass="error"/>
                    </div>

                    <div class="form-group col-md-3">
                        <label for="ratingId">Rating:</label>
                        <form:input type="number" path="rating" id="ratingId" class="form-control"/>
                        <form:errors path="rating" element="div" cssClass="error"/>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="categoryId">Category:</label>
                        <form:select path="category.id" items="${categories}" itemLabel="name" itemValue="id" id="categoryId" class="form-control"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="publisherId">Publisher:</label>
                        <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" id="publisherId" class="form-control"/>
                        <form:errors path="publisher" element="div" cssClass="error"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="authorId">Authors:</label>
                        <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id" id="authorId" class="form-control"/>
                        <form:errors path="authors" element="div" cssClass="error"/>
                    </div>

                </div>

                <div class="form-group">
                    <label for="descriptionId">Description:</label>
                    <form:textarea rows="3" cols="60" path="description" id="descriptionId" class="form-control"/>
                    <form:errors path="description" element="div" cssClass="error"/>
                </div>

                <input type="submit" value="Send" class="btn btn-primary">
            </form:form>

        </div>
    </div>

</div>
</body>
</html>
