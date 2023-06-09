package com.AppsFactory.GetwayService;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication

@EnableDiscoveryClient
public class GetwayServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(GetwayServiceApplication.class, args);
    }

}
