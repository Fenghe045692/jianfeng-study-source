package com.asd.finalexa;

import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args){
		N2S();
	}
	
	public static void N1(){
		IVehicle c = new Car();
		ClassLoader cl = IVehicle.class.getClassLoader();
		IVehicle v1 = (IVehicle)Proxy.newProxyInstance(cl, new Class[]
				{IVehicle.class}, new Logger(c));
		IVehicle v2 = (IVehicle)Proxy.newProxyInstance(cl, new Class[]
				{IVehicle.class}, new Notifier(v1));
		v2.start();
	}
	
	public static void N2(){
		ICustomerService customerService = new CustomerService();
		Customer c = customerService.findCustomer("324-554-5678");
		System.out.println(c.getName());
		c = customerService.findCustomer("233-332-4444");
		System.out.println(c.getName());
	}
	
	public static void N2S(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springconfig.xml");
		ICustomerService customerService = (ICustomerService) context.getBean("customerService");
		System.out.println(customerService.findCustomer("324-554-5678").getName());
		System.out.println(customerService.findCustomer("233-332-4444").getName());
	}
}
