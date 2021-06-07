package yun.web;

import yun.pojo.Cart;
import yun.pojo.User;
import yun.service.OrderService;
import yun.service.impl.OrderServiceImpl;
import yun.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 订单程序
 * @author Yunjl
 * @create 2021-05-18 11:52
 */
public class OrderServlet extends BaseServlet {

  private OrderService orderService = new OrderServiceImpl();

  /**
   * 生成订单
   *
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 先获取Cart购物车对象(在session域中)
    Cart cart = (Cart) req.getSession().getAttribute("cart");
    // 获取Userid
    User loginUser = (User) req.getSession().getAttribute("user");

    //判断是否登录，没有登录则跳转到登录页面
    if (loginUser == null) {
      req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
      return;
    }

    Integer userId = loginUser.getId();

//        调用orderService.createOrder(Cart,Userid);生成订单
    //使用事务，try-catch，有异常则回滚，没有异常提交并关闭数据库连接
  /*  String orderId = null;
    try {
      orderId = orderService.createOrder(cart, userId);
      JdbcUtils.commitAndClose();//提交事务并关闭连接
    } catch (Exception e) {
      JdbcUtils.rollbackAndClose();//有异常，回滚事务
      e.printStackTrace();
    }*/
    //因为使用了TransactionFilter 过滤器统一给所有的 Service 方法都加上 try-catch。所以这里就不用try-catch，
    // 调用orderService.createOrder(Cart,Userid);生成订单
    String orderId = orderService.createOrder(cart, userId);


    //重定向就不能用req域保存订单号了，可以使用session域
//        req.setAttribute("orderId", orderId);
    System.out.println("订单号为：" + orderId);
    req.getSession().setAttribute("orderId",orderId);
    // 请求转发到/pages/cart/checkout.jsp
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
    //防止表单重复提交，使用重定向
    resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
  }

}

