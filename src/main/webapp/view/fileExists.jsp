<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File saving error</title>
</head>
<body>
<section>
    <jsp:useBean id="file" scope="request" type="org.mmyroshnychenko.model.File"/>
    <h3>File <jsp:getProperty name="file" property="name"/> already exists</h3>
</section>
</body>
</html>
