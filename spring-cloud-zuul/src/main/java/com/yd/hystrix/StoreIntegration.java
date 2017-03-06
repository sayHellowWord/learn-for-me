package com.yd.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StoreIntegration {

    @HystrixCommand(fallbackMethod = "defaultStores")
    public Object getStores(Map<String, Object> parameters) {
        //do stuff that might fail
        System.out.println("getStores");
        return  null;
    }

    public Object defaultStores(Map<String, Object> parameters) {
//        return /* something useful */;
        System.out.println("defaultStores");
        return  null;
    }
}