package com.asd.finalexa;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Logger implements InvocationHandler{

	private Object v;
	
	public Logger(Object v){
		this.v = v;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Logger: " + method.getName());
		Object object = method.invoke(v, args);
		return object;
	}

}
