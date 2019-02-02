<%@ page import="java.time.LocalDateTime" %>
<%@ page import="pl.sda.Counter" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 02.02.2019
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
    <p><% out.print("Licznik odwiedzin: " + Counter.INSTANCE.getCount()); %></p>
</body>
</html>
