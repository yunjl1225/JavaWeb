package com.yun.servlet;

import com.yun.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 1、用于获取客户端发来的请求参数，
 * 2、发送SQL语句给数据库执行查询操作
 * 3、报错查询的信息到request域中
 * 4、请求转发给showStudent.jsp，让他回传给客户端
 *
 * 使用此方法必须从servlet程序（SearchStudentServlet）的访问地址访问（需要设置配置文件）
 * @author Yunjl
 * @create 2021-05-11 19:00
 */
public class SearchStudentServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 获取请求的参数
    // 发sql语句查询学生的信息
      // 使用for循环生成查询到的数据做模拟
    List<Student> studentList = new ArrayList<Student>();
    for (int i = 0; i < 10; i++) {
      int t = i + 1;
      studentList.add(new Student(t,"name"+t, 18+t,"phone"+t));
    }
    // 保存查询到的结果（学生信息）到request域中
    req.setAttribute("stuList", studentList);
    // 请求转发到showStudent.jsp页面
    req.getRequestDispatcher("/test/showStudent.jsp").forward(req,resp);
  }
}
