<%@ page import="java.util.List" %>
<%@ page import="org.mmyroshnychenko.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List users = (List) request.getAttribute("usersList"); %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<section>
    <table>
        <%
            for(int i=0; i<users.size();i++){%>
        <tr>
            <td><%= ((User)users.get(i)).getId() %></td>
            <td><%= ((User)users.get(i)).getUsername() %></td>
        </tr>
        <%}%>
    </table>
</section>
</body>
</html>