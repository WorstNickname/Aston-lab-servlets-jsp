<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<h1><%= "Home page" %></h1>
<br/>
<br/>

<a href="${pageContext.request.contextPath}/login">Login</a>
<br/>
<a href="${pageContext.request.contextPath}/userPage">User page</a>
<br/>
<a href="${pageContext.request.contextPath}/adminPage">Admin page</a>
</body>
</html>