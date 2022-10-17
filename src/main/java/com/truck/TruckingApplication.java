package com.truck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TruckingApplication {

  public static void main(String[] args) {
    SpringApplication.run(TruckingApplication.class, args);
    System.out.println("Ready");
  }

}
