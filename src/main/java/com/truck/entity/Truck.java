package com.truck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.truck.enums.Type;

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

  public Truck() {
    super();
  }

  public Truck(int truck_id, String make, String model, int yr, String weight, String volume,
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

  public Truck(String make, String model, int yr) {
    super();
    this.make = make;
    this.model = model;
    this.yr = yr;
    weight = "0kg";
    volume = "0 cu. m";
    mpg = 0;
    space = volume;
    type = Type.GAS;
    truck_id = -1;
  }

  public int getTruck_id() {
    return this.truck_id;
  }

  public String getMake() {
    return this.make;
  }

  public String getModel() {
    return this.model;
  }

  public int getYr() {
    return this.yr;
  }

  public String getWeight() {
    return this.weight;
  }

  public String getVolume() {
    return this.volume;
  }

  public int getMpg() {
    return this.mpg;
  }

  public String getSpace() {
    return this.space;
  }

  public Type getType() {
    return this.type;
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

  public void setYr(final int yr) {
    this.yr = yr;
  }

  public void setWeight(final String weight) {
    this.weight = weight;
  }

  public void setVolume(final String volume) {
    this.volume = volume;
  }

  public void setMpg(final int mpg) {
    this.mpg = mpg;
  }

  public void setSpace(final String space) {
    this.space = space;
  }

  public void setType(final Type type) {
    this.type = type;
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
    if (this.getYr() != other.getYr())
      return false;
    if (this.getMpg() != other.getMpg())
      return false;
    final Object this$make = this.getMake();
    final Object other$make = other.getMake();
    if (this$make == null ? other$make != null : !this$make.equals(other$make))
      return false;
    final Object this$model = this.getModel();
    final Object other$model = other.getModel();
    if (this$model == null ? other$model != null : !this$model.equals(other$model))
      return false;
    final Object this$weight = this.getWeight();
    final Object other$weight = other.getWeight();
    if (this$weight == null ? other$weight != null : !this$weight.equals(other$weight))
      return false;
    final Object this$volume = this.getVolume();
    final Object other$volume = other.getVolume();
    if (this$volume == null ? other$volume != null : !this$volume.equals(other$volume))
      return false;
    final Object this$space = this.getSpace();
    final Object other$space = other.getSpace();
    if (this$space == null ? other$space != null : !this$space.equals(other$space))
      return false;
    final Object this$type = this.getType();
    final Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type))
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
    result = result * PRIME + this.getYr();
    result = result * PRIME + this.getMpg();
    final Object $make = this.getMake();
    result = result * PRIME + ($make == null ? 43 : $make.hashCode());
    final Object $model = this.getModel();
    result = result * PRIME + ($model == null ? 43 : $model.hashCode());
    final Object $weight = this.getWeight();
    result = result * PRIME + ($weight == null ? 43 : $weight.hashCode());
    final Object $volume = this.getVolume();
    result = result * PRIME + ($volume == null ? 43 : $volume.hashCode());
    final Object $space = this.getSpace();
    result = result * PRIME + ($space == null ? 43 : $space.hashCode());
    final Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "Truck(truck_id=" + this.getTruck_id() + ", make=" + this.getMake() + ", model="
        + this.getModel() + ", yr=" + this.getYr() + ", weight=" + this.getWeight() + ", volume="
        + this.getVolume() + ", mpg=" + this.getMpg() + ", space=" + this.getSpace() + ", type="
        + this.getType() + ")";
  }
}
