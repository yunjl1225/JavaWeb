package yun.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求重定向
 * @author Yunjl
 * @create 2021-05-09 21:11
 */
public class Response1 extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("yun到此地一游 Response1");
//方法一
    //设置响应状态码 302 ，表示此程序已被废弃（重定向）
    resp.setStatus(302);

    //设置响应头   说明新地址
    resp.setHeader("Location","http://localhost:8080/06_Servlet/response2");

//方法二
    resp.sendRedirect("http://localhost:8080/06_Servlet/response2");
  }
}
