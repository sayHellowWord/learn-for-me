package com.xiaowo.demo.jdk8.Number;

/**
 * Created by nick on 2019/3/25.
 *
 * @author nick
 * @date 2019/3/25
 */
public class IntegerTest {


    public static void main(String[] args) {
        int low = -128;
        Integer i  = Math.min(100, Integer.MAX_VALUE - (-low) -1);

        System.out.println("args = [" + args + "]");
    }

}
