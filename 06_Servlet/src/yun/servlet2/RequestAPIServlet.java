package yun.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试 HttpServletRequest 类的常用方法
 * @author Yunjl
 * @create 2021-05-09 11:16
 */
public class RequestAPIServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //首先在配置文件里配置访问路径
//    HttpServletRequest 类的常用方法
//    i.    getRequestURI() 获取请求的资源路径
    System.out.println("URI => " + req.getRequestURI());
            //      /06_Servlet/requestapi

//    ii.   getRequestURL() 获取请求的统一资源定位符（绝对路径）
    System.out.println("URL => " + req.getRequestURL());
            //      http://localhost:8080/06_Servlet/requestapi

//    iii.  getRemoteHost() 获取客户端的 ip 地址
    /**
     * 在IDEA中，使用localhost访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1
     * 在IDEA中，使用127.0.0.1访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1
     * 在IDEA中，使用 真实ip 访问时，得到的客户端 ip 地址是 ===>>> 真实的客户端 ip 地址
     */
    System.out.println("客户端的IP => " + req.getRemoteHost());
            //      0:0:0:0:0:0:0:1

//    iv.   getHeader() 获取请求头
    System.out.println("请求头User-Agent ==>> " + req.getHeader("User-Agent"));

//    v.    getParameter() 获取请求的参数
//    vi.   getParameterValues() 获取请求的参数（多个值的时候使用）

//    vii.  getMethod() 获取请求的方式 GET 或 POST
    System.out.println( "请求的方式 ==>> " + req.getMethod() );

  }
}
