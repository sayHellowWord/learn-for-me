package com.xiaowo.test;

import java.util.HashMap;

/**
 * Created by nick on 2019/6/18.
 *
 * @author nick
 * @date 2019/6/18
 */
public class TestFactory {

    //    @Autowired()
    static TraceFactory factory;

    public static void main(String[] args) {

        String traceType = "pay";

        factory.calculate(traceType, new HashMap());

    }

}
