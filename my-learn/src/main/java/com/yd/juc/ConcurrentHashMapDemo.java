package com.yd.juc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wubo15 on 2020/8/7.
 *
 * @author wubo15
 * @date 2020/8/7
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        concurrentHashMap.put("key","value");

        System.out.println(concurrentHashMap.toString());

    }

}
