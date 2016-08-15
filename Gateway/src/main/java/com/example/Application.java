package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by hutianbao on 2016/7/20.
 */
@EnableZuulProxy
@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
//    new SpringApplicationBuilder(SpringApplication.class).web(true).run(args);
  }
  @Bean
  public HelloController accessFilter() {
    return new HelloController();
  }
}

