package com.washmycar.packagesservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.washmycar.packagesservice.model.Package;
import com.washmycar.packagesservice.repository.PackagesDaoInterface;
import com.washmycar.packagesservice.repository.PackagesRepository;


@Service
public class PackagesDaoImpl implements PackagesDaoInterface {

	@Autowired
	private PackagesRepository packagesRepository;
	
	@Override
	public Package addPackages(Package packages) {
		return packagesRepository.save(packages);
	}

	@Override
	public List<Package> getAllPackages() {
		return packagesRepository.findAll();
	}

	@Override
	public Optional<Package> getPackagesbyPackageCode(String packageCode) {
		return packagesRepository.findByPackageCode(packageCode);
	}

	@Override
	public Optional<List<Package>> getPackagesbyCarType(String carType) {
		return packagesRepository.findByCarType(carType);
	}

	@Override
	public Package updatePackagebyPackageCode(String packageCode, Package packages) {
		Optional<Package> packages1 = packagesRepository.findByPackageCode(packageCode);
		Package updatePackage =packages1.get();
		updatePackage.setPackageCode(packages.getPackageCode());
		updatePackage.setCarType(packages.getCarType());
		updatePackage.setDescription(packages.getDescription());
		updatePackage.setPackageType(packages.getPackageType());
		updatePackage.setPrice(packages.getPrice());
		return packagesRepository.save(updatePackage);
	}

	/*
	 * @Override public Package updatePackagebyCarType(String carType, Package
	 * packages) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public Package updatePackagebyPackageType(String packageType,
	 * Package packages) { // TODO Auto-generated method stub return null; }
	 */

	@Override
	public String deletePackagebyPackageCode(String packageCode) {
		packagesRepository.deleteByPackageCode(packageCode);
		return null;
	}

	@Override
	public String deletePackagebyCarType(String carType) {
		packagesRepository.deleteByCarType(carType);
		return null;
	}

}
