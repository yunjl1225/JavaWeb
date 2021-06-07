package com.yun.servlet;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import javax.activation.MimeType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于下载文件的servlet程序
 *
 客户端：
    发送请求告诉服务器，我要下戴什么文件
 服务器：
   1、获取要下载的文件名
   2、读取要下载的文件内容
   3、把下载的文件内容回传给客户端
   4、在回传前，通过响应头告诉客户端返回的数据类型；
   5、还要告诉客户端收到的数据是用于下戴使用（还是使用响应头）
 * @author Yunjl
 * @create 2021-05-13 11:41
 */
public class DownloadServlet extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//   1、获取要下载的文件名
    String downloadFileName = "yun1.jpg";//先写死

//   2、读取要下载的文件内容（通过ServletContext对象可以读取）
    ServletContext servletContext = getServletContext();

//   4、在回传前，通过响应头告诉客户端返回的数据类型；
    //获取要下载文件的类型
    String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
    //通过响应头告诉客户端返回的数据类型
    resp.setContentType(mimeType);

//   5、还要告诉客户端收到的数据是用于下戴使用（还是使用响应头）不写仅仅是在页面显示图片
    /**
     * Content-Disposition响应头，表示收到的数据怎么处理
     * attachment 表示附件，表示下载使用
     * fileName= 表示指定下载的文件名，自定义，可以与上面的名字不同，如果想用中文需要通过URL编码
     *    url编码是把汉字转换为%xx%xx的格式
     */
    resp.setHeader("Content-Disposition", "attachment; fileName=" + URLEncoder.encode("艾米莉亚.jpg","UTF-8"));

//   3、把下载的文件内容回传给客户端
    //获取读取文件的输入流
    // /斜红表示服务解解析表示地址为http://ip:port/工程名/   映射到代码的ueb目录
    InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
    //获取响应的输出流
    OutputStream outputStream = resp.getOutputStream();
    //利用jar包中的IOUtils工具类
    //将读取到的文件内容复制到输出流中，输出给客户端
    IOUtils.copy(resourceAsStream,outputStream);

  }


}
