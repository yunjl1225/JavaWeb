package yun.service;

import yun.pojo.Cart;

/**
 * 订单业务层
 * @author Yunjl
 * @create 2021-05-18 11:43
 */
public interface OrderService {
  public String createOrder(Cart cart, Integer userId);
}
