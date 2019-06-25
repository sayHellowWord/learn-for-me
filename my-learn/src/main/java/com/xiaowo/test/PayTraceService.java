package com.xiaowo.test;

import java.util.Map;

/**
 * Created by nick on 2019/6/18.
 *
 * @author nick
 * @date 2019/6/18
 */
public class PayTraceService extends  AbstractTraceSrvice {

    @Override
    public void getModel(Map map) {
        //转换对象
        super.getModel1();
    }

    @Override
    public String getPayTrace() {
        return "pay";
    }
}
