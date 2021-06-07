package yun.Servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Yunjl
 * @create 2021-05-08 18:52
 */
public class HelloServlet implements Servlet{
  public static void main(String[] args) {

  }

  @Override
  public void init(ServletConfig servletConfig) throws ServletException {

  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  /**
   *service()方法时专门用来处理请求和响应的
   */
  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    System.out.println("Hello Servlet 被访问了");
  }

  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public void destroy() {

  }
}
