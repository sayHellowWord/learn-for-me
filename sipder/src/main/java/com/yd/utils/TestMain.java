package com.yd.utils;

import java.util.HashMap;
import java.util.Map;
//对接口进行测试
public class TestMain {
    private String url = "https://192.168.1.101/";
    private String charset = "utf-8";
    private HttpClientUtil httpClientUtil = null;

    public TestMain(){
        httpClientUtil = new HttpClientUtil();
    }

    public void test(){
/*
https://passenger.01zhuanche.com/car-rest/webservice/passenger/orderEstimatedAmount
      bookingDate=1486628852
        bookingEndPointLa=40.071857
        bookingEndPointLo=116.360286
        bookingStartPointLa=39.98361626519097
        bookingStartPointLo=116.3106233723958
        cityId=44
        serviceType=1
        token=UDE1ODEwMDQ1NDM2fDE0ODY2Mjg4NjU3OTc.
                version=4.3.5*/

        String httpOrgCreateTest = "https://passenger.01zhuanche.com/car-rest/webservice/passenger/orderEstimatedAmount";
        Map<String,String> createMap = new HashMap<String,String>();
        createMap.put("bookingDate","1486628852");
        createMap.put("bookingEndPointLa","40.071857");
        createMap.put("bookingEndPointLo","116.360286");
        createMap.put("bookingStartPointLa","39.98361626519097");
        createMap.put("bookingStartPointLo","116.3106233723958");
        createMap.put("cityId","44");
        createMap.put("serviceType","1");
        createMap.put("token","UDE1ODEwMDQ1NDM2fDE0ODY2Mjg4NjU3OTc.");
        createMap.put("version","4.3.5");
        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);
        System.out.println("result:"+httpOrgCreateTestRtn);
    }

    public static void main(String[] args){
        TestMain main = new TestMain();
        main.test();
    }
}