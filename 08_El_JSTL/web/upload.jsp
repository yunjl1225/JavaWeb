<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/13
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<%--1、要有一个 form 标签，method=post 请求 --%>
<%--2、form 标签的 encType 属性值必须为 multipart/form-data 值 --%>
  <form action="http://192.168.1.209:8080/08_EL_JSTL/uploadServlet" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"/><br/>
<%--3、在 form 标签中使用 input type=file 添加上传的文件--%>
    头像：<input type="file" name="photo" ><br/>
    <input type="submit" value="提交">
  </form>
<%--4、编写服务器代码（Servlet 程序）接收，处理上传的数据。--%>

</body>
</html>
