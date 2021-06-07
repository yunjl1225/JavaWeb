<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>

  <%--使用静态包含调用公共的头部信息 base标签、css样式、jQuery文件--%>
  <%@include file="/pages/common/head.jsp"%>
  <script type="text/javascript">

    //页面接在完成之后的代码
    $(function () {
      //给删除的a标签点击事件，按钮添加确认提示信息
        $("a.deleteClass").click(function () {
          // 在事件的function函数中，有一个this对象。这个this对象，是当前正在响应事件的dom对象。
          /**
           * confirm()是确认提示框函数
           * 参数是他的提示内容
           * 他有两个按钮，一个是确认一个是取消
           * 返回true表示点击确认，返回false表示点击取消
           */
         /* return false 表示阻止元素的默认行为===不提交
            return true 表示提交*/
          // $(this).parent().parent().find("td:first").text()  表示a标签的父类(td)的父类(tr)的第一行td数据
          return confirm("是否确定删除【" + $(this).parent().parent().find("td:first").text() + "】？")

        })
    });
  </script>

</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/log.gif" >
			<span class="wel_word">图书管理系统</span>

    <%--静态包含图书管理相同部分：图书管理、订单管理、返回商城--%>
    <%@include file="/pages/common/manager_menu.jsp"%>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
      <%--遍历输出域中的数据--%>
      <c:forEach items="${requestScope.page.items}"  var="book">
        <tr>
          <td>${book.name}</td>
          <td>${book.price}</td>
          <td>${book.author}</td>
          <td>${book.sales}</td>
          <td>${book.stock}</td>
          <td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
          <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
        </tr>
      </c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>
		</table>
    <%--静态包含分页条--%>
    <%@include file="/pages/common/page_nav.jsp"%>

  </div>


  <%--静态包含公共的页脚部分--%>
  <%@include file="/pages/common/footer.jsp"%>

</body>
</html>
