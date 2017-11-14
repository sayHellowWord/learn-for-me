package com.yd.decorator;

public class Mocha extends Decorator {
    private String description = "加了摩卡！";
    private Beverage beverage = null;
    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }
    public String getDescription(){
        return beverage.getDescription()+"\n"+description;
    }
    public double getPrice(){
        return beverage.getPrice()+49;  //30表示摩卡的价格
    }
}