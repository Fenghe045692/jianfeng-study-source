package com.jianfeng.agile.payroll;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Iterator;

import org.junit.Test;
import org.mockito.Mockito;

import com.jianfeng.agile.payroll.transaction.impl.AddHourlyEmployee;

public class TestMockito {
	@Test
	public void test1()  {
	  //  create mock
		AddHourlyEmployee test = Mockito.mock(AddHourlyEmployee.class);
	  
	  // define return value for method getUniqueId()
//	  when(test.getUniqueId()).thenReturn(43);
//	  
//	  // use mock in test.... 
//	  assertEquals(test.getUniqueId(), 43);
	}


	// Demonstrates the return of multiple values
	@Test
	public void testMoreThanOneReturnValue()  {
	  Iterator i= mock(Iterator.class);
	  when(i.next()).thenReturn("Mockito").thenReturn("rocks");
	  String result=i.next()+" "+i.next();
	  //assert
	  assertEquals("Mockito rocks", result);
	}

	// this test demonstrates how to return values based on the input
	@Test
	public void testReturnValueDependentOnMethodParameter()  {
	  Comparable c= mock(Comparable.class);
	  when(c.compareTo("Mockito")).thenReturn(1);
	  when(c.compareTo("Eclipse")).thenReturn(2);
	  //assert
	  assertEquals(1,c.compareTo("Mockito"));
	}

	// this test demonstrates how to return values independent of the input value

	@Test
	public void testReturnValueInDependentOnMethodParameterI()  {
	  Comparable c= mock(Comparable.class);
	  when(c.compareTo(anyInt())).thenReturn(-1);
	  //assert
	  assertEquals(-1 ,c.compareTo(9));
	}

	// return a value based on the type of the provide parameter

//	@Test
//	public void testReturnValueInDependentOnMethodParameter()  {
//	  Comparable c= mock(Comparable.class);
//	  when(c.compareTo(isA(Todo.class))).thenReturn(0);
//	  //assert
//	  Todo todo = new Todo(5);
//	  assertEquals(todo ,c.compareTo(new Todo(1)));
//	} 
}
