package yun.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 设置返回给客户端的信息
 *  字节流 getOutputStream(); 常用于下载（传递二进制数据）
 *  字符流 getWriter(); 常用于回传字符串（常用）
 *   两个流同时只能使用一个。
 * @author Yunjl
 * @create 2021-05-09 17:45
 */
public class ResponseIOServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    System.out.println(resp.getCharacterEncoding());//获取响应的字符集  默认ISO-8859-1
// 方法一
    //设置字符集
    resp.setCharacterEncoding("UTF-8");
    /* System.out.println(resp.getCharacterEncoding()); //设置后的字符集  UTF-8
    但是只是设置了服务器的字符集，浏览器没有设置，字符集不符。*/
    // 通过响应头，设置浏览器也使用UTF-8字符集
    resp.setHeader("Content-Type", "text/html; charset=UTF-8");

//方法二
    // 同时设置服务器和客户端都使用UTF-8字符集，还设置了响应头
    // 此方法一定要在获取流对象之前调用才有效
    resp.setContentType("text/html; charset=UTF-8");

// 要求 ： 往客户端回传 字符串 数据。
    PrintWriter writer = resp.getWriter();//字符流
    writer.write("yun很帅！");
//    resp.getOutputStream(); //字节流   两个流同时只能使用一个。

  }
}
