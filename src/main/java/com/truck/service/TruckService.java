package com.truck.service;

import com.truck.entity.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truck.repo.TruckRepo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TruckService {


  private TruckRepo repo;

  @Autowired
  public TruckService(TruckRepo repo) {
    this.repo = repo;
  }

  @Transactional(readOnly = true)
  public Truck getTruckById(int id) {
    return repo.findById(id).orElseThrow(() -> new RuntimeException("Unable to find truck with ID: " + id));
  }

  @Transactional(readOnly = true)
  public List<Truck> getAllTrucks() {
    return repo.findAll();
  }

  @Transactional(readOnly = true)
  public List<Truck> getAllTrucksConditional(int conditional, String data) {
    List<Truck> truckList = repo.findAll();
    List<Truck> newList = new ArrayList<>();

    switch (conditional) {
      case 0:
        for (Truck truck : truckList) {
          if (truck.getMake().equalsIgnoreCase(data)) {
            newList.add(truck);
          }
        }
        break;

      case 1:
        for (Truck truck : truckList) {
          if (truck.getModel().equalsIgnoreCase(data)) {
            newList.add(truck);
          }
        }
        break;

      case 2:
        for (Truck truck : truckList) {
          try {
            if (truck.getYear() == Integer.parseInt(data)) {
              newList.add(truck);
            }
          } catch (NumberFormatException e) {
            e.printStackTrace();
          }
        }
        break;
    }
    return newList;
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Truck addTruck(Truck truck) {
    return repo.save(truck);
  }

  @Transactional
  public void deleteTruck(int id) {
    Truck truck = repo.findById(id).orElseThrow(() -> new RuntimeException("Unable to find truck with ID: " + id));
    repo.delete(truck);
  }
}
