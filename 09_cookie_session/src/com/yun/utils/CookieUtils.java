package com.yun.utils;

import javax.servlet.http.Cookie;

/**
 * @author Yunjl
 * @create 2021-05-17 9:49
 */
public class CookieUtils {
  /**
   * 查找指定名称的cookie对象
   * @param name
   * @param cookies
   * @return
   */
  public static Cookie fingCookie(String name,Cookie[] cookies){
    if(name == null || cookies==null || cookies.length == 0){
      return null;
    }
    for (Cookie cookie : cookies) {
      if(name.equals(cookie.getName())){
        return cookie;
      }
    }
    return null;
  }
}
