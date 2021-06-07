<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/13
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--图书管理中相同的部分--%>
<div>
  <a href="manager/bookServlet?action=page">图书管理</a> <%--通过BookServlet程序查询数据后跳转到指定（page）分页的jsp页面--%>
  <a href="pages/manager/order_manager.jsp">订单管理</a>
  <a href="index.jsp">返回商城</a>
</div>
