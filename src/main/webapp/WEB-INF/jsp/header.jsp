<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <c:if test="${not empty sessionScope.user}">
        <form action="/logout" method="POST">
            <button type="submit">Logout</button>
        </form>
    </c:if>
</div>