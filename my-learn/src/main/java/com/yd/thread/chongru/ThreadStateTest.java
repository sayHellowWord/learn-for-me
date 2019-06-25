package com.yd.thread.chongru;

/**
 * Created by nick on 2019/6/5.
 *
 * @author nick
 * @date 2019/6/5
 */
public class ThreadStateTest {

    public static void main(String[] args) {

        Thread testThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("111");
            }
        });


        System.out.println(testThread.getState());

        testThread.start();

        System.out.println(testThread.getState());


    }


}
