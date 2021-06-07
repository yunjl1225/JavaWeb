package yun.dao;

import yun.pojo.Book;

import java.util.List;

/**Book类的接口
 * @author Yunjl
 * @create 2021-05-14 17:50
 */
public interface BookDao {

  /**
   * 添加图书
   * @param book
   * @return
   */
  public int addBook(Book book);

  /**
   * 根据ID删除图书
   * @param id
   * @return
   */
  public int deleteBookById(Integer id);

  /**
   * 修改图书信息
   * @param book
   * @return
   */
  public int updateBook(Book book);

  /**
   * 通过ID查询图书
   * @param id
   * @return
   */
  public Book queryBookById(Integer id);

  /**
   * 查询图书
   * @return
   */
  public List<Book> queryBooks();

  //总的记录数
  Integer queryForPageTotalCount();
  //当前页的数据
  List<Book> queryForPageItems(int begin, int pageSize);

  Integer queryForPageTotalCountByPrice(int min, int max);
  List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
