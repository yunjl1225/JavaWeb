package com.yun.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Yunjl
 * @create 2021-05-18 14:44
 */
public class Filter2 implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    System.out.println("Filter2 前置代码");
    System.out.println("filter2的线程" + Thread.currentThread().getName());
    filterChain.doFilter(servletRequest,servletResponse);

    System.out.println("Filter2 后置代码");
  }

  @Override
  public void destroy() {

  }
}
