package com.jianfeng.agile.payroll.util;

import java.util.HashMap;

import com.jianfeng.agile.payroll.model.Employee;

public class PayrollDatabase {
	private static HashMap<Integer, Employee> itsEmployees;
	
	public PayrollDatabase(){}
	
	public static Employee getEmployee(int empid){
		return itsEmployees.get(empid);
	}
	
	public static void addEmployee(int empid, Employee e){
		itsEmployees.put(empid, e);
	}
	
	public static void DeleteEmployee(int empid){
		itsEmployees.remove(empid);
	}
}
