package com.washmycar.packagesservice.api.repository;

import java.util.List;
import java.util.Optional;

import com.washmycar.packagesservice.api.model.Package;

public interface PackagesDaoInterface {
	
	public Package addPackages(Package packages);
	public List<Package> getAllPackages();
	public Optional<Package> getPackagesbyPackageCode(String packageCode);
	public Optional<List<Package>> getPackagesbyCarType(String carType);
	public Package updatePackagebyPackageCode(String packageCode,Package packages);
	//public Package updatePackagebyCarType(String carType,Package packages);
	//public Package updatePackagebyPackageType(String packageType,Package packages);
	public String deletePackagebyPackageCode(String packageCode);
	public String deletePackagebyCarType(String carType);
	

}
