package com.jianfeng.JavaTutorial;


import java.util.Hashtable;
import java.util.concurrent.CopyOnWriteArrayList;

import com.jianfeng.JavaTutorial.thread.Consumer;
import com.jianfeng.JavaTutorial.thread.Drop;
import com.jianfeng.JavaTutorial.thread.Producer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.testProducerConsumer();
    }
    
    public void testProducerConsumer(){
    	Drop drop = new Drop();
    	new Thread(new Producer(drop, 1)).start();
    	new Thread(new Consumer(drop, 1)).start();
    	new Thread(new Consumer(drop, 2)).start();
    }
}
