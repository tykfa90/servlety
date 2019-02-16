<%@ page import="pl.sda.UserDTO" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 03.02.2019
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
<%@include file="header.html"%>
<tr>
    <td>Imię: <jsp:getProperty name="user" property="firstName"/></td>
    <td>Nazwisko: <jsp:getProperty name="user" property="lastName"/></td>
    <td>
        Adres: <jsp:getProperty name="user" property="addressDTO" />
    </td>
</tr>
</body>
</html>
