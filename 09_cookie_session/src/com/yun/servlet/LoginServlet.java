package com.yun.servlet;

import javafx.scene.control.Alert;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yunjl
 * @create 2021-05-17 11:55
 */
public class LoginServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    //判断账号密码
    if("yunjl".equals(username) && "yjl122500".equals(password)){
      //登录成功
      Cookie cookie = new Cookie("username",username);
      cookie.setMaxAge(60*60*24*7);//存活七天
      resp.addCookie(cookie);
      System.out.println("登录成功");

    }else{
      //登录失败

      System.out.println("登录失败");
    }
  }
}
