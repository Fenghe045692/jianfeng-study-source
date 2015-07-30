package com.jianfeng.agile.payroll.transaction.impl;

import com.jianfeng.agile.payroll.model.Employee;
import com.jianfeng.agile.payroll.model.PaymentClassification;
import com.jianfeng.agile.payroll.transaction.PaymentMethod;
import com.jianfeng.agile.payroll.transaction.PaymentSchedule;
import com.jianfeng.agile.payroll.transaction.Transaction;
import com.jianfeng.agile.payroll.util.PayrollDatabase;

public abstract class AddEmployeeTransaction implements Transaction{
	private int empid;
	private String itsAddress;
	private String itsName;
	
	public AddEmployeeTransaction(){
		
	}
	public AddEmployeeTransaction(int empid, String name, String address){
		setEmpid(empid);
		setItsAddress(address);
		setItsName(name);
	}
	
	public abstract PaymentMethod getPaymentMethod();
	
	public abstract PaymentClassification getPaymentClassification();
	
	public abstract PaymentSchedule getPaymentSchedule();
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getItsAddress() {
		return itsAddress;
	}
	public void setItsAddress(String itsAddress) {
		this.itsAddress = itsAddress;
	}
	public String getItsName() {
		return itsName;
	}
	public void setItsName(String itsName) {
		this.itsName = itsName;
	}
	
	public void execute(){
		PaymentClassification pc = getPaymentClassification();
		PaymentMethod pm = getPaymentMethod();
		PaymentSchedule ps = getPaymentSchedule();
		Employee e = new Employee(empid, itsAddress, itsName);
		e.setClassification(pc);
		e.setPaymentMethod(pm);
		e.setSchedule(ps);
		PayrollDatabase.addEmployee(empid, e);
	}
}
