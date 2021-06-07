package yun.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yunjl
 * @create 2021-05-09 10:20
 */
public class ContextServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //通过ServletConfig的对象创建ServletContext对象
      ServletContext servletContext = getServletConfig().getServletContext();
      //或者直接调用getServletContext()方法
      ServletContext servletContext1 = getServletContext();

//      4、像 Map 一样存取数据
      //一个 web 工程，只有一个 ServletContext 对象实例
      //ServletContext 是在 web 工程部署启动的时候创建。在 web 工程停止的时候销毁。
      //存储数据  一旦赋值，在别的类中调用也是有数据的
      servletContext1.setAttribute("key1","value1");
      //读取数据
      System.out.println("servletContext1中获取域数据key1的值是：" + servletContext1.getAttribute("key1"));
    }
}
