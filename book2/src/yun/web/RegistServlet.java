package yun.web;


import yun.pojo.User;
import yun.service.UserService;
import yun.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册的Servlet程序
 *    (需要配置文件web.xml中配置访问地址等)
 * @author Yunjl
 * @create 2021-05-10 12:08
 */
public class RegistServlet extends HttpServlet {

  private UserService userService = new UserServiceImpl();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //  1、获取请求的参数
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String email = req.getParameter("email");
    String code = req.getParameter("code");

//        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
    if ("abcde".equalsIgnoreCase(code)) {
//        3、检查 用户名是否可用
      if (userService.existsUsername(username)) {
        //把错误提示信息保存到request域中
        req.setAttribute("msg","用户名已存在！");
        //把回显信息保存到request域中
        req.setAttribute("username",username);
        req.setAttribute("email",email);

        System.out.println("用户名[" + username + "]已存在!");
//        跳回注册页面
        req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
      } else {
        //      可用
//                调用Sservice保存到数据库
        userService.registUser(new User(null, username, password, email));
//
//        跳到注册成功页面 regist_success.jsp
        req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
      }
    } else {
      //把错误提示信息保存到request域中
      req.setAttribute("msg","验证码错误！");
      //把回显信息保存到request域中
      req.setAttribute("username",username);
      req.setAttribute("email",email);

      System.out.println("验证码[" + code + "]错误");
      //跳转回本页面
      req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
    }
  }
}
