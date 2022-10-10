package com.truck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "TruckEntity")
@Table(name = "truck")
public class Truck {
  @Id
  @Column(name = "truck_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer truck_id;
  String make;
  String model;
  Integer year;

  public Integer getTruck_id() {
    return this.truck_id;
  }

  public String getMake() {
    return this.make;
  }

  public String getModel() {
    return this.model;
  }

  public Integer getYear() {
    return this.year;
  }

  public void setTruck_id(final Integer truck_id) {
    this.truck_id = truck_id;
  }

  public void setMake(final String make) {
    this.make = make;
  }

  public void setModel(final String model) {
    this.model = model;
  }

  public void setYear(final Integer year) {
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
    final Object this$truck_id = this.getTruck_id();
    final Object other$truck_id = other.getTruck_id();
    if (this$truck_id == null ? other$truck_id != null : !this$truck_id.equals(other$truck_id))
      return false;
    final Object this$year = this.getYear();
    final Object other$year = other.getYear();
    if (this$year == null ? other$year != null : !this$year.equals(other$year))
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
    final Object $truck_id = this.getTruck_id();
    result = result * PRIME + ($truck_id == null ? 43 : $truck_id.hashCode());
    final Object $year = this.getYear();
    result = result * PRIME + ($year == null ? 43 : $year.hashCode());
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

  protected Truck(final Integer truck_id, final String make, final String model,
      final Integer year) {
    this.truck_id = truck_id;
    this.make = make;
    this.model = model;
    this.year = year;
  }

  public Truck(final String make, final String model, final Integer year) {
    this((Integer) null, make, model, year);
  }

  public Truck() {}
}
