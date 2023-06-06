<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="POST">
    <label for="name"> Name:
        <input type="text" name="name" id="name" value="${param.name}" required>
    </label><br>
    <label for="password"> Password:
        <input type="password" name="password" id="password" required>
    </label><br>
    <button type="submit">Sign in</button>

    <c:if test="${param.error != null}">
        <div>
            <span style="color: red">
                Email or password is not correct
            </span>
        </div>
    </c:if>

</form>
</body>
</html>
