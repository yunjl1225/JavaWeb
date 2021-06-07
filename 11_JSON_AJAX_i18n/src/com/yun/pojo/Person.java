package com.yun.pojo;

/**
 * @author Yunjl
 * @create 2021-05-18 22:01
 */
public class Person {
  private Integer id;
  private String name;

  public Person(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Person() {

  }

  @Override
  public String toString() {
    return "Person{" +
      "id=" + id +
      ", name='" + name + '\'' +
      '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
