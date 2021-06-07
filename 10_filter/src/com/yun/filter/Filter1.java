package com.yun.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * FilterChain 过滤器链的执行顺序
       Filter1 前置代码
       Filter2 前置代码
       target页面执行了
       Filter2 后置代码
       Filter1 后置代码
 * 特点：
 *    1、多个Filter过滤器的执行顺序是由web.xml中的配置顺序决定的
 *    2、拦截路径相同的所有的Filter和目标资源默认都执行在同一个线程中
 *    3、拦截路径相同的所有的Filter都是用同一个Request对象，共享域中的数据
 * @author Yunjl
 * @create 2021-05-18 14:41
 */
public class Filter1 implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    System.out.println("Filter1 前置代码");
    System.out.println("filter1的线程" + Thread.currentThread().getName());
    filterChain.doFilter(servletRequest,servletResponse);

    System.out.println("Filter1 后置代码");
  }

  @Override
  public void destroy() {

  }
}
