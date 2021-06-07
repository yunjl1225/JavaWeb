package yun.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发的代码
 * @author Yunjl
 * @create 2021-05-09 17:15
 */
public class ForwardToC extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("经过了ForwardToC程序");
    req.getRequestDispatcher("/a/b/c.html").forward(req, resp);  }
}
