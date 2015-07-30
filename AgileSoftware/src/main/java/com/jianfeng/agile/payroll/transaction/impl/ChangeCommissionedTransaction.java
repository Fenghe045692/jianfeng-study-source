package com.jianfeng.agile.payroll.transaction.impl;

import com.jianfeng.agile.payroll.model.PaymentClassification;
import com.jianfeng.agile.payroll.payment.PaymentSchedule;
import com.jianfeng.agile.payroll.payment.impl.BiWeeklyPaymentSchedule;
import com.jianfeng.agile.payroll.transaction.ChangeClassificationTransaction;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction{
	private double salary;
	private double commissionRate;
	
	
	public ChangeCommissionedTransaction(int empid, double salary, double commissionRate) {
		super(empid);
		this.salary = salary;
		this.commissionRate = commissionRate;
	}

	@Override
	public PaymentClassification getPaymentClassification() {
		return new CommissionedClassification(salary, commissionRate);
	}

	@Override
	public PaymentSchedule getPaymentSchedule() {
		return new BiWeeklyPaymentSchedule();
	}

}
