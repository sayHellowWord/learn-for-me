package com.yd.java8.juc;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by nick on 2018/2/5.
 *
 * @author nick
 * @date 2018/2/5
 */
public class AtomicTest {

    @Test
    public void test1(){

        LongAdder longAdder =new LongAdder();


        LongAccumulator longAccumulator = new LongAccumulator(Long::sum,0);


        StampedLock stampedLock = new StampedLock();

        List<Integer> list = Lists.newArrayList();
        for(int i = 0 ; i < 10 ; i++){
            list.add(i);
        }

        System.out.println(list.subList(0,5));

    }

}
