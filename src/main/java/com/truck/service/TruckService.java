package com.truck.service;

import com.truck.entity.Route;
import com.truck.entity.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.truck.repo.TruckRepo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TruckService {

  @Autowired
  private TruckRepo repo;

  @Autowired
  private CircuitBreakerFactory circuitBreakerFactory;

  RestTemplate restTemplate = new RestTemplate();
  @Value("${server.url}")
  String serverURL;

  @Transactional(readOnly = true)
  public Truck getTruckById(int id) {
    return repo.findById(id)
        .orElseThrow(() -> new RuntimeException("Unable to find truck with ID: " + id));
  }

  @Transactional(readOnly = true)
  public List<Truck> getAllTrucks() {
    return repo.findAll();
  }

  @Transactional(readOnly = true)
  public List<Truck> getAllTrucksExt(Map<String, String> query) {
    if (query.isEmpty()) {
      return repo.findAll();
    }
    List<Truck> truckList = repo.findAll();
    List<Truck> newList = new ArrayList<>();
    String queryString = "";
    int page = 1;
    int pageSize = -1;
    newList.addAll(truckList);

    queryString = query.get("make");
    if (queryString != null) {
      for (Truck truck : truckList) {
        if (!queryString.equalsIgnoreCase(truck.getMake())) {
          newList.remove(truck);
        }
      }
    }

    queryString = query.get("model");
    if (queryString != null) {
      for (Truck truck : truckList) {
        if (!queryString.equalsIgnoreCase(truck.getModel())) {
          newList.remove(truck);
        }
      }
    }

    queryString = query.get("year");
    if (queryString != null) {
      for (Truck truck : truckList) {
        try {
          if (!(truck.getYear() == Integer.parseInt(queryString))) {
            newList.remove(truck);
          }
        } catch (NumberFormatException e) {
          e.printStackTrace();
        }
      }
    }

    queryString = query.get("mpg");
    if (queryString != null) {
      for (Truck truck : truckList) {
        try {
          if (!(truck.getMpg() == Integer.parseInt(queryString))) {
            newList.remove(truck);
          }
        } catch (NumberFormatException e) {
          e.printStackTrace();
        }
      }
    }

    queryString = query.get("type");
    if (queryString != null) {
      for (Truck truck : truckList) {
        if (!(truck.getType().toString().equalsIgnoreCase(queryString))) {
          newList.remove(truck);
        }
      }
    }

    queryString = query.get("page");
    try {
      page = Integer.parseInt(queryString);
      if (page < 1) {
        page = 1;
      }
    } catch (NumberFormatException e) {
      page = 1;
    }

    queryString = query.get("page-size");
    try {
      pageSize = Integer.parseInt(queryString);
      if (pageSize < 1) {
        pageSize = -1;
      }
    } catch (NumberFormatException e) {
      pageSize = -1;
    }

    if (pageSize == -1) {
      return newList;
    }

    List<Truck> pageList = new ArrayList<>();
    int index = 0;
    for (int i = 0; i < pageSize; i++) {
      index = (((page - 1) * pageSize) + i);
      if (index < newList.size()) {
        pageList.add(newList.get(index));
      }
    }
    return pageList;
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
    Truck truck = repo.findById(id)
        .orElseThrow(() -> new RuntimeException("Unable to find truck with ID: " + id));
    repo.delete(truck);
  }

  public List<Route> getAllRoutes() {
    CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
    ArrayList arrayList = new ArrayList();
    return circuitBreaker.run(() -> restTemplate.getForObject(serverURL + "/api/vi/transportation/route", List.class),
            throwable -> arrayList);
  }
}
