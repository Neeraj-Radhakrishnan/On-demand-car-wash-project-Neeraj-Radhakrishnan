package com.washmycar.usermicroservice.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.washmycar.usermicroservice.api.exception.ResourceNotFoundException;
import com.washmycar.usermicroservice.api.model.Customer;
import com.washmycar.usermicroservice.api.service.CustomerDaoImpl;
import com.washmycar.usermicroservice.api.service.SequenceGeneratorService;

public class CustomerController {
	@Autowired
	private CustomerDaoImpl customerdaoimpl;
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	
	
	@PostMapping("/customer")
	public ResponseEntity<String> createUsers( @Validated @RequestBody Customer customer) {
		try {
			customerdaoimpl.addCustomers(customer);
			return ResponseEntity.ok("Customer Registered Suceesfully with Id:"+customer.getId());
			}
			catch (Exception e) {
			 sequenceGeneratorService.decreamentSequence(Customer.SEQUENCE_NAME);
				 return new ResponseEntity<>("Email or MobileNumber Already Exist",HttpStatus.BAD_REQUEST);
			}
	}
	
	
	
	
	  @GetMapping("/customers") public List<Customer> getAllUsers() { 
		  return customerdaoimpl.getAllCustomers(); }
	  
	  
	  @GetMapping("/customer/find/{id}") public ResponseEntity<Customer> findUserById(@PathVariable(value="id")long id)throws ResourceNotFoundException{
		  Customer customer=customerdaoimpl.getCustomerbyId(id).orElseThrow(()->new
	      ResourceNotFoundException("Customer Not Found For This ID::"+id)); return
	      ResponseEntity.ok(customer); }
	 
	
	 
	  @GetMapping("/customer/get/{role}") 
	  public ResponseEntity<List<Customer>> findCustomerByRole(@PathVariable(value="role")String role)throws ResourceNotFoundException{ 
		  List<Customer> customers=customerdaoimpl.getCustomerbyRole(role).orElseThrow(()->new
	      ResourceNotFoundException("Cusromers Not Found For This Role::"+role)); return
	      ResponseEntity.ok(customers); }
	 
	
	  @PutMapping("/customer/update/{id}")
	  public ResponseEntity<String> updateCustomerById(@PathVariable(value="id")long id, @Validated @RequestBody Customer customer){
		 try {
			
				 Customer customer1=customerdaoimpl.updateCustomerbyId(id, customer);
				  return ResponseEntity.ok("Customer Updated Sucessfully For Id"+customer1.getId());
				 
		 }
		 catch(Exception e) {
			return e.getMessage().contains("duplicate") ? new ResponseEntity<>("Email Or Mobile Number already Exists",HttpStatus.INTERNAL_SERVER_ERROR): new ResponseEntity<>("Customer Not Found for ID: "+id,HttpStatus.INTERNAL_SERVER_ERROR);
		 } 
		  
	  }
 
	  
	 
	  @DeleteMapping("/customer/delete/{id}")
	  
	  public ResponseEntity<String> deleteUserById(@PathVariable(value="id")long id) {
		  Optional<Customer> customer=customerdaoimpl.getCustomerbyId(id);
		  try {
			  if(customer.isEmpty()) {
				  return new ResponseEntity<>("Customer Not Found For ID:"+id, HttpStatus.NOT_FOUND);
		 }
			  customerdaoimpl.deleteCustomerbyId(id);
			  return ResponseEntity.ok("Customer Deleted Sucessfully For Id"+id);
			 
	  }
		  catch (Exception e) {
			  return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		  }
	  }
	  
	  
	 @GetMapping("/customer/{email}")
	 public  ResponseEntity<Customer> findUserByMail(@PathVariable(value= "email")String email) throws ResourceNotFoundException{
		 Customer customer=customerdaoimpl.getCustomerbyEmail(email).orElseThrow(()->new ResourceNotFoundException("User Not Found For This Email ::"+email));
		 return ResponseEntity.ok(customer);
	}
	
}


