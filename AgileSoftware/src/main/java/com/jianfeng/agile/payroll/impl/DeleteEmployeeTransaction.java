package com.jianfeng.agile.payroll.impl;

import com.jianfeng.agile.payroll.Transaction;
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
