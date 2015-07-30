package com.jianfeng.agile.payroll.transaction.impl;

import java.util.Date;
import java.util.List;

import com.jianfeng.agile.payroll.model.PaymentClassification;
import com.jianfeng.agile.payroll.model.SalesReceipt;

public class CommissionedClassification implements PaymentClassification{
	private double salary;
	private double commissionRate;
	private List<SalesReceipt> receipts;
	
	
	public  CommissionedClassification(){}
	
	public double calculate(Date date) {
		return 0;
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

	public List<SalesReceipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(List<SalesReceipt> receipts) {
		this.receipts = receipts;
	}
}
