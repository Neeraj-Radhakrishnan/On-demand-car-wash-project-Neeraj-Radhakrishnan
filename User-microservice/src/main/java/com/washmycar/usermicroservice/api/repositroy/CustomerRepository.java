package com.washmycar.usermicroservice.api.repositroy;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.washmycar.usermicroservice.api.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Long>{

	Optional<List<Customer>> findByRole(String role);

	Optional<Customer> findByEmail(String email);

}
