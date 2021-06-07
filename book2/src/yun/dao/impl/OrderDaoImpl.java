package yun.dao.impl;

import yun.dao.OrderDao;
import yun.pojo.Order;

/**
 * @author Yunjl
 * @create 2021-05-18 11:00
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
  @Override
  public int saveOrder(Order order) {
    String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

    return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
  }
}
