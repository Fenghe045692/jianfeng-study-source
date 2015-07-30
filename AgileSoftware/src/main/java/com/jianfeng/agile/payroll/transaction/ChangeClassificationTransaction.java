package com.jianfeng.agile.payroll.transaction;

import com.jianfeng.agile.payroll.model.Employee;
import com.jianfeng.agile.payroll.model.PaymentClassification;
import com.jianfeng.agile.payroll.payment.PaymentSchedule;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction{
	public abstract PaymentClassification getPaymentClassification();
	public abstract PaymentSchedule getPaymentSchedule();
	
	public ChangeClassificationTransaction(){}
	
	public ChangeClassificationTransaction(int empid) {
		super(empid);
	}

	@Override
	public void change(Employee e) {
		e.setClassification(getPaymentClassification());
		e.setSchedule(getPaymentSchedule());
	}

}
