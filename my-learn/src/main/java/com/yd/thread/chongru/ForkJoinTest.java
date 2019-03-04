package com.yd.thread.chongru;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by nick on 2019/1/8.
 *
 * @author nick
 * @date 2019/1/8
 */
public class ForkJoinTest {


    public static void main(String[] args) {

        IForkJoinCalculator task1 = new IForkJoinCalculator(ImmutableMap.<String,Integer>of("data", 10)) {
            @Override
            protected List<Integer> compute() {

                List<Integer> result = Lists.newArrayList();

                Integer index = (Integer) this.getContext().get("data");
                for (int i = 0; i < index; i++) {
                    result.add(index);
                    System.out.println("1");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                return result;
            }
        };

        IForkJoinCalculator task2 = new IForkJoinCalculator(ImmutableMap.<String,Integer>of("data", 10)) {
            @Override
            protected List<Integer> compute() {

                List<Integer> result = Lists.newArrayList();

                Integer index = (Integer) this.getContext().get("data");
                for (int i = 0; i < index; i++) {
                    result.add(index);
                    System.out.println("2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                return result;
            }
        };

        long start = System.currentTimeMillis();

        task1.fork();
        task2.fork();

        List<Integer> result1 = (List<Integer>) task1.join();
        List<Integer> result2 = (List<Integer>) task2.join();

        System.out.println(result1);
        System.out.println(result2);

        System.out.println(System.currentTimeMillis() - start);

    }
}
