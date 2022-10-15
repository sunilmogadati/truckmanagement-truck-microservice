package com.truck.model;

import java.util.List;
import com.truck.enums.Type;

public class TruckTransportation {
  // TRUCK PROPERTIES
  int truckID;
  String make;
  String model;
  int year;
  String weight;
  String volume;
  int mpg;
  String space;
  Type type;
  String img;

  // TRANSPORTATION PROPERTIES
  List<Route> routes;

  public TruckTransportation() {}

  public int getTruckID() {
    return truckID;
  }

  public void setTruckID(int truckID) {
    this.truckID = truckID;
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

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
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


  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public List<Route> getRoutes() {
    return routes;
  }

  public void setRoutes(List<Route> routes) {
    this.routes = routes;
  }

  @Override
  public String toString() {
    return "TruckTransportation [truckID=" + truckID + ", make=" + make + ", model=" + model
        + ", year=" + year + ", weight=" + weight + ", volume=" + volume + ", mpg=" + mpg
        + ", space=" + space + ", type=" + type + ", img=" + img + ", routes=" + routes + "]";
  }
 
}
