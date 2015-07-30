package com.jianfeng.agile.payroll;

import junit.framework.TestCase;

import com.jianfeng.agile.payroll.model.Employee;
import com.jianfeng.agile.payroll.transaction.impl.AddHourlyEmployee;
import com.jianfeng.agile.payroll.transaction.impl.ChangeNameTransaction;
import com.jianfeng.agile.payroll.util.PayrollDatabase;

public class TestChangeNameTransaction extends TestCase{
	public void testChangeNameTransaction(){
		int empid = 2;
		AddHourlyEmployee ae = new AddHourlyEmployee(empid, "danny", "home", 23.4);
		ae.execute();
		ChangeNameTransaction ct = new ChangeNameTransaction(empid, "honey");
		ct.execute();
		Employee e = PayrollDatabase.getEmployee(empid);
		assertEquals("honey", e.getItsName());
	}
}
