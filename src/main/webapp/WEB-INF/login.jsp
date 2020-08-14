<%--
  Created by IntelliJ IDEA.
  User: magdy marko
  Date: 8/13/2020
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/news" method="post">

<input type="text" name="email" placeholder="Email.com"/>
<br>
<input type="password" name="password" placeholder="password"/>
</form>
</body>
</html>
