package com.jianfeng.agile.payroll.transaction.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jianfeng.agile.payroll.model.ServiceCharge;
import com.jianfeng.agile.payroll.transaction.Affiliation;

public class UnionAffiliation implements Affiliation{
	private double dues;
	private int memberId;
	private List<ServiceCharge> serviceCharges = new ArrayList<ServiceCharge>();

	public void addServiceCharge(Date date, double amount) {
		ServiceCharge serviceCharge = new ServiceCharge(date, amount);
		serviceCharges.add(serviceCharge);
	}

	public ServiceCharge getServiceCharge(Date date) {
		ServiceCharge sc = null;
		for(int i = 0; i < serviceCharges.size(); i++){
			if(serviceCharges.get(i).getDate().compareTo(date) == 0){
				sc = serviceCharges.get(i);
				break;
			}
		}
		return sc;
	}

	public UnionAffiliation(double dues, int memberId) {
		super();
		this.dues = dues;
		this.memberId = memberId;
	}

	public double getDues() {
		return dues;
	}

	public void setDues(double dues) {
		this.dues = dues;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	

}
