package yun.service;

import yun.pojo.Book;
import yun.pojo.Page;

import java.util.List;

/**
 * 图书管理接口
 * @author Yunjl
 * @create 2021-05-14 18:33
 */
public interface BookService {

  public void addBook(Book book);

  public void deleteBookById(Integer id);

  public void updateBook(Book book);

  public Book queryBookById(Integer id);

  public List<Book> queryBooks();

  Page<Book> page(int pageNo, int pageSize);

  Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
