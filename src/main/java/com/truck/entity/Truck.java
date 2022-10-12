package com.truck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.truck.enums.Type;
import lombok.*;

import javax.persistence.*;

@Entity(name = "trucks")
@Table(name = "trucks")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
}
