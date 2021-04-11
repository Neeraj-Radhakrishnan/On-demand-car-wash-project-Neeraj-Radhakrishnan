package com.washmycar.packagesservice.api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.washmycar.packagesservice.api.model.AddOn;

public interface AddOnRepository extends MongoRepository<AddOn, String> {

	public Optional<AddOn> findByAddOnCode(String addOnCode);

	public Optional<AddOn> findByAddOnName(String addOnName);

	public void deleteByAddOnCode(String addOnCode);

}
