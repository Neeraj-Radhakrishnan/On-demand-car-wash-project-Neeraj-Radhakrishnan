package com.washmycar.packagesservice.api.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.washmycar.packagesservice.api.exception.ResourceNotFoundException;
import com.washmycar.packagesservice.api.model.AddOn;
import com.washmycar.packagesservice.api.service.AddOnDaoImpl;


@RestController
public class AddOnController {
	
	@Autowired
	private AddOnDaoImpl addOnDaoImpl;
	
	@PostMapping("/add-on")
	public ResponseEntity<String> createAddOn (@Validated @RequestBody AddOn addOns){
		
		try {
			addOnDaoImpl.addAddOn(addOns);
			return ResponseEntity.ok("Add-On added succesfully with add-on code "+ addOns.getAddOnCode());
		} 
		catch (Exception e) {
			return e.getMessage().contains("duplicate") ? new ResponseEntity<>("Add-on code already exist",HttpStatus.CONFLICT):new ResponseEntity<>("No add-on code found: "+addOns.getAddOnCode(),HttpStatus.INTERNAL_SERVER_ERROR);
		 } 
		
		
	}
	
	@GetMapping("/add-ons")
	public ResponseEntity<?> getAllAddOns(){
		List<AddOn> addOns = addOnDaoImpl.getAddOns();
		if (addOns.size()>0) {
			return new ResponseEntity<List<AddOn>>(addOns, HttpStatus.OK );
		}
		else {
			return new ResponseEntity<String>("No add-ons availale", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/add-ons/find/{addOnCode}")
	public ResponseEntity<AddOn> findAddOnByAddOnCode (@PathVariable(value="addOnCode")String addOnCode)throws ResourceNotFoundException{
		AddOn addOns = addOnDaoImpl.getAddOnsbyAddOnCode(addOnCode ).orElseThrow(
				()->new ResourceNotFoundException("There is no add-on available for this "+addOnCode));
		return new ResponseEntity<>(addOns, HttpStatus.OK);
		}
	
	@GetMapping("/add-ons/get/{addOnName}")
	public ResponseEntity<AddOn> findAddOnByAddOnName (@PathVariable(value="addOnName")String addOnName)throws ResourceNotFoundException{
		AddOn addOns = addOnDaoImpl.getAddOnsbyAddOnName(addOnName).orElseThrow(
				()->new ResourceNotFoundException("Thers are no add-ons avilable for this add-on name : "+addOnName));
		return new ResponseEntity<AddOn>(addOns, HttpStatus.OK);
		}
	
	
	@PutMapping("/add-ons/update/{addOnCode}")
	public ResponseEntity<String> updateAddOnByAddOnCode(@PathVariable(value = "addOnCode")String addOnCode, @RequestBody AddOn addOns){
		Optional<AddOn> addOnCheck = addOnDaoImpl.getAddOnsbyAddOnCode(addOnCode);
		if(addOnCheck.isPresent()) {
			addOnDaoImpl.UpdatebyAddOnCode(addOnCode, addOns);
			return new ResponseEntity<>("Details updated for add-on with add-on code "+addOnCode, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Add-on details not found for add-on code "+addOnCode, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("add-on/delete/{addOnCode}")
	public ResponseEntity<String> deleteAddOnByAddOnCode(@PathVariable(value = "addOnCode")String addOnCode){
		Optional<AddOn> addOnCheck= addOnDaoImpl.getAddOnsbyAddOnCode(addOnCode);
		if(addOnCheck.isEmpty()) {
			return new ResponseEntity<>("Add-on not found with add-on code "+addOnCode, HttpStatus.NOT_FOUND);
		}
		else {
			addOnDaoImpl.deleteAddOnbyAddOnCode(addOnCode);
			return new ResponseEntity<>("Package deleted with package code "+addOnCode, HttpStatus.OK);
		}
		
	}

}
