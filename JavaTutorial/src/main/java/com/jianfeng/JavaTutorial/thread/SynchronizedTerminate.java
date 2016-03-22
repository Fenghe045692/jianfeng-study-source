package com.jianfeng.JavaTutorial.thread;

import java.util.concurrent.TimeUnit;

public class SynchronizedTerminate {
	private static boolean stopRequested;
	
	public static void main(String[] args) throws InterruptedException{
		new Thread(new Runnable(){
			public void run() {
				int i = 0;
				while(!stopRequested){
					i++;
				}
			}
			
		}).start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
}
