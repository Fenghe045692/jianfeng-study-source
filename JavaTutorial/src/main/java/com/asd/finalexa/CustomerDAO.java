package com.asd.finalexa;

public class CustomerDAO implements ICustomerDAO{

	public Customer getCustomer(String ssn) {
		if(ssn.equals("324-554-5678"))
			return new Customer("Frank Brown");
		if(ssn.equals("233-332-4444"))
			return new Customer("John Doe");
		return null;
	}
	
}
