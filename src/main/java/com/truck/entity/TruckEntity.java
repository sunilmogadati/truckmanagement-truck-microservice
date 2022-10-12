package com.truck.entity;


import javax.persistence.*;
// import lombok.*;
import com.truck.enums.Type;

// @Data
@Entity(name = "TruckEntity")
@Table(name = "truck")
public class TruckEntity {

  @Id
  @Column(name = "truck_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int truck_id;

  String make;
  String model;
  int yr;
  String weight;
  String volume;
  int mpg;
  String space;

  @Column(columnDefinition = "ENUM('GAS', 'HYBRID', 'ELECTRIC')")
  @Enumerated(EnumType.STRING)
  Type type;

  public TruckEntity() {}
  
  public TruckEntity(int truck_id, String make, String model, int yr, String weight, String volume,
      int mpg, String space, Type type) {
    super();
    this.truck_id = truck_id;
    this.make = make;
    this.model = model;
    this.yr = yr;
    this.weight = weight;
    this.volume = volume;
    this.mpg = mpg;
    this.space = space;
    this.type = type;
  }

  public int getTruck_id() {
    return truck_id;
  }

  public void setTruck_id(int truck_id) {
    this.truck_id = truck_id;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYr() {
    return yr;
  }

  public void setYr(int yr) {
    this.yr = yr;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public String getVolume() {
    return volume;
  }

  public void setVolume(String volume) {
    this.volume = volume;
  }

  public int getMpg() {
    return mpg;
  }

  public void setMpg(int mpg) {
    this.mpg = mpg;
  }

  public String getSpace() {
    return space;
  }

  public void setSpace(String space) {
    this.space = space;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "TruckEntity [truck_id=" + truck_id + ", make=" + make + ", model=" + model + ", yr="
        + yr + ", weight=" + weight + ", volume=" + volume + ", mpg=" + mpg + ", space=" + space
        + ", type=" + type + "]";
  }

}
