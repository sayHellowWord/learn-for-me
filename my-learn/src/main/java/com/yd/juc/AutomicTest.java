package com.yd.juc;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by nick on 2019/6/12.
 *
 * @author nick
 * @date 2019/6/12
 */
public class AutomicTest {

    public static void main(String[] args) {

        AtomicLong atomicLong = new AtomicLong();

        System.out.println(atomicLong.get());

        atomicLong.set(55L);

        System.out.println(atomicLong.get());

        System.out.println(atomicLong.getAndIncrement());

        System.out.println(atomicLong.get());

    }


}
