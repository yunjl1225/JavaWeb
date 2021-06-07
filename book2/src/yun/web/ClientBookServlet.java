package yun.web;


import yun.pojo.Book;
import yun.pojo.Page;
import yun.service.BookService;
import yun.service.impl.BookServiceImpl;
import yun.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于在首页上显示数据,本程序的主要功能是查询分页数据,
 * web/index.jsp  --请求转发-->  ClientBookServlet(处理分页)  --保存数据并转发-->  web/pages/client/index.jsp(用于显示带数据首页)
 *
 * @author Yunjl
 * @create 2021-05-16 20:55
 */
public class ClientBookServlet extends BaseServlet{

  private BookService bookService = new BookServiceImpl();
  /**
   * 处理分页的功能
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1 获取请求的参数 pageNo 和 pageSize
    int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
    int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
    //2 调用BookService.page(pageNo，pageSize)：Page对象
    Page<Book> page = bookService.page(pageNo,pageSize);

    page.setUrl("manager/bookServlet?action=page");

    //设置url地址
    page.setUrl("client/clientBookServlet?action=page");
    //3 保存Page对象到Request域中
    req.setAttribute("page",page);
    //4 请求转发到pages/manager/book_manager.jsp页面
    req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
  }
  /**
   * 根据价格处理分页功能
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1 获取请求的参数 pageNo 和 pageSize
    int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
    int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
    int min = WebUtils.parseInt(req.getParameter("min"), 0);
    int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

    //2 调用BookService.page(pageNo，pageSize)：Page对象
    Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);

    StringBuilder sb = new StringBuilder("client/clientBookServlet?action=pageByPrice");
    // 如果有最小价格的参数,追加到分页条的地址参数中
    if (req.getParameter("min") != null) {
      sb.append("&min=").append(req.getParameter("min"));
    }
    // 如果有最大价格的参数,追加到分页条的地址参数中
    if (req.getParameter("max") != null) {
      sb.append("&max=").append(req.getParameter("max"));
    }
    page.setUrl(sb.toString());
    //3 保存Page对象到Request域中
    req.setAttribute("page",page);
    //4 请求转发到pages/manager/book_manager.jsp页面
    req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
  }
}
