package com.yd.thread.wait;

/**
 * Created by nick on 2019/6/5.
 *
 * @author nick
 * @date 2019/6/5
 */
public class WaitTestMain {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();

        Thread thread1 = new Thread(myThread, "thread1");
        Thread thread2 = new Thread(myThread, "thread2");

        thread1.start();
        thread2.start();

//        MyThread.class.notify();
    }


}
