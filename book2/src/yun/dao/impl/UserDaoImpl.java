package yun.dao.impl;


import yun.dao.UserDao;
import yun.pojo.User;

/**
 * UserDao接口的实现类，
 * 需要继承BaseDao类和实现UserDao接口
 * @author Yunjl
 * @create 2021-05-10 10:51
 */
public class UserDaoImpl extends BaseDao implements UserDao {

  /**
   * 根据用户名查询
   * @param username 用户名
   * @return
   */
  @Override
  public User queryUserByUsername(String username) {
    String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
    return queryForOne(User.class, sql, username);
  }

  /**
   * 根据用户名和密码查询
   * @param username
   * @param password
   * @return
   */
  @Override
  public User queryUserByUsernameAndPassword(String username, String password) {
    String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
    return queryForOne(User.class, sql, username,password);
  }

  /**
   * 保存用户信息
   * @param user
   * @return
   */
  @Override
  public int saveUser(User user) {
    String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
    return update(sql, user.getUsername(),user.getPassword(),user.getEmail());
  }

}
