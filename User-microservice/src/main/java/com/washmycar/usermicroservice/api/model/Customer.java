package com.washmycar.usermicroservice.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Customer-details")
public class Customer {
	@Transient 
    public static final String SEQUENCE_NAME = "customers_sequence";
	@Id // Generates A Unique Id In MongoDB
	private long id;
	
	private String name;
	
	private String gender;
	
	private String password;
	
    @Indexed(unique=true) 
	private String email;
    
    @Indexed(unique=true)
	private long mobilenumber;
    
	private String role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	
	

}
