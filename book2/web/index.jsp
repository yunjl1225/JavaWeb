<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
本页面只用于请求转发

web/index.jsp  --请求转发-->  ClientBookServlet(处理分页)  --保存数据并转发-->  web/pages/client/index.jsp(用于显示带数据首页)
--%>
<%--请求转发--%>
<jsp:forward page="client/clientBookServlet?action=page" ></jsp:forward>
