<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>

  <%--使用静态包含调用公共的头部信息 base标签、css样式、jQuery文件--%>
  <%@include file="/pages/common/head.jsp"%>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}

	h1 a {
		color:red;
	}

	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/log.gif" >
			<span class="wel_word">编辑图书</span>

      <%--静态包含图书管理相同部分：图书管理、订单管理、返回商城--%>
      <%@include file="/pages/common/manager_menu.jsp"%>

		</div>

		<div id="main">
			<form action="manager/bookServlet" method="post">
        <input type="hidden" name="pageNo" value="${param.pageNo}">
        <%--添加隐藏域，方便后面程序判断调用方法--%>
        <%--<input type="hidden" name="action" value="add"/>--%>
          <%--此页面处理添加和修改两个功能，需要动态设置隐藏域--%>
             <%--解决方法一:请求发起时，附带需要的功能，并注入隐藏域中
                          修改和添加按钮属性中添加 &method=update 和 &method=add
                          --%>
             <%--<input type="hidden" name="action" value="${param.method}"/>--%>

            <%--解决方法二：可以根据请求中是否有ID数据来判断,有ID数据的为修改，没有的为添加
                            ${empty param.id ? "add" : "update"}
                            --%>
            <input type="hidden" name="action" value="${empty param.id ? "add" : "update"}"/>
            <%--修改操作需要ID定位到哪本图书，所以发送个ID的数据--%>
            <input type="hidden" name="id" value="${requestScope.book.id}"/>


          <table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>
					<tr>
						<td><input name="name" type="text" value="${requestScope.book.name}"/></td>
						<td><input name="price" type="text" value="${requestScope.book.price}"/></td>
						<td><input name="author" type="text" value="${requestScope.book.author}"/></td>
						<td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
						<td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>
				</table>
			</form>


		</div>


    <%--静态包含公共的页脚部分--%>
    <%@include file="/pages/common/footer.jsp"%>

</body>
</html>
