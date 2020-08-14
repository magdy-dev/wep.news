<%--
  Created by IntelliJ IDEA.
  User: magdy marko
  Date: 8/11/2020
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegisterPage</title>
    <link rel="stylesheet" href="jsp/css/registerStyle.css">
</head>
<body>


<form action="${pageContext.request.contextPath}/news" method="post">
    <input type="text" name="command" hidden value="Create_User"/><br>
      <input type="text" class="input" name="name" placeholder="name"/><br>
      <input type="text" class="input" name="lastName" placeholder="last name"/><br>
      <input type="text" class="input" name="login" placeholder="login"/><br>
      <input type="password" class="input" name="password" placeholder="password"/><br>
    <input type="submit" name="register" value="Register">

</form>
</body>
</html>
