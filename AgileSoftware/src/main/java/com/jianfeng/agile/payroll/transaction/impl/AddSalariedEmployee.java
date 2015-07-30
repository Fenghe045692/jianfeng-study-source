package com.jianfeng.agile.payroll.transaction.impl;

import com.jianfeng.agile.payroll.model.PaymentClassification;
import com.jianfeng.agile.payroll.transaction.PaymentMethod;
import com.jianfeng.agile.payroll.transaction.PaymentSchedule;

public class AddSalariedEmployee extends AddEmployeeTransaction{
	private double salary;

	public AddSalariedEmployee(int empid, String name, String address, double salary){
		super(empid, name, address);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public PaymentMethod getPaymentMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentClassification getPaymentClassification() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentSchedule getPaymentSchedule() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
