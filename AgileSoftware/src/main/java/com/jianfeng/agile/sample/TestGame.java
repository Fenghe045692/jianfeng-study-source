package com.jianfeng.agile.sample;

import junit.framework.TestCase;

public class TestGame extends TestCase{
	public TestGame(String name){
		super(name);
	}
	
	private Game g;
	
	public void setUp(){
		g = new Game();
	}
	
	public void testOneThrow(){
		g.add(5);
		assertEquals(0, g.score());
	}
	
	public void testMultipleThrows(){
		g.add(2);
		g.add(4);
		g.add(5);
		g.add(1);
		assertEquals(6, g.scoreForFrame(1));
		assertEquals(12, g.scoreForFrame(2));
		assertEquals(12,  g.score());
	}
	
	public void testSimpleFrameAfterSquare(){
		g.add(3);
		g.add(7);
		g.add(5);
		g.add(2);
		assertEquals(15, g.scoreForFrame(1));
		assertEquals(22, g.scoreForFrame(2));
		assertEquals(22, g.score());
		assertEquals(2, g.getCurrentFrame());
	}
	
	public void testPerfectGame(){
		for(int i=0; i < 12; i++){
			g.add(10);
		}
		assertEquals(300, g.score());
		assertEquals(10, g.getCurrentFrame());
	}
	
	public void testEndOfArray(){
		for(int i=0; i < 9; i++){
			g.add(0);
			g.add(0);
		}
		g.add(2);
		g.add(8);
		g.add(10);
		assertEquals(20, g.score());
	}
}
