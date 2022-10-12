package com.truck.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truck.entity.TruckEntity;

public interface TruckRepo extends JpaRepository<TruckEntity, Integer> {

}
