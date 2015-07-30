package com.jianfeng.agile.payroll.transaction.impl;

import java.util.Date;

import com.jianfeng.agile.payroll.model.PaymentClassification;

public class SalariedClassification implements PaymentClassification{
	
	private double salary;
	
	public SalariedClassification(){}
	
	public SalariedClassification(double salary) {
		super();
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double calculate(Date date) {
		return 0;
	}

}
