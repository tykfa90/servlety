<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 02.02.2019
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New User Account</title>
</head>
<body>
<%@include file="header.html"%>

    <form method="post">
        <label for="firstName">First Name: </label>
        <input type="text" id="firstName" name="firstName">
        <br/>
        <label for="lastName">Last Name: </label>
        <input type="text" id="lastName" name="lastName">
        <br/>
        <label for="city"> City: </label>
        <input type="text" id="city" name="city">
        <br/>
        <label for="street">Street: </label>
        <input type="text" id="street" name="street">
        <br/>
        <label for="houseNo">House No: </label>
        <input type="text" id="houseNo" name="houseNo">
        <br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
