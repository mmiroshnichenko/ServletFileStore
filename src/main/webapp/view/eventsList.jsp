<%@ page import="java.util.List" %>
<%@ page import="org.mmyroshnychenko.model.Event" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List events = (List) request.getAttribute("eventsList"); %>
<html>
<head>
    <title>Events list</title>
</head>
<body>
<section>
    <table>
        <%
            for(int i=0; i<events.size();i++){%>
        <tr>
            <td><%= ((Event)events.get(i)).getId() %></td>
            <td><%= ((Event)events.get(i)).getFile().getName() %></td>
            <td><%= ((Event)events.get(i)).getFile().getPath() %></td>
            <td><%= ((Event)events.get(i)).getUser().getUsername() %></td>
            <td><%= ((Event)events.get(i)).getCreated() %></td>
            <td><%= ((Event)events.get(i)).getType().toString() %></td>
        </tr>
        <%}%>
    </table>
</section>
</body>
</html>