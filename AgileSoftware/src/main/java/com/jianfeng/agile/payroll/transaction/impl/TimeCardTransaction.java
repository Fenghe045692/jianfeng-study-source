package com.jianfeng.agile.payroll.transaction.impl;

import java.util.Date;

import com.jianfeng.agile.payroll.model.Employee;
import com.jianfeng.agile.payroll.model.PaymentClassification;
import com.jianfeng.agile.payroll.model.TimeCard;
import com.jianfeng.agile.payroll.transaction.Transaction;
import com.jianfeng.agile.payroll.util.PayrollDatabase;

public class TimeCardTransaction implements Transaction{
	private Date itsDate;
	private double hours;
	private int empid;
	
	public TimeCardTransaction(Date date, double hours, int empid){
		this.itsDate = date;
		this.hours = hours;
		this.empid = empid;
	}
	public void execute() {
		Employee e = PayrollDatabase.getEmployee(empid);
		if(e != null){
			PaymentClassification pc = e.getClassification();
			if(pc instanceof HourlyClassification){
				HourlyClassification hc = (HourlyClassification)pc;
				hc.getTimecards().add(new TimeCard(itsDate, hours));
			}else{
				throw new RuntimeException("Tried to add time-card to non-hourly employee");
			}
		}else{
			throw new RuntimeException("No such employee.");
		}
	}
	public Date getItsDate() {
		return itsDate;
	}
	public void setItsDate(Date itsDate) {
		this.itsDate = itsDate;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	
	

}
