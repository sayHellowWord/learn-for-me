package com.yd.decorator;

/**
 * Created by nick on 2017/6/28.
 */
public class Test {

    public static void main(String[] args) {
        Beverage beverage = new CoffeeBean1();  //选择了第一种咖啡豆磨制的咖啡
        beverage = new Mocha(beverage);     //为咖啡加了摩卡
        beverage = new Milk(beverage);
        System.out.println(beverage.getDescription() + "\n加了摩卡和牛奶的咖啡价格：" + beverage.getPrice());



    }
}