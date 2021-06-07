package com.yun.json;

import com.google.gson.reflect.TypeToken;
import com.yun.pojo.Person;

import java.util.List;

/**
 * 用于把json字符串转换为List
 * @author Yunjl
 * @create 2021-05-18 23:13
 */
public class PersonListType extends TypeToken<List<Person>>{
//使用gson-2.2.4.jar 提供的TypeToken类  泛型中写需要转换后的类型
}
