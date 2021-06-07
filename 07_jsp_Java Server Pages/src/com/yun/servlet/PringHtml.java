package com.yun.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 使用servlet程序回传HTML页面数据    十分麻烦复杂，被舍弃
 * @author Yunjl
 * @create 2021-05-11 12:35
 */
public class PringHtml extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //        JspWriter
    //设置响应编码集为UTF-8
    resp.setContentType("text/html; charset=UTF-8");
    // 通过响应的回传流回传html页面数据
    PrintWriter writer = resp.getWriter();

    writer.write("<!DOCTYPE html>\r\n");
    writer.write("  <html lang=\"en\">\r\n");
    writer.write("  <head>\r\n");
    writer.write("      <meta charset=\"UTF-8\">\r\n");
    writer.write("      <title>Title</title>\r\n");
    writer.write("  </head>\r\n");
    writer.write(" <body>\r\n");
    writer.write("    这是html页面数据<br/> \r\n");
    writer.write("    通过http://localhost:8080/07_jsp/pringHtml 访问\r\n");
    writer.write("  </body>\r\n");
    writer.write("</html>\r\n");
    writer.write("\r\n");
  }
}
