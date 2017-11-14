package com.yd.decorator;

public class CoffeeBean2 implements Beverage {

    private String description = "第二种咖啡豆！";

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return 100;
    }

}