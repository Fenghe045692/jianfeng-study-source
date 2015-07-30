package com.jianfeng.agile.payroll.transaction.impl;

import com.jianfeng.agile.payroll.model.PaymentClassification;
import com.jianfeng.agile.payroll.payment.PaymentSchedule;
import com.jianfeng.agile.payroll.payment.impl.WeeklyPaymentSchedule;
import com.jianfeng.agile.payroll.transaction.ChangeClassificationTransaction;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction{
	private double itsHourlyRate;
	
	public ChangeHourlyTransaction(int empid, double itsHourlyRate) {
		super(empid);
		this.itsHourlyRate = itsHourlyRate;
	}

	@Override
	public PaymentClassification getPaymentClassification() {
		return new HourlyClassification(itsHourlyRate);
	}

	@Override
	public PaymentSchedule getPaymentSchedule() {
		return new WeeklyPaymentSchedule();
	}

}
