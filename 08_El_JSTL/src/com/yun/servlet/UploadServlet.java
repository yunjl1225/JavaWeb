package com.yun.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 接受上传的文件的servlet程序
 * 需要设置配置文件
 * @author Yunjl
 * @create 2021-05-13 9:56
 */
public class UploadServlet extends HttpServlet{
  /**
   * 处理文件上传的数据
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("文件上传过来了");
  /*  //以流的方式接收数据
    ServletInputStream inputStream = req.getInputStream();

    byte[] buffer = new byte[102400];
    int read = inputStream.read(buffer);
    System.out.println(new String(buffer,0,read));*/
    System.out.println("数据获取成功\n开始解析数据");
    //要导入两个 jar 包： commons-fileupload-1.2.1.jar commons-io-1.4.jar
    //1、判断从上传的数据是否是多段数据（只有是多段的数据，才是文件上传的）
    if(ServletFileUpload.isMultipartContent(req)){//返回true则为多段的
      //创建FileItemFactory工厂接口的实现类DiskFileItemFactory()对象
      FileItemFactory fileItemFactory = new DiskFileItemFactory();
      //创建用于解析上传数据的工具类ServletFileUpload()的对象
      ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
      try {
        //调用解析方法,得到每一个表单项FileItem
        List<FileItem> list = servletFileUpload.parseRequest(req);
        //循环判断每一个表单项是普通表单项还是上传文件的
        for(FileItem fileItem : list){
            if(fileItem.isFormField()){
              //true  普通表单项
              System.out.println("表单项的name属性值：" + fileItem.getFieldName());
              //UTF-8解决中文乱码问题
              System.out.println("表单项的value属性值：" + fileItem.getString("UTF-8"));

            }else{
              //false  上传文件的表单项
              System.out.println("表单项的name属性值：" + fileItem.getFieldName());
              System.out.println("上传的文件名：" + fileItem.getName());
              //将上传的文件存入到硬盘中
              fileItem.write(new File("D:\\Java\\4、JavaWeb\\资料\\资料\\09-EL表达式&JSTL标签库\\笔记\\文件上传和下载\\图片资源" +  fileItem.getName()));

            }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

   }
}
