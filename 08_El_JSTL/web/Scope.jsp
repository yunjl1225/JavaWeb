<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/12
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取域数据的对象</title>
</head>
<body>
首先往域对象中存入数据<br/>
    <%
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","Request");
        session.setAttribute("key","Session");
        application.setAttribute("key","ServletContext");

    %>
pageScope ====== pageContext 域<br/>
  ${pageScope.key}
  <br/><br/>

requestScope ====== Request 域<br/>
  ${requestScope.key}
  <br/><br/>

sessionScope ====== Session 域<br/>
  ${sessionScope.key}
  <br/><br/>

applicationScope ====== ServletContext  域<br/>
  ${applicationScope.key}
</body>
</html>
