<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Input user</h2>
<form method="post" action="<c:url value='/'/>">
    <label><input type="text" name="name"></label></br>
    <input type="submit" value="проверить"><br>
</form>

<h1><c:out value="${userFind}"/></h1>
</body>
</html>
