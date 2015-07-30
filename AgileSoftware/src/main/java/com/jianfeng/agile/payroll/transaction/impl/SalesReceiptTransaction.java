package com.jianfeng.agile.payroll.transaction.impl;

import java.util.Date;

import com.jianfeng.agile.payroll.model.Employee;
import com.jianfeng.agile.payroll.model.PaymentClassification;
import com.jianfeng.agile.payroll.model.SalesReceipt;
import com.jianfeng.agile.payroll.transaction.Transaction;
import com.jianfeng.agile.payroll.util.PayrollDatabase;

public class SalesReceiptTransaction implements Transaction{
	private Date date;
	private double amount;
	private int empid;
	
	public SalesReceiptTransaction(){}
	
	public SalesReceiptTransaction(Date date, double amount, int empid){
		this.date = date;
		this.amount = amount;
		this.empid = empid;
	}
	
	public void execute() {
		Employee e = PayrollDatabase.getEmployee(empid);
		if(e != null){
			PaymentClassification pc = e.getClassification();
			if(pc instanceof HourlyClassification){
				CommissionedClassification cc = (CommissionedClassification)pc;
				cc.getReceipts().add(new SalesReceipt(date, amount));
			}else{
				throw new RuntimeException("Tried to add sale-receipt to non-sales employee");
			}
		}else{
			throw new RuntimeException("No such employee.");
		}
	}

}
