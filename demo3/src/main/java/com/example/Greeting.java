package com.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by hutianbao on 2016/7/21.
 */
public class Greeting extends ResourceSupport {

  private  String content;
  private String test;
  @JsonCreator
  public Greeting( @JsonProperty("content") String content,@JsonProperty("test") String test) {
    this.content = content;
    this.test=test;
  }

  public String getContent() {
    return content;
  }

  public String getTest() {
    return test;
  }
}
