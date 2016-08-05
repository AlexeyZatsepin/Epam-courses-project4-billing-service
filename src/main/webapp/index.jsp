<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="./styles/main.css" rel="stylesheet" type="text/css">
    <title>Welcome</title>
</head>
<body>
<div class="login-page">
    <div class="form">
        <form method="POST" action="Controller" class="login-form">
            <input type="text" name="email" placeholder="email">
            <input type="password" name="password" placeholder="password">
            <input type="hidden" name="command" value="LOG_IN"/>
            <button type="submit" name="command" value="login">login</button>
            <p class="message"><c:out value="${message}"/></p>
        </form>
    </div>
</div>

</body>
</html>