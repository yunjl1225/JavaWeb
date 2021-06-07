<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>

  <%--使用静态包含调用公共的头部信息 base标签、css样式、jQuery文件--%>
  <%@include file="/pages/common/head.jsp"%>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/log.gif" >
			<span class="wel_word">后台管理系统</span>

    <%--静态包含图书管理相同部分：图书管理、订单管理、返回商城--%>
    <%@include file="/pages/common/manager_menu.jsp"%>
	</div>

	<div id="main">
		<h1>欢迎管理员进入后台管理系统</h1>
	</div>


  <%--静态包含公共的页脚部分--%>
  <%@include file="/pages/common/footer.jsp"%>

</body>
</html>
