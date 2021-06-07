package yun.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yunjl
 * @create 2021-05-08 23:55
 */
public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //ServletContext 类的四个作用
//      1、获取 web.xml 中配置的上下文参数 context-param
      ServletContext servletContext = getServletConfig().getServletContext();   //通过ServletConfig的对象创建ServletContext对象
      String username = servletContext.getInitParameter("username");
      System.out.println("配置文件中上下文参数username的值为：" + username);
      String password = servletContext.getInitParameter("password");
      System.out.println("配置文件中上下文参数password的值为：" + password);
//      2、获取当前的工程路径，格式: /工程路径
      System.out.println("获取当前工程路径：" + servletContext.getContextPath());
//      3、获取工程部署后在服务器硬盘上的绝对路径
      /**
       *     /      被服务器解析地址为：http://ip:port/工程名/  （即为.../web/）
       */
      System.out.println("工程部署的路径是：" + servletContext.getRealPath("/"));
//      4、像 Map 一样存取数据


    }
}
