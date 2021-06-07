<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/16
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--分页条--%>

<%--分页条的开始--%>
<div id="page_nav">
  <%--当前页面为首页时，隐藏首页和上一页的按钮，页码大于1，才显示--%>
  <c:if test="${requestScope.page.pageNo > 1}">
    <a href="${requestScope.page.url}&pageNo=1">首页</a>
    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
  </c:if>

  <%--页码输出的开始--%>
  <c:choose>
    <%--情况1：如果总页码小于等于5的情况，页码的范围是：1-总页码--%>
    <c:when test="${ requestScope.page.pageTotal <= 5 }">
      <c:set var="begin" value="1"/>
      <c:set var="end" value="${requestScope.page.pageTotal}"/>
    </c:when>
    <%--情况2：总页码大于5的情况--%>
    <c:when test="${requestScope.page.pageTotal > 5}">
      <c:choose>
        <%--小情况1：当前页码为前面3个：1，2，3的情况，页码范围是：1-5.--%>
        <c:when test="${requestScope.page.pageNo <= 3}">
          <c:set var="begin" value="1"/>
          <c:set var="end" value="5"/>
        </c:when>
        <%--小情况2：当前页码为最后3个，8，9，10，页码范围是：总页码减4 - 总页码--%>
        <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
          <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
          <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>
        <%--小情况3：4，5，6，7，页码范围是：当前页码减2 - 当前页码加2--%>
        <c:otherwise>
          <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
          <c:set var="end" value="${requestScope.page.pageNo+2}"/>
        </c:otherwise>
      </c:choose>
    </c:when>
  </c:choose>
  <%--输出记录的值--%>
  <c:forEach begin="${begin}" end="${end}" var="i">
    <c:if test="${i == requestScope.page.pageNo}">
      【${i}】
    </c:if>
    <c:if test="${i != requestScope.page.pageNo}">
      <a href="${ requestScope.page.url }&pageNo=${i}">${i}</a>
    </c:if>
  </c:forEach>
  <%--页码输出的结束--%>

  <%--当前页面为末页时，隐藏末页和下一页的按钮，页码小于总页码，才显示--%>
  <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
  </c:if>
  共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
  到第<input value="${param.pageNo}" name="pn" id="pn_input" />页
  <input type="button" id="searchPageBtn" value="确定"/>
  <script>
    $(function () {
      //确定按钮的单击事件，跳到指定的页码
      $("#searchPageBtn").click(function () {
        //首先获取输入框中的数据
        var pageNo = $("#pn_input").val();
        //获取总页码
        var pageTotal = ${requestScope.page.pageTotal};
        //页码大于0，小于总页码才能跳转
        //已经在Page页面设置了如果输入框的页码小于1，则显示首页，如果大于总页码，则显示末页
        //所以这里不需要写if代码了
        // if(pageNo > 0 && pageNo <= pageTotal){
        //页面跳转
        // javaScript语言中提供了一个location地址栏对象
        // 它有一个属性叫href.它可以获取浏览器地址栏中的地址(通过head.jsp中的basePath动态获取)
        // href属性可读，可写
        location.href = "${pageScope.basePath}${ requestScope.page.url }&pageNo=" + pageNo;
        // }
      });
    });
  </script>

</div>
<%--分页条的结束--%>
