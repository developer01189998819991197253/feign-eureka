package demo;

import demo.web.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class HelloClientApplication {
    @Autowired
    HelloClient client;

    @RequestMapping("/")
    public String hello() {
        System.out.println("Hello Client is:" + client);
        return client.hello();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloClientApplication.class, args);
    }

}
