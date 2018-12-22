package com.yd;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by nick on 2018/3/15.
 *
 * @author nick
 * @date 2018/3/15
 */
public class TestInteger {


    public static void main(String[] args) {

        Integer small1 = 100;
        Integer small2 = 100;


        Integer small1New = new Integer(100);
        Integer small2New = new Integer(100);

        Integer small1NewOf =  Integer.valueOf(100);
        Integer small2Newof =  Integer.valueOf(100);


        Integer big1 = 1000;
        Integer big2 = 1000;


        Integer bif1New = new Integer(1000);
        Integer big2New = new Integer(1000);

        Integer big1NewOf =  Integer.valueOf(1000);
        Integer big2Newof =  Integer.valueOf(1000);

        System.out.println(small1 == small2);
        System.out.println(small1New == small2New);
        System.out.println(small1NewOf == small2Newof);

        System.out.println(big1 == big2);
        System.out.println(bif1New == big2New);
        System.out.println(big1NewOf == big2Newof);


        System.out.println("==========");

        List<String> arr = Lists.newArrayList();
        List<String> arr2 = Lists.newArrayList();
        for (int i = 0; i < 1000 ; i++) {
            arr.add(""+ i);
            arr2.add(""+ i);
        }

        Integer tmp = arr.size();
        Integer tmp2 = arr2.size();
        System.out.println(tmp + " " + tmp2);
        System.out.println(tmp == tmp2);

    }

}
