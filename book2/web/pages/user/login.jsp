<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员登录页面</title>

  <%--使用静态包含调用公共的头部信息 base标签、css样式、jQuery文件--%>
  <%@include file="/pages/common/head.jsp"%>

</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/log.gif" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>会员</h1>
								<a href="/book2/pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">
                  <%-- 输出错误提示信息   刚进去时域对象中没有数据，为null，输出“请输入用户名和密码”--%>
                  <%-- 表达式脚本  <%=request.getAttribute("msg") == null? "请输入用户名和密码":request.getAttribute("msg")%>--%>
                  <%--EL表达式--%> ${ empty requestScope.msg ?"请输入用户名和密码" :requestScope.msg}
                </span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
                  <input type="hidden" name="action" value="login">     <%--添加隐藏域--%>

									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"
                         <%--登录错误是回显信息--%>
                         <%--表达式脚本  value="<%=request.getAttribute("username") == null ? "":request.getAttribute("username")%>" />  --%>
                         value="${requestScope.username}"/><%--EL表达式--%>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>

    <%--静态包含公共的页脚部分--%>
    <%@include file="/pages/common/footer.jsp"%>

</body>
</html>
