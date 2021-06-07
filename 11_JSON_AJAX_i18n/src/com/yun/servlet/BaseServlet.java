package com.yun.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 所有程序的父类，子类通过继承实现，代码复用
 * @author Yunjl
 * @create 2021-05-14 11:26
 */
public abstract class BaseServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req,resp);
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //设置编码集
    req.setCharacterEncoding("UTF-8");
    //设置响应编码集
    resp.setContentType("text/html; charset=UTF-8");
    /*获取页面中的隐藏域的值*/
    String action =  req.getParameter("action");

    //通过反射动态获取action的值
    try {
      // 获取action业务鉴别字符串，获取相应的业务 方法反射对象
      Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);

//      System.out.println(method);
      // 调用目标业务 方法
      method.invoke(this, req,resp);

    } catch (Exception e) {
      e.printStackTrace();
      //因为使用了TransactionFilter 过滤器统一给所有的 Service 方法都加上 try-catch。所以治理的异常需要全抛出去
      throw new RuntimeException(e);
    }
  }


}
