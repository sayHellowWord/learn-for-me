package com.yd.web;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/3/3.
 */
@Component
public class ComputeClientHystrix implements ComputeClient {
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }
}