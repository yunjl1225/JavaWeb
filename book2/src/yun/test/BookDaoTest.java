package yun.test;

import org.junit.Test;
import yun.dao.BookDao;
import yun.dao.impl.BookDaoImpl;
import yun.pojo.Book;
import yun.pojo.Page;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author Yunjl
 * @create 2021-05-14 18:04
 */
public class BookDaoTest {

  private BookDao bookDao = new BookDaoImpl();
  @Test
  public void addBook() {
    bookDao.addBook(new Book(null,"爱上你的那一天", "yun", new BigDecimal(9999),1100000,0,null
    ));
  }

  @Test
  public void deleteBookById() {
  }

  @Test
  public void updateBook() {
    bookDao.updateBook(new Book(21,"大家都可以这么帅！", "云哥", new BigDecimal(9999),1100000,0,null
    ));
  }

  @Test
  public void queryBookById() {
    System.out.println( bookDao.queryBookById(21) );
  }

  @Test
  public void queryBooks() {
    for (Book queryBook : bookDao.queryBooks()) {
      System.out.println(queryBook);
    }
  }
  @Test
  public void queryForPageTotalCount() {
    //输出总的记录数
    System.out.println(bookDao.queryForPageTotalCount());

  }
  @Test
  public void queryForPageTotalCountByPrice() {
    //输出价格在10-50之间的图书总的记录数
    System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));

  }

  @Test
  public void queryForPageItems() {
    //起始索引为8，有4条数据的页面
    for (Book book : bookDao.queryForPageItems(8, Page.PAGE_SIZE)) {
      System.out.println(book);
    }
  }
  @Test
  public void queryForPageItemsByPrice() {
    //起始索引为0，有4条数据的价格在10-50之间的数据页面
    for (Book book : bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,10,50)) {
      System.out.println(book);
    }
  }
}
