package com.kagan.callbyvalue.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.kagan.callbyvalue.exception.CustomerException;
import com.kagan.callbyvalue.model.Customer;
import com.kagan.callbyvalue.model.CustomerPojo;
import com.kagan.callbyvalue.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository repo;
	
	public CustomerServiceImpl(CustomerRepository repo) {
		super();
		this.repo = repo;
	}
	
	public CustomerServiceImpl() {
		if(Objects.isNull(repo)) {
			repo = new CustomerRepository();
		}
	}
	
	public List<Customer> getAllCustomers(){
		return repo.getCustomers();
	}
	
	public Customer getCustomer(String name) throws CustomerException {
		
		Optional<Customer> customer = repo.getCustomer(name);
		
		if(!customer.isPresent()) {
			throw new CustomerException(CustomerNotFoundException);
		}
		return customer.get();
	}

	@Override
	public List<Customer> getCustomers() {

		return repo.getCustomers();
	}

	@Override
	public List<Customer> addNewCustomerAndGetList(CustomerPojo customerPojo, List<Customer> customers) throws CustomerException {
		
		Customer customer = new Customer(customerPojo.getName(),customerPojo.getAge());
		customers.add(customer);
		//List<Customer> customers2 = customers;
		customers.forEach(c -> c.setName("Kagan"));
		
		return customers;
	}
	
	@Override
	public void addNewCustomer(CustomerPojo customerPojo, List<Customer> customers) throws CustomerException {
		
		Customer customer = new Customer(customerPojo.getName(),customerPojo.getAge());
		customers.add(customer);
		//List<Customer> customers2 = customers;
		customers.forEach(c -> c.setName("Kagan"));
		
	}
	
}
