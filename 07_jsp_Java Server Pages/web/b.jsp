<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/11
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Map" %>    <%--跟 java 源代码中一样。用于导包，导类。--%>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=utf-8"
         isErrorPage="true"
         language="java"
         errorPage="/error500.jsp"
    %>
<%--
i.   language 属性 表示 jsp 翻译后是什么语言文件。暂时只支持 java。
ii.  contentType 属性 表示 jsp 返回的数据类型是什么。也是源码中 response.setContentType()参数值
iii. pageEncoding 属性 表示当前 jsp 页面文件本身的字符集。
     ========================两个属性是给 out 输出流使用=============================
  v. autoFlush 属性 设置当 out 输出流缓冲区满了之后，是否自动刷新冲级区。默认值是 true。
  vi. buffer 属性 设置 out 缓冲区的大小。默认是 8kb 缓冲区溢出错误：
      ========================两个属性是给 out 输出流使用=============================
vii.errorPage 属性 设置当 jsp 页面运行时出错，自动跳转去的错误页面路径。
    这个路径一般都是以斜杠打头，它表示请求地址为http://ip:port/工程路径/
    映射到代码的Web目录
viii. isErrorPage 属性 设置当前 jsp 页面是否是错误信息页面。默认是 false。如果是 true 可以 获取异常信息。
ix.   session 属性 设置访问当前 jsp 页面，是否会创建 HttpSession 对象。默认是 true。
x.    extends 属性 设置 jsp 翻译出来的 java 类默认继承谁。
--%>


<html>
<head>
    <title>jsp的各个属性</title>
</head>
<body>
    jsp页面

<%--
      <%
      int i = 12/0;
      %>
  这是个错误，测试错误跳转页面功能
--%>

有个错误

    <%--练习：     jsp注释
    --%>

    <%--1、声明类属性--%>
    <%!
      private Integer id;
      private String name;
      private static Map<String,Object> map;
    %>
    <%--2、声明static静态代码块--%>
    <%!
      static {
        map = new HashMap<String,Object>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
      }
    %>
    <%--3、声明类方法--%>
    <%!
      public int abc(){
        return 12;
      }
    %>
    <%--4、声明内部类--%>
    <%!
      public static class A {
        private Integer id = 12;
        private String abc = "abc";
      }
    %>

    <%--练习：表达式脚本的格式
    1.输出整型
    2.输出浮点型
    3.输出字符串
    4.输出对象    --%>
    <%=12 %> <br>

    <%=12.12 %> <br>

    <%="我是字符串" %> <br>

    <%=map%> <br>

    <%=request.getParameter("username")%>


    <%--练习：--%>
    <%--1.代码脚本----if 语句--%>
    <%
      int i = 13 ;
      if (i == 12) {
    %>
      <h1>yun好帅</h1>
    <%
    } else {
    %>
      <h1>又骗人了！</h1>
    <%
      }
    %>
    <br>
    <%--2.代码脚本----for 循环语句--%>
    <table border="1" cellspacing="0">
      <%
        for (int j = 0; j < 10; j++) {
      %>
      <tr>
        <td>第 <%=j + 1%>行</td>
      </tr>
      <%
        }
      %>
    </table>
    <%--3.翻译后java文件中_jspService方法内的代码都可以写--%>
    <%
      String username = request.getParameter("username");
      System.out.println("用户名的请求参数值是：" + username);
    %>

</body>
</html>
