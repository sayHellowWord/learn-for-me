package com.yd.thread.wait;

/**
 * Created by nick on 2019/6/5.
 *
 * @author nick
 * @date 2019/6/5
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        synchronized (MyThread.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                if (i == 5) {
                    if (Thread.currentThread().getName().equals("thread1")) {
                        try {
                            MyThread.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        MyThread.class.notify();
                    }
                }
            }
        }
    }


}
