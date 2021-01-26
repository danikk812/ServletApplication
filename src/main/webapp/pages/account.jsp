
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <h3>Account</h3>
    <h4>Name: ${sessionScope.user.name}</h4>
    <br>
    <h4>Basket:</h4>
    <ul>
        <c:forEach items="${sessionScope.basket.getAll()}" var="book">
            <li>${book.name}
                <form action="/basket/delete" method="post">
                    <input type="hidden" name="id" value="${book.id}">
                    <button class="btn btn-primary" type="submit">Delete</button>
                </form>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
