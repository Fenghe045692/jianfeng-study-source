package com.jianfeng.agile.payroll.transaction;

import com.jianfeng.agile.payroll.model.Employee;
import com.jianfeng.agile.payroll.util.PayrollDatabase;

public abstract class ChangeEmployeeTransaction implements Transaction{
	private int empid;
	
	public ChangeEmployeeTransaction(){}
	
	public ChangeEmployeeTransaction(int empid) {
		super();
		this.empid = empid;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}
	
	public void execute(){
		Employee e = PayrollDatabase.getEmployee(empid);
		if(e != null) change(e);
	}

	public abstract void change(Employee e);
	
}
