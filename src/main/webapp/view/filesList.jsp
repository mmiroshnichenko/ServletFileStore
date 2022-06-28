<%@ page import="java.util.List" %>
<%@ page import="org.mmyroshnychenko.model.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List files = (List) request.getAttribute("filesList"); %>
<html>
<head>
    <title>Files list</title>
</head>
<body>
<section>
    <table>
        <%
            for(int i=0; i<files.size();i++){%>
        <tr>
            <td><%= ((File)files.get(i)).getId() %></td>
            <td><%= ((File)files.get(i)).getName() %></td>
            <td><%= ((File)files.get(i)).getPath() %></td>
        </tr>
        <%}%>
    </table>
</section>
</body>
</html>