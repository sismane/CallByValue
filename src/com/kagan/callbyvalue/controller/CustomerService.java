package com.kagan.callbyvalue.controller;

import java.util.List;

import com.kagan.callbyvalue.exception.CustomerException;
import com.kagan.callbyvalue.model.Customer;
import com.kagan.callbyvalue.model.CustomerPojo;

public interface CustomerService {

	public static final String CustomerNotFoundException = "Customer is not found";
	
	public Customer getCustomer(String name) throws CustomerException;
	
	public List<Customer> getCustomers();
	
	public List<Customer> addNewCustomerAndGetList(CustomerPojo customer, List<Customer> customers) throws CustomerException;
	
	public void addNewCustomer(CustomerPojo customerPojo, List<Customer> customers) throws CustomerException;
}
