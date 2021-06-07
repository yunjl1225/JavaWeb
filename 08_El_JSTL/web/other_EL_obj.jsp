<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/12
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>其他EL隐含对象</title>
</head>
<body>
param  它可以获取请求参数的值 <br/>
在浏览器地址栏中存入数据：http://localhost:8080/08_EL_JSTL/other_EL_obj.jsp?username=yun&password=122500<br/>
  输出请求参数 username 的值：${ param.username } <br>
  输出请求参数 password 的值：${ param.password } <br><br>

paramValues 它也可以获取请求参数的值，获取多个值的时候使用。  <br/>
  输出请求参数 username 的第一个值：${ paramValues.username[0] } <br>
  输出请求参数 hobby 的第一个值：${ paramValues.hobby[0] } <br>
  输出请求参数 hobby 的第二个值：${ paramValues.hobby[1] } <br><hr>

header 它可以获取请求头的信息 <br/>
  输出请求头【User-Agent】的值：${ header['User-Agent'] } <br>
  输出请求头【Connection】的值：${ header.Connection } <br><br>

headerValues 它可以获取请求头的信息，它可以获取多个值的情况 <br/>
  输出请求头【User-Agent】的值：${ headerValues['User-Agent'][0] } <br><hr>

cookie  它可以获取当前请求的 Cookie 信息 <br/>
  获取 Cookie 的名称：${ cookie.JSESSIONID.name } <br>
  获取 Cookie 的值：${ cookie.JSESSIONID.value } <br><hr>

initParam  它可以获取在 web.xml 中配置的&lt;Context-param&gt;上下文参数 <br/>
输出&lt;Context-param&gt;username 的值：${ initParam.username } <br>
输出&lt;Context-param&gt;url 的值：${ initParam.url } <br>
</body>
</html>
