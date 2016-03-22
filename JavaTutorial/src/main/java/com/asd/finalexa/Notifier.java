package com.asd.finalexa;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Notifier implements InvocationHandler{
	private Object v;
	
	public Notifier(Object v){
		this.v = v;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Notifier: " + method.getName());
		Object object = method.invoke(v, args);
		System.out.println("Notifier: " + method.getName());
		return object;
	}

}
