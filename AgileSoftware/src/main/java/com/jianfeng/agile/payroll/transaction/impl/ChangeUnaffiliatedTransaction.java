package com.jianfeng.agile.payroll.transaction.impl;

import com.jianfeng.agile.payroll.model.Employee;
import com.jianfeng.agile.payroll.transaction.Affiliation;
import com.jianfeng.agile.payroll.util.PayrollDatabase;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction{
	private int memId;
	
	public ChangeUnaffiliatedTransaction(){}
	
	public ChangeUnaffiliatedTransaction(int memId) {
		super(memId);
	}

	@Override
	public void RecordMembership(Employee e) {
		if(e.getAffiliation() instanceof UnionAffiliation){
			PayrollDatabase.removeUnionMember(memId);
		}
	}

	@Override
	public Affiliation getAffiliation() {
		return new NoAffiliation();
	}

}
