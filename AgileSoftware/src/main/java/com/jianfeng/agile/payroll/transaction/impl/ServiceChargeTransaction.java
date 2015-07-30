package com.jianfeng.agile.payroll.transaction.impl;

import java.util.Date;

import com.jianfeng.agile.payroll.model.Employee;
import com.jianfeng.agile.payroll.transaction.Transaction;
import com.jianfeng.agile.payroll.util.PayrollDatabase;

public class ServiceChargeTransaction implements Transaction{
	private Date date;
	private double amount;
	private int itsMemberId;
	
	public void execute() {
		Employee e = PayrollDatabase.getUnionMember(itsMemberId);
		if(e.getAffiliation() instanceof UnionAffiliation){
			((UnionAffiliation)e.getAffiliation()).addServiceCharge(date, amount);
		}
	}
	
	public ServiceChargeTransaction(){}

	public ServiceChargeTransaction(Date date, double amount, int itsMemberId) {
		super();
		this.date = date;
		this.amount = amount;
		this.itsMemberId = itsMemberId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getItsMemberId() {
		return itsMemberId;
	}

	public void setItsMemberId(int itsMemberId) {
		this.itsMemberId = itsMemberId;
	}
	
	
}
