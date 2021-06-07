<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/18
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  System.out.println("target页面执行了");
  System.out.println("target.jsp的线程" + Thread.currentThread().getName());
 /* Filter1 前置代码
  Filter2 前置代码
  target页面执行了
  Filter2 后置代码
  Filter1 后置代码*/
%>
</body>
</html>
