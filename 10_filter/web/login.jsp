<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/18
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
这是登录界面<br/>
<form action="http://localhost:8080/10_filter/loginServlet" method="get">
  用户名<input type="text" name="username" />
  密码<input type="text" name="password" />
  <input type="submit" value="登录">

</form>
</body>
</html>
