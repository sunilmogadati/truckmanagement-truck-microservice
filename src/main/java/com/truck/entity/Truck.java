package com.truck.entity;


import javax.persistence.*;
import lombok.*;
import com.truck.enums.Type;

@Data
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

}
