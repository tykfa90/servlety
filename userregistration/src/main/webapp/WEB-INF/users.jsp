<%@ page import="pl.sda.UserDTO" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 03.02.2019
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
    <style>
        body {
            background-color: powderblue;
        }

        h1 {
            color: red;
        }

        p {
            color: blue;
        }

        td {
            border: solid black 2px;
            border-radius: 5px
        }

    </style>
</head>
<body>
<%@include file="header.html"%>

<table>
    <tr>
        <td>First name</td>
        <td>Last name</td>
        <td>Address</td>
        <td>Action</td>
    </tr>
    <% for (UserDTO userDTO : (Collection<UserDTO>) request.getAttribute("users")) { %>
    <tr>
        <td><%= userDTO.getFirstName()%>
        </td>
        <td><%= userDTO.getLastName()%>
        </td>
        <td><%= userDTO.getAddressDTO()%>
        </td>
        <td>
            <a href="userProfile?userId=<%=userDTO.getId()%>">Show user</a>
            <a href="userProfileEdit?userId=<%=userDTO.getId()%>">Edit user</a>
        </td>
    </tr>
    <br>

    <% } %>
</table>
</body>
</html>
