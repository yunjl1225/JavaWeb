<%@ page import="com.yun.pojo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/12
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>person</title>
</head>
<body>
  <%
    //创建Person类的对象
    Person person = new Person();

    //给各个属性赋值
    person.setName("云");
    person.setPhones(new String[]{"122500","110","119"});

    List<String> cities = new ArrayList<String>();
    cities.add("北京");
    cities.add("上海");
    cities.add("安徽");
    person.setCities(cities);

    Map<String,Object>map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    person.setMap(map);

    //把Person类的对象放进域对象中
    pageContext.setAttribute("personKey",person);
  %>
<%--输出域对象personKey中的数据person--%>
  输出person对象：
  ${ personKey }<br/>

  输出person对象的name的属性值：
  ${personKey.name}<br/>

  输出person对象的phone数组的属性值：
  ${personKey.phones}<br/>    <%--输出结果为数组对象地址 [Ljava.lang.String;@208fc5e9--%>
  ${personKey.phones[0]}<br/> <%--输出结果为122500 数组中第一个数据--%>

  输出person对象的list集合的属性值：
  ${personKey.cities}<br/>         <%--输出结果为集合中的所有数据--%>
  输出person对象的cities集合中的某个属性值：
  ${personKey.cities[0]}<br/>      <%--输出结果为北京 集合中第一个数据--%>

  输出person对象的map集合的属性值：
  ${personKey.map}<br/>        <%--输出结果为集合中的所有数据--%>
  输出person对象的map集合中的某个属性值：
  ${personKey.map.key1}<br/>       <%--输出结果为value1 集合中key值为“key1”的value值--%>

  输出person对象中的未声明属性只写了getAge()方法的值
  ${personKey.age}<br/>

</body>
</html>
