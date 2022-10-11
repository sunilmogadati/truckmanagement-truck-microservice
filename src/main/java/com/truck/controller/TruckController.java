package com.truck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.truck.service.TruckService;

@RestController
@RequestMapping("/api/v1/truck")
public class TruckController {

  @Autowired
  TruckService service;
  
}
