package com.truck.entity;

import com.truck.enums.Type;
import com.truck.model.Route;
import java.util.List;
import javax.persistence.*;

@Entity(name = "TruckEntity")
@Table(name = "trucks")
public class Truck {

  @Id
  @Column(name = "truck_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "truck_make")
  private String make;

  @Column(name = "truck_model")
  private String model;

  @Column(name = "truck_year")
  private int year;

  @Column(name = "truck_weight")
  private String weight;

  @Column(name = "truck_volume")
  private String volume;

  @Column(name = "truck_mpg")
  private int mpg;

  @Column(name = "truck_space")
  private String space;

  @Column(name = "truck_type", columnDefinition = "ENUM('GAS','HYBRID','ELECTRIC')")
  @Enumerated(EnumType.STRING)
  private Type type;

  private String img;
  
  @Transient
  private List<Route> routes;

  public Truck() {}

  public Truck(int id, String make, String model, int year, String weight, String volume, int mpg,
      String space, Type type, String img, List<Route> routes) {
    super();
    this.id = id;
    this.make = make;
    this.model = model;
    this.year = year;
    this.weight = weight;
    this.volume = volume;
    this.mpg = mpg;
    this.space = space;
    this.type = type;
    this.img = img;
    this.routes = routes;
  }

  public Truck(int id, String make, String model, int year) {
    this(id, make, model, year, "0kg", "0 cu. m", 0, "0 cu. m", Type.GAS, null, null);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
    return "Truck [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year
        + ", weight=" + weight + ", volume=" + volume + ", mpg=" + mpg + ", space=" + space
        + ", type=" + type + ", img=" + img + ", routes=" + routes + "]";
  }

}
