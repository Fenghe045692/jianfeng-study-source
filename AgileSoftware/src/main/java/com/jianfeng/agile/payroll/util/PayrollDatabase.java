package com.jianfeng.agile.payroll.util;

import java.util.HashMap;

import com.jianfeng.agile.payroll.model.Employee;

public class PayrollDatabase {
	private static HashMap<Integer, Employee> itsEmployees;
	
	private static HashMap<Integer, Employee> itsMembers;
	
	static{
		itsEmployees = new HashMap<Integer, Employee>();
		itsMembers = new HashMap<Integer, Employee>();
	}
	
	public PayrollDatabase(){
	}
	
	public static Employee getEmployee(int empid){
		return itsEmployees.get(empid);
	}
	
	public static void addEmployee(int empid, Employee e){
		itsEmployees.put(empid, e);
	}
	
	public static void DeleteEmployee(int empid){
		itsEmployees.remove(empid);
	}
	
	public static Employee getUnionMember(int memberId){
		return itsMembers.get(memberId);
	}
	
	public static void AddMember(int memberId, Employee e){
		itsMembers.put(memberId, e);
	}
	
	public static void removeUnionMember(int memId){
		itsMembers.remove(memId);
	}
}
