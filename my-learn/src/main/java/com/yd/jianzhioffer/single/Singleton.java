package com.yd.jianzhioffer.single;

/**
 * 单例模式的各种实现
 */
public class Singleton {

    private Singleton() {
    }

    private volatile static Singleton instance; //声明成 volatile

    //双重检查锁
    public static Singleton getSingleton() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    //静态内部类
    private static class  SingletonHodler{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHodler.INSTANCE;
    }


}
