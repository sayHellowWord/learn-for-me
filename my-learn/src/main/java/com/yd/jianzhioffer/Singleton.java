package com.yd.jianzhioffer;

/**
 * 单例模式的各种实现
 */
public class Singleton {


    private Singleton() {
    }

    private static Singleton singleton;

    //双重检查锁
    public static Singleton getSingleton() {
        if (null == singleton) {
            synchronized (singleton) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


}
