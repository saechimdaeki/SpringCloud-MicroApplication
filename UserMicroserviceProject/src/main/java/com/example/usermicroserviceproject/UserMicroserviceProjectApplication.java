package com.example.usermicroserviceproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserMicroserviceProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMicroserviceProjectApplication.class, args);
    }

}
