package yun.test;

import org.junit.Test;
import yun.pojo.Cart;
import yun.pojo.CartItem;
import yun.service.OrderService;
import yun.service.impl.OrderServiceImpl;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Yunjl
 * @create 2021-05-18 11:49
 */
public class OrderServiceTest {

  @Test
  public void createOrder() {
    Cart cart = new Cart();

    cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
    cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
    cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));

    OrderService orderService = new OrderServiceImpl();

    System.out.println( "订单号是：" + orderService.createOrder(cart, 1) );
  }
}
