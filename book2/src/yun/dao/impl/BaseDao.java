package yun.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import yun.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 给别人复用代码
 * @author Yunjl
 * @create 2021-05-10 9:57
 */
public abstract class BaseDao {
  //使用dbutils操作数据库
  private QueryRunner runner = new QueryRunner();

  /**
   * update()方法用来执行insert、update、delete操作
   *
   * @return   返回-1说明失败，其他数值表示update影响的行数
   */
  public int update(String sql, Object... args) {
    Connection conn = JdbcUtils.getConnection();

    try {
      return runner.update(conn, sql, args);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }

  }

  /**
   * 查询一条数据（一个Javabean对象）
   * @param type    返回的对象类型
   * @param sql     执行的SQL语句
   * @param args    SQL对应的参数值
   * @param <T>     返回的类型的泛型
   * @return  返回null表示失败，
   */
  public <T> T queryForOne(Class<T> type,String sql,Object ...args){
    Connection conn = JdbcUtils.getConnection();
    try {
      return runner.query(conn,sql,new BeanHandler<>(type),args);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  /**
   * 查询多条数据（多个Javabean对象）使用list集合盛放
   * @return
   */
  public <T> List<T> queryForList(Class<T> type, String sql, Object ...args){
    Connection conn = JdbcUtils.getConnection();
    try {
      return runner.query(conn,sql,new BeanListHandler<T>(type),args);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  /**
   * 查询某行数据的单个属性值 (某行某列的数据)
   * @return
   */
  public Object queryForSingleValue(String sql, Object ...args){
    Connection conn = JdbcUtils.getConnection();
    try {
      return runner.query(conn,sql,new ScalarHandler(),args);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
