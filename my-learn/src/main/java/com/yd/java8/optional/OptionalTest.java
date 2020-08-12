package com.yd.java8.optional;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by Administrator on 2017/2/23.
 */
public class OptionalTest {

    public static void main(String[] args) {
        BigDecimal value = null;
        BigDecimal a = Optional.ofNullable(value).orElse(null);
        System.out.println(a);


//        Optional.of();
//        Optional.empty()
    }

}
