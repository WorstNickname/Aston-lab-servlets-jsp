<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/registration" method="POST">
    <label for="name"> Name:
        <input type="text" name="name" id="name">
    </label><br>
    <label for="password"> Password:
        <input type="password" name="password" id="password">
    </label><br>
    <select name="role" id="role">
        <c:forEach var="role" items="${requestScope.roles}">
            <option value=${role}>${role}</option>
        </c:forEach>
    </select><br>
    <button type="submit">Send</button>
</form>
</body>
</html>
