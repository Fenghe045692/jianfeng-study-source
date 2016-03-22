package com.jianfeng.JavaTutorial.thread;

import java.util.Random;

public class Consumer implements Runnable{
	private Drop drop;
	private int threadnumber;

    public Consumer(Drop drop, int threadnumber) {
        this.drop = drop;
        this.threadnumber = threadnumber;
    }

    public void run() {
        Random random = new Random();
        String message = "";
        while(!message.equals("DONE")) {
        	message = drop.take();
            System.out.format("Consumber thread No. " + threadnumber + " MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
        System.out.println("Consumber thread No. " + threadnumber + " finished!");
    }
}
