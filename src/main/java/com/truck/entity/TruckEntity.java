package com.truck.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "TruckEntity")
@Table(name = "truck")
@NoArgsConstructor
@AllArgsConstructor
public class TruckEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "truck_id")
	@GeneratedValue
	private Integer truck_id;
	
	String make;
	String model;
	Integer year;
	
}
