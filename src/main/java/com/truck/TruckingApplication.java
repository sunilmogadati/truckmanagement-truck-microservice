package com.truck;

import com.truck.repo.TruckRepo;
import com.truck.service.TruckService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TruckingApplication {

  public static void main(String[] args) {
    SpringApplication.run(TruckingApplication.class, args);
    System.out.println("Ready");
  }

}
