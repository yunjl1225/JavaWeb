package yun.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 使用 Filter 过滤器拦截/pages/manager/所有内容，实 现权限检查
 * @author Yunjl
 * @create 2021-05-18 17:20
 */
public class ManagerFilter implements Filter{
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    Object user = httpServletRequest.getSession().getAttribute("user");
    if(user == null){
      //没有登录,请求转发到登录界面
      httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
    }else{
      //已经登录，放行
      filterChain.doFilter(servletRequest,servletResponse);
    }

  }

  @Override
  public void destroy() {

  }
}
