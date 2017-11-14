package com.yd.decorator;

public class Decorator implements Beverage {

    private String description = "我只是装饰器，不知道具体的描述";

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return 0;       //价格由子类来决定
    }

}