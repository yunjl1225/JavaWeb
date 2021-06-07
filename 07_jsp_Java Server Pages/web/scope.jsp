<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/11
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp的内置对象</title>
</head>
<body>
<%--四个域对象分别是：
    pageContext (PageContextImpl 类) 当前 jsp 页面范围内有效
    request (HttpServletRequest 类)、 一次请求内有效
    session (HttpSession 类)、 一个会话范围内有效（打开浏览器访问服务器，直到关闭浏览器）
    application (ServletContext 类) 整个 web 工程范围内都有效（只要 web 工程不停止，数据都在）
四个域在使用的时候，优先顺序分别是，他们从小到大的范围的顺序。
 pageContext ====>>> request ====>>> session ====>>> application
--%>
<h1>scope.jsp页面</h1>
<%
  // 往四个域中都分别保存了数据
  pageContext.setAttribute("key", "pageContext");
  request.setAttribute("key", "request");
  session.setAttribute("key", "session");
  application.setAttribute("key", "application");
%>
pageContext域是否有值：<%=pageContext.getAttribute("key")%> <br>
request域是否有值：    <%=request.getAttribute("key")%> <br>
session域是否有值：    <%=session.getAttribute("key")%> <br>
application域是否有值：<%=application.getAttribute("key")%> <br>
<%
         /*request.getRequestDispatcher("/scope2.jsp").forward(request,response);*/
%>
<%--
    <jsp:forward page=""></jsp:forward> 是请求转发标签，它的功能就是请求转发
        page 属性设置请求转发的路径
--%>
<jsp:forward page="/scope2.jsp"></jsp:forward>


</body>
</html>
