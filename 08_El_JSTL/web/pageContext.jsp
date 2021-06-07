<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/12
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext隐含对象</title>
</head>
<body>
pageContext 对象的使用<br/>
  1. 协议： <br/>
    <%--
    request.getScheme()可以获取请求的协议
    使用jsp获取协议
    --%>
    <%=request.getScheme()%><br/>
    <%--
    使用EL表达式获取协议
    EL会自动找get方法即getScheme()
    --%>
    ${pageContext.request.scheme}<br/>

  2. 服务器 ip：<br/>
    <%=request.getServerName()%><br/>
    ${pageContext.request.serverName}<br/>

  3. 服务器端口：<br/>
    <%=request.getServerPort()%><br/>
    ${pageContext.request.serverPort}<br/>

  4. 获取工程路径：<br/>
    <%=request.getContextPath()%><br/>
    ${pageContext.request.contextPath}<br/>

  5. 获取请求方法：<br/>
    <%=request.getMethod()%><br/>
    ${pageContext.request.method}<br/>

  6. 获取客户端 ip 地址：<br/>
    <%=request.getRemoteHost()%><br/>
    ${pageContext.request.remoteHost}<br/>

  7. 获取会话的 id 编号：<br/>
    <%=session.getId()%><br/>
    ${pageContext.session.id}<br/>

使用域对象封装request对象,是代码更简洁<br/>
  <%
  pageContext.setAttribute("req",request);
  %>
获取请求方法：<br/>
  ${req.method}

</body>
</html>
