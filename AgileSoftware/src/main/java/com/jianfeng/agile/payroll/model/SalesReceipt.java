package com.jianfeng.agile.payroll.model;

import java.util.Date;

public class SalesReceipt implements PaymentClassification{
	private double amount;
	private Date date;
	
	public SalesReceipt(){}
	
	
	public SalesReceipt(Date date, double amount) {
		this.date = date;
		this.amount = amount;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double calculate(Date date) {
		return 0;
	}
	
}
