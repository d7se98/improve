package com.example;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by hutianbao on 2016/7/21.
 */
@RestController
public class GreetingController {
  List<Greeting> list;

  public GreetingController() {
    list = new ArrayList<>();
    Greeting obj1 = new Greeting("A", "a");
    Greeting obj2 = new Greeting("B", "b");
    Greeting obj3 = new Greeting("C", "c");
    list.add(obj1);
    list.add(obj2);
    list.add(obj3);
  }

  //  private static final String TEMPLATE = "Hello, %s!";
  @RequestMapping("/greeting")
  public ResponseEntity<Map<String, Object>> greeting(
//          @RequestParam(value = "name", required = false, defaultValue = "World")
//          String name,String test
  ) {
    Map<String, Object> resultMap = new HashMap<>();

//    Greeting greeting = new Greeting("htb","123");
    Collection<Greeting> greetings = list;
//    greetings.add(linkTo(methodOn(GreetingController.class).greeting()).withSelfRel());

//    return new ResponseEntity<Greeting>((Greeting) list, HttpStatus.OK);
//    for(Greeting obj:greetings){
//      obj.add(linkTo(methodOn(GreetingController.class).greeting()).withSelfRel());
//      obj.add(linkTo(methodOn(GreetingController.class).delete(obj.getTest())).withSelfRel());
//    }
    if (greetings.size() > 0) {
      Greeting g = greetings.iterator().next();
      g.add(linkTo(methodOn(GreetingController.class).delete(g.getTest())).withSelfRel());
    }
    resultMap.put("errorCode", 0);
    resultMap.put("data", greetings);
    resultMap.put("errorMsg", "");

    return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
  }


  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  public ResponseEntity delete(@PathVariable("id") String id){
    return null;
  }

  @RequestMapping("/id")
  public ResponseEntity id(@RequestParam(value = "id", required = false, defaultValue = "0") int id){
    Greeting g = list.get(id);
    g.add(linkTo(methodOn(GreetingController.class).delete(id+"")).withSelfRel());
    g.add(linkTo(methodOn(GreetingController.class).id(id)).withSelfRel());
    return new ResponseEntity<Greeting>(g,HttpStatus.OK);
  }


}
