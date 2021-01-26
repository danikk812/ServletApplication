<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All users</title>
</head>
<body>

<jsp:include page="_header.jsp"/>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.users}" var="user">
            <tr>
            <th scope="row">${user.id}</th>
                <td>${user.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
