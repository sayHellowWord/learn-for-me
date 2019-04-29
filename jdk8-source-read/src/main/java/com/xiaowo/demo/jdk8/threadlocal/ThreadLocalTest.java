package com.xiaowo.demo.jdk8.threadlocal;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by nick on 2019/3/29.
 *
 * @author nick
 * @date 2019/3/29
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        final ThreadLocal threadLocal = new InheritableThreadLocal();

        threadLocal.set("droidyue.com");
        Thread t = new Thread("thread-local") {
            @Override
            public void run() {
                super.run();
                System.out.println("testInheritableThreadLocal =" + threadLocal.get());
            }
        };

        t.start();

    }

    private static class InnerClass {

        public void add(String newStr) {
            StringBuilder str = Counter.counter.get();
            Counter.counter.set(str.append(newStr));
        }

        public void print() {
            System.out.printf("Thread name:%s , ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
        }

        public void set(String words) {
            Counter.counter.set(new StringBuilder(words));
            System.out.printf("Set, Thread name:%s , ThreadLocal hashcode:%s,  Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
        }
    }

    private static class Counter {

        private static ThreadLocal<StringBuilder> counter = new ThreadLocal<StringBuilder>() {
            @Override
            protected StringBuilder initialValue() {
                return new StringBuilder();
            }
        };

    }


    @Test
    public void test1() throws InterruptedException {
        int threads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        InnerClass innerClass = new InnerClass();
        for (int i = 1; i <= threads; i++) {
            new Thread(() -> {
                for (int j = 0; j < 4; j++) {
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("hello world");
                countDownLatch.countDown();
            }, "thread - " + i).start();
        }

        countDownLatch.await();

    }


    @Test
    public void test2() throws InterruptedException {
        Thread t = new Thread("thread-local") {
            ThreadLocal<Integer> threadLocal1 = new ThreadLocal();
            ThreadLocal<Integer> threadLocal2 = new ThreadLocal();

            @Override
            public void run() {
                threadLocal1.set(1);
                threadLocal2.set(2);
                System.out.println("testThreadLocal =" + threadLocal1.get());
                System.out.println("testThreadLocal =" + threadLocal2.get());
            }
        };

        t.start();
    }

}
