package com.truck.model;

import java.time.LocalDate;
import com.truck.enums.Status;

public class TruckRoute {

  private int id;
  private LocalDate startDate;
  private LocalDate endDate;
  private String source;
  private String destination;
  private Status status;

  public TruckRoute() {}

  public TruckRoute(int id, LocalDate startDate, LocalDate endDate, String source,
      String destination, Status status) {
    super();
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.source = source;
    this.destination = destination;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
    return "TruckRoute [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate
        + ", source=" + source + ", destination=" + destination + ", status=" + status + "]";
  }

}
