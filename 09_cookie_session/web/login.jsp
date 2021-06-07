<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/17
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>免用户名登录（一次登录后保存用户名）</title>
</head>
<body>
<form method="get" action="http://localhost:8080/09_cookie_session/loginServlet">
  用户名：<input type="text" name="username" value="${cookie.username.value}"><br/>
  密  码：<input type="text" name="password" value="${cookie.password.value}"><br/>
  <input type="submit" value="登录"/>

</form>

</body>
</html>
