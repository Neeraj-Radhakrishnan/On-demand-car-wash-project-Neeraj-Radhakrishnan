package com.washmycar.usermicroservice.api.repositroy;

import java.util.List;
import java.util.Optional;

import com.washmycar.usermicroservice.api.model.Customer;

public interface CustomerDaoInterface {
	
	public Customer addCustomers(Customer customer);
	public List<Customer> getAllCustomers();
	public Optional<Customer> getCustomerbyId(long Id);
	public Optional<Customer> getCustomerbyEmail(String Email);
	public Optional<List<Customer>> getCustomerbyRole(String Role);
	public Customer updateCustomerbyId(long Id, Customer customer);
	public long deleteCustomerbyId(long Id);
	

}
