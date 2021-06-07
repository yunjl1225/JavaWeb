package yun.test;

import org.junit.Test;
import yun.pojo.Book;
import yun.pojo.Page;
import yun.service.BookService;
import yun.service.impl.BookServiceImpl;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Yunjl
 * @create 2021-05-14 18:40
 */
public class BookServiceTest {

  private BookService bookService = new BookServiceImpl();

  @Test
  public void addBook() {
    bookService.addBook(new Book(null,"云哥在手，天下我有！", "1125", new BigDecimal(1000000), 100000000, 0, null));
  }

  @Test
  public void deleteBookById() {
    bookService.deleteBookById(22);
  }

  @Test
  public void updateBook() {
    bookService.updateBook(new Book(22,"社会我云哥，人狠话不多！", "1125", new BigDecimal(999999), 10, 111110, null));
  }

  @Test
  public void queryBookById() {
    System.out.println(bookService.queryBookById(22));
  }

  @Test
  public void queryBooks() {
    for (Book queryBook : bookService.queryBooks()) {
      System.out.println(queryBook);
    }
  }

  @Test
  public void page(){
    //第一页，每页4条数据
    System.out.println(bookService.page(1, Page.PAGE_SIZE));
  }
  @Test
  public void pageByPrice(){
    //第一页，每页4条数据(价格在10-50之间)
    System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50));
  }
}
