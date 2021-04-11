package com.washmycar.packagesservice.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection="addon")
public class AddOn {
	
	
	@Id
	private String id;
	@Indexed(unique = true)
	private String addOnCode;
	private String addOnName;
	private int price;
	public String getAddOnCode() {
		return addOnCode;
	}
	public void setAddOnCode(String addOnCode) {
		this.addOnCode = addOnCode;
	}
	public String getAddOnName() {
		return addOnName;
	}
	public void setAddOnName(String addOnName) {
		this.addOnName = addOnName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	

}
