package com.truck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
