package com.yun.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContextListener 监听器
 * @author Yunjl
 * @create 2021-05-11 20:11
 */
public class MyServletContextListenerImpl implements ServletContextListener{
  /**
   * 在 ServletContext 对象创建之后马上调用，做初始化
   */
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("ServletContext 对象被创建了");
  }
  /**
   * 在 ServletContext 对象销毁之后调用
   */
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("ServletContext 对象被销毁了");

  }
}
