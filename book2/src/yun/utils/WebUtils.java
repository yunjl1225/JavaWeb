package yun.utils;

import org.apache.commons.beanutils.BeanUtils;
import yun.pojo.User;

import java.util.Map;

/**
 * @author Yunjl
 * @create 2021-05-14 11:47
 */
public class WebUtils {
  /**
   * beanutils中的一个功能：把所有Map对象的值都注入到bean对象中
   * 复用代码
     *  HttpServletRequest
     *  Dao层
     *  Service层
     *  Web层
   *  都可以使用这个工具
   *    使用方法：
   *      把所有请求的对象都注入到user对象中
   *      User user = WebUtils.copyParamBean(req.getParameterMap(), new User());
   */
  public static <T>  T copyParamBean(Map value, T bean){
    try {

      System.out.println("注入之前" + bean);
      //把所有Map对象的值都注入到bean对象中
      BeanUtils.populate(bean,value);
      System.out.println("注入之后" + bean);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return bean;
  }

  /**
   * 类型转换string-->int
   * @param strInt
   * @param defaultValue
   * @return  成功则返回转换后的值，失败的话则返回默认值
   */
  public static int parseInt(String strInt, int defaultValue ){
    try {
      return Integer.parseInt(strInt);
    } catch (Exception e) {
//      e.printStackTrace();
    }
    return defaultValue;
  }
}

