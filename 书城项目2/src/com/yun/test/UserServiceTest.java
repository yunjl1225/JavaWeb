package com.yun.test;

import com.yun.pojo.User;
import com.yun.service.UserService;
import com.yun.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 测试业务层的实现类
 * @author Yunjl
 * @create 2021-05-10 11:51
 */
public class UserServiceTest {
  //创建对象
  UserService userService = new UserServiceImpl();

  @Test
  public void registUser() {
    userService.registUser(new User(null,"yunjl","122500","yunjl@qq.com"));
  }

  @Test
  public void login() {
    System.out.println(userService.login(new User(null,"yunjl","122500",null)));
  }

  @Test
  public void existsUsername() {
    if (userService.existsUsername("wzg16888")) {
      System.out.println("用户名已存在！");
    } else {
      System.out.println("用户名可用！");
    }
  }
}
