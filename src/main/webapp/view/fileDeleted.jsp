<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File deleted</title>
</head>
<body>
<section>
    <jsp:useBean id="file" scope="request" type="org.mmyroshnychenko.model.File"/>
    <h3>File <b><jsp:getProperty name="file" property="name"/></b> has been deleted!</h3>
    <table>
        <tr>
            <tb>Id:</tb>
            <td><jsp:getProperty name="file" property="id"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><jsp:getProperty name="file" property="name"/></td>
        </tr>
        <tr>
            <td>Path:</td>
            <td><jsp:getProperty name="file" property="path"/></td>
        </tr>
    </table>
</section>
</body>
</html>