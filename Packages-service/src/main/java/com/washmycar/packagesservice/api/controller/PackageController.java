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
import com.washmycar.packagesservice.api.model.Package;
import com.washmycar.packagesservice.api.service.PackagesDaoImpl;

@RestController
public class PackageController {
	
	@Autowired
	private PackagesDaoImpl packagesDaoImpl;
	
	@PostMapping("/package")
	public ResponseEntity<String> createPackages (@Validated @RequestBody Package packages){
		
		try {
			packagesDaoImpl.addPackages(packages);
			return ResponseEntity.ok("Package added succesfully with package code "+ packages.getPackageCode());
		} 
		catch (Exception e) {
			return e.getMessage().contains("duplicate") ? new ResponseEntity<>("Package code already exist",HttpStatus.CONFLICT):new ResponseEntity<>("No package code found: "+packages.getPackageCode(),HttpStatus.INTERNAL_SERVER_ERROR);
		 } 
		
		
	}
	
	@GetMapping("/packages")
	public ResponseEntity<?> getAllPackages(){
		List<Package> packages = packagesDaoImpl.getAllPackages();
		if (packages.size()>0) {
			return new ResponseEntity<List<Package>>(packages, HttpStatus.OK );
		}
		else {
			return new ResponseEntity<String>("No packages availale", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/packages/find/{packageCode}")
	public ResponseEntity<Package> findPackageByPackageCode (@PathVariable(value="packageCode")String packageCode)throws ResourceNotFoundException{
		Package packages = packagesDaoImpl.getPackagesbyPackageCode(packageCode ).orElseThrow(
				()->new ResourceNotFoundException("There is no package available for this "+packageCode));
		return new ResponseEntity<>(packages, HttpStatus.OK);
		}
	
		
	@GetMapping("/packages/get/{carType}")
	public ResponseEntity<List<Package>> findPackageByCarType (@PathVariable(value="carType")String carType)throws ResourceNotFoundException{
		List<Package> packagesList = packagesDaoImpl.getPackagesbyCarType(carType).orElseThrow(
				()->new ResourceNotFoundException("Thers are no packages avilable for this cartype : "+carType));
		return new ResponseEntity<List<Package>>(packagesList, HttpStatus.OK);
		}
	
	
	@PutMapping("/packages/update/{packageCode}")
	public ResponseEntity<String> updatePackageByPackageCode(@PathVariable(value = "packageCode")String packageCode, @RequestBody Package packages){
		Optional<Package> packageCheck = packagesDaoImpl.getPackagesbyPackageCode(packageCode);
		if(packageCheck.isPresent()) {
			packagesDaoImpl.updatePackagebyPackageCode(packageCode, packages);
			return new ResponseEntity<>("Details updated for package with package code "+packageCode, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Package not found with package code "+packageCode, HttpStatus.NOT_FOUND);
		}
	 
	}
	
	@DeleteMapping("packages/delete/{packageCode}")
	public ResponseEntity<String> deletePackageByPackageCode(@PathVariable(value = "packageCode")String packageCode){
		Optional<Package> packageCheck= packagesDaoImpl.getPackagesbyPackageCode(packageCode);
		if(packageCheck.isEmpty()) {
			return new ResponseEntity<>("Package not found with package code "+packageCode, HttpStatus.NOT_FOUND);
		}
		else {
			packagesDaoImpl.deletePackagebyPackageCode(packageCode);
			return new ResponseEntity<>("Package deleted with package code "+packageCode, HttpStatus.OK);
		}
		
	}
	@DeleteMapping("packages/remove/{carType}")
	public ResponseEntity<String> deletePackageByCarType(@PathVariable(value ="carType")String carType){
		Optional<List<Package>> packageslist =packagesDaoImpl.getPackagesbyCarType(carType);
		if(packageslist.isEmpty()) {
			return new ResponseEntity<>("No packages available for car type : "+carType, HttpStatus.NOT_FOUND);
		}
		else {
			packagesDaoImpl.deletePackagebyCarType(carType);
			return new ResponseEntity<>("All packages deleted with car type : "+carType,HttpStatus.OK);
		}
		
	}
	
		
	}
	
	
	
	


