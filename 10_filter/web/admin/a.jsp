<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/18
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
      <%
        System.out.println("a.jsp执行了");
      Object user = session.getAttribute("user");
      //如果等于null，说明没有登录
        if(user == null){
          //请求转发到登录界面
          request.getRequestDispatcher("/login.jsp").forward(request,response);
          return;
        }
      %>
  我是a.jsp文件
</body>
</html>
