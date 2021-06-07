<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/11
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>静态包含</title>      <%--一个完整的页面--%>
</head>
<body>
    头部信息<br/>
    主体内容<br/>

   <%--
    页脚信息<br/>

    每个页面都含有相同的页脚信息，
    所以可以使用静态包含
        <%@include file="  "%>
        file属性指定需要包含的jsp页面的路径
        路径中的第一个   /   表示 http:://ip:port/工程路径/    映射到代码的web目录

    静态包含的特点：
        1、静态包含不会翻译被包含的 jsp 页面。
        2、静态包含其实是把被包含的 jsp 页面的代码拷贝到包含的位置执行输出。
    --%>
    <%@include file="/include/footer.jsp"%>
</body>
</html>
