package com.example;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hutianbao on 2016/8/8.
 */

@RestController
public class ComputeController {

  private final Logger logger = Logger.getLogger(getClass());

  @Autowired
  private DiscoveryClient client;

  @RequestMapping(value = "/Hello" ,method = RequestMethod.GET)
  public String add(@RequestParam String name) {
    ServiceInstance instance = client.getLocalServiceInstance();
    String Hello="Hello:"+name;
    logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + Hello);
    return Hello;
  }
}
