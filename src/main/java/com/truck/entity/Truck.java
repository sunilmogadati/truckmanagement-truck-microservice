package com.truck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class was de-Lomboked by Erik to facilitate testing. Direct any comments appropriately.
 * 
 * @author Pirai Ojeda
 *
 */
@Entity(name = "TruckEntity")
@Table(name = "truck")
public class Truck {
  @Id
  @Column(name = "truck_id")
  @GeneratedValue
  private int truck_id;
  String make;
  String model;
  int year;

  public int getTruck_id() {
    return this.truck_id;
  }

  public String getMake() {
    return this.make;
  }

  public String getModel() {
    return this.model;
  }

  public int getYear() {
    return this.year;
  }

  public void setTruck_id(final int truck_id) {
    this.truck_id = truck_id;
  }

  public void setMake(final String make) {
    this.make = make;
  }

  public void setModel(final String model) {
    this.model = model;
  }

  public void setYear(final int year) {
    this.year = year;
  }

  @Override
  public boolean equals(final Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Truck))
      return false;
    final Truck other = (Truck) o;
    if (!other.canEqual((Object) this))
      return false;
    if (this.getTruck_id() != other.getTruck_id())
      return false;
    if (this.getYear() != other.getYear())
      return false;
    final Object this$make = this.getMake();
    final Object other$make = other.getMake();
    if (this$make == null ? other$make != null : !this$make.equals(other$make))
      return false;
    final Object this$model = this.getModel();
    final Object other$model = other.getModel();
    if (this$model == null ? other$model != null : !this$model.equals(other$model))
      return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Truck;
  }

  @Override
  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    result = result * PRIME + this.getTruck_id();
    result = result * PRIME + this.getYear();
    final Object $make = this.getMake();
    result = result * PRIME + ($make == null ? 43 : $make.hashCode());
    final Object $model = this.getModel();
    result = result * PRIME + ($model == null ? 43 : $model.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "Truck(truck_id=" + this.getTruck_id() + ", make=" + this.getMake() + ", model="
        + this.getModel() + ", year=" + this.getYear() + ")";
  }

  public Truck(final int truck_id, final String make, final String model, final int year) {
    this.truck_id = truck_id;
    this.make = make;
    this.model = model;
    this.year = year;
  }

  public Truck() {}
}
