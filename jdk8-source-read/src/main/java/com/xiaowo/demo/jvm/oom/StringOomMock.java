package com.xiaowo.demo.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2019/3/25.
 *
 * @author nick
 * @date 2019/3/25
 */
public class StringOomMock {

    static String  base = "string";

    public static void main(String[] args) {

        String str1 = "str";
        String str2 = "ing";

        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //在堆上创建的新的对象
        String str5 = "string";//常量池中的对象
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false

        List<String> list = new ArrayList<String>();
        for (int i=0;i< Integer.MAX_VALUE;i++){

            //这种方法有问题，base+base会生成新String对象在heap 应该用字符串+
//            String str = base + base;
            String str = "string" + "string";

            base = str;
            list.add(str.intern());
        }
    }
}
