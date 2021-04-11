package com.washmycar.packagesservice.api.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.washmycar.packagesservice.api.model.Package;

@Repository
public interface PackagesRepository extends MongoRepository<Package, String> {
	

	public Optional<Package> findByPackageCode(String packageCode);

	public Optional<List<Package>> findByCarType(String carType);

	public void deleteByPackageCode(String packageCode);

	public void deleteByCarType(String carType);

	



	

	

}
