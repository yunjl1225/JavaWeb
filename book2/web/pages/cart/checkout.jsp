<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>

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
			<span class="wel_word">结算</span>
    <%--使用静态包含公共部分--%>
    <%@ include file="/pages/common/login_sucess_menu.jsp"%>
	</div>

	<div id="main">

		<h1>你的订单已结算，订单号为：${sessionScope.orderId}</h1>


	</div>


  <%--静态包含公共的页脚部分--%>
  <%@include file="/pages/common/footer.jsp"%>

</body>
</html>
