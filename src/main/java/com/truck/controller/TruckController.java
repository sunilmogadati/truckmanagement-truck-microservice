package com.truck.controller;

import com.truck.entity.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.truck.service.TruckService;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/truck")
public class TruckController {

  private TruckService service;
  
  @Autowired
  public TruckController(TruckService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Truck> findTruckById(@PathVariable("id") int id) {
    Truck truck;

    try {
      truck = service.getTruckById(id);
    } catch (RuntimeException e) {
      return new ResponseEntity<Truck>(HttpStatus.NOT_FOUND);
    }

    return ResponseEntity.ok(truck);
  }

  @GetMapping
  public ResponseEntity<List<Truck>> findAllTrucks(@RequestParam Map<String, String> query) {
    return ResponseEntity.ok(service.getAllTrucksExt(query));
  }

  @GetMapping("/make/{value}")
  public ResponseEntity<List<Truck>> getAllTrucksByMake(@PathVariable("value") String value) {
    return ResponseEntity.ok(service.getAllTrucksConditional(0, value));
  }

  @GetMapping("/model/{value}")
  public ResponseEntity<List<Truck>> getAllTrucksByModel(@PathVariable("value") String value) {
    return ResponseEntity.ok(service.getAllTrucksConditional(1, value));
  }

  @GetMapping("/year/{value}")
  public ResponseEntity<List<Truck>> getAllTrucksByYear(@PathVariable("value") String value) {
    return ResponseEntity.ok(service.getAllTrucksConditional(2, value));
  }

  @PostMapping
  public ResponseEntity<Truck> addTruck(@RequestBody Truck truck) {
    return ResponseEntity.ok(service.addTruck(truck));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Truck> deleteTruck(@PathVariable("id") int id) {
    try {
      service.deleteTruck(id);
    } catch (RuntimeException e) {
      return new ResponseEntity<Truck>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<Truck>(HttpStatus.NO_CONTENT);
  }
}
