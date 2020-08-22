package com.xiaowo.start;

/**
 * Created by wubo15 on 2020/8/21.
 *
 * @author wubo15
 * @date 2020/8/21
 */
public class Foo {

    public static void main(String[] args) {
        boolean flag = 2; // 直接编译的话javac会报错
        if (flag)
            System.out.println("吃了");
        if (true == flag) System.out.println("真吃了");
    }

}
