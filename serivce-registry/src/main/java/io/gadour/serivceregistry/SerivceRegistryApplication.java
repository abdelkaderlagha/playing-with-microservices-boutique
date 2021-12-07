package io.gadour.serivceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SerivceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SerivceRegistryApplication.class, args);
    }

}
