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
import java.util.List;

/**
 * 处理图书管理的程序
 * @author Yunjl
 * @create 2021-05-14 18:44
 */
public class BookServlet extends BaseServlet{

  private BookService bookService = new BookServiceImpl();

  /**
   * 添加图书信息。如果出现书名乱码，在程序的post方法中设置编码集UTF-8
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //添加数据后直接跳转到添加的那一页
    //不加一的话就是跳转到之前的总页数，可能添加数据会导致总页数增加。
    int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),0);
    pageNo += 1;

//        1、获取请求的参数==封装成为Book对象
    Book book = WebUtils.copyParamBean(req.getParameterMap(),new Book());
//        2、调用BookService.addBook()保存图书
    bookService.addBook(book);
//        3、跳到图书列表页面
//                /manager/bookServlet?action=list
    //请求转发：此方法有bug，刷新页面时会重复提交
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);

    //使用重定向方法，新建一个请求
    resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);

  }

  protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1 通过BookService查询全部图书
    List<Book> books = bookService.queryBooks();
    //2 把全部图书保存到Request域中
    req.setAttribute("books", books);
    //3、请求转发到/pages/manager/book_manager.jsp页面
    req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
  }

  protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、获取请求的参数id，图书编程，调用工具类的类型转换功能
    int id = WebUtils.parseInt(req.getParameter("id"), 0);
//        2、调用bookService.deleteBookById();删除图书
    bookService.deleteBookById(id);
//        3、重定向回图书列表管理页面
//                /book/manager/bookServlet?action=list
    resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
  }

  /**
   * 获取要修改的图书信息
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1 获取请求的参数图书编号
    int id = WebUtils.parseInt(req.getParameter("id"), 0);
    //2 调用bookService.queryBookById查询图书
    Book book = bookService.queryBookById(id);
    //3 保存到图书到Request域中
    req.setAttribute("book", book) ;
    //4 请求转发到。pages/manager/book_edit.jsp页面
    req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
  }

  /**
   * 修改图书信息
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、获取请求的参数==封装成为Book对象
    Book book = WebUtils.copyParamBean(req.getParameterMap(),new Book());
//        2、调用BookService.updateBook( book );修改图书
    bookService.updateBook(book);
//        3、重定向回图书列表管理页面
//        地址：/工程名/manager/bookServlet?action=list
    resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
  }

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
    page.setUrl("manager/bookServlet?action=page");

    //3 保存Page对象到Request域中
    req.setAttribute("page",page);
    //4 请求转发到pages/manager/book_manager.jsp页面
    req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
  }
}
