package com.jianfeng.agile.payroll.impl;

import com.jianfeng.agile.payroll.PaymentClassification;
import com.jianfeng.agile.payroll.PaymentMethod;
import com.jianfeng.agile.payroll.PaymentSchedule;

public class AddHourlyEmployee extends AddEmployeeTransaction{
	private double hourlyRate;
	
	public AddHourlyEmployee(int empid, String name, String address, double hourlyRate){
		super(empid, name, address);
		this.hourlyRate = hourlyRate;
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
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
