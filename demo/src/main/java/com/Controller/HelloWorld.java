package com.Controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by hutianbao on 2016/7/19.
 */
@RestController
@RequestMapping("/springboot")
public class HelloWorld {
  @RequestMapping(value = "/{name}", method = RequestMethod.GET)
  public String sayWorld(@PathVariable("name") String name) {
    return "Hello " + name;
  }
}
