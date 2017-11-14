package com.yd.web;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/7/23.
 */
public class InputParam {

    private Demo param1;

    private Demo param2;

    private List<Demo> demos;

    public Demo getParam1() {
        return param1;
    }

    public void setParam1(Demo param1) {
        this.param1 = param1;
    }

    public Demo getParam2() {
        return param2;
    }

    public void setParam2(Demo param2) {
        this.param2 = param2;
    }

    public List<Demo> getDemos() {
        return demos;
    }

    public void setDemos(List<Demo> demos) {
        this.demos = demos;
    }

    @Override
    public String toString() {
        return "InputParam{" +
                "param1=" + param1 +
                ", param2=" + param2 +
                ", demos=" + demos +
                '}';
    }


    public static void main(String[] args) {

        Demo param1 = new Demo();
        param1.setName("name1");

        Demo param2 = new Demo();
        param2.setName("name2");

        List<Demo> demos = new ArrayList<>();
        Demo demo1 = new Demo();
        Demo demo2 = new Demo();
        demo1.setName("demo1");
        demo2.setName("demo2");
        demos.add(demo1);
        demos.add(demo2);

        InputParam inputParam = new InputParam();
        inputParam.setParam1(param1);
        inputParam.setParam2(param2);
        inputParam.setDemos(demos);

        String jsonString = JSON.toJSONString(inputParam);

        System.out.println(jsonString);

    }
}
