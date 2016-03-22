package com.jianfeng.JavaTutorial.thread;

import java.util.Random;

public class Producer implements Runnable{
	private Drop drop;
	private int threadnumber;
	
	public Producer(Drop drop, int threadnumber){
		this.drop = drop;
		this.threadnumber = threadnumber;
	}
	
	public void run() {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };
        Random random = new Random();

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            drop.put(importantInfo[i]);
            System.out.println("Producer thread No." + threadnumber + " produces " + importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
        drop.put("DONE");
        System.out.println(drop.getMessage());
        System.out.println(drop.isEmpty());
    }
}
