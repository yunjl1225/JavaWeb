<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>

  <%--使用静态包含调用公共的头部信息 base标签、css样式、jQuery文件--%>
  <%@include file="/pages/common/head.jsp"%>

</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/log.gif" >
			<span class="wel_word">购物车</span>
    <%--使用静态包含公共部分--%>
    <%@ include file="/pages/common/login_sucess_menu.jsp"%>

    <script type="text/javascript">
      /*页面加载完成后*/
      $(function () {
        <%--给删除按钮添加点击事件--%>
        $("a.deleteItem").click(function () {
          //获取a标签的父类的父类的td标签的第一个元素（entry.value.name）的文本数据
          return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗？");
        });

        <%--给清空购物车按钮添加点击事件--%>
        $("a.clearCart").click(function () {
          return confirm("你确定要清空购物车吗？");
        });

        //给数量输入框添加失去焦点事件blur()  ----  change()可以判断内容是否发生变化，未变化不调用
        $(".updateCount").change(function () {
          // 获取商品名称
          var name = $(this).parent().parent().find("td:first").text();
          //获取商品的编号
          var id = $(this).attr('bookId');
          // 获取商品数量
          var count = this.value;
          if ( confirm("你确定要将【" + name + "】商品修改数量为：" + count + " 吗?") ) {
            //发起请求。给服务器保存修改
            location.href = "http://localhost:8080/book2/cartServlet?action=updateCount&count="+count+"&id="+id;
          } else {
            // defaultValue属性是表单项Dom对象的属性。它表示默认的value属性值。
            this.value = this.defaultValue;
          }
        });

      });
    </script>

	</div>

	<div id="main">

		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
      <%--遍历购物车中的商品项--%>
      <c:forEach items="${sessionScope.cart.items}" var="entry">
        <tr>
          <td>${entry.value.name}</td>
          <td>
            <input  class="updateCount" style="width: 40px"
                    bookId = "${entry.value.id}"    <%--记录商品的编号--%>
                    type="text" value="${entry.value.count}">
          </td>
          <td>${entry.value.price}</td>
          <td>${entry.value.totalPrice}</td>
          <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
        </tr>
      </c:forEach>

      <%--当购物车为空时--%>
      <c:if test="${empty sessionScope.cart.items}">
        <tr >
          <td colspan="5"><a href="index.jsp">亲，当前购物车为空！快跟小伙伴们去浏览商品吧！！！</a> </td>
        </tr>
      </c:if>
    </table>
    <%--当购物车里有商品项时，下面的选项按钮才显示--%>
    <c:if test="${not empty sessionScope.cart.items}">
      <div class="cart_info">
        <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
        <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
        <span class="cart_span"><a class="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
        <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
      </div>
    </c:if>

	</div>

  <%--静态包含公共的页脚部分--%>
  <%@include file="/pages/common/footer.jsp"%>

</body>
</html>
