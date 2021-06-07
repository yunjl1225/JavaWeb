package yun.filter;

import yun.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * 使用 Filter 过滤器统一给所有的 Service 方法都加上 try-catch。来进行实现事务的管理。
 * @author Yunjl
 * @create 2021-05-18 20:44
 */
public class TransactionFilter implements Filter{
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    try {
      filterChain.doFilter(servletRequest,servletResponse);
      JdbcUtils.commitAndClose();//所有的Service方法没有异常就提交事务并关闭连接

    } catch (Exception e) {
      JdbcUtils.rollbackAndClose();//有异常则回滚事务
      e.printStackTrace();
      throw new RuntimeException(e);//处理异常还要抛出异常给服务器，配置文件需要知道，然后跳转到对应的错误提示界面
    }
  }

  @Override
  public void destroy() {

  }
}
