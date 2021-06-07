package com.yun.utils;
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
    Connection conn = null;
    try {
      conn = dataSource.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return conn;
  }

  /**
   * 关闭数据库的连接,放回数据库连接池
   */
  public static void close(Connection conn){

    if(conn != null){
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

  }
}
