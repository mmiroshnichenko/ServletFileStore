<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User info</title>
</head>
<body>
<section>
    <jsp:useBean id="user" scope="request" type="org.mmyroshnychenko.model.User"/>
    <table>
        <tr>
            <tb>Id:</tb>
            <td><jsp:getProperty name="user" property="id"/></td>
        </tr>
        <tr>
            <td>Username:</td>
            <td><jsp:getProperty name="user" property="username"/></td>
        </tr>
    </table>
</section>
</body>
</html>
