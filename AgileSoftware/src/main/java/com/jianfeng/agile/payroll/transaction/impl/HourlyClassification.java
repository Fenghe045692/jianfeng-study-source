package com.jianfeng.agile.payroll.transaction.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jianfeng.agile.payroll.model.PaymentClassification;
import com.jianfeng.agile.payroll.model.TimeCard;

public class HourlyClassification implements PaymentClassification{
	private double hourlyRate;
	
	private List<TimeCard> timecards;
	
	public HourlyClassification(){}
	
	public HourlyClassification(double hourlyRate) {
		super();
		this.hourlyRate = hourlyRate;
		this.timecards = new ArrayList<TimeCard>();
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double calculate(Date date) {
		return 0;
	}

	public List<TimeCard> getTimecards() {
		return timecards;
	}

	public void setTimecards(List<TimeCard> timecards) {
		this.timecards = timecards;
	}
	
}
