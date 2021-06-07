<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/13
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--欢迎韩总光临Yun书城 我的订单 注销   返回--%>
<%--在含有此公共部分的页面全部使用静态包含--%>
<div>
  <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临Yun书城</span>
  <a href="pages/order/order.jsp">我的订单</a>
  <a href="userServlet?action=loginout">注销</a>&nbsp;&nbsp;
  <a href="index.jsp">返回</a>
</div>

