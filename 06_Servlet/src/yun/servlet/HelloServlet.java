package yun.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 手动实现 Servlet 程序
 *  1、编写一个类去实现 Servlet 接口
 *  2、实现 service 方法，处理请求，并响应数据
 *  3、到 web.xml 中去配置 servlet 程序的访问地址
 */
public class HelloServlet implements Servlet {
  public static void main(String[] args) {

  }

   public HelloServlet(){
     System.out.println("1、构造器方法");
   }

  @Override
  public void init(ServletConfig servletConfig) throws ServletException {
    System.out.println("2、init初始化方法");

    //ServletConfig 类的三大作用
//    1、可以获取 Servlet 程序的别名 servlet-name 的值
    System.out.println("HelloServlet程序的别名是：" + servletConfig.getServletName());
//    2、获取初始化参数 init-param
    System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));
    System.out.println("初始化参数url的值是：" + servletConfig.getInitParameter("url"));
//    3、获取 ServletContext 对象
    System.out.println(servletConfig.getServletContext());
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
    System.out.println("3、service方法");

//    父类型ServletRequest没有getMethod()方法，子类型 HttpServletRequest 有
     //类型转换，将 ServletRequest 类转换为子类型 HttpServletRequest
    HttpServletRequest httpServletRequest  =  (HttpServletRequest)servletRequest;
    //getMethod()获取请求的方式
    String method = httpServletRequest.getMethod();
    //根据获取的请求方式回复不同的响应
    if("GET".equals(method)){
      doGet();      //把响应的操作封装成各自的方法
    }else if("POST".equals(method)){
      doPost();
    }
  }

  /**
   * 做get请求响应的操作
   * @return
   */
  public void doGet(){
    System.out.println("get请求");
    System.out.println("get请求");
  }

  /**
   * 做post请求响应的操作
   * @return
   */
  public void doPost(){
    System.out.println("post请求");
    System.out.println("post请求");
  }


  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public void destroy() {
    System.out.println("4、destroy销毁方法");
  }
}
