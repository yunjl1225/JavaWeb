package yun.dao;

import yun.pojo.Order;

/**
 * 订单接口
 * @author Yunjl
 * @create 2021-05-18 10:58
 */
public interface OrderDao {
  /**
   * 保存订单
   * @param order
   * @return
   */
  public int saveOrder(Order order);

}
