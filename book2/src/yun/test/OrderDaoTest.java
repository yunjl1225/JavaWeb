package yun.test;

import org.junit.Test;
import yun.dao.OrderDao;
import yun.dao.impl.OrderDaoImpl;
import yun.pojo.Order;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Yunjl
 * @create 2021-05-18 11:10
 */
public class OrderDaoTest {

  @Test
  public void saveOrder() {
    OrderDao orderDao = new OrderDaoImpl();
    orderDao.saveOrder(new Order("12345wq6378901",new Date(),new BigDecimal(100),0, 2));
  }
}
