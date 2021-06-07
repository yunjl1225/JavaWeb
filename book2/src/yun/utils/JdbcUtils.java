package yun.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 管理数据库连接的工具类
 * @author Yunjl
 * @create 2021-05-09 23:59
 */
public class JdbcUtils {
  //创建ThreadLocal对象，用于事务的回滚
  private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
  private static DataSource dataSource;
  static{
    try {
      Properties pro = new Properties();
      //加载配置文件,生成一个流
      InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
      //通过Properties对象获取流中的数据
      pro.load(is);
      //创建数据库连接池
      dataSource= DruidDataSourceFactory.createDataSource(pro);

      //测试数据库连接
//      System.out.println(dataSource.getConnection());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {

  }

  /**
   * 获取数据库连接池中的连接
   * @return  返回null说明获取连接失败
   */
  public static Connection getConnection(){

    //首先通过上卖弄的静态代码块创建数据库连接池等操作
    //连接数据库
    Connection conn = conns.get();
    if(conn == null){
      try {
        conn = dataSource.getConnection();//从数据库连接池获取连接

        conns.set(conn);//保存到ThreadLocal对象中，供后面的jdbc操作使用

        conn.setAutoCommit(false);//设置为手动管理事务

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return conn;

  }

  /**
   * 提交事务，并关闭释放连接
   */
  public static void commitAndClose(){
    Connection conn = conns.get();

    if(conn != null){   //如果不为null，说明之前使用过连接操作过数据库

      try {
        conn.commit();    //提交事务
      } catch (SQLException e) {
        e.printStackTrace();
      }finally {
        try {
          conn.close();     //关闭连接释放资源
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    //一定要执行remove()操作，否则会出错   （因为TomCat服务器底层使用了线程池技术）
    conns.remove();
  }

  /**
   * 回滚事务，并关闭释放连接
   */
  public static void rollbackAndClose(){
    Connection conn = conns.get();

    if(conn != null){   //如果不为null，说明之前使用过连接操作过数据库

      try {
        conn.rollback();    //回滚事务
      } catch (SQLException e) {
        e.printStackTrace();
      }finally {
        try {
          conn.close();     //关闭连接释放资源
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    //一定要执行remove()操作，否则会出错   （因为TomCat服务器底层使用了线程池技术）
    conns.remove();
  }



  /**
   * 关闭数据库的连接,放回数据库连接池
   *//*
  public static void close(Connection conn){

    if(conn != null){
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

  }*/
}
