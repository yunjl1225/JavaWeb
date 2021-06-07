<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/11
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动态包含</title>
</head>
<body>
    头部信息<br/>
    主体内容<br/>

    <%--动态包含
        <jsp:include page="  "></jsp:include>
        page属性指定需要包含的jsp页面的路径
        动态包含也可以像静态包含一样。把被包含的内容执行输出到包含位置

     动态包含的特点：
        1、动态包含会把被包含的 jsp 页面也翻译成为 java 代码
        2、动态包含底层代码使用如下代码去调用被包含的 jsp 页面执行输出。 J
          spRuntimeLibrary.include(request, response, "/include/footer.jsp", out, false);
        3、动态包含，还可以传递参数
    --%>
    <jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>
