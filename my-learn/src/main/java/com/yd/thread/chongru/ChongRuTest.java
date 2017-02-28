package com.yd.thread.chongru;

/**
 * Created by Administrator on 2017/1/2.
 */
public class ChongRuTest {

    public synchronized void method1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()
        );
        System.out.println("===========1=========");
        Thread.sleep(1000);
        System.out.println("end ");
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName()
        );
        System.out.println("===========2=========");
    }


    public static void main(String[] args) throws InterruptedException {

        ChongRuTest chongRuTest = new ChongRuTest();
        chongRuTest.method1();
        chongRuTest.method2();

    }

}
