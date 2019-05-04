package me.zhongmin.client.Controller;

import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class RibbonTestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/ribbon-hello")
    public String helloRibbon(){
        return restTemplate.getForEntity("http://SERVER/hello",String.class).getBody();
    }

    @RequestMapping("/girl")
    public String girl(){
        return restTemplate.getForEntity("http://SERVER/girl",String.class).getBody();
    }
}
