<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Admin page</h1>
<h2>User list:</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>role</th>
    </tr>
    <c:forEach var="user" items="${requestScope.users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
