<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 03.02.2019
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Added</title>
</head>
<body>
    <p><%= "Użytkownik " + request.getParameter("firstName") + " " + request.getParameter("lastName")%></p>
    <a href="users">Lista użytkowników.</a>
</body>
</html>
