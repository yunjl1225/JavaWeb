<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/11
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp 中的 out 输出和 response.getWriter 输出的区 别</title>
</head>
<body>
  <%
    out.write("out输出1 <br/>");
    out.write("out输出2 <br/>");

    response.getWriter().write("response输出1 <br/>");
    response.getWriter().write("response输出2 <br/>");

  %>
</body>
</html>
