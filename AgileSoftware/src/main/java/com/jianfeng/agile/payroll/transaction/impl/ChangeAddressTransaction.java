package com.jianfeng.agile.payroll.transaction.impl;

import com.jianfeng.agile.payroll.model.Employee;
import com.jianfeng.agile.payroll.transaction.ChangeEmployeeTransaction;

public class ChangeAddressTransaction extends ChangeEmployeeTransaction {
	private String address;
	
	public ChangeAddressTransaction(){}
	
	public ChangeAddressTransaction(int empid, String address) {
		super(empid);
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String address) {
		this.address = address;
	}

	@Override
	public void change(Employee e) {
		e.setItsAddress(address);
	}

}
