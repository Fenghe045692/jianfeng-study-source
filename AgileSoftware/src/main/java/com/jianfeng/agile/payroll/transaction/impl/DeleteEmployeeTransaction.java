package com.jianfeng.agile.payroll.transaction.impl;

import com.jianfeng.agile.payroll.transaction.Transaction;
import com.jianfeng.agile.payroll.util.PayrollDatabase;

public class DeleteEmployeeTransaction implements Transaction{
	private int empid;
	
	public DeleteEmployeeTransaction(int empid){
		this.empid = empid;
	}
	public void execute() {
		PayrollDatabase.DeleteEmployee(empid);
	}

}
