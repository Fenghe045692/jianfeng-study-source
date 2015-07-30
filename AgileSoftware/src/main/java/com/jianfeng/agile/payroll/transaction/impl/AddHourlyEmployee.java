package com.jianfeng.agile.payroll.transaction.impl;

import com.jianfeng.agile.payroll.model.PaymentClassification;
import com.jianfeng.agile.payroll.payment.PaymentMethod;
import com.jianfeng.agile.payroll.payment.PaymentSchedule;

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
