package com.kagan.callbyvalue.controller;

import java.util.List;

import com.kagan.callbyvalue.exception.CustomerException;
import com.kagan.callbyvalue.model.Customer;
import com.kagan.callbyvalue.model.CustomerPojo;

public class CustomerController {
	
	private CustomerService service;

	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}
	
	public List<Customer> addNewCustomerAndGetList(CustomerPojo newCustomer){
		List<Customer> customers = service.getCustomers();
		try {
			List<Customer> latestCustomers = service.addNewCustomerAndGetList(newCustomer, customers);
			if(customers == latestCustomers) {
				//same value
				System.out.println("new customer added to same list!");
			}else {
				System.out.println("new customer added to totally different list!");
			}
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		
		return customers;
	}
	
	public void addNewCustomer(CustomerPojo newCustomer){
		List<Customer> customers = service.getCustomers();
		try {
			service.addNewCustomer(newCustomer, customers);
			customers.forEach(c -> System.out.println(c.getName()));
		} catch (CustomerException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		CustomerController controller = new CustomerController(new CustomerServiceImpl());
		CustomerPojo newCustomer = new CustomerPojo("Kagan3",40);
		
		/*
		List<Customer> customers = controller.addNewCustomerAndGetList(newCustomer);
		customers.stream().forEach(c -> System.out.println(c.getName()));
		*/
		
		CustomerPojo newCustomer2 = new CustomerPojo("Kagan4",40);
		controller.addNewCustomer(newCustomer2);
		
	}

}
