<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row row-cols-1 row-cols-md-3">
        <c:forEach items="${requestScope.books}" var="book">
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${book.name}</h5>
                        <p class="card-text">${book.description}</p>
                        <a href="/book/view?id=${book.id}" class="btn btn-primary">See</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
