<%@ page import="com.yun.pojo.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/11
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>使用请求转发的方法显示学生信息</title>
  <style>
    table{
      border: 1px blue solid;
      width: 600px;
      border-collapse: collapse;
    }
    td,th{
      border: 1px blue solid;
    }
  </style>
</head>
<body>
<%--练习二：jsp输出一个表格，里面有10个学生信息。--%>
<%
  //从request域中获取学生信息
  List<Student> studentList = (List<Student>) request.getAttribute("stuList");
%>
<table>
  <tr>
    <td>编号</td>
    <td>姓名</td>
    <td>年龄</td>
    <td>电话</td>
    <td>操作</td>
  </tr>
  <% for (Student student : studentList) { %>
  <tr>
    <td><%=student.getId()%></td>
    <td><%=student.getName()%></td>
    <td><%=student.getAge()%></td>
    <td><%=student.getPhone()%></td>
    <td>删除、修改</td>
  </tr>
  <% } %>
</table>

</body>
</html>
