package com.yun.servlet;

import com.google.gson.Gson;
import com.yun.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**Ajax请求
 * @author Yunjl
 * @create 2021-05-18 23:26
 */
public class AjaxServlet extends BaseServlet{
  protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("Ajax请求过来了");

    //将下面数据转给客户端(响应)
    Person person = new Person(1,"yun");
    //需要先转化为json字符串
    Gson gson = new Gson();
    String personJsonString = gson.toJson(person);

    resp.getWriter().write(personJsonString);

  }

  protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("  jQueryAjax == 方法调用了");
    Person person = new Person(1, "国哥");
    // json格式的字符串
    Gson gson = new Gson();
    String personJsonString = gson.toJson(person);

    resp.getWriter().write(personJsonString);
  }

  protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("  jQueryGet  == 方法调用了");
    Person person = new Person(1, "国哥");
    // json格式的字符串
    Gson gson = new Gson();
    String personJsonString = gson.toJson(person);

    resp.getWriter().write(personJsonString);
  }

  protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("  jQueryPost   == 方法调用了");
    Person person = new Person(1, "国哥");
    // json格式的字符串
    Gson gson = new Gson();
    String personJsonString = gson.toJson(person);

    resp.getWriter().write(personJsonString);
  }


  protected void jQueryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("  jQueryGetJSON   == 方法调用了");
    Person person = new Person(1, "国哥");
    // json格式的字符串
    Gson gson = new Gson();
    String personJsonString = gson.toJson(person);

    resp.getWriter().write(personJsonString);
  }

  protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("  jQuerySerialize   == 方法调用了");

    System.out.println("用户名：" + req.getParameter("username"));
    System.out.println("密码：" + req.getParameter("password"));

    Person person = new Person(1, "国哥");
    // json格式的字符串
    Gson gson = new Gson();
    String personJsonString = gson.toJson(person);

    resp.getWriter().write(personJsonString);
  }



}
