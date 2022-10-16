package com.truck.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.truck.enums.Status;

public class Route {
  
  String routeID;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate startDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate endDate;
  private String source;
  private String destination;
  private Status status;
  
  public Route() {}

  public Route(String routeID, LocalDate startDate, LocalDate endDate, String source,
      String destination, Status status) {
    super();
    this.routeID = routeID;
    this.startDate = startDate;
    this.endDate = endDate;
    this.source = source;
    this.destination = destination;
    this.status = status;
  }

  public String getRouteID() {
    return routeID;
  }

  public void setRouteID(String routeID) {
    this.routeID = routeID;
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
    return "Route [routeID=" + routeID + ", startDate=" + startDate + ", endDate=" + endDate
        + ", source=" + source + ", destination=" + destination + ", status=" + status + "]";
  }

}
