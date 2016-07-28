package com.example;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by hutianbao on 2016/7/20.
 */
@Repository
@RestController
public class GreetingController {
  @PersistenceUnit
  private EntityManagerFactory entityManagerFactory;
  List<Greeting> list;
  public GreetingController(){
    Greeting obj1 =new Greeting(1,"htb","市场");
    Greeting obj2 =new Greeting(2,"hc","采购");
    Greeting obj3 =new Greeting(3,"hc1","采购1");
    Greeting obj4 =new Greeting(4,"hc2","采购2");
    Greeting obj5 =new Greeting(5,"hc3","采购2");
    list =new ArrayList<>();
    list.add(obj1);
    list.add(obj2);
    list.add(obj3);
    list.add(obj4);
    list.add(obj5);

  }

  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/greeting")
  public String greeting() throws IOException {
    FileWriter fw = new FileWriter("c:\\TXT\\suncity.txt");//,加参数true为可追加模式
    String path = "c:\\TXT";
    File filename = new File(path);
    if (!filename.exists()) {
      filename.mkdirs();
    }
    try {
      fw.write("员工姓名||身份证||主账号（P13账号）||从账号||P09工号||P09机构编码||总公司名称||分公司名称||中支公司名称||所在部门名称||权限编码||权限名称\r\n");
      for(Greeting greeting:list){
        fw.write(greeting.getId()+"||"+greeting.getName()+"||"+greeting.getDeptName()+"\r\n");
      }
      fw.close();
    } catch (IOException e1) {
      e1.printStackTrace();
//      System.exit(-1);非正常退出情况异常
    }
    StringBuilder  buffer = new StringBuilder ();
    for (Greeting buff:list) {
      buffer.append("||"+buff.getId() + "||" + buff.getName() + "||" + buff.getDeptName());
      buffer.append("\n");
    }

      return buffer.toString();
  }

}
