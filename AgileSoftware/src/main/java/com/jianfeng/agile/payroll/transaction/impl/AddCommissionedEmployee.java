package com.jianfeng.agile.payroll.transaction.impl;

import com.jianfeng.agile.payroll.model.PaymentClassification;
import com.jianfeng.agile.payroll.payment.PaymentMethod;
import com.jianfeng.agile.payroll.payment.PaymentSchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction{
	private double salary;
	private double commissionRate;
	
	public AddCommissionedEmployee(int empid, String name, String address, 
			double salary, double commissionRate){
		super(empid, name, address);
		this.commissionRate = commissionRate;
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
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
