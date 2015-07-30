package com.jianfeng.agile.payroll.transaction.impl;

import com.jianfeng.agile.payroll.model.PaymentClassification;
import com.jianfeng.agile.payroll.payment.PaymentSchedule;
import com.jianfeng.agile.payroll.payment.impl.MonthlyPaymentSchedule;
import com.jianfeng.agile.payroll.transaction.ChangeClassificationTransaction;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction{
	private double itsSalary;
	
	public ChangeSalariedTransaction(int empid, double itsSalary) {
		super(empid);
		this.itsSalary = itsSalary;
	}

	@Override
	public PaymentClassification getPaymentClassification() {
		return new SalariedClassification(itsSalary);
	}

	@Override
	public PaymentSchedule getPaymentSchedule() {
		return new MonthlyPaymentSchedule();
	}

}
