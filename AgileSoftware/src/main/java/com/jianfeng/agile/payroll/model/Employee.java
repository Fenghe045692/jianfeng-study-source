package com.jianfeng.agile.payroll.model;

import com.jianfeng.agile.payroll.PaymentClassification;
import com.jianfeng.agile.payroll.PaymentMethod;
import com.jianfeng.agile.payroll.PaymentSchedule;

public class Employee {

	private int empid;
	private String itsAddress;
	private String itsName;
	private PaymentClassification classification;
	private PaymentSchedule schedule;
	private PaymentMethod paymentMethod;
	
	public Employee(){}
	
	public Employee(int empid, String itsAddress, String itsName) {
		this.empid = empid;
		this.itsAddress = itsAddress;
		this.itsName = itsName;
	}

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

	public PaymentClassification getClassification() {
		return classification;
	}

	public void setClassification(PaymentClassification classification) {
		this.classification = classification;
	}

	public PaymentSchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(PaymentSchedule schedule) {
		this.schedule = schedule;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	

}
