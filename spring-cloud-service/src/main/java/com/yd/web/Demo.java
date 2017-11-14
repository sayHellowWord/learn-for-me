package com.yd.web;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.MapContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nick on 2017/7/23.
 */
public class Demo {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                '}';
    }


    public static void main(String[] args) {

//        System.out.println(Demo.class.getName());

        System.out.println((long) (Double.valueOf("1111.00") * 100));

        int night = 20;
        int adr = 200;
        int factor = 30;

        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            compute(night, adr, factor);
        }

        System.out.println(" java 方程式计算时间：" + (System.currentTimeMillis() - start));

        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("night", 20.1);
        mapa.put("adr", 200);
        mapa.put("factor", 30);

        // 让这个人变成一个Context，以便Jexl认识他
        JexlContext context = new MapContext(mapa);
        // 创建 JexlBuilder
        JexlBuilder jexlB = new JexlBuilder();

        // 创建 JexlEngine
        JexlEngine engine = jexlB.create(); //new JexlBuilder().namespaces(funcs).create();

        start = System.currentTimeMillis();

        double result = 0;
        for (int i = 0; i < 10; i++) {
            result = (Double) engine.createExpression("night * adr * factor").evaluate(context);
        }

        System.out.println(" jxel 方程式计算时间：" + (System.currentTimeMillis() - start));

        System.out.println(result + "");

        String expression = "night * adr * factor + night ";

        // 编译表达式
        Expression compiledExp = AviatorEvaluator.compile(expression);

        Double aviatorResult = Double.valueOf(0);

        start = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            // 执行表达式
            aviatorResult = (Double) compiledExp.execute(mapa);
        }

        System.out.println(" Aviator 方程式计算时间：" + (System.currentTimeMillis() - start));
        System.out.println(result + "");


        start = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            // 执行表达式
            aviatorResult = (Double) compiledExp.execute(mapa);
        }

        System.out.println(" Aviator 方程式计算时间：" + (System.currentTimeMillis() - start));
        System.out.println(result + "");
    }

    /**
     * （历史日均消费间夜*历史消费ADR*30）
     */
    public static double compute(int night, int adr, int factor) {
        return night * adr * factor;
    }


}
