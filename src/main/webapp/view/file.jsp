<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File info</title>
</head>
<body>
<section>
    <jsp:useBean id="file" scope="request" type="org.mmyroshnychenko.model.File"/>
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