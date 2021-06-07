package com.yun.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录程序
 * @author Yunjl
 * @create 2021-05-18 12:57
 */
public class LoginServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //解决响应乱码
    resp.setContentType("text/html; charset=UTF-8");
    //获取域中的数据
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    if("yunjl".equals(username) && "122500".equals(password)){
      //登录成功
      req.getSession().setAttribute("user",username);
      resp.getWriter().write("登陆成功");

    }else{
      //登录失败，请求转发到登录界面
      req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }
  }
}
