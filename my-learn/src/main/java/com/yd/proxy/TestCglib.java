package com.yd.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by nick on 2019/3/4.
 *
 * @author nick
 * @date 2019/3/4
 */
public class TestCglib {
    public static void main(String args[]) {
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());
        TargetObject targetObject2=(TargetObject)enhancer.create();
//        System.out.println(targetObject2);

        System.out.println(targetObject2.method1("mmm1"));
//        System.out.println(targetObject2.method2(100));
//        System.out.println(targetObject2.method3(200));
    }

}
