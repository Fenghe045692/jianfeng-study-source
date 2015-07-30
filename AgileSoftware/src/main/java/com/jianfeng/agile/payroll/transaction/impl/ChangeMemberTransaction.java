package com.jianfeng.agile.payroll.transaction.impl;

import com.jianfeng.agile.payroll.model.Employee;
import com.jianfeng.agile.payroll.transaction.Affiliation;
import com.jianfeng.agile.payroll.util.PayrollDatabase;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction{
	private double dues;
	private int memberId;
	private int empid;
	
	public ChangeMemberTransaction(){}
	
	public ChangeMemberTransaction(double dues, int memberId, int empid) {
		super(empid);
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

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	@Override
	public void RecordMembership(Employee e) {
		PayrollDatabase.AddMember(memberId, e);
	}

	@Override
	public Affiliation getAffiliation() {
		return new UnionAffiliation(dues, memberId);
	}
	
}
