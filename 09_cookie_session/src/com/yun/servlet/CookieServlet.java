package com.yun.servlet;

import com.yun.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yunjl
 * @create 2021-05-17 9:01
 */
public class CookieServlet extends BaseServlet {
  /**
   * 创建cookie
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1、创建cookie对象
    Cookie cookie = new Cookie("key1","value1");
    //2、通过响应通知客户端保存cookie
    resp.addCookie(cookie);
    //可以创建多个cookie
    Cookie cookie2 = new Cookie("key2","value2");
    resp.addCookie(cookie2);

    resp.getWriter().write("Cookie创建成功");
  }

  /**
   * 获取cookie
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie[] cookies =  req.getCookies();

    for (Cookie cookie : cookies) {
      //getName 返回cookie的key(名称)
      resp.getWriter().write("cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");
    }

    //返回指定的key的cookie
//    Cookie iWantCookie = null;
//    for (Cookie cookie : cookies) {
//      if("key2".equals(cookie.getName())){
//        iWantcookie = cookie;
//        break;
//      }
//    }
//或
    //调用工具类的查找方法
    Cookie iWantCookie = CookieUtils.fingCookie("key2", cookies);
    // 如果不等于null，说明赋过值，也就是找到了需要的Cookie
    if (iWantCookie != null) {
      resp.getWriter().write("找到了需要的Cookie");
    }
  }

  /**
   * 修改cookie
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 方案一：
    // 1、先创建一个要修改的同名的 Cookie 对象
    // 2、在构造器，同时赋于新的 Cookie 值。
    Cookie cookie = new Cookie("key1","newValue1");
    // 3、调用 response.addCookie( Cookie ); 通知 客户端 保存修改
    resp.addCookie(cookie);
    resp.getWriter().write("key1的cookie已经修改<br/>");

    // 方案二：
    // 1、先查找到需要修改的 Cookie 对象
    Cookie cookie2 = CookieUtils.fingCookie("key2", req.getCookies());
    if (cookie2 != null) {
      // 2、调用 setValue()方法赋于新的 Cookie 值。
      cookie2.setValue("newValue2");
      // 3、调用 response.addCookie()通知客户端保存修改
      resp.addCookie(cookie2);
      resp.getWriter().write("key2的cookie已经修改");
    }

  }

  /**
   * cookie 的默认存活时间,浏览器一关，Cookie 就会被删除
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie cookie = new Cookie("defaultLife","defaultLifeValue");
    //设置存活时间，表示浏览器一关，Cookie 就会被删除
    cookie.setMaxAge(-1);
    resp.addCookie(cookie);
  }

  /**
   * 马上删除cookie
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 先找到你要删除的Cookie对象
    Cookie cookie = CookieUtils.fingCookie("key2", req.getCookies());
    if (cookie != null) {
      // 调用setMaxAge(0);
      cookie.setMaxAge(0); // 表示马上删除，都不需要等待浏览器关闭
      // 调用response.addCookie(cookie);
      resp.addCookie(cookie);

      resp.getWriter().write("key2的Cookie已经被删除");
    }
  }
  /**
   * 设置存活1个小时的Cooie
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Cookie cookie = new Cookie("life3600", "life3600");
    cookie.setMaxAge(60 * 60); // 设置Cookie一小时之后被删除。无效
    resp.addCookie(cookie);
    resp.getWriter().write("已经创建了一个存活一小时的Cookie");

  }

  /**
   * cookie的Path路径
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie cookie = new Cookie("path1", "path1");
    // getContextPath() ===>>>>  得到工程路径
    cookie.setPath( req.getContextPath() + "/abc" ); // ===>>>>  /工程路径/abc
    resp.addCookie(cookie);
    resp.getWriter().write("创建了一个带有Path路径的Cookie");
  }

}
