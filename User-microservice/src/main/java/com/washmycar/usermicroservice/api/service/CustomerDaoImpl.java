package com.washmycar.usermicroservice.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washmycar.usermicroservice.api.model.Customer;
import com.washmycar.usermicroservice.api.repositroy.CustomerDaoInterface;
import com.washmycar.usermicroservice.api.repositroy.CustomerRepository;


@Service
public class CustomerDaoImpl implements CustomerDaoInterface{
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Override
	public Customer addCustomers(Customer customer) {
		customer.setId(sequenceGeneratorService.generateSequence(Customer.SEQUENCE_NAME));
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomerbyId(long Id) {
		return customerRepository.findById(Id);
	}
	
	@Override
	public Optional<Customer> getCustomerbyEmail(String Email) {
		return customerRepository.findByEmail(Email);
	}

	@Override
	public Optional<List<Customer>> getCustomerbyRole(String Role) {
		return customerRepository.findByRole(Role);
	}

	@Override
	public Customer updateCustomerbyId(long Id, Customer customer) {
		Optional<Customer> customer1=customerRepository.findById(Id);
		Customer updateCustomer= customer1.get();
		updateCustomer.setGender(customer.getGender());
		updateCustomer.setMobilenumber(customer.getMobilenumber());
		updateCustomer.setName(customer.getName());
		return customerRepository.save(updateCustomer);
	}

	@Override
	public long deleteCustomerbyId(long Id) {
		customerRepository.deleteById(Id);
		
	       return Id;
	}

	

}
