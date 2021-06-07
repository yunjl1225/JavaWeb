package com.yun.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**Filter 过滤器
 * @author Yunjl
 * @create 2021-05-18 12:31
 */
public class AdminFilter implements Filter{

  public AdminFilter() {
    System.out.println("1.filter构造器方法AdminFilter");
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("2.filter的init初始化方法");
    // 1、获取 Filter 的名称 filter-name 的内容
    System.out.println("filter-name 的值是：" + filterConfig.getFilterName());
    // 2、获取在 web.xml 中配置的 init-param 初始化参数
    System.out.println("初始化参数 username 的值是：" + filterConfig.getInitParameter("username"));
    System.out.println("初始化参数 url 的值是：" + filterConfig.getInitParameter("url"));
    // 3、获取 ServletContext 对象
    System.out.println(filterConfig.getServletContext());
  }

  /**
   * 专门用于拦截请求（可以做权限检查），过滤响应
   * 需要在web.xml中配置
   * @param servletRequest
   * @param servletResponse
   * @param filterChain
   * @throws IOException
   * @throws ServletException
   */
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    System.out.println("3.filter的doFilter过滤方法");
    System.out.println("AdminFilter的线程" + Thread.currentThread().getName());
    //使用httpServletRequest域对象获取session域对象
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpSession session = httpServletRequest.getSession();
    //权限检查
    Object user = session.getAttribute("user");
    // 如果等于 null，说明还没有登录
    if (user == null) {
      //请求转发到登录界面
      servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
    return;
    } else {
      // 让程序继续往下访问用户的目标资源
      filterChain.doFilter(servletRequest,servletResponse);
    }
}


  @Override
  public void destroy() {
    System.out.println("4.filter的destroy销毁方法");
  }
}
