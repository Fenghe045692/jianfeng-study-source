package com.jianfeng.agile.sample;

import junit.framework.TestCase;

public class TestSample extends TestCase{
	public void testLSP(){
		Rectangle re = new Square();
		re.setWidth(2);
		assertEquals(2.0, re.getHeight());
	}
}
