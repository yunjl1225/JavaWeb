package yun.dao.impl;

import yun.dao.OrderItemDao;
import yun.pojo.OrderItem;

/**
 * @author Yunjl
 * @create 2021-05-18 11:01
 */
public class OrderItemDaoImpl  extends BaseDao implements OrderItemDao {
  @Override
  public int saveOrderItem(OrderItem orderItem) {
    String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
    return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
  }
}
