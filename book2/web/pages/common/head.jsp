<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/13
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--公共的头部信息--%>

<%--http://localhost:8080/book2/  地址需要动态获取--%>
<%
  String basePath = request.getScheme()   /*获取协议*/
    + "://"
    + request.getServerName()   /*获取服务器的IP*/
    + ":"
    + request.getServerPort()   /*获取端口号*/
    + request.getContextPath()  /*获取工程路径*/
    + "/";
  pageContext.setAttribute("basePath",basePath);
%>
<%-- basePath   http://192.168.1.209:8080/book2/  --%>

<base href="<%=basePath%>">  <!-- base标签+相对路径 确定本页面的相对路径-->
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
