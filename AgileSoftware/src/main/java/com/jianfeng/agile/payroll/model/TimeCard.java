package com.jianfeng.agile.payroll.model;

import java.util.Date;

public class TimeCard {
	private Date date;
	private double hours;
	
	public TimeCard(){}

	public TimeCard(Date itsDate, double hours2) {
		this.date = itsDate;
		this.hours = hours2;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}
	
	
}
