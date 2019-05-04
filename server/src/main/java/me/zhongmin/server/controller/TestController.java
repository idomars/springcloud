package me.zhongmin.server.controller;

import lombok.extern.slf4j.Slf4j;
import me.zhongmin.server.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TestController {
    @Autowired
    private DiscoveryClient client;
    @Autowired
    private GirlConfig girlConfig;

    @Value("${form}")
    String form;


    @RequestMapping("form")
    @RefreshScope
    public String form(){
        print(client);
        log.info("/hello,form ====="+form);
        return form;
    }

    @RequestMapping("girl")
    public String girl(){
        print(client);
        log.info("/girl,girl ====="+girlConfig.toString());
        return girlConfig.toString();
    }

    public void print(DiscoveryClient client){
        for( String s :  client.getServices()){
            System.out.println("services " + s);
            List<ServiceInstance> serviceInstances =  client.getInstances(s);
            for(ServiceInstance si : serviceInstances){
                System.out.println("    services:" + s + ":getHost()=" + si.getHost());
                System.out.println("    services:" + s + ":getPort()=" + si.getPort());
                System.out.println("    services:" + s + ":getServiceId()=" + si.getServiceId());
                System.out.println("    services:" + s + ":getUri()=" + si.getUri());
                System.out.println("    services:" + s + ":getMetadata()=" + si.getMetadata());
            }

        }

    }
}
