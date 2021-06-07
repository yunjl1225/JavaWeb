<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/12
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL获取域数据的顺序</title>
</head>
<body>

  <% //往四个域中都保存了相同的 key 的数据。
    request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
    pageContext.setAttribute("key", "pageContext");
  %>
  <%--当四个域中都有相同的 key 的数据的时候，
  EL 表达式会按照四个域的从小到大的顺序去进行搜索，找到就输出。
  与代码的先后顺序无关
    pageContext ====>>> request ====>>> session ====>>> application
  --%>
${ key }

</body>
</html>
