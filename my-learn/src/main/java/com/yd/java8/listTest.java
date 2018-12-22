package com.yd.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2018/5/7.
 *
 * @author nick
 * @date 2018/5/7
 */
public class listTest {

    public static void main(String[] args) {

        List<String> lists = new ArrayList<>();
        lists.add("11");

        int size = lists.size();
        for (int i = 0; i < size; i++) {
            lists.add("22");
        }

        System.out.println(lists);


        BigDecimal a = BigDecimal.valueOf(73120014.46800);
        BigDecimal b = BigDecimal.valueOf(Double.MAX_VALUE);
        System.out.println(b.compareTo(a));

    }

}
