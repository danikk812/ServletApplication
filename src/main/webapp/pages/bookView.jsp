
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <h5>Name: ${requestScope.book.name}</h5>
    <h5>Description: ${requestScope.book.description}</h5>
    <h5>Price: ${requestScope.book.price}</h5>
    <form action="/basket/add" method="post">
        <input type="hidden" name="id" value="${requestScope.book.id}">
        <button class="btn btn-primary" type="submit">Add</button>
    </form>
    <c:if test="${sessionScope.user == null}">
        <p style="color: red">You must be authorized to add books</p>
    </c:if>
</div>
</body>
</html>
