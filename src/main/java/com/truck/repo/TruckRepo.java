package com.truck.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truck.entity.Truck;

public interface TruckRepo extends JpaRepository<Truck, Integer> {

}
