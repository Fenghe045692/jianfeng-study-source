package com.asd.finalexa;

import java.util.concurrent.atomic.AtomicInteger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ServiceCounter {
	private AtomicInteger count = new AtomicInteger(0);
	
	@Before("execution(* com.asd.finalexa.CustomerService.findCustomer(..))")
	public void log(JoinPoint joinPoint){
		System.out.println("Method " + joinPoint.getSignature().getName() 
				+ " is called " + count.addAndGet(1) + " times");
	}
}
