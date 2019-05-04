package me.zhongmin.server;

import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import me.zhongmin.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@Slf4j
public class ServerApplication {
    @Autowired
    private DiscoveryClient client;
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @RequestMapping("hello")
    public String helloEureka(){
        print(client);
        return "hello i am from cloud-server;";
    }

    @RequestMapping("/user/{userid}")
    public String hellouser(@PathVariable("userid")String userid){
        print(client);
        log.info("/hello,host");
        return userid+"_userid";
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
