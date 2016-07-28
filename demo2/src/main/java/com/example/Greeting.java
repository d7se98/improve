package com.example;

/**
 * Created by hutianbao on 2016/7/20.
 */
public class Greeting {

  private final long id;
  private final String name;
  private final String deptName;

  public Greeting(long id, String name,String deptName) {
    this.id = id;
    this.name = name;
    this.deptName=deptName;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDeptName() {
    return deptName;
  }
}
