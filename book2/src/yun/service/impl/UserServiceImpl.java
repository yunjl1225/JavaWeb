package yun.service.impl;


import yun.dao.UserDao;
import yun.dao.impl.UserDaoImpl;
import yun.pojo.User;
import yun.service.UserService;

/**
 * 业务层的实现类
 * @author Yunjl
 * @create 2021-05-10 11:45
 */
public class UserServiceImpl implements UserService {
  //创建UserDaoImpl()实现类的对象,因为数据库是Dao操作的
  private UserDao userDao = new UserDaoImpl();

  /**
   * 注册保存
   * @param user
   */
  @Override
  public void registUser(User user) {
    userDao.saveUser(user);
  }

  /**
   * 登录
   * @param user
   * @return 如果返回null，说明登录失败，返回有值，登录成功.
   */
  @Override
  public User login(User user) {
    return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
  }

  /**
   * 检查 用户名是否可用
   * @param username
   * @return   返回false表示可用，返回true表示已存在
   */
  @Override
  public boolean existsUsername(String username) {

    if (userDao.queryUserByUsername(username) == null) {
      // 等于null,说明没查到，没查到表示可用
      return false;
    }
    return true;

  }
}
