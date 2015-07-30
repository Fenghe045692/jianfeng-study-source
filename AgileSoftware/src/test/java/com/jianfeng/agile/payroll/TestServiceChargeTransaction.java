package com.jianfeng.agile.payroll;

import java.util.Date;

import junit.framework.TestCase;

import com.jianfeng.agile.payroll.model.Employee;
import com.jianfeng.agile.payroll.model.ServiceCharge;
import com.jianfeng.agile.payroll.transaction.impl.AddHourlyEmployee;
import com.jianfeng.agile.payroll.transaction.impl.ServiceChargeTransaction;
import com.jianfeng.agile.payroll.transaction.impl.UnionAffiliation;
import com.jianfeng.agile.payroll.util.PayrollDatabase;

public class TestServiceChargeTransaction extends TestCase{
	public void testAddServiceCharge(){
		int empid = 2;
		int memberId = 86;
		AddHourlyEmployee ae = new AddHourlyEmployee(empid, "jack", "home", 23.5);
		ae.execute();
		Employee e = PayrollDatabase.getEmployee(empid);
		assertNotNull(e);
		UnionAffiliation uf = new UnionAffiliation(12.5, memberId);
		e.setAffiliation(uf);
		PayrollDatabase.AddMember(memberId, e);
		Date date = new Date();
		ServiceChargeTransaction st = new ServiceChargeTransaction(date, 56.3, memberId);
		st.execute();
		ServiceCharge sc = uf.getServiceCharge(date);
		assertNotNull(sc);
		assertEquals(56.3, sc.getAmount(), 0.0001);
	}
}
