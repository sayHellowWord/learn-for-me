package com.yd.test;

import java.math.BigDecimal;
import java.nio.channels.SelectionKey;

/**
 * Created by nick on 2018/8/5.
 *
 * @author nick
 * @date 2018/8/5
 */
public class ByteTest {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString((1 << 3)));
        System.out.println(Integer.toBinaryString(1 << 2));

        BigDecimal amt = new BigDecimal(1001);
        BigDecimal[] results = amt.divideAndRemainder(BigDecimal.valueOf(100));
        System.out.println(results[0]);
        System.out.println(results[1]);

    }

}
