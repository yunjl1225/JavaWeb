package yun.dao;
import yun.pojo.OrderItem;
/**
 * 订单项
 * @author Yunjl
 * @create 2021-05-18 10:59
 */
public interface OrderItemDao {
  /**
   * 保存订单项
   * @param orderItem
   * @return
   */
  public int saveOrderItem(OrderItem orderItem);
}
