package com.asd.finalexa;

public class CustomerService implements ICustomerService{
//	private ICustomerDAO customerDao = new CustomerDAO();
	//Spring injection
	private ICustomerDAO customerDao;
	
	public Customer findCustomer(String ssn) {
		return customerDao.getCustomer(ssn);
	}
	
	public void setCustomerDao(CustomerDAO customerDao){
		this.customerDao = customerDao;
	}

}
