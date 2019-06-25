package com.xiaowo.test;

import java.util.Map;

/**
 * Created by nick on 2019/6/18.
 *
 * @author nick
 * @date 2019/6/18
 */
public class BookTraceService  extends  AbstractTraceSrvice{

    @Override
    public void getModel(Map map) {
        //
    }

    @Override
    public String getPayTrace() {
        return "book";
    }
}
