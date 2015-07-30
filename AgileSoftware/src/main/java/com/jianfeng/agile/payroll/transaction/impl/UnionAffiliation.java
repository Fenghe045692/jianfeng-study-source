package com.jianfeng.agile.payroll.transaction.impl;

import java.util.Date;

import com.jianfeng.agile.payroll.model.ServiceCharge;
import com.jianfeng.agile.payroll.transaction.Affiliation;

public class UnionAffiliation implements Affiliation{
	private ServiceCharge serviceCharge;

	public void addServiceCharge(Date date, double amount) {
		serviceCharge.setAmount(amount);
		serviceCharge.setDate(date);
	}

	public ServiceCharge getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(ServiceCharge serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	
	

}
