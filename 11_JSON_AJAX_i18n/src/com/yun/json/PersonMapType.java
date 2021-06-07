package com.yun.json;

import com.google.gson.reflect.TypeToken;
import com.yun.pojo.Person;

import java.util.Map;

/**用于把json字符串转换为map
 * @author Yunjl
 * @create 2021-05-18 23:19
 */
public class PersonMapType extends TypeToken<Map<Integer,Person>>{
  //使用gson-2.2.4.jar 提供的TypeToken类  泛型中写需要转换后的类型
}
