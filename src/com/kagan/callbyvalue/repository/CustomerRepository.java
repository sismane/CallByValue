package com.kagan.callbyvalue.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.kagan.callbyvalue.model.Customer;

public class CustomerRepository {
	
	
	public List<Customer> getCustomers(){
		List<Customer> customers = new ArrayList<>();
		Customer customer = new Customer("Kagan",40);
		customers.add(customer);
		customer = new Customer("Kagan2",40);
		customers.add(customer);
		return customers;
	}
	
	public Optional<Customer> getCustomer(String name){
		
		return Optional.empty();
	}

}
