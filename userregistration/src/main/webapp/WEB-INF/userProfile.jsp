<%--@elvariable id="userDTO" type="pl.sda.UserDTO"--%>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 03.02.2019
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
<%@include file="header.html"%>

<tr>
    <td>Imię: ${userDTO.firstName}</td>
    <td>Nazwisko: ${userDTO.lastName}</td>
    <td>
        Adres: ${userDTO.addressDTO.city}, ${userDTO.addressDTO.street} ${userDTO.addressDTO.houseNo}
    </td>
</tr>
</body>
</html>
