package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hutianbao on 2016/8/8.
 */
@RestController
public class HelloController {
  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }
}
