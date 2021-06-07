package yun.test;


import org.junit.Test;
import yun.dao.UserDao;
import yun.dao.impl.UserDaoImpl;
import yun.pojo.User;

/**
 * @author Yunjl
 * @create 2021-05-10 11:03
 */
public class UserDaoTest {
  //创建一个UserDaoImpl()实现类的对象
  UserDao userDao= new UserDaoImpl();

  @Test
  public void queryUserByUsername() {
    if(userDao.queryUserByUsername("admin") == null){
      System.out.println("用户名可用");  //创建新用户时的检查
    }else{
      System.out.println("用户名已存在");
    }
  }

  @Test
  public void queryUserByUsernameAndPassword() {
    if ( userDao.queryUserByUsernameAndPassword("admin","admin1234") == null) {
      System.out.println("用户名或密码错误，登录失败");
    } else {
      System.out.println("查询成功");
    }
  }

  @Test
  public void saveUser() {
    System.out.println( userDao.saveUser(new User(null,"yun", "122500", "yun@qq.com")) );
  }
}
