package com.jianfeng.agile.payroll.transaction.impl;

import com.jianfeng.agile.payroll.model.Employee;
import com.jianfeng.agile.payroll.transaction.ChangeEmployeeTransaction;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {
	private String name;
	
	public ChangeNameTransaction(){}
	
	public ChangeNameTransaction(int empid, String name) {
		super(empid);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void change(Employee e) {
		e.setItsName(name);
	}

}
