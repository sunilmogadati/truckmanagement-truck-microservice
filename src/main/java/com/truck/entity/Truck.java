package com.truck.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.truck.enums.Type;
import lombok.Data;

@Data
@Entity(name = "TruckEntity")
@Table(name = "truck")
public class Truck {

  @Id
  @Column(name = "truck_id")
  @GeneratedValue
  private int truck_id;

  String make;
  String model;
  int yr;
  String weight;
  String volume;
  int mpg;
  String space;
  Type type;

  public Truck() {}
}
