package com.truck.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.truck.enums.Status;
import com.truck.enums.Type;

public class TruckTransportation {
  // TRUCK PROPERTIES
  int truckId;
  String make;
  String model;
  int year;
  String weight;
  String volume;
  int mpg;
  String space;
  Type type;

  // TRANSPORTATION PROPERTIES
  String routeId;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate startDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate endDate;
  private String source;
  private String destination;
  private Status status;

  public TruckTransportation() {}

  public int getTruckId() {
    return truckId;
  }

  public void setTruckId(int truckId) {
    this.truckId = truckId;
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

  public String getRouteId() {
    return routeId;
  }

  public void setRouteId(String routeId) {
    this.routeId = routeId;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "TruckTransportation [truckId=" + truckId + ", make=" + make + ", model=" + model
        + ", year=" + year + ", weight=" + weight + ", volume=" + volume + ", mpg=" + mpg
        + ", space=" + space + ", type=" + type + ", routeId=" + routeId + ", startDate="
        + startDate + ", endDate=" + endDate + ", source=" + source + ", destination=" + destination
        + ", status=" + status + "]";
  }
}
