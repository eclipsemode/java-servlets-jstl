<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.util.Map" %>
<%@ page import="ru.daniel.servlets.model.Account" %><%--
  Created by IntelliJ IDEA.
  User: eclip
  Date: 06.09.2024
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h2>All users:</h2>
<table>
    <tr>
        <td>Account name</td>
        <td>Balance</td>
    </tr>
    <c:forEach items="${requestScope.accounts}" var="account">
        <tr>
            <td>${account.name}</td>
            <td>${account.balance}</td>
        </tr>
    </c:forEach>
</table>

<h2 style="color: brown">Создание нового пользователя</h2>
<form method="post" style="display: flex; flex-direction: column; row-gap: 10px">
    <input type="text" name="name" placeholder="Account name" minlength="5" maxlength="20" />
    <input type="password" name="password" placeholder="Account password" minlength="5" />
    <input type="number" name="balance" placeholder="Account balance" min="0" step="0.001" />
    <input type="submit" value="Create">
    <c:if test="${requestScope.userExistsError}" var="true">
        <p style="color: darkred">This user is already exists</p>
    </c:if>
    <c:if test="${requestScope.emptyField}" var="true">
        <p style="color: darkred">Fields cannot be empty</p>
    </c:if>
</form>
</body>
</html>
