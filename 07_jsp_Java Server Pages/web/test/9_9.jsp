<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/11
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
  <style type="text/css">
    table{
      width: 700px;
    }
  </style>
</head>
<body>
<h1 align="center">九九乘法表</h1>
  <%--练习一：在 jsp 页面中输出九九乘法口诀表--%>
  <table align="center">
  <%for (int i = 1; i <= 9 ; i++) { %>
    <tr>
     <% for (int j = 1; j <= i ; j++) { %>
        <td><%=j + "*" + i + "=" + (i*j)%></td>
    <%  }%>
    </tr>
  <br/>
  <% } %>
  </table>

</body>
</html>
