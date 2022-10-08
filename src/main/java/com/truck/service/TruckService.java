package com.truck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truck.repo.TruckRepo;

@Service
public class TruckService {

  @Autowired
  private TruckRepo repo;
}
