package yun.test;

import org.junit.Test;
import yun.dao.OrderItemDao;
import yun.dao.impl.OrderItemDaoImpl;
import yun.pojo.OrderItem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Yunjl
 * @create 2021-05-18 11:29
 */
public class OrderItemDaoTest {

  @Test
  public void saveOrderItem() {
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    orderItemDao.saveOrderItem(new OrderItem(1,"1",2,new BigDecimal(122),new BigDecimal(1111),"2"));
  }
}
