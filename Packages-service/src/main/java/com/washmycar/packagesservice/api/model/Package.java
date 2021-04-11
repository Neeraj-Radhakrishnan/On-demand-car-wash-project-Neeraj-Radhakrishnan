package com.washmycar.packagesservice.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection ="packages")
public class Package {
	
	@Id
	private String id;
	@Indexed(unique = true)
	private String packageCode;
	private String carType;
	private String packageType;
	private String description;
	private int price;
	
	
	
	public Package() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Package(String packageCode, String carType, String packageType, String description, int price) {
		super();
		this.packageCode = packageCode;
		this.carType = carType;
		this.packageType = packageType;
		this.description = description;
		this.price = price;
	}


	//Getters and setters
	public String getPackageCode() {
		return packageCode;
	}
	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	

}
