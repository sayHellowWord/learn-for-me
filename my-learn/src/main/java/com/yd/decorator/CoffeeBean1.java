package com.yd.decorator;

public class CoffeeBean1 implements Beverage {

    private String description = "选了第一种咖啡豆";

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return 50;
    }

}