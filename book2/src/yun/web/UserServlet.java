package yun.web;

import com.google.gson.Gson;
import yun.pojo.User;
import yun.service.UserService;
import yun.service.impl.UserServiceImpl;
import yun.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;


/**
 * 整合登录与注册两个Servlet程序在一起，并封装成两个方法
 * 后续需要添加功能只需要封装在方法里，通过反射动态获取请求，调用不同的功能，前提需要在页面添加隐藏域，
 * @author Yunjl
 * @create 2021-05-14 0:36
 */
public class UserServlet extends BaseServlet{ //复用代码，继承父类就行，dopost方法在父类中

  private UserService userService = new UserServiceImpl();

  /**
   * 登录的方法
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //  1、获取请求的参数
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    // 调用 userService.login()登录处理业务
    User loginUser = userService.login(new User(null, username, password, null));
    // 如果等于null,说明登录 失败!
    if (loginUser == null) {
      //   把错误信息和回显的表单项信息，保存到request域中
      req.setAttribute("msg","用户名或密码错误！");  /*错误提示信息*/
      req.setAttribute("username",username);           /*需要回显的信息*/
      //   跳回登录页面
      req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
    } else {
      // 登录 成功
      //保存用户登录之后的信息到session域中
      req.getSession().setAttribute("user",loginUser);
      //跳到成功页面login_success.jsp
      req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
    }
  }

  /**
   * 注册的方法
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 获取 Session 中的验证码
    String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
    // 删除 Session 中的验证码
    req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);


    //  1、获取请求的参数
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String email = req.getParameter("email");
    String code = req.getParameter("code");

//    WebUtils 工具类，它可以一次性的把所有请求的参数注入到 JavaBean 中。
    //req.getParameterMap()   获取请求数据的Map值
    User user = WebUtils.copyParamBean(req.getParameterMap(), new User());


//        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
    if (token != null && token.equalsIgnoreCase(code)) {
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

  /**
   * 注销用户
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void loginout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、销毁Session中用户登录的信息（或者销毁Session）
    req.getSession().invalidate();
//        2、重定向到首页（或登录页面）。
    resp.sendRedirect(req.getContextPath());
  }

  /**
   * 使用AJax异步发起请求，局部更新页面的技术
   * 用于在输入用户名后立马验证是否可用，
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 获取请求的参数username
    String username = req.getParameter("username");
    // 调用userService.existsUsername();
    boolean existsUsername = userService.existsUsername(username);
    // 把返回的结果封装成为map对象
    Map<String,Object> resultMap = new HashMap<>();
    resultMap.put("existsUsername",existsUsername);

    Gson gson = new Gson();
    String json = gson.toJson(resultMap);

    resp.getWriter().write(json);
  }


}
