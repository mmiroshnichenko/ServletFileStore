<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User saving error</title>
</head>
<body>
<section>
    <jsp:useBean id="user" scope="request" type="org.mmyroshnychenko.model.User"/>
    <h3>Username <jsp:getProperty name="user" property="username"/> already exists</h3>
</section>
</body>
</html>
