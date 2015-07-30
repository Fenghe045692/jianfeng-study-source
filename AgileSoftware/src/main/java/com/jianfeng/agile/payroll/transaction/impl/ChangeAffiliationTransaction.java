package com.jianfeng.agile.payroll.transaction.impl;

import com.jianfeng.agile.payroll.model.Employee;
import com.jianfeng.agile.payroll.transaction.Affiliation;
import com.jianfeng.agile.payroll.transaction.ChangeEmployeeTransaction;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction{
	private int empid;
	
	public abstract void RecordMembership(Employee e);
	public abstract Affiliation getAffiliation();
	
	public ChangeAffiliationTransaction(){}
	
	public ChangeAffiliationTransaction(int empid) {
		super(empid);
	}

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	@Override
	public void change(Employee e) {
		RecordMembership(e);
		e.setAffiliation(getAffiliation());
	}

}
